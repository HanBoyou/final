package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSettings = findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSettings();
            }
        });
        Button buttonStart = findViewById(R.id.buttonStart);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGame();
            }
        });
        Button buttonHighScore = findViewById(R.id.buttonHighScores);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickHighScore();
            }
        });
    }
    private void onClickSettings() {
        startActivity (new Intent(this, SettingsActivity.class));
    }
    private void onClickHighScore() {
        startActivity(new Intent(this, HighScoreActivity.class));
    }
    private void onClickGame() {
        startActivity(new Intent(this, GameActivity.class));
    }
}
