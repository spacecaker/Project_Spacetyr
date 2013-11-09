package com.spacecaker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.spacecaker.R;

import android.os.Handler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class Date extends TextView {

	TextView textView;
	
	public Date(final Context context, AttributeSet attrs) {
	super(context, attrs);	
	
	textView = (TextView) findViewById(R.id.dateView);
   
    	
    final Handler h = new Handler();
    h.post(new Runnable() {
        @Override
        public void run() {
            updateTime(context);
            h.postDelayed(this, 1000);
        }
    }); 
	};

	protected void updateTime(final Context context) {
		  textView = (TextView) findViewById(R.id.dateView);
		  Calendar cal = Calendar.getInstance();
		  SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMM");
		  SimpleDateFormat year_date = new SimpleDateFormat("yyyy");
		  SimpleDateFormat day_date = new SimpleDateFormat("dd");
          String day = day_date.format(cal.getTime());
          String mon = month_date.format(cal.getTime());
          String year = year_date.format(cal.getTime());
          textView.setText(mon.toUpperCase()+" "+day+", "+year);
          }
	
}
