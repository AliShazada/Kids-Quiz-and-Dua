package com.takbir.kids.quiz;

import java.util.List;







import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.startapp.android.publish.StartAppAd;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion;
	RadioButton rda, rdb, rdc;
	ImageView butNext,btn_skip,close;
	
	StartAppAd startAppAd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		
		AdView adview = (AdView) findViewById(R.id.adView_quiz);

		AdRequest re = new AdRequest();

		re.setTesting(true);

		adview.loadAd(re);
		
		startAppAd = new StartAppAd(this);
		
		
		
		
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView1);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		butNext=(ImageView)findViewById(R.id.next_button);
		close=(ImageView)findViewById(R.id.close_btn_quiz);
		
		btn_skip=(ImageView)findViewById(R.id.skip_quiz_button);
		final  AlertDialog ad=new AlertDialog.Builder(this).create();
		
		
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
				RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
				if(currentQ.getANSWER().equals(answer.getText()))
				{
					ad.setTitle("Congratulations !");
                    ad.setMessage("    Good!!...Correct Answer");
                    ad.setIcon(R.drawable.bachii);
                    ad.show();
					score++;
					Log.d("score", "Your score"+score);
				}
				else
				{
					ad.setTitle("Oops! Wrong Answer");
                    ad.setMessage(currentQ.getANSWER() +" is the Correct Answer");
                    ad.setIcon(R.drawable.girl);
                    ad.show(); 
			
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		});
		
		
		btn_skip.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(qid<5){
					
					ad.setTitle(" ");
                    ad.setMessage("You have skipped the question.");
                    ad.setIcon(R.drawable.bachii);
                    ad.show(); 					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					
					ad.setTitle(" ");
                    ad.setMessage("You have skipped the question.");
                    ad.setIcon(R.drawable.bachii);
                    ad.show(); 

                    
					
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
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
				
				
				new AlertDialog.Builder(QuizActivity.this)
				.setMessage("Back to Main Menu?")
				.setCancelable(true)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int id) {
								
								
								
								
								Intent i = new Intent(QuizActivity.this, MainMenu.class);
				                startActivity(i);	
							}
						}).setNegativeButton("No", null).show();

				
				
				
			}
		});
	}
	
	
	
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		qid++;
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

