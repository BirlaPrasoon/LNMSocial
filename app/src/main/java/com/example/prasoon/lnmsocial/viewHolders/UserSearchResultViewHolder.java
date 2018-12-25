package com.example.prasoon.lnmsocial.viewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.Utility;
import com.example.prasoon.lnmsocial.activities.ProfileActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserSearchResultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private CircleImageView profileImage;
    private TextView studentName;
    private TextView studentDepartment;
    private TextView studentCurrentYear;
    private Context context;
    private int index ;

    public UserSearchResultViewHolder(@NonNull View itemView) {
        super(itemView);
        studentName = itemView.findViewById(R.id.student_name);
        studentDepartment = itemView.findViewById(R.id.student_dept_name);
        studentCurrentYear = itemView.findViewById(R.id.student_cur_year);
        profileImage = itemView.findViewById(R.id.student_profile_image);
        itemView.setOnClickListener(this);
        context = itemView.getContext();

    }

    public void setProfileImage(String imageURL) {
//        this.profileImage = profileImage;
        if(imageURL!=null && imageURL.length()> 20){
            Utility.downloadImage(imageURL,profileImage);
        }

    }

    public void setStudentCurrentYear(String studentCurrentYear) {
        this.studentCurrentYear.setText(studentCurrentYear);
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment.setText(studentDepartment);
    }

    public void setStudentName(String studentName) {
        this.studentName.setText(studentName);
    }

    @Override
    public void onClick(View v) {
        // user clicks the item
        Intent i = new Intent(context, ProfileActivity.class);
        i.putExtra("index", "" + index);
        context.startActivity(i);
    }

    public void setIndex(int i) {
        this.index = i;
    }

}
