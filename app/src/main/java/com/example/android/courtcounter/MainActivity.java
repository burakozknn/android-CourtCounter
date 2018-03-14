package com.example.android.courtcounter;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    int scoreForChicago = 0;
    int scoreForMiami = 0;

    Chronometer simpleChronometer;
    Chronometer startStop;

    boolean isPlaying = true;

    long timeWhenStopped = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate views
        simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);

        startStop = (Chronometer) findViewById(R.id.simpleChronometer);


        simpleChronometer.start();

        // perform click  event on stop button to start a chronometer


        startStop.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                if (isPlaying) {
                    simpleChronometer.stop();
                    timeWhenStopped = simpleChronometer.getBase() - SystemClock.elapsedRealtime();

                }
                else {

                    simpleChronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    simpleChronometer.start();
                }

                isPlaying = !isPlaying;

            }
        });











    }


    public void displayForChicago(int score) {
        TextView scoreView = (TextView) findViewById(R.id.text2);
        scoreView.setText("" + score);

    }

    public void threepoints(View view) {
        scoreForChicago = scoreForChicago + 3;
        displayForChicago(scoreForChicago);

    }

    public void twopoints(View view) {
        scoreForChicago = scoreForChicago + 2;
        displayForChicago(scoreForChicago);

    }


    public void onepoints(View view) {
        scoreForChicago = scoreForChicago + 1;
        displayForChicago(scoreForChicago);

    }



    public void displayForMiami(int score) {
        TextView miami = (TextView) findViewById(R.id.text3);
        miami.setText("" + score);

    }

    public void threepoint(View view) {
        scoreForMiami = scoreForMiami + 3;
        displayForMiami(scoreForMiami);

    }

    public void twopoint(View view) {
        scoreForMiami = scoreForMiami + 2;
        displayForMiami(scoreForMiami);

    }


    public void onepoint(View view) {
        scoreForMiami = scoreForMiami + 1;
        displayForMiami(scoreForMiami);

    }




}
