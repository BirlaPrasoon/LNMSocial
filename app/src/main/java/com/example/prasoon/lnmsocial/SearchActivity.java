package com.example.prasoon.lnmsocial;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.NestedScrollView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SearchActivity extends Activity implements View.OnTouchListener{

    NestedScrollView scrollView;

    private static final float MIN_DISTANCE = 150f;
    float downX;
    float upX;

    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        scrollView = findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(this);
    }

//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        boolean result = false;
//        try {
//            float diffY = e2.getY() - e1.getY();
//            float diffX = e2.getX() - e1.getX();
//            if (Math.abs(diffX) > Math.abs(diffY)) {
//                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
//                    if (diffX > 0) {
//                        onSwipeRight();
//                    } else {
//                        onSwipeLeft();
//                    }
//                    result = true;
//                }
//            }
//            else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
//                if (diffY > 0) {
//                    onSwipeBottom();
//                } else {
//                    onSwipeTop();
//                }
//                result = true;
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return result;
//    }

    public void onSwipeRight() {
        Toast.makeText(this, "Swipe Right", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void onSwipeLeft() {
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                downX = event.getX();}
            case MotionEvent.ACTION_UP:{
                upX = event.getX();

                float deltaX = downX - upX;

                if(deltaX > MIN_DISTANCE){
                        onSwipeRight();
                        return true;
                }
            }
        }

        return false;
    }
}
