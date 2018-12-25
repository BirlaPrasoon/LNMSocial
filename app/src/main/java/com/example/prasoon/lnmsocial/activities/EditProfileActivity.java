package com.example.prasoon.lnmsocial.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.Utility;
import com.example.prasoon.lnmsocial.models.User;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.prasoon.lnmsocial.Utility.initMaps;

public class EditProfileActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    Map<String, Object> userMap;

    String uid;
    User user;
    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.emailTextInput)
    TextInputLayout emailTextInput;
    @BindView(R.id.usernameTextInput)
    TextInputLayout usernameTextInput;
    @BindView(R.id.homeTownTextInput)
    TextInputLayout homeTownTextInput;
    @BindView(R.id.stateTextIput)
    TextInputLayout stateTextIput;
    @BindView(R.id.facebookprofileTextIput)
    TextInputLayout facebookProfileTextIput;
    @BindView(R.id.phoneNumberTextInput)
    TextInputLayout phoneNumberTextInput;
    @BindView(R.id.linkedinprofileTextIput)
    TextInputLayout linkedinProfileTextIput;
    @BindView(R.id.githubprofileTextIput)
    TextInputLayout githubProfileTextIput;
    @BindView(R.id.twitterprofileTextIput)
    TextInputLayout twitterProfileTextIput;
    @BindView(R.id.aboutMeTextInput)
    TextInputLayout aboutMeTextInput;
    @BindView(R.id.clubsArrow)
    ImageView clubsArrow;
    @BindView(R.id.clubsCard)
    CardView clubsCard;
    @BindView(R.id.club_cybros)
    CheckBox Cybros;
    @BindView(R.id.club_csi)
    CheckBox Csi;
    @BindView(R.id.club_insignia)
    CheckBox Insignia;
    @BindView(R.id.club_ecell)
    CheckBox Ecell;
    @BindView(R.id.club_ccell)
    CheckBox Ccell;
    @BindView(R.id.club_arts)
    CheckBox Arts;
    @BindView(R.id.club_rendition)
    CheckBox Rendition;
    @BindView(R.id.club_quizzinga)
    CheckBox Quizzinga;
    @BindView(R.id.club_literary)
    CheckBox Literary;
    @BindView(R.id.club_chess)
    CheckBox Chess;
    @BindView(R.id.club_fashion)
    CheckBox Fashion;
    @BindView(R.id.club_innovation)
    CheckBox Innovation;
    @BindView(R.id.clubsExpandableLayout)
    ExpandableRelativeLayout clubsLayout;
    @BindView(R.id.subclubsCard)
    CardView subclubsCard;
    @BindView(R.id.sportsArrow)
    ImageView sportsArrow;
    @BindView(R.id.sportsCard)
    CardView sportsCard;
    @BindView(R.id.sport_badminton)
    CheckBox Badminton;
    @BindView(R.id.sport_ttennis)
    CheckBox Ttennis;
    @BindView(R.id.sport_cricket)
    CheckBox Cricket;
    @BindView(R.id.sport_football)
    CheckBox Football;
    @BindView(R.id.sport_volleyball)
    CheckBox Volleyball;
    @BindView(R.id.sport_basketball)
    CheckBox Basketball;
    @BindView(R.id.sport_lawn_tennis)
    CheckBox LawnTennis;
    @BindView(R.id.sport_kabaddi)
    CheckBox Kabaddi;
    @BindView(R.id.sport_squash)
    CheckBox Squash;
    @BindView(R.id.sportsExpandableLayout)
    ExpandableRelativeLayout sportsLayout;
    @BindView(R.id.subSportsCard)
    CardView subSportsCard;
    @BindView(R.id.interestsArrow)
    ImageView interestsArrow;
    @BindView(R.id.interestsCard)
    CardView interestsCard;
    @BindView(R.id.int_cp)
    CheckBox Cp;
    @BindView(R.id.int_ai)
    CheckBox Ai;
    @BindView(R.id.int_ds)
    CheckBox Ds;
    @BindView(R.id.int_ml)
    CheckBox Ml;
    @BindView(R.id.int_web_dev)
    CheckBox WebDev;
    @BindView(R.id.int_mobile_web)
    CheckBox MobileWeb;
    @BindView(R.id.int_android)
    CheckBox Android;
    @BindView(R.id.int_literature)
    CheckBox Literature;
    @BindView(R.id.int_blockchain)
    CheckBox Blockchain;
    @BindView(R.id.int_content_writing)
    CheckBox ContentWriting;
    @BindView(R.id.int_uiux)
    CheckBox Uiux;
    @BindView(R.id.int_ios)
    CheckBox Ios;
    @BindView(R.id.interestsExpandableLayout)
    ExpandableRelativeLayout interestsLayout;
    @BindView(R.id.subInterestsCard)
    CardView subInterestsCard;
    @BindView(R.id.submitFieldsButton)
    Button submitFieldsButton;
    private Toolbar toolbar;
    private Map<String, Boolean> Sports, Clubs, Interests;
    private String useri;

    private Uri selectedImage;
    private String TAG = EditProfileActivity.class.getSimpleName();
    Uri downUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Edit Profile");
        setSupportActionBar(toolbar);

        user = new User();
        userMap = new HashMap<>();

        FirebaseUser curUser = FirebaseAuth.getInstance().getCurrentUser();
        if(curUser !=null){
            useri = curUser.getUid();
        }else{
            Snackbar.make(findViewById(R.id.root),"No user logged in", Snackbar.LENGTH_INDEFINITE);
        }

        arrayList = new ArrayList<>();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            uid = mUser.getUid();
        }

        Sports = new HashMap<>();
        Clubs = new HashMap<>();
        Interests = new HashMap<>();
        initMaps(Sports, Clubs, Interests);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        CollectionReference usersRef = db.collection("users");
        usersRef.document(uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot d = task.getResult();

                    user = Utility.getUserFromDocument(d);
                    setup();
                } else {
                    Toast.makeText(getApplicationContext(), "Could not fetch data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void setup(){
        if(user!=null){

            if(user.getImageUrl()!=null && user.getImageUrl().length() > 20)
                Utility.downloadImage(user.getImageUrl(),circleImageView);

            emailTextInput.getEditText().setText(user.getEmail());
            usernameTextInput.getEditText().setText(user.getUsername());
            homeTownTextInput.getEditText().setText(user.getHometown());
            stateTextIput.getEditText().setText(user.getState());
            phoneNumberTextInput.getEditText().setText(user.getPhoneNumber());
            facebookProfileTextIput.getEditText().setText(user.getFacebookProfileLink());
            linkedinProfileTextIput.getEditText().setText(user.getLinkedInProfileLink());
            githubProfileTextIput.getEditText().setText(user.getGithubProfileLink());
            twitterProfileTextIput.getEditText().setText(user.getTwitterProfileLink());
            aboutMeTextInput.getEditText().setText(user.getAboutMe());

        }
    }

    public void pickImage(View v){
        CropImage.activity()
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .setAspectRatio(200,200)
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
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


    public void interestsClicked(View view) {
        interestsLayout.toggle(500, new BounceInterpolator());
        interestsArrow.animate().rotationBy(180f).setDuration(200);

        if (clubsLayout.isExpanded()) {
            clubsLayout.collapse(500, new BounceInterpolator());
            clubsArrow.animate().rotationBy(180f).setDuration(200);
        }
        if (sportsLayout.isExpanded()) {
            sportsLayout.collapse(500, new BounceInterpolator());
            sportsArrow.animate().rotationBy(180f).setDuration(200);
        }
    }

    public void sportsClicked(View view) {
        sportsLayout.toggle(500, new BounceInterpolator());
        sportsArrow.animate().rotationBy(180f).setDuration(200);
        if (clubsLayout.isExpanded()) {
            clubsLayout.collapse(500, new BounceInterpolator());
            clubsArrow.animate().rotationBy(180f).setDuration(200);
        }
        if (interestsLayout.isExpanded()) {
            interestsLayout.collapse(500, new BounceInterpolator());
            interestsArrow.animate().rotationBy(180f).setDuration(200);
        }
    }

    public void clubsClicked(View view) {
        clubsLayout.toggle(500, new BounceInterpolator());
        clubsArrow.animate().rotationBy(180f).setDuration(200);
        if (sportsLayout.isExpanded()) {
            sportsLayout.collapse(500, new BounceInterpolator());
            sportsArrow.animate().rotationBy(180f).setDuration(200);
        }
        if (interestsLayout.isExpanded()) {
            interestsLayout.collapse(500, new BounceInterpolator());
            interestsArrow.animate().rotationBy(180f).setDuration(200);
        }

    }

    @OnClick({R.id.club_cybros, R.id.club_csi, R.id.club_insignia, R.id.club_ecell, R.id.club_ccell, R.id.club_arts, R.id.club_rendition, R.id.club_quizzinga, R.id.club_literary, R.id.club_chess, R.id.club_fashion, R.id.club_innovation, R.id.sport_badminton, R.id.sport_ttennis, R.id.sport_cricket, R.id.sport_football, R.id.sport_volleyball, R.id.sport_basketball, R.id.sport_lawn_tennis, R.id.sport_kabaddi, R.id.sport_squash, R.id.int_cp, R.id.int_ai, R.id.int_ds, R.id.int_ml, R.id.int_web_dev, R.id.int_mobile_web, R.id.int_android, R.id.int_literature, R.id.int_blockchain, R.id.int_content_writing, R.id.int_uiux, R.id.int_ios})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.club_csi:
                if (Csi.isChecked())
                    userMap.put("CSI",true);
                else
                    userMap.put("CSI",false);
                break;
            case R.id.club_innovation:
                if (Innovation.isChecked())
                    userMap.put("Innovation",true);
                else
                    userMap.put("Innovation",false);
                break;
            case R.id.club_ecell:
                if (Ecell.isChecked())
                    userMap.put("ECell",true);
                else
                    userMap.put("ECell",false);
                break;
            case R.id.club_ccell:
                if (Ccell.isChecked())
                    userMap.put("CCell",true);
                else
                    userMap.put("CCell",false);
                break;
            case R.id.club_arts:
                if (Arts.isChecked())
                    userMap.put("Arts",true);
                else
                    userMap.put("Arts",false);
                break;
            case R.id.club_rendition:
                if (Rendition.isChecked())
                    userMap.put("Rendition",true);
                else
                    userMap.put("Rendition",false);
                break;
            case R.id.club_quizzinga:
                if (Quizzinga.isChecked())
                    userMap.put("Quizzinga",true);
                else
                    userMap.put("Quizzinga",false);
                break;
            case R.id.club_literary:
                if (Literary.isChecked())
                    userMap.put("Literary",true);
                else
                    userMap.put("Literary",false);
                break;
            case R.id.club_chess:
                if (Chess.isChecked())
                    userMap.put("Chess",true);
                else
                    userMap.put("Chess",false);
                break;
            case R.id.club_fashion:
                if (Fashion.isChecked())
                    userMap.put("Fashion",true);
                else
                    userMap.put("Fashion",false);
                break;
            case R.id.club_cybros:
                if (Cybros.isChecked())
                    userMap.put("Cybros",true);
                else
                    userMap.put("Cybros",false);
                break;
            case R.id.club_insignia:
                if (Insignia.isChecked())
                    userMap.put("Insignia",true);
                else
                    userMap.put("Insignia",false);
                break;


            case R.id.sport_badminton:
                if (Badminton.isChecked())
                    userMap.put("Badminton",true);
                else
                    userMap.put("Badminton",false);
                break;
            case R.id.sport_cricket:
                if (Cricket.isChecked())
                    userMap.put("Cricket",true);
                else
                    userMap.put("Cricket",false);
                break;
            case R.id.sport_football:
                if (Football.isChecked())
                    userMap.put("Football",true);
                else
                    userMap.put("Football",false);
                break;
            case R.id.sport_volleyball:
                if (Volleyball.isChecked())
                    userMap.put("VolleyBall",true);
                else
                    userMap.put("VolleyBall",false);
                break;
            case R.id.sport_basketball:
                if (Basketball.isChecked())
                    userMap.put("Basketball",true);
                else
                    userMap.put("Basketball",false);
                break;
            case R.id.sport_lawn_tennis:
                if (LawnTennis.isChecked())
                    userMap.put("LawnTennis",true);
                else
                    userMap.put("LawnTennis",false);
                break;
            case R.id.sport_kabaddi:
                if (Kabaddi.isChecked())
                    userMap.put("Kabaddi",true);
                else
                    userMap.put("Kabaddi",false);
                break;
            case R.id.sport_squash:
                if (Squash.isChecked())
                    userMap.put("Squash",true);
                else
                    userMap.put("Squash",false);
                break;
            case R.id.sport_ttennis:
                if (Ttennis.isChecked())
                    userMap.put("TableTennis",true);
                else
                    userMap.put("TableTennis",false);
                break;

            //TODO: INTERESTS
            case R.id.int_cp:
                if (Cp.isChecked())
                    userMap.put("CP",true);
                else
                    userMap.put("CP",false);
                break;
            case R.id.int_ai:
                if (Ai.isChecked())
                    userMap.put("AI",true);
                else
                    userMap.put("AI",false);
                break;
            case R.id.int_ds:
                if (Ds.isChecked())
                    userMap.put("DS",true);
                else
                    userMap.put("DS",false);
                break;
            case R.id.int_ml:
                if (Ml.isChecked())
                    userMap.put("ML",true);
                else
                    userMap.put("ML",false);
                break;
            case R.id.int_mobile_web:
                if (MobileWeb.isChecked())
                    userMap.put("MobileWeb",true);
                else
                    userMap.put("MobileWeb",false);
                break;
            case R.id.int_android:
                if (Android.isChecked())
                    userMap.put("Android",true);
                else
                    userMap.put("Android",false);
                break;
            case R.id.int_literature:
                if (Literature.isChecked())
                    userMap.put("Literature",true);
                else
                    userMap.put("Literature",false);
                break;
            case R.id.int_blockchain:
                if (Blockchain.isChecked())
                    userMap.put("Blockchain",true);
                else
                    userMap.put("Blockchain",false);
                break;
            case R.id.int_content_writing:
                if (ContentWriting.isChecked())
                    userMap.put("ContentWriting",true);
                else
                    userMap.put("ContentWriting",false);
                break;
            case R.id.int_web_dev:
                if (WebDev.isChecked())
                    userMap.put("WebDev",true);
                else
                    userMap.put("WebDev",false);
                break;
            case R.id.int_uiux:
                if (Uiux.isChecked())
                    userMap.put("uiux",true);
                else
                    userMap.put("uiux",false);
                break;
            case R.id.int_ios:
                if (Ios.isChecked())
                    userMap.put("IOS",true);
                else
                    userMap.put("IOS",false);
                break;
        }
    }

    public void submit(View v){

        getBasicDetails();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users" )
                .document(useri)
                .update(userMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot added");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        if(selectedImage!=null){
            updateProfileImageUrl();
        }

        Toast.makeText(this,"Data Submitted", Toast.LENGTH_SHORT).show();
    }

    public void getBasicDetails() {

        if (checkifEmptyFields())
            return;

        Intent intent = new Intent(getApplicationContext(), FieldsInfoActivity.class);
        Bundle b = new Bundle();
        userMap.put("email", Objects.requireNonNull(emailTextInput.getEditText()).getText().toString());
        userMap.put("username", Objects.requireNonNull(usernameTextInput.getEditText()).getText().toString());
        userMap.put("hometown", Objects.requireNonNull(homeTownTextInput.getEditText()).getText().toString());
        userMap.put("state", Objects.requireNonNull(stateTextIput.getEditText()).getText().toString());
        userMap.put("phone_number", Objects.requireNonNull(phoneNumberTextInput.getEditText()).getText().toString());
        userMap.put("aboutMe", Objects.requireNonNull(aboutMeTextInput.getEditText()).getText().toString());

        Editable facebookLink = Objects.requireNonNull(facebookProfileTextIput.getEditText()).getText();
        String facebookProfileLink = "later";
        if(!TextUtils.isEmpty(facebookLink)){
            facebookProfileLink = facebookLink.toString();
        }

        Editable githubLink = Objects.requireNonNull(githubProfileTextIput.getEditText()).getText();
        String githubProfileLink = "later";
        if(!TextUtils.isEmpty(githubLink)){
            githubProfileLink = githubLink.toString();
        }

        Editable linkedInLink = Objects.requireNonNull(linkedinProfileTextIput.getEditText()).getText();
        String linkedInProfileLink = "later";
        if(!TextUtils.isEmpty(linkedInLink)){
            linkedInProfileLink = linkedInLink.toString();
        }

        Editable twitterLink = Objects.requireNonNull(twitterProfileTextIput.getEditText()).getText();
        String twitterProfileLink = "later";
        if(!TextUtils.isEmpty(twitterLink)){
            twitterProfileLink = twitterLink.toString();
        }

        userMap.put("facebookLink",facebookProfileLink);
        userMap.put("linkedInLink",linkedInProfileLink);
        userMap.put("githubLink",githubProfileLink);
        userMap.put("twitterLink",twitterProfileLink);

    }

    // check if any of the input fields is empty and show error toast as well
    private boolean checkifEmptyFields() {

        if (TextUtils.isEmpty(Objects.requireNonNull(emailTextInput.getEditText()).getText().toString())) {
            Toast.makeText(getApplicationContext(), "Email field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(usernameTextInput.getEditText()).getText().toString())) {
            Toast.makeText(getApplicationContext(), "Username field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(homeTownTextInput.getEditText()).getText().toString())) {
            Toast.makeText(getApplicationContext(), "Home town field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(phoneNumberTextInput.getEditText()).getText().toString())) {
            Toast.makeText(getApplicationContext(), "Phone Number field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(aboutMeTextInput.getEditText()).getText().toString())) {
            Toast.makeText(getApplicationContext(), "About field can't be empty, max 200 chars Alowed", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void updateProfileImageUrl() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        final StorageReference riversRef = storageRef.child("images/" + selectedImage.getLastPathSegment());


        riversRef.putFile(selectedImage).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Image upload failed!", Toast.LENGTH_SHORT).show();
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
                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("users").document(useri).update("image_Url",downUri.toString());
                    Log.i(TAG,"Image URL Updated");
                } else {
                    Log.i(TAG, "failed uri");
                    Toast.makeText(getApplicationContext(), "failed url",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
