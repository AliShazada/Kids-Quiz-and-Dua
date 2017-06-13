package com.takbir.kids.quiz;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.startapp.android.publish.StartAppAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Setting_activity extends Activity {
	StartAppAd startAppAd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting_layout);
		
		startAppAd = new StartAppAd(this);
		
		AdView adview = (AdView) findViewById(R.id.adView_settings);

		AdRequest re = new AdRequest();

		re.setTesting(true);

		adview.loadAd(re);
		
		
	}
	
	
	@Override
	public void onResume(){
	super.onResume();
	startAppAd.onResume();
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		startAppAd.onBackPressed();
		
//		Intent i = new Intent();
//
//		i.setClass(Setting_activity.this, MainMenu.class);
//		startActivity(i);
		
	}

}
