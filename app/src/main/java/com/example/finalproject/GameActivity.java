package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GameActivity extends AppCompatActivity {

//    @Override
    private Game gameView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        gameView = new Game(this);

//
        ConstraintLayout ball = findViewById(R.id.ball);
        Ball ball1 = new Ball(this);
        ball.addView(ball1);
//

        Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.start();
//        chronometer.setTextSize(100);
//        chronometer.start();
//
//

    }




}
