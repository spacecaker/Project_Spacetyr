package com.spacecaker;

import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class NoteEditor extends ImageView {

    public NoteEditor (final Context context, AttributeSet attrs) {
		  super(context, attrs);
          BroadcastReceiver mReceiver = new BroadcastReceiver() {    	  
              @Override
              public void onReceive(final Context context, Intent intent) {
                  //start activity
                ImageView image = (ImageView) findViewById(R.id.set_btn);
                image.setImageResource(R.drawable.ic_notify_quicksettings);    				  
				setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent i = new Intent();
						i.setClassName("com.android.settings", "com.android.settings.Settings");
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(i);
						try{ 
							Object service  = context.getSystemService("statusbar");
							Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
							Method collapse = statusbarManager.getMethod("collapse");
							collapse.invoke(service);
							}
							catch(Exception ex){           
	
							}						
					}
				});						                                   
              }              
          }; 
          BroadcastReceiver mReceiver1 = new BroadcastReceiver() {
              @Override
              public void onReceive(final Context context, Intent intent) {
                  //start activity
                ImageView image = (ImageView) findViewById(R.id.set_btn);
                image.setImageResource(R.drawable.touchwiz_edit);    				  
				setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent i = new Intent();
						i.setClassName("com.lidroid.parts", "com.lidroid.parts.MainActivity");
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(i);
						try{ 
							Object service  = context.getSystemService("statusbar");
							Class<?> statusbarManager = Class.forName("android.app.StatusBarManager");
							Method collapse = statusbarManager.getMethod("collapse");
							collapse.invoke(service);
							}
							catch(Exception ex){           
	
							}							
					}
				});				          	  
              }              
          };      
          context.registerReceiver(mReceiver, new IntentFilter("com.spacecaker.FLIP_TO_NOTIF")); 
          context.registerReceiver(mReceiver1, new IntentFilter("com.spacecaker.FLIP_TO_TOGGLES"));
	 }	
}

