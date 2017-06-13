package com.takbir.kids.quiz;

import com.google.ads.AdRequest;
import com.google.ads.AdView;



import com.startapp.android.publish.StartAppAd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
	
	ImageView contin11;
	StartAppAd startAppAd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get rating bar object
		
		startAppAd = new StartAppAd(this);

		AdView adview = (AdView) findViewById(R.id.adView_quiz_result);

		AdRequest re = new AdRequest();

		re.setTesting(true);

		adview.loadAd(re);
		
		
		
		
		
		contin11=(ImageView)findViewById(R.id.continue_buton_result);
		
		contin11.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				startAppAd.showAd();
				startAppAd.loadAd();
				
				Intent i = new Intent(ResultActivity.this, MainMenu.class);
				startActivity(i);
				
			}
		});
		
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1); 
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		
		bar.setRating(score);
		
		switch (score)
		{
		case 0: t.setText("Oohoo!.. 0/5 No Answer is correct.");
		break;	
		
		case 1: t.setText("Satisfactory!.. Only 1/5 is correct.");
		break;
		
		case 2: t.setText("Fair!... 2/5 are correct!!");
		break;
		
		case 3: t.setText("Good!... 3/5 are correct");
		break;
		
		case 4: t.setText("Good Effort!... 4/5 are correct");
		break;
		
		case 5: t.setText("MashaAllah Excellent!... 5/5 All are correct");
		break;
		
		}
		
		
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}

