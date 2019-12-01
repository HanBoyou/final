
package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int difficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("difficulty")) {
            difficulty = intent.getIntExtra("difficulty", R.id.radioButtonEasy);
        } else difficulty = R.id.radioButtonEasy;

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
        intent.putExtra("difficulty", difficulty);
        startActivity (intent);
        System.out.println(2);
        finish();
    }

    private void onClickHighScore() {
        startActivity(new Intent(this, HighScoreActivity.class));
    }

    private void onClickGame() {
        startActivity(new Intent(this, GameActivity.class));
    }
}