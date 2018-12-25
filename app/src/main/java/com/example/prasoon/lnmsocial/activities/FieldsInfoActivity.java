package com.example.prasoon.lnmsocial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.prasoon.lnmsocial.R;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

import static com.example.prasoon.lnmsocial.Utility.initMaps;

public class FieldsInfoActivity extends AppCompatActivity {

    private Map<String,Boolean> Sports,Clubs,Interests;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields_info);
        ButterKnife.bind(this);
        Intent i= getIntent();
        b=i.getExtras();

        Sports = new HashMap<>();
        Clubs = new HashMap<>();
        Interests = new HashMap<>();
        initMaps(Sports, Clubs, Interests);
    }

    public void next(View v){

        b.putSerializable("Sportsmap",(Serializable) Sports);

        b.putSerializable("Clubsmap",(Serializable) Clubs);

        b.putSerializable("Interestsmap",(Serializable) Interests);

        //pass the bundle to UploadImage activity to be uploaded to firebase.
        Intent i = new Intent(FieldsInfoActivity.this, UploadImage.class);
        i.putExtras(b);
        startActivity(i);

    }

    public void clicked(View view) {

        String tag[]=(view).getTag().toString().split(" ");
        String type=tag[0];
        String name=tag[1];
        switch (type) {
            case "Sports":
                if(Sports.get(name)) {
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.white));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(3);
                    Sports.put(name, false);
                }
                else {
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.pickCategoryColor));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(5);
                    Sports.put(name, true);
                }
                break;
            case "Clubs":
                if(Clubs.get(name)){
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.white));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(3);
                    Clubs.put(name, false);
                }
                else {
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.pickCategoryColor));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(5);
                    Clubs.put(name,true);
                }
                break;
            case "Interests":
                if(Interests.get(name)) {
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.white));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(3);
                    Interests.put(name, false);
                }
                else {
                    ((CardView)view).setCardBackgroundColor(getResources().getColor(R.color.pickCategoryColor));
                    ((CardView)view).setRadius(16);
                    ((CardView)view).setCardElevation(5);
                    Interests.put(name,true);
                }
                break;
        }


    }
}
