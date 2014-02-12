package com.spacecaker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;

public class DeliciousCake extends View {
	
    private View spaceStatusBar;
    String message;
	public DeliciousCake(final Context context, AttributeSet attrs) {
	super(context, attrs); 
	
	spaceStatusBar = (View) findViewById(R.id.cake_bar_space);	 
	try{ 
		spaceStatusBar.setBackgroundResource(R.drawable.tw_gradient_bg);
		spaceStatusBar.getBackground(); 
		}
		catch(Exception ex){           
		}  
		
    BroadcastReceiver mHomeScreen = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
			try{ 
	    		spaceStatusBar.setBackgroundResource(R.drawable.tw_gradient_bg);
	    		spaceStatusBar.getBackground(); 
				}
				catch(Exception ex){           
				}        	 
        }
        
    };      
    
    BroadcastReceiver mOther = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
			try{ 
	    		spaceStatusBar.setBackgroundResource(R.drawable.tw_other_background);
	    		spaceStatusBar.getBackground(); 
				}
				catch(Exception ex){           
				}        	
        }
        
    };    
    
	context.registerReceiver(mHomeScreen, new IntentFilter("android.intent.category.MONKEY"));
	context.registerReceiver(mHomeScreen, new IntentFilter("com.cooee.launcherS3"));
	context.registerReceiver(mHomeScreen, new IntentFilter("com.iLoong.launcher.desktop.iLoongLauncher"));
	context.registerReceiver(mHomeScreen, new IntentFilter("com.iLoong.launcher.desktop.iLoongApplication"));
	context.registerReceiver(mHomeScreen, new IntentFilter("com.iLoong.launcher.app.LauncherProvider"));
	context.registerReceiver(mOther, new IntentFilter("Intent.ACTION_SCREEN_ON"));
	context.registerReceiver(mOther, new IntentFilter("android.intent.action.SCREEN_ON"));
	context.registerReceiver(mOther, new IntentFilter("android.search.action.GLOBAL_SEARCH"));
	context.registerReceiver(mOther, new IntentFilter("com.google.android.finsky.FinskyApp"));
	context.registerReceiver(mOther, new IntentFilter("com.google.android.finsky.FinskyApp.AssetBrowserActivity"));
	context.registerReceiver(mOther, new IntentFilter("com.noshufou.android.su"));
	context.registerReceiver(mOther, new IntentFilter("com.noshufou.android.su.HomeActivity"));
	context.registerReceiver(mOther, new IntentFilter("com.whatsapp"));
	context.registerReceiver(mOther, new IntentFilter("com.whatsapp.Main"));
	context.registerReceiver(mOther, new IntentFilter("com.whatsapp.Conversation"));
	}
}
