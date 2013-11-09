package com.spacecaker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class Day extends TextView {

	 private TextView textView;	
	public Day(final Context context, AttributeSet attrs) {
	super(context, attrs);	
	
	textView = (TextView) findViewById(R.id.dayView);
	    
    final Handler h = new Handler();
    h.post(new Runnable() {
        @Override
        public void run() {
            updateTime(context);
            h.postDelayed(this, 1000);
        }
    }); 
	}
	
	protected void updateTime(final Context context) {
		  Calendar cal = Calendar.getInstance();
		  SimpleDateFormat day_date = new SimpleDateFormat("EEEEEEEE");
          String day = day_date.format(cal.getTime());
          textView.setText(day.toUpperCase());
          }

}