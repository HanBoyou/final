package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Chronometer;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ConstraintLayout ball = findViewById(R.id.ball);
        Ball ball1 = new Ball(this);
        ball.addView(ball1);

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
//        chronometer.setTextSize(100);
        chronometer.start();


    }

}
