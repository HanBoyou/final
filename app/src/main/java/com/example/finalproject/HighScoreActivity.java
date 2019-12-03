package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.List;

public class HighScoreActivity extends AppCompatActivity {
    private List easyList;
    private List normalList;
    private List hardList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroupHS);
        difficultyGroup.check(getIntent().getIntExtra("difficulty", R.id.radioButtonEasyHS));


    }
}
