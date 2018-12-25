package com.example.prasoon.lnmsocial.viewPagers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.prasoon.lnmsocial.SearchResultActivity;
import com.example.prasoon.lnmsocial.activities.ProfileActivity;
import com.example.prasoon.lnmsocial.activities.SearchActivity;

public class VerticalViewPager extends ViewPager {

    private float x1,x2;
    static final int MIN_DISTANCE = 350;

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setPageTransformer(true, new VerticalPageTransformerAnimate());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    /**
     * Swaps the X and Y coordinates of your touch event.
     */
    private MotionEvent swapXY(MotionEvent ev) {
        float width = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * width;
        float newY = (ev.getX() / width) * height;

        ev.setLocation(newX, newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev){
        boolean intercepted = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercepted;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performClick();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (deltaX > MIN_DISTANCE)
                {

                    Intent intent = new Intent(getContext(), SearchActivity.class);
                    getContext().startActivity(intent);
                }
                else if( deltaX < -MIN_DISTANCE)
                {
//                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    Intent intent = new Intent(getContext(), SearchResultActivity.class);
                    getContext().startActivity(intent);
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(swapXY(event));
    }

    private class VerticalPageTransformerAnimate implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.5f;

        @Override
        public void transformPage(@NonNull View view, float position) {

            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();
            float alpha = 0;
            if (0 <= position && position <= 1) {
                alpha = 1 - position;
            } else if (-1 < position && position < 0) {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float verticalMargin = pageHeight * (1 - scaleFactor) / 2;
                float horizontalMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horizontalMargin - verticalMargin / 2);
                } else {
                    view.setTranslationX(-horizontalMargin + verticalMargin / 2);
                }

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                alpha = position + 1;
            }

            view.setAlpha(alpha);
            view.setTranslationX(view.getWidth() * -position);
            float yPosition = position * view.getHeight();
            view.setTranslationY(yPosition);

        }
    }

}

