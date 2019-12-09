package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Chronometer;

public class GameActivity extends AppCompatActivity {
    private Chronometer chronometer;

    public Chronometer getChronometer() {
        return chronometer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ConstraintLayout ball = findViewById(R.id.ball);
        Ball ball1 = new Ball(this);
        ball.addView(ball1);

        chronometer = findViewById(R.id.chronometer);
//        chronometer.setTextSize(100);
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override

            public void onChronometerTick(Chronometer chronometer) {
                String time = chronometer.getText().toString();
                System.out.println(time);
            }
        });


    }

}
