package com.example.prasoon.lnmsocial.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.prasoon.lnmsocial.fragments.ProfileFragment;
import com.example.prasoon.lnmsocial.models.User;

import java.util.ArrayList;

public class VerticalPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<User> users;

    public VerticalPagerAdapter(FragmentManager fm, ArrayList<User> users) {
        super(fm);
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Fragment getItem(int i) {

        User u = users.get(i);
        ProfileFragment fragment = new ProfileFragment();
        Bundle b = new Bundle();
        b.putString("first_name",u.getFirstName());
        b.putString("last_name" ,u.getLastname());
        b.putString("roll_number",u.getRollNumber());
        b.putString("email",u.getEmail());
        b.putString("username",u.getUsername());
        b.putString("hometown",u.getHometown());
        b.putString("state",u.getState());
        b.putString("phone_number",u.getPhoneNumber());
        b.putString("password",u.getPassword());
        b.putString("aboutMe",u.getAboutMe());
        b.putString("Sports", u.getSports());
        b.putString("Interests", u.getInterests());
        b.putString("Clubs", u.getClubs());
        b.putString("profile_image",u.getImageUrl());
        b.putString("year",u.getYear());
        b.putString("department",u.getDepartment());
        b.putString("index",String.valueOf(i));

        fragment.setArguments(b);

        return fragment;
    }

}
