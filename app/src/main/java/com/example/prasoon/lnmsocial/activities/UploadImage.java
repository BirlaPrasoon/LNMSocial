package com.example.prasoon.lnmsocial.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class UploadImage extends AppCompatActivity {
    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.upload_profileButton)
    Button uploadProfileButton;
    @BindView(R.id.finishButton)
    Button finishButton;
    private Bundle b;
    Map<String,Object> user;
    private Map<String,Object> clubs,sports,interests;
    private String email,password;
    private Uri selectedImage;
    private final String TAG = UploadImage.class.getSimpleName();

    private Uri downUri;
    private String useri;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        ButterKnife.bind(this);
        Intent i = getIntent();
        b = i.getExtras();
        assert b!=null;
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setTitle("Registering User");
        user =new HashMap<>();

        email = b.getString("email");
        password = b.getString("password");
//        Toast.makeText(this,email + " : " + password,Toast.LENGTH_LONG).show();
        user.put("first_name",b.getString("first_name"));
        user.put("last_name" ,b.getString("last_name"));
        user.put("roll_number",b.getString("roll_number"));
        user.put("email",b.getString("email"));
        user.put("username",b.getString("username"));
        user.put("hometown",b.getString("hometown"));
        user.put("state",b.getString("state"));
        user.put("phone_number",b.getString("phone_number"));
        //user.put("password",b.getString("password"));
        user.put("aboutMe",b.getString("aboutMe"));
        user.put("Sports", b.getString("Sports"));
        user.put("Interests", b.getString("Interests"));
        user.put("Clubs", b.getString("Clubs"));
        user.put("facebookLink",b.getString("facebookLink"));
        user.put("linkedInLink",b.getString("linkedInLink"));
        user.put("githubLink",b.getString("githubLink"));
        user.put("twitterLink",b.getString("twitterLink"));

        sports = new HashMap<>();
        clubs = new HashMap<>();
        interests = new HashMap<>();

        sports = (Map<String, Object>) b.getSerializable("Sportsmap");
        clubs = (Map<String, Object>) b.getSerializable("Clubsmap");
        interests = (Map<String, Object>) b.getSerializable("Interestsmap");

        for(String s: sports.keySet())
            user.put(s,sports.get(s));
        for(String s:clubs.keySet())
            user.put(s,clubs.get(s));
        for(String s: interests.keySet())
            user.put(s,interests.get(s));

    }
    @OnClick(R.id.upload_profileButton)
    public void onUploadProfileButtonClicked() {
        CropImage.activity()
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setAspectRatio(200,200)
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }


    @OnClick(R.id.finishButton)
    public void onFinishButtonClicked() {


        dialog.show();

        final FirebaseAuth mAuth = FirebaseAuth.getInstance();

        // setDepartment
        user.put("CSE",false);
        user.put("CCE",false);
        user.put("MME",false);
        user.put("ME",false);
        user.put("ECE",false);
        String rollNumber = (String)user.get("roll_number");
        String department = "Wrong department";
        if(rollNumber.length() > 5)
            department = rollNumber.substring(3,5).toUpperCase();
        department = getDepartment(department);
        user.put(department,true);
        user.put("department",department);

        // set year
        String year = "Y16";
        if(rollNumber.length() > 2)
            year = "Y" + rollNumber.substring(0,2);
        user.put("year",year);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    useri = FirebaseAuth.getInstance().getCurrentUser().getUid();

                    updateUserData();

                }else {
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void updateProfileImageUrl() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        final StorageReference riversRef = storageRef.child("images/" + useri);

        riversRef.putFile(selectedImage).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "File upload failed!", Toast.LENGTH_SHORT).show();
                    return null;
                }
                return riversRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    downUri = task.getResult();
                    assert downUri != null;
                    Log.d(TAG, "onComplete: Url: " + downUri.toString());
                    user.put("imageUrl", downUri.toString());
                    Map<String, Object> mp = new HashMap<>();
                    mp.put("image_Url", downUri.toString());

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("users").document(useri).update(mp);
                    Log.i(TAG,"Image URL Updated");
                    dialog.dismiss();
                    Intent i = new Intent(UploadImage.this,MainActivity.class);
                    String from = "UploadImageActivity";
                    i.putExtra("from", from);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                } else {
                    Log.i(TAG, "failed uri");
                    Toast.makeText(getApplicationContext(), "failed url",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateUserData() {
        // Add a new document with a generated ID
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users" )
        .document(useri)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot added");

                        if(selectedImage!=null) {
                            updateProfileImageUrl();
                        }else {
                            dialog.dismiss();
                            Intent i = new Intent(UploadImage.this,MainActivity.class);
                            String from = "UploadImageActivity";
                            i.putExtra("from", from);
                            startActivity(i);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        // Sign in success, update UI with the signed-in user's information
        Log.d(TAG, "createUserWithEmail:success");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                selectedImage = resultUri;
                circleImageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Log.e(TAG,error.getMessage());
            }
        }
    }

    private String getDepartment(String department) {
        switch (department){
            case "CS" : return "CSE";
            case "CC" : return "CCE";
            case "EC" : return "ECE";
            case "ME" : return "ME";
            case "MM" : return "MME";
            default: return "No department";
        }
    }
}
