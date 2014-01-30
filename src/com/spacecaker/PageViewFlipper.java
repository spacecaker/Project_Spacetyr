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
          		 VF.setInAnimation(outToLeftAnimation());	 
              }
              
          }; 
          BroadcastReceiver mReceiver1 = new BroadcastReceiver() {
              @Override
              public void onReceive(Context c, Intent i) {
             	 VF.setDisplayedChild(1);
          		 VF.setInAnimation(outToLeftAnimation());
              }
              
          };      
          context.registerReceiver(mReceiver, new IntentFilter("com.spacecaker.FLIP_TO_NOTIF")); 
          context.registerReceiver(mReceiver1, new IntentFilter("com.spacecaker.FLIP_TO_TOGGLES"));
	 }	
    
	private Animation inFromRightAnimation() {
  	  Animation inFromRight = AnimationUtils.loadAnimation(getContext(), R.anim.flip_3d_quicker_anim_out);
  	  return inFromRight;
  	 }

	private Animation outToLeftAnimation() {
         Animation outtoLeft = AnimationUtils.loadAnimation(getContext(), R.anim.flip_3d_quicker_anim);
      return outtoLeft;
     }

}

