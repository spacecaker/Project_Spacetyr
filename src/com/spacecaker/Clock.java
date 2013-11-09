package com.spacecaker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class Clock extends TextView {
	
 private TextView clock;
 
	 public Clock(final Context context, AttributeSet attrs) {
		  super(context, attrs);

			clock = (TextView) findViewById(R.id.clock);
     
              final Handler h = new Handler();
              h.post(new Runnable() {
                  @Override
                  public void run() {
                      updateTime();
                      h.postDelayed(this, 1000);
                  }
              });               
              };

	private void updateTime() {
		  Calendar cal = Calendar.getInstance();
          int hour = cal.get(Calendar.HOUR);
          SimpleDateFormat ampm = new SimpleDateFormat("aa");
          String am_pm = ampm.format(cal.getTime());
          int min = cal.get(Calendar.MINUTE);
          if (min < 10) {
        	  
        	  if (hour < 10){
        		  if (hour == 0){
                      clock.setText("12"+":"+"0"+min);
                	  }
        		  else {
        			  clock.setText("0"+hour+":"+"0"+min);	  
        		  }
        	  }
        	  else {
                  clock.setText(hour+":"+"0"+min);  
        	  }
          }
          else {
        	  if (hour < 10){
        		  if (hour == 0){
                      clock.setText("12"+":"+min);
                	  }
        		  else {
        			  clock.setText("0"+hour+":"+min);	  
        		  }
        	  }
        	  else {
                  clock.setText(hour+":"+min);  
        	  }
          }	
		
	}
	 
}
