package com.takbir.kids.quiz;




import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.startapp.android.publish.StartAppAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Level_cleared extends Activity {
	// private static int SPLASH_TIME_OUT = 3000;
	StartAppAd startAppAd;
	ImageView contin;

	// Splash screen timer

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.level_cleared_xml);
		startAppAd = new StartAppAd(this);
		
		AdView adview = (AdView) findViewById(R.id.adView_level_clear_duas);

		AdRequest re = new AdRequest();

		re.setTesting(true);

		adview.loadAd(re);
		

		

		
		
		contin=(ImageView)findViewById(R.id.continue_buton_level_cleared);
		
		contin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				startAppAd.showAd();
				startAppAd.loadAd();
				
				Intent i = new Intent(Level_cleared.this, MainMenu.class);
				startActivity(i);
				
			}
		});

		//
		// new Handler().postDelayed(new Runnable() {
		//
		// @Override
		// public void run() {
		// // This method will be executed once the timer is over
		// // Start your app main activity
		// Intent i = new Intent(level_cleared.this, page_dua_two.class);
		// startActivity(i);
		//
		// // close this activity
		// finish();
		// }
		// }, SPLASH_TIME_OUT);

	}

}
