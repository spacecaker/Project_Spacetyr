package com.spacecaker;

import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.spacecaker.R;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class Settings extends ImageView {

	 public Settings(final Context context, AttributeSet attrs) {
		  super(context, attrs);
		  
		  ImageView image = (ImageView) findViewById(R.id.set_btn);
		    	
		  image.setImageResource(R.drawable.ic_notify_quicksettings);
			image.setOnClickListener(new View.OnClickListener() {
 
				@Override
				public void onClick(View v) {
					v.getContext().startActivity((new Intent("android.settings.SETTINGS")).setFlags(0x10000000));
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
		public void hide() {
			  this.setVisibility(GONE);
		}
		
		public void unhide() {
			  this.setVisibility(VISIBLE);
		}
	}