package com.spacecaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class PageView extends ViewFlipper {

    ViewFlipper VF;

    public PageView (final Context context, AttributeSet attrs) {
		  super(context, attrs);
  
          BroadcastReceiver mReceiver = new BroadcastReceiver() {
              @Override
              public void onReceive(Context c, Intent i) {
            	 VF.setDisplayedChild(2);
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
          context.registerReceiver(mReceiver, new IntentFilter("com.spacecaker.FLIP_TO_SLIDER")); 
          context.registerReceiver(mReceiver1, new IntentFilter("com.spacecaker.FLIP_TO_PANEL"));
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

