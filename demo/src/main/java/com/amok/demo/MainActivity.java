package com.amok.demo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amok.ringprogressbar.RingProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RingProgressBar ringProgressBar, ringProgressBar2,  ringProgressBar3;
    CountDownTimer countDownTimer;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ringProgressBar = (RingProgressBar)findViewById(R.id.ringProgressBar);
        ringProgressBar2 = (RingProgressBar)findViewById(R.id.ringProgressBar2);
        ringProgressBar3 = (RingProgressBar)findViewById(R.id.ringProgressBar3);
        Log.d("test","ringProgressBar = "+ringProgressBar);
        Init();
    }

    private void Init() {

        final int time = 4000;
        int duration = 20;
        ringProgressBar.setMax(time);
        ringProgressBar2.setMax(time);
        ringProgressBar3.setMax(time);
        ringProgressBar.setTip("跳过");

        countDownTimer = new CountDownTimer(time,duration ) {
            @Override
            public void onTick(long millisUntilFinished) {
//                tvJump.setText("跳过(" + millisUntilFinished / 1000 + ")");
//                tvJump.setVisibility(View.VISIBLE);
                progress =  time - (int)millisUntilFinished;
                ringProgressBar.setProgress(progress);
                ringProgressBar2.setProgress(progress);
                ringProgressBar3.setProgress(progress);
            }

            @Override
            public void onFinish() {
                ringProgressBar.setProgress(time);
                ringProgressBar2.setProgress(time);
                ringProgressBar3.setProgress(time);
            }
        }.start();
    }
}
