package com.spacecaker;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class Boot extends RelativeLayout {

    public Boot (final Context context, AttributeSet attrs) {
		  super(context, attrs);  
			Intent intent = new Intent();
			intent.setAction("com.spacecaker.FLIP_TO_NOTIF");
			context.sendBroadcast(intent);
	}		
}

