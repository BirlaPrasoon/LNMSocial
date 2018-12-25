package com.example.prasoon.lnmsocial.activities;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

public class StartActivity extends Activity {

    @BindView(R.id.usernameEditText)
    EditText usernameEditText;
    @BindView(R.id.passwordEditText)
    EditText passwordEditText;
    @BindView(R.id.signInButton)
    Button signInButton;
    @BindView(R.id.registerButton)
    Button registerButton;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            startMainActivity();
        }

    }

    @OnClick(R.id.signInButton)
    public void onSignInButtonClicked() {

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please check username and password", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete()){
                    Toast.makeText(getApplicationContext(),"Signed in successfully.",Toast.LENGTH_SHORT).show();
                    startMainActivity();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Couldn't sign in! Please try after some time.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.registerButton)
    public void onRegisterButtonClicked() {

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);

    }

    public void startMainActivity(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        String from = "StartActivity";
        intent.putExtra("from", from);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void resetPassword(View view) {
        Intent i = new Intent(this, ResetPasswordActivity.class);
        startActivity(i);
    }
}
