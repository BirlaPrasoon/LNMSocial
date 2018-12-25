package com.example.prasoon.lnmsocial.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.Utility;
import com.example.prasoon.lnmsocial.adapter.VerticalPagerAdapter;
import com.example.prasoon.lnmsocial.models.User;
import com.example.prasoon.lnmsocial.viewPagers.VerticalViewPager;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ArrayList<User> userList;
    ArrayList<String> filters;
    boolean fromSearch;
    String query;

    private VerticalViewPager verticalViewPager;
    private VerticalPagerAdapter verticalPagerAdapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        if(i!=null) {
            String from = i.getStringExtra("from");
            if(from!=null) {
                switch (from) {
                    case "SearchActivity":
                        query = i.getStringExtra("query");
                        filters = i.getStringArrayListExtra("arraylist");
                        if(filters.size()>0 || query.length()>0) {
                            fromSearch = true;
                        }
                        break;
                }
            };
        }
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setTitle("Fetching Users");

        getData();
    }

    public List<User> getData() {

        dialog.show();
        userList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        final Task<QuerySnapshot> users = db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> docs = queryDocumentSnapshots.getDocuments();
                for( DocumentSnapshot d: docs){
                    User user = Utility.getUserFromDocument(d);
                    if(fromSearch)
                        filterUser(d,user);
                    else
                        userList.add(user);
                }
                if(userList.size() >0) {
                    verticalPagerAdapter = new VerticalPagerAdapter(getSupportFragmentManager(), userList);
                    verticalViewPager = findViewById(R.id.container);
                    verticalViewPager.setOffscreenPageLimit(5);
                    verticalViewPager.setAdapter(verticalPagerAdapter);
                } else {
                    Snackbar.make(findViewById(R.id.main_content),"No users found",Snackbar.LENGTH_INDEFINITE).show();
                }
                dialog.dismiss();
            }
        });

        Utility.setData(userList);
        return userList;
    }


    private void filterUser(DocumentSnapshot d, User user) {
        Boolean flag = false;
        query = query.trim().toLowerCase();

        if(!query.equals("")){
            if(query.contains(" ")){
                String name[] = query.split(" ");
                // search for name. hometown and state
                if(d.get("first_name").toString().toLowerCase().equals(name[0])){
                    filterForTerms(d, user);
                }

                else if(d.get("last_name").toString().toLowerCase().equals(name[1])){
                    filterForTerms(d,user);
                }

            }else{
                // search for name, hometown, and state

                if(d.get("first_name").toString().toLowerCase().equals(query)){
                    filterForTerms(d,user);
                }else if(d.get("last_name").toString().toLowerCase().equals(query))
                    filterForTerms(d,user);
                else if(d.get("hometown").toString().toLowerCase().equals(query))
                    filterForTerms(d,user);
                else if(d.get("state").toString().toLowerCase().equals(query))
                    filterForTerms(d,user);
            }
        }else {
            if(filters.size()>0){
                for (String s : filters) {
                    if (d.getBoolean(s)) {
                        flag = true;
                        break;
                    }
                }
                if (flag.equals(true))
                    userList.add(user);
            }
        }
    }

    private void filterForTerms(DocumentSnapshot d, User user) {
        Boolean flag = false;
        if(filters.size()>0){
            for (String s : filters) {
                if (d.getBoolean(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag.equals(true))
                userList.add(user);
        }else {
            userList.add(user);
        }
    }



}
