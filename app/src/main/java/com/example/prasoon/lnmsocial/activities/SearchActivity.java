package com.example.prasoon.lnmsocial.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.prasoon.lnmsocial.R;
import com.example.prasoon.lnmsocial.models.User;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends Activity implements View.OnTouchListener {

    ArrayList<String> arrayList;
    ArrayList<User> userList;
    NestedScrollView rootView;
    ImageView departmentsArrow, clubsArrow, sportsArrow, interestsArrow;
    @BindView(R.id.dept_CSE)
    CheckBox CSE;
    @BindView(R.id.dept_CCE)
    CheckBox CCE;
    @BindView(R.id.dept_MTE)
    CheckBox MTE;
    @BindView(R.id.dept_EC)
    CheckBox EC;
    @BindView(R.id.dept_ME)
    CheckBox ME;
    @BindView(R.id.club_cybros)
    CheckBox clubCybros;
    @BindView(R.id.club_csi)
    CheckBox Csi;
    @BindView(R.id.club_insignia)
    CheckBox clubInsignia;
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
    CheckBox intUiux;
    @BindView(R.id.int_ios)
    CheckBox intIos;
    @BindView(R.id.searchText)
    EditText searchText;

    private ExpandableRelativeLayout departmentLayout, sportsLayout, clubsLayout, interestsLayout;

    private static final float MIN_DISTANCE = 250f;
    float downX;
    float upX;

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        rootView = findViewById(R.id.rootView);
        rootView.setOnTouchListener(this);

        arrayList = new ArrayList<>();

        departmentLayout = findViewById(R.id.departmentExpandableLayout);
        sportsLayout = findViewById(R.id.sportsExpandableLayout);
        clubsLayout = findViewById(R.id.clubsExpandableLayout);
        interestsLayout = findViewById(R.id.interestsExpandableLayout);

        departmentsArrow = findViewById(R.id.departMentArrow);
        clubsArrow = findViewById(R.id.clubsArrow);
        sportsArrow = findViewById(R.id.sportsArrow);
        interestsArrow = findViewById(R.id.interestsArrow);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                downX = event.getX();
            }
            case MotionEvent.ACTION_UP: {
                upX = event.getX();

                float deltaX = downX - upX;

                if (deltaX > MIN_DISTANCE) {
                    finish();
                    return true;
                }
            }
        }

        return false;
    }

    public void departmentClicked(View view) {
        departmentLayout.toggle(500, new BounceInterpolator());
        departmentsArrow.animate().rotationBy(180f).setDuration(200);

        if (clubsLayout.isExpanded()) {
            clubsArrow.animate().rotationBy(180f).setDuration(200);
            clubsLayout.collapse(500, new BounceInterpolator());
        }
        if (sportsLayout.isExpanded()) {
            sportsArrow.animate().rotationBy(180f).setDuration(200);
            sportsLayout.collapse(500, new BounceInterpolator());
        }
        if (interestsLayout.isExpanded()) {
            interestsArrow.animate().rotationBy(180f).setDuration(200);
            interestsLayout.collapse(500, new BounceInterpolator());
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
        if (departmentLayout.isExpanded()) {
            departmentLayout.collapse(500, new BounceInterpolator());
            departmentsArrow.animate().rotationBy(180f).setDuration(200);
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
        if (departmentLayout.isExpanded()) {
            departmentLayout.collapse(500, new BounceInterpolator());
            departmentsArrow.animate().rotationBy(180f).setDuration(200);
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
        if (departmentLayout.isExpanded()) {
            departmentLayout.collapse(500, new BounceInterpolator());
            departmentsArrow.animate().rotationBy(180f).setDuration(200);
        }
    }


    @OnClick({R.id.departMentArrow, R.id.dept_CSE, R.id.dept_CCE, R.id.dept_MTE, R.id.dept_EC, R.id.dept_ME, R.id.club_cybros, R.id.club_csi, R.id.club_insignia, R.id.club_ecell, R.id.club_ccell, R.id.club_arts, R.id.club_rendition, R.id.club_quizzinga, R.id.club_literary, R.id.club_chess, R.id.club_fashion, R.id.club_innovation, R.id.sport_badminton, R.id.sport_ttennis, R.id.sport_cricket, R.id.sport_football, R.id.sport_volleyball, R.id.sport_basketball, R.id.sport_lawn_tennis, R.id.sport_kabaddi, R.id.sport_squash, R.id.int_cp, R.id.int_ai, R.id.int_ds, R.id.int_ml, R.id.int_web_dev, R.id.int_mobile_web, R.id.int_android, R.id.int_literature, R.id.int_blockchain, R.id.int_content_writing, R.id.int_uiux, R.id.int_ios})
    public void onViewClicked(View view) {
        switch (view.getId()) {
                case R.id.dept_CSE:
                    if (CSE.isChecked())
                        arrayList.add("CSE");
                    else
                        arrayList.remove("CSE");
                    break;
                case R.id.dept_CCE:
                    if (CCE.isChecked())
                        arrayList.add("CCE");
                    else
                        arrayList.remove("CCE");
                    break;
                case R.id.dept_MTE:
                    if (MTE.isChecked())
                        arrayList.add("MME");
                    else
                        arrayList.remove("MME");
                    break;
                case R.id.dept_EC:
                    if (EC.isChecked())
                        arrayList.add("ECE");
                    else
                        arrayList.remove("ECE");
                    break;
                case R.id.dept_ME:
                    if (ME.isChecked())
                        arrayList.add("ME");
                    else
                        arrayList.remove("ME");
                    break;

                case R.id.club_csi:
                    if (Csi.isChecked())
                        arrayList.add("CSI");
                    else
                        arrayList.remove("CSI");
                    break;
                case R.id.club_innovation:
                    if (Innovation.isChecked())
                        arrayList.add("Innovation");
                    else
                        arrayList.remove("Innovation");
                    break;
                case R.id.club_ecell:
                    if (Ecell.isChecked())
                        arrayList.add("ECell");
                    else
                        arrayList.remove("ECell");
                    break;
                case R.id.club_ccell:
                    if (Ccell.isChecked())
                        arrayList.add("CCell");
                    else
                        arrayList.remove("CCell");
                    break;
                case R.id.club_arts:
                    if (Arts.isChecked())
                        arrayList.add("Arts");
                    else
                        arrayList.remove("Arts");
                    break;
                case R.id.club_rendition:
                    if (Rendition.isChecked())
                        arrayList.add("Rendition");
                    else
                        arrayList.remove("Rendition");
                    break;
                case R.id.club_quizzinga:
                    if (Quizzinga.isChecked())
                        arrayList.add("Quizzinga");
                    else
                        arrayList.remove("Quizzinga");
                    break;
                case R.id.club_literary:
                    if (Literary.isChecked())
                        arrayList.add("Literary");
                    else
                        arrayList.remove("Literary");
                    break;
                case R.id.club_chess:
                    if (Chess.isChecked())
                        arrayList.add("Chess");
                    else
                        arrayList.remove("Chess");
                    break;
                case R.id.club_fashion:
                    if (Fashion.isChecked())
                        arrayList.add("Fashion");
                    else
                        arrayList.remove("Fashion");
                    break;
                case R.id.club_cybros:
                    if (clubCybros.isChecked())
                        arrayList.add("Cybros");
                    else
                        arrayList.remove("Cybros");
                    break;
                case R.id.club_insignia:
                    if (clubInsignia.isChecked())
                        arrayList.add("Insignia");
                    else
                        arrayList.remove("Insignia");
                    break;


                case R.id.sport_badminton:
                    if (Badminton.isChecked())
                        arrayList.add("Badminton");
                    else
                        arrayList.remove("Badminton");
                    break;
                case R.id.sport_cricket:
                    if (Cricket.isChecked())
                        arrayList.add("Cricket");
                    else
                        arrayList.remove("Cricket");
                    break;
                case R.id.sport_football:
                    if (Football.isChecked())
                        arrayList.add("Football");
                    else
                        arrayList.remove("Football");
                    break;
                case R.id.sport_volleyball:
                    if (Volleyball.isChecked())
                        arrayList.add("VolleyBall");
                    else
                        arrayList.remove("VolleyBall");
                    break;
                case R.id.sport_basketball:
                    if (Basketball.isChecked())
                        arrayList.add("Basketball");
                    else
                        arrayList.remove("Basketball");
                    break;
                case R.id.sport_lawn_tennis:
                    if (LawnTennis.isChecked())
                        arrayList.add("LawnTennis");
                    else
                        arrayList.remove("LawnTennis");
                    break;
                case R.id.sport_kabaddi:
                    if (Kabaddi.isChecked())
                        arrayList.add("Kabbadi");
                    else
                        arrayList.remove("Kabbadi");
                    break;
                case R.id.sport_squash:
                    if (Squash.isChecked())
                        arrayList.add("Squash");
                    else
                        arrayList.remove("Squash");
                    break;
                case R.id.sport_ttennis:
                    if (Ttennis.isChecked())
                        arrayList.add("TableTennis");
                    else
                        arrayList.remove("TableTennis");
                    break;

                //TODO: INTERESTS
                case R.id.int_cp:
                    if (Cp.isChecked())
                        arrayList.add("CP");
                    else
                        arrayList.remove("CP");
                    break;
                case R.id.int_ai:
                    if (Ai.isChecked())
                        arrayList.add("AI");
                    else
                        arrayList.remove("AI");
                    break;
                case R.id.int_ds:
                    if (Ds.isChecked())
                        arrayList.add("DS");
                    else
                        arrayList.remove("DS");
                    break;
                case R.id.int_ml:
                    if (Ml.isChecked())
                        arrayList.add("ML");
                    else
                        arrayList.remove("ML");
                    break;
                case R.id.int_mobile_web:
                    if (MobileWeb.isChecked())
                        arrayList.add("MobileWeb");
                    else
                        arrayList.remove("MobileWeb");
                    break;
                case R.id.int_android:
                    if (Android.isChecked())
                        arrayList.add("Android");
                    else
                        arrayList.remove("Android");
                    break;
                case R.id.int_literature:
                    if (Literature.isChecked())
                        arrayList.add("Literature");
                    else
                        arrayList.remove("Literature");
                    break;
                case R.id.int_blockchain:
                    if (Blockchain.isChecked())
                        arrayList.add("Blockchain");
                    else
                        arrayList.remove("Blockchain");
                    break;
                case R.id.int_content_writing:
                    if (ContentWriting.isChecked())
                        arrayList.add("ContentWriting");
                    else
                        arrayList.remove("ContentWriting");
                    break;
                case R.id.int_web_dev:
                    if (WebDev.isChecked())
                        arrayList.add("WebDev");
                    else
                        arrayList.remove("WebDev");
                    break;
                case R.id.int_uiux:
                    if (intUiux.isChecked())
                        arrayList.add("uiux");
                    else
                        arrayList.remove("uiux");
                    break;
                case R.id.int_ios:
                    if (intIos.isChecked())
                        arrayList.add("IOS");
                    else
                        arrayList.remove("IOS");
                    break;
        }
    }

    public void search(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra("arraylist", arrayList);

        Editable search = searchText.getText();
        String query = "none";
        if(search!=null)
            query = search.toString();
        intent.putExtra("query", query);
        String from = "SearchActivity";
        intent.putExtra("from", from);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}
