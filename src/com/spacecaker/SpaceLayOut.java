package com.spacecaker;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class SpaceLayOut extends LinearLayout {
	
    private LinearLayout ln;
    String message;
    String layoutType;
    private static final int MAJOR_MOVE = 60;
    private GestureDetector mGestureDetector; 
    Handler mHandler = new Handler();
    
	public SpaceLayOut(final Context context, AttributeSet attrs) {
	super(context, attrs); 
		
	 ln = (LinearLayout) findViewById(R.id.spacelayoutbar);

     mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
         public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                float velocityY) {
             int dx = (int) (e2.getX() - e1.getX());

             // don't accept the fling if it's too short
             // as it may conflict with tracking move
             if (Math.abs(dx) > MAJOR_MOVE && Math.abs(velocityX) > Math.abs(velocityY)) {
                 if (velocityX > 0) {
                     mHandler.post(new Runnable() {
                         @Override
                         public void run() {
                        		Intent intent = new Intent();
                        		intent.setAction("com.spacecaker.FLIP_TO_TOGGLES");
                        		context.sendBroadcast(intent); 
                         }
                     });
                 } else {
                     mHandler.post(new Runnable() {
                         @Override
                         public void run() {
                        		Intent intent = new Intent();
                        		intent.setAction("com.spacecaker.FLIP_TO_NOTIF");
                        		context.sendBroadcast(intent); 
                         }
                     });
                 }
                 return true;
             } else {
                 return false;
             }
         }
     });	 	 
    }; 
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
   
}
