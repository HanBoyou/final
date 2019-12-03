
package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private int difficulty;
    private int[] easyList = new int[10];
    private int[] normalList = new int[10];
    private int[] hardList = new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("difficulty")) {
            difficulty = intent.getIntExtra("difficulty", R.id.radioButtonEasy);
        } else difficulty = R.id.radioButtonEasy;

        if (intent.hasExtra("easyList")) {
            easyList = intent.getIntArrayExtra("easyList");
            normalList = intent.getIntArrayExtra("normalList");
            hardList = intent.getIntArrayExtra("hardList");
        } else {
            for (int i = 0; i < easyList.length; i++) {
                easyList[i] = i; // to be replaced with file actions.
            }
            for (int i = 0; i < normalList.length; i++) {
                normalList[i] = i + 1;
            }
            for (int i = 0; i < hardList.length; i++) {
                hardList[i] = i + 2;
            }
        }


        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSettings();
            }
        });


        Button buttonStart = findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGame();
            }
        });
        Button buttonHighScore = findViewById(R.id.buttonHighScores);
        buttonHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHighScore();
            }
        });
    }


    private void onClickSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        putAllExtra(intent);
        startActivity (intent);
        finish();
    }

    private void onClickHighScore() {
        Intent intent = new Intent(this, HighScoreActivity.class);
        putAllExtra(intent);
        int a = intent.getIntExtra("difficulty", -1);
        System.out.println(a == R.id.radioButtonEasy);
        startActivity(intent);
    }

    private void onClickGame() {
        Intent intent = new Intent(this, GameActivity.class);
        putAllExtra(intent);
        startActivity(intent);
    }

    private void putAllExtra(Intent intent) {
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("easyList", easyList);
        intent.putExtra("normalList", normalList);
        intent.putExtra("hardList", hardList);
    }
}