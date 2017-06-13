package com.takbir.kids.quiz;

import java.util.Timer;
import java.util.TimerTask;

import com.startapp.android.publish.StartAppAd;

import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class page_dua_two extends Activity {

	private static int SPLASH_TIME_OUT1 = 19500;

	ImageView b1;
	MediaPlayer mp = null;
	String click = "click";
	int counter = 0;
	ImageView im1;
	ImageView im2;
	ImageView im3;

	ImageView stop;
	ImageView next_but;
	ImageView close;

	StartAppAd startAppAd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dua1);

		startAppAd = new StartAppAd(this);
		
		final  AlertDialog ad=new AlertDialog.Builder(this).create();
		
		b1 = (ImageView) findViewById(R.id.play_button2);
		stop = (ImageView) findViewById(R.id.stop);
		next_but = (ImageView) findViewById(R.id.next_lay_one_but1);
		close=(ImageView)findViewById(R.id.close_btn1);

		im1 = (ImageView) findViewById(R.id.img1_a);
		im2 = (ImageView) findViewById(R.id.img2_a);
		im3 = (ImageView) findViewById(R.id.img3_a);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				// managerOfSound(click);

				
				counter = counter + 1;
				if (counter == 1) {
					im1.setImageResource(R.drawable.star);

					ad.setTitle("Good!");
                    ad.setMessage("Now Listen carefully and then Play again to get one more Star");
                    ad.setIcon(R.drawable.bachii);
                    ad.show();
                    
                    final Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            ad.dismiss(); // when the task active then close the dialog
                            t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                        }
                    }, 2000); // after 2 second (or 2000 miliseconds), the task will be active.
                   
                    managerOfSound(click);
//					Toast.makeText(getApplicationContext(),
//							"Good !!.. Play again to get one more Star",
//							Toast.LENGTH_SHORT).show();

				} else if (counter == 2) {
					im2.setImageResource(R.drawable.star);
					
					ad.setTitle("Very Good!");
                    ad.setMessage("Now Listen carefully and then Play again to get another Star");
                    ad.setIcon(R.drawable.bachha);
                    ad.show();
                    
                    final Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            ad.dismiss(); // when the task active then close the dialog
                            t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                        }
                    }, 2000); // after 2 second (or 2000 miliseconds), the task will be active.
                    
                    managerOfSound(click);

//					Toast.makeText(getApplicationContext(),
//							"Very Good !!.. Play again to get another Star",
//							Toast.LENGTH_SHORT).show();

				} else if (counter == 3) {

//					Toast.makeText(getApplicationContext(),
//							"MashaAllah !!.. Excellent Job ", Toast.LENGTH_SHORT)
//							.show();
					
					ad.setTitle("MashaAllah !!.. Excellent Job!");
                    ad.setMessage("Now Listen carefully and after Press the Next Button");
                    ad.setIcon(R.drawable.bachii);
                    ad.show();
                    
                    final Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            ad.dismiss(); // when the task active then close the dialog
                            t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                        }
                    }, 2000); // after 2 second (or 2000 miliseconds), the task will be active.
                    
                    managerOfSound(click);

					im3.setImageResource(R.drawable.star);
					next_but.setVisibility(View.VISIBLE);

					// new Handler().postDelayed(new Runnable() {
					//
					// @Override
					// public void run() {
					// // This method will be executed once the timer is
					// // over
					// // Start your app main activity
					// Intent i = new Intent(page_dua_two.this,
					// page_dua.class);
					// managerOfSound_stop(click);
					// startActivity(i);
					//
					// // close this activity
					// finish();
					// }
					// }, SPLASH_TIME_OUT1);
					//
					// // Intent i = new Intent();
					// // i.setClass(page_dua.this, level_1_screen.class);
					// // startActivity(i);
					// }

				}
			}
		});

		stop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				managerOfSound_stop(click);

			}
		});

		next_but.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (counter >= 3) {
					
					
					
					Intent i = new Intent(page_dua_two.this, page_dua.class);
					managerOfSound_stop(click);
					startActivity(i);

				} else {
					Toast.makeText(
							getApplicationContext(),
							"You don't have three Stars. Play three times the Dua",
							Toast.LENGTH_SHORT).show();

				}

			}
		});
		
		close.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startAppAd.showAd();
				startAppAd.loadAd();
				
				close.setImageResource(R.drawable.close2);
				   
				
				
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
				    @Override
				    public void run() {
				       
				    	close.setImageResource(R.drawable.close);
				    }
				}, 80);
				
				
				new AlertDialog.Builder(page_dua_two.this)
				.setMessage("Back to Main Menu?")
				.setCancelable(true)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								managerOfSound_stop(click);
								Intent i = new Intent(page_dua_two.this, MainMenu.class);
				                startActivity(i);	
							}
						}).setNegativeButton("No", null).show();

				
				
				
			}
		});

	}

	protected void managerOfSound(String theText) {
		if (mp != null) {
			mp.reset();
			mp.release();
		}
		if (theText == "click") {
			mp = MediaPlayer.create(this, R.raw.dua_after_wking);
			mp.start();
		}

	}

	protected void managerOfSound_stop(String theText) {
		if (mp != null) {
			mp.reset();
			mp.release();
		}
		if (theText == "click") {
			mp = MediaPlayer.create(this, R.raw.dua_after_wking);
			mp.stop();
		}

	}

	protected void Sound_stop(String theText) {
		if (mp != null) {
			mp.reset();
			mp.release();
		}
		if (theText == "click") {
			mp = MediaPlayer.create(this, R.raw.dua_after_wking);
			mp.stop();
		}

	}
	
	@Override
	public void onBackPressed() {
	    // do nothing.
	}

}
