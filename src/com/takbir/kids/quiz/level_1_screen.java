package com.takbir.kids.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
 
public class level_1_screen extends Activity {
	private static int SPLASH_TIME_OUT = 2000;
    // Splash screen timer
  
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    
        
        setContentView(R.layout.level_1_screen_xml);
        
      
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				Intent i = new Intent(level_1_screen.this, page_dua_two.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	

}
    @Override
	public void onBackPressed() {
	    // do nothing.
	}
    }
    
 

