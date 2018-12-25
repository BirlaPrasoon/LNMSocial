package com.example.prasoon.lnmsocial.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.models.User;
import com.example.prasoon.lnmsocial.viewHolders.UserSearchResultViewHolder;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<UserSearchResultViewHolder>{

    // store data
    ArrayList<User> userList;
    public SearchResultAdapter(ArrayList<User> userArrayList){
        this.userList = userArrayList;
    }

    @NonNull
    @Override
    public UserSearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_single_user, parent, false);

        return new UserSearchResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserSearchResultViewHolder userSearchResultViewHolder, int i) {
        // set the holder positions
        User user = userList.get(i);
        userSearchResultViewHolder.setIndex(i);
        userSearchResultViewHolder.setStudentCurrentYear(user.getYear());
        userSearchResultViewHolder.setProfileImage(user.getImageUrl());
        userSearchResultViewHolder.setStudentName(user.getFirstName() +" " + user.getLastname());
        userSearchResultViewHolder.setStudentDepartment(user.getDepartment());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
