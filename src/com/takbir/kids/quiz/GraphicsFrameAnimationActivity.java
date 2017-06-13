package com.takbir.kids.quiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class GraphicsFrameAnimationActivity extends Activity {
	private AnimationDrawable mAnim;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView imageView = (ImageView) findViewById(R.id.countdown_frame);

		imageView.setBackgroundResource(R.drawable.view_animation);

		mAnim = (AnimationDrawable) imageView.getBackground();
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		    @Override
		    public void run() {
		        // Do something after 5s = 5000ms
		    	
		    	finish();
		    	
		    	Intent i = new Intent(GraphicsFrameAnimationActivity.this, MainMenu.class);
		    	startActivity(i);
		    }
		}, 7000);
		
		
		
	}

	
	@Override
	protected void onPause() {
 		super.onPause();
		if (mAnim.isRunning()) {
			mAnim.stop();
		}
	}


	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			mAnim.start();
		}
	}
	
	@Override
	public void onBackPressed() {
	    // do nothing.
	}
}
