package com.aaa.homeworktojava;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.q42.android.scrollingimageview.ScrollingImageView;


public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ScrollingImageView scrollingBackground = (ScrollingImageView)findViewById(R.id.scrolling_background);
        scrollingBackground.start();
        // Animation background ****
//        ConstraintLayout constraintLayout = findViewById(R.id.splash_layout);
//        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground() ;
//        animationDrawable.setEnterFadeDuration(20);
//        animationDrawable.setExitFadeDuration(400);
//        animationDrawable.start();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 5;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 3*1000); // wait for 5 seconds
    }
}




