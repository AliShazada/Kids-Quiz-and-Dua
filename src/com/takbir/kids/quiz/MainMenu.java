package com.takbir.kids.quiz;



import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.startapp.android.publish.StartAppAd;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainMenu extends Activity {

	ImageView i, i1, i2;
	StartAppAd startAppAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_xml);

		AdView adview = (AdView) findViewById(R.id.adView);

		AdRequest re = new AdRequest();

		re.setTesting(true);

		adview.loadAd(re);
		
		startAppAd = new StartAppAd(this);
	

		

		i = (ImageView) findViewById(R.id.quiz_button);
		i.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				i.setImageResource(R.drawable.quiz_button2);

				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {

						i.setImageResource(R.drawable.quiz_button);
					}
				}, 80);

				// i.setImageResource(R.drawable.quiz_button);
				Intent i = new Intent();

				i.setClass(MainMenu.this, QuizActivity.class);
				startActivity(i);

			}
		});

		i1 = (ImageView) findViewById(R.id.dua_button);
		i1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i11 = new Intent();

				i11.setClass(MainMenu.this, level_1_screen.class);
				startActivity(i11);

			}
		});

		i2 = (ImageView) findViewById(R.id.settings_button);
		i2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

//				i2.setImageResource(R.drawable.setting_button2);
//
//				final Handler handler = new Handler();
//				handler.postDelayed(new Runnable() {
//					@Override
//					public void run() {
//
//						i2.setImageResource(R.drawable.setting_button);
//					}
//				}, 80);

				Intent i11 = new Intent();

				i11.setClass(MainMenu.this, Setting_activity.class);
				startActivity(i11);

			}
		});

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

