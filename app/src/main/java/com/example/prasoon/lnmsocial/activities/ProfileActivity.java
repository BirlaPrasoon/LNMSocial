package com.example.prasoon.lnmsocial.activities;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.Utility;
import com.example.prasoon.lnmsocial.models.User;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends FragmentActivity implements View.OnTouchListener {

    @BindView(R.id.circleImageView)
    CircleImageView circleImageView;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_about)
    TextView userAbout;
    @BindView(R.id.hometown)
    TextView hometown;
    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.user_department)
    TextView userDepartment;
    @BindView(R.id.user_current_year)
    TextView userCurrentYear;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.CSI)
    CardView CSI;
    @BindView(R.id.Cybros)
    CardView Cybros;
    @BindView(R.id.Insignia)
    CardView Insignia;
    @BindView(R.id.ECell)
    CardView ECell;
    @BindView(R.id.CCell)
    CardView CCell;
    @BindView(R.id.Arts)
    CardView Arts;
    @BindView(R.id.Rendition)
    CardView Rendition;
    @BindView(R.id.Quizzinga)
    CardView Quizzinga;
    @BindView(R.id.Literary)
    CardView Literary;
    @BindView(R.id.Chess)
    CardView Chess;
    @BindView(R.id.Fashion)
    CardView Fashion;
    @BindView(R.id.Innovation)
    CardView Innovation;
    @BindView(R.id.Badminton)
    CardView Badminton;
    @BindView(R.id.TableTennis)
    CardView TableTennis;
    @BindView(R.id.Basketball)
    CardView Basketball;
    @BindView(R.id.VolleyBall)
    CardView VolleyBall;
    @BindView(R.id.Football)
    CardView Football;
    @BindView(R.id.Cricket)
    CardView Cricket;
    @BindView(R.id.LawnTennis)
    CardView LawnTennis;
    @BindView(R.id.Kabbadi)
    CardView Kabbadi;
    @BindView(R.id.Squash)
    CardView Squash;
    @BindView(R.id.AI)
    CardView AI;
    @BindView(R.id.CP)
    CardView CP;
    @BindView(R.id.DS)
    CardView DS;
    @BindView(R.id.ML)
    CardView ML;
    @BindView(R.id.WebDev)
    CardView WebDev;
    @BindView(R.id.MobileWeb)
    CardView MobileWeb;
    @BindView(R.id.Android)
    CardView Android;
    @BindView(R.id.Literature)
    CardView Literature;
    @BindView(R.id.Blockchain)
    CardView Blockchain;
    @BindView(R.id.ContentWriting)
    CardView ContentWriting;
    @BindView(R.id.IOS)
    CardView IOS;
    @BindView(R.id.UIUX)
    CardView UIUX;
    @BindView(R.id.rootViewProfileActivity)
    NestedScrollView rootViewProfileActivity;
    @BindView(R.id.userPhoneNumber)
    TextView userPhoneNumber;
    @BindView(R.id.facebookIcon)
    ImageView facebookIcon;
    @BindView(R.id.linkedInIcon)
    ImageView linkedInIcon;
    @BindView(R.id.githubIcon)
    ImageView githubIcon;
    @BindView(R.id.twitterIcon)
    ImageView twitterIcon;
    private float downX, upX;
    static final int MIN_DISTANCE = 150;

    private NestedScrollView rootView;

    private int index = -1;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        rootView = findViewById(R.id.rootViewProfileActivity);
        rootView.setOnTouchListener(this);

        Intent i = getIntent();
        if (i != null) {
            index = Integer.parseInt(i.getStringExtra("index"));
        }

        if (index != -1) {
            user = Utility.getData().get(index);
            //todo: clubs:
            if (user.getCSI().equals(true)) CSI.setVisibility(View.VISIBLE);
            if (user.getCybros().equals(true)) Cybros.setVisibility(View.VISIBLE);
            if (user.getInsignia().equals(true)) Insignia.setVisibility(View.VISIBLE);
            if (user.getEcell().equals(true)) ECell.setVisibility(View.VISIBLE);
            if (user.getCcell().equals(true)) CCell.setVisibility(View.VISIBLE);
            if (user.getArts().equals(true)) Arts.setVisibility(View.VISIBLE);
            if (user.getRendition().equals(true)) Rendition.setVisibility(View.VISIBLE);
            if (user.getQuizzinga().equals(true)) Quizzinga.setVisibility(View.VISIBLE);
            if (user.getLiterary().equals(true)) Literary.setVisibility(View.VISIBLE);
            if (user.getChess().equals(true)) Chess.setVisibility(View.VISIBLE);
            if (user.getFashion().equals(true)) Fashion.setVisibility(View.VISIBLE);
            if (user.getInnovation().equals(true)) Innovation.setVisibility(View.VISIBLE);
            //todo: sports
            if (user.getBadminton().equals(true)) Badminton.setVisibility(View.VISIBLE);
            if (user.getTableTennis().equals(true)) TableTennis.setVisibility(View.VISIBLE);
            if (user.getCricket().equals(true)) Cricket.setVisibility(View.VISIBLE);
            if (user.getBasketball().equals(true)) Basketball.setVisibility(View.VISIBLE);
            if (user.getFootball().equals(true)) Football.setVisibility(View.VISIBLE);
            if (user.getVolleyball().equals(true)) VolleyBall.setVisibility(View.VISIBLE);
            if (user.getLawnTennis().equals(true)) LawnTennis.setVisibility(View.VISIBLE);
            if (user.getSquash().equals(true)) Squash.setVisibility(View.VISIBLE);
            if (user.getKabaddi().equals(true)) Kabbadi.setVisibility(View.VISIBLE);

            //todo:interests
            if (user.getAI().equals(true)) AI.setVisibility(View.VISIBLE);
            if (user.getCP().equals(true)) CP.setVisibility(View.VISIBLE);
            if (user.getML().equals(true)) ML.setVisibility(View.VISIBLE);
            if (user.getDS().equals(true)) DS.setVisibility(View.VISIBLE);
            if (user.getWebDev().equals(true)) WebDev.setVisibility(View.VISIBLE);
            if (user.getMobileWebDev().equals(true)) MobileWeb.setVisibility(View.VISIBLE);
            if (user.getIos().equals(true)) IOS.setVisibility(View.VISIBLE);
            if (user.getAndroid().equals(true)) Android.setVisibility(View.VISIBLE);
            if (user.getBlockChain().equals(true)) Blockchain.setVisibility(View.VISIBLE);
            if (user.getContentWriting().equals(true)) ContentWriting.setVisibility(View.VISIBLE);
            if (user.getLiterature().equals(true)) Literature.setVisibility(View.VISIBLE);
            if (user.getUiux().equals(true)) UIUX.setVisibility(View.VISIBLE);

            if (user.getImageUrl() != null && user.getImageUrl().length() > 20) {
                Utility.downloadImage(user.getImageUrl(), circleImageView);
            } else {
                Picasso.get().load(R.drawable.user_profile).into(circleImageView);
            }
            userName.setText(user.getFirstName());
            userAbout.setText(user.getAboutMe());
            userDepartment.setText(user.getDepartment());
            userCurrentYear.setText(user.getYear());
            userPhoneNumber.setText(user.getPhoneNumber());
            hometown.setText(user.getHometown());
            state.setText(user.getState());

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
            }
            case MotionEvent.ACTION_UP: {
                upX = event.getX();

                float deltaX = upX - downX;

                if (deltaX > MIN_DISTANCE) {
                    finish();
                    return true;
                }
            }
        }

        return false;
    }

    @OnClick(R.id.userPhoneNumber)
    public void onViewClicked() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + user.getPhoneNumber()));
        startActivity(intent);
    }

    public void iconClicked(View view) {

        String tag = view.getTag().toString();

        switch (tag){
            case "facebook":
                if(user.getFacebookProfileLink() == null
                        ||user.getFacebookProfileLink().length()==0
                        ||user.getFacebookProfileLink().equals("later")){
                    Toast.makeText(this, "No link provided", Toast.LENGTH_SHORT).show();
                }else {
                    // open web View
                    Intent i = new Intent(this,WebViewActivity.class);
                    i.putExtra("url",user.getFacebookProfileLink());
                    startActivity(i);
                }
                break;
            case "github":
                if(user.getGithubProfileLink() ==null
                        ||user.getGithubProfileLink().length()==0
                        ||user.getGithubProfileLink().equals("later")){
                    Toast.makeText(this, "No link provided", Toast.LENGTH_SHORT).show();
                }else {
                    // open web View
                    Intent i = new Intent(this,WebViewActivity.class);
                    i.putExtra("url",user.getGithubProfileLink());
                    startActivity(i);
                }
                break;
            case "linkedin":
                if(user.getLinkedInProfileLink() ==null
                        || user.getLinkedInProfileLink().length()==0
                        || user.getLinkedInProfileLink().equals("later")) {
                    Toast.makeText(this, "No link provided", Toast.LENGTH_SHORT).show();
                }else {
                    // open web View
                    Intent i = new Intent(this,WebViewActivity.class);
                    i.putExtra("url",user.getLinkedInProfileLink());
                    startActivity(i);
                }
                break;
            case "twitter":
                if(user.getTwitterProfileLink() ==null
                        || user.getTwitterProfileLink().length() == 0
                        || user.getTwitterProfileLink().equals("later")){
                    Toast.makeText(this, "No link provided", Toast.LENGTH_SHORT).show();
                }else {
                    // open web View
                    Intent i = new Intent(this,WebViewActivity.class);
                    i.putExtra("url",user.getTwitterProfileLink());
                    startActivity(i);
                }
                break;
        }
    }
}