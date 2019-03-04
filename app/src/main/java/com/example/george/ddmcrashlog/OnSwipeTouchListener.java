package com.example.george.ddmcrashlog;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


    // This class is to gain a swipe touch functionality
    // If user does not want to use the touch controls they can swipe in the appropriate direction
    // Will be mainly used for the splash and onboarding screen as its most appropriate to get the pop up effect this way
public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;

    // Using library GestureDetector for our motion event
    public OnSwipeTouchListener(Context ctx) {
        gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {

        // Swipe threshold is how much the user has to swipe to gain the functionality (distance of swipe)
        // Velocity threshold is the speed of the swipe itself
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;

            // gaining the directions of vertical and horizontal
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight(); // Our method call for swipe Right diffX > 0
                        } else {
                            onSwipeLeft(); // Our method call for swipe Left diffX < 0
                        }
                        result = true;
                    }
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY < 0) {
                        onSwipeBottom(); // Our method call for swipe Bottom diffY < 0
                    } else {
                        onSwipeTop(); // Our method call for swipe Top diffY > 0
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRight() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeTop() {
    }

    public void onSwipeBottom() {
    }
}