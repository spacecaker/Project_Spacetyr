package com.spacecaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class PageViewFlipper extends ViewFlipper {

    ViewFlipper VF;

    public PageViewFlipper (final Context context, AttributeSet attrs) {
		  super(context, attrs);
		  VF = (ViewFlipper) findViewById(R.id.flipper);
          BroadcastReceiver mReceiver = new BroadcastReceiver() {    	  
              @Override
              public void onReceive(Context c, Intent i) {
            	 VF.setDisplayedChild(0);
          		 VF.setInAnimation(inFromLeftAnimation());	 
              }
              
          }; 
          BroadcastReceiver mReceiver1 = new BroadcastReceiver() {
              @Override
              public void onReceive(Context c, Intent i) {
             	 VF.setDisplayedChild(1);
          		 VF.setInAnimation(inFromLeftAnimation());
              }
              
          };      
          context.registerReceiver(mReceiver, new IntentFilter("com.spacecaker.FLIP_TO_NOTIF")); 
          context.registerReceiver(mReceiver1, new IntentFilter("com.spacecaker.FLIP_TO_TOGGLES"));
	 }	
    
    @SuppressWarnings("unused")
	private Animation inFromRightAnimation() {
  	  Animation inFromRight = AnimationUtils.loadAnimation(getContext(), R.anim.flip_3d_quicker_anim);
  	  return inFromRight;
  	 }

    	 @SuppressWarnings("unused")
		private Animation outToLeftAnimation() {
          Animation outtoLeft = AnimationUtils.loadAnimation(getContext(), R.anim.flip_3d_quicker_anim);
    	  return outtoLeft;
    	 }

    	 private Animation inFromLeftAnimation() {
          Animation inFromLeft = AnimationUtils.loadAnimation(getContext(), R.anim.flip_3d_quicker_anim);
    	  return inFromLeft;
    	 }

}

