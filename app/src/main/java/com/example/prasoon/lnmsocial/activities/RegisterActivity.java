package com.example.prasoon.lnmsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends Activity {

    @BindView(R.id.ActivityLabel)
    TextView ActivityLabel;
    @BindView(R.id.firstNameTextInput)
    TextInputLayout firstNameTextInput;
    @BindView(R.id.lastNameTextInput)
    TextInputLayout lastNameTextInput;
    @BindView(R.id.rollNumberTextInput)
    TextInputLayout rollNumberTextInput;
    @BindView(R.id.emailTextInput)
    TextInputLayout emailTextInput;
    @BindView(R.id.usernameTextInput)
    TextInputLayout usernameTextInput;
    @BindView(R.id.homeTownTextInput)
    TextInputLayout homeTownTextInput;
    @BindView(R.id.stateTextIput)
    TextInputLayout stateTextIput;
    @BindView(R.id.phoneNumberTextInput)
    TextInputLayout phoneNumberTextInput;
    @BindView(R.id.passwordTextIput)
    TextInputLayout passwordTextInput;
    @BindView(R.id.facebookprofileTextIput)
    TextInputLayout facebookProfileTextInput;
    @BindView(R.id.linkedinprofileTextIput)
    TextInputLayout linkedInProfileTextInput;
    @BindView(R.id.githubprofileTextIput)
    TextInputLayout githubProfileTextInput;
    @BindView(R.id.twitterprofileTextIput)
    TextInputLayout twitterProfileTextInput;

    @BindView(R.id.registerActivityNextButton)
    Button registerActivityNextButton;
    @BindView(R.id.aboutMeTextInput)
    TextInputLayout aboutMeTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registerActivityNextButton)
    public void onViewClicked() {

        if (checkifEmptyFields())
            return;

        Intent intent = new Intent(getApplicationContext(), FieldsInfoActivity.class);
        Bundle b = new Bundle();
        b.putString("first_name", firstNameTextInput.getEditText().getText().toString());
        b.putString("last_name", lastNameTextInput.getEditText().getText().toString());
        b.putString("roll_number", rollNumberTextInput.getEditText().getText().toString());
        b.putString("email", emailTextInput.getEditText().getText().toString());
        b.putString("username", usernameTextInput.getEditText().getText().toString());
        b.putString("hometown", homeTownTextInput.getEditText().getText().toString());
        b.putString("state", stateTextIput.getEditText().getText().toString());
        b.putString("phone_number", phoneNumberTextInput.getEditText().getText().toString());
        b.putString("password", passwordTextInput.getEditText().getText().toString());
        b.putString("aboutMe", aboutMeTextInput.getEditText().getText().toString());

        Editable facebookLink = facebookProfileTextInput.getEditText().getText();
        String facebookProfileLink = "later";
        if(facebookLink!=null){
            facebookProfileLink = facebookLink.toString();
        }

        Editable githubLink = githubProfileTextInput.getEditText().getText();
        String githubProfileLink = "later";
        if(githubLink!=null){
            githubProfileLink = githubLink.toString();
        }

        Editable linkedInLink = linkedInProfileTextInput.getEditText().getText();
        String linkedInProfileLink = "later";
        if(facebookLink!=null){
            linkedInProfileLink = linkedInLink.toString();
        }

        Editable twitterLink = twitterProfileTextInput.getEditText().getText();
        String twitterProfileLink = "later";
        if(facebookLink!=null){
            twitterProfileLink = twitterLink.toString();
        }

        b.putString("facebookLink",facebookProfileLink);
        b.putString("linkedInLink",linkedInProfileLink);
        b.putString("githubLink",githubProfileLink);
        b.putString("twitterLink",twitterProfileLink);

        intent.putExtras(b);
        startActivity(intent);

    }

    // check if any of the input fields is empty and show error toast as well
    private boolean checkifEmptyFields() {

        if (TextUtils.isEmpty(firstNameTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "First Name field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(lastNameTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Last Name field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(rollNumberTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Roll Number field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(emailTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Email field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(usernameTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Username field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(homeTownTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Home town field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(phoneNumberTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Phone Number field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        } else if (TextUtils.isEmpty(passwordTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "Password field can't be empty", Toast.LENGTH_SHORT).show();
            return true;
        }else if (TextUtils.isEmpty(aboutMeTextInput.getEditText().getText().toString())) {
            Toast.makeText(getApplicationContext(), "About field can't be empty, max 200 chars Alowed", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
