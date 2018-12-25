package com.example.prasoon.lnmsocial.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.Utility;
import com.example.prasoon.lnmsocial.activities.EditProfileActivity;
import com.example.prasoon.lnmsocial.activities.MainActivity;
import com.example.prasoon.lnmsocial.activities.ProfileActivity;
import com.example.prasoon.lnmsocial.activities.StartActivity;
import com.example.prasoon.lnmsocial.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.MessageFormat;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseUser curUser;
    String index;
    public ProfileFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        curUser = mAuth.getCurrentUser();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView menu = v.findViewById(R.id.menuView);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                    //Creating the instance of PopupMenu
                    PopupMenu popup = new PopupMenu(v.getContext(), v);
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.menu_profile, popup.getMenu());

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {

                            if(item.getTitle().equals("Profile")){
                                Intent i = new Intent(v.getContext(),EditProfileActivity.class);
                                i.putExtra("index",index);
                                startActivity(i);
                            }else if(item.getTitle().equals("Sign Out")){
                                mAuth.signOut();
                                Intent i = new Intent(v.getContext(),StartActivity.class);
                                startActivity(i);
                            }else if(item.getTitle().equals("Reset")){
                                Intent i = new Intent(v.getContext(),MainActivity.class);
                                startActivity(i);
                            }
                            return true;
                        }
                    });

                    popup.show();//showing popup menu
            }
        });

        final Bundle b = getArguments();
        if( b != null) {
            String fName = b.getString("first_name");
            String lName = b.getString("last_name");
            String username = b.getString("username");
            String hometown = b.getString("hometown");
            String state = b.getString("state");
            String aboutMe = b.getString("aboutMe");
            String year = b.getString("year");
            String department = b.getString("department");

            index = b.getString("index");

            final String imageUrl = b.getString("profile_image");

            TextView nameTextView = v.findViewById(R.id.name);
            TextView usernameTextView = v.findViewById(R.id.user_name);
            TextView userAbout = v.findViewById(R.id.user_about);
            TextView userDepartment = v.findViewById(R.id.user_department);
            TextView userCurrentYear = v.findViewById(R.id.user_current_year);
            Button viewFullProfileButton = v.findViewById(R.id.viewFullProfile);
            TextView userLocationButton = v.findViewById(R.id.user_location);
            viewFullProfileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),ProfileActivity.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            });

            final CircleImageView profileImage = v.findViewById(R.id.circleImageView);

            if(imageUrl!=null && imageUrl.length() > 0){
                Utility.downloadImage(imageUrl,profileImage);
            }

            nameTextView.setText(MessageFormat.format("{0} {1}", fName, lName));
            usernameTextView.setText("@"+username);
            userAbout.setText(aboutMe);
            userCurrentYear.setText(year);
            userDepartment.setText(department);
            String location = hometown + ", " + state;
            userLocationButton.setText(location);
        }
        return v;
    }

}
