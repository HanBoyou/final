package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    private int[] easyList = new int[10];
    private int[] normalList = new int[10];
    private int[] hardList = new int[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroupHS);
        difficultyGroup.check(getIntent().getIntExtra("difficulty", R.id.radioButtonEasyHS));

        Intent intent = getIntent();
        easyList = intent.getIntArrayExtra("easyList");
        normalList = intent.getIntArrayExtra("normalList");
        hardList = intent.getIntArrayExtra("hardList");
        updateList();
        difficultyGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup radioGroup, int checked) {
                updateList();
            }
        });
        RadioButton normalRadioButtonHS = findViewById(R.id.radioButtonNormalHS);
        RadioButton hardRadioButtonHS = findViewById(R.id.radioButtonHardHS);

    }

    private void viewEasy() {
        LinearLayout scoreBoardLayout = findViewById(R.id.scoreBoardLayout);
        scoreBoardLayout.removeAllViews();

        for (int i = 0; i < easyList.length; i++) {
            View chunkHighScore = getLayoutInflater().inflate(R.layout.chunk_high_score, scoreBoardLayout, false);
            TextView rank = chunkHighScore.findViewById(R.id.rank);
            TextView score = chunkHighScore.findViewById(R.id.score);
            Integer a = i + 1;
            rank.setText(a.toString());
            if (easyList[i] < 0) {
                score.setText("-");
            } else score.setText(((Integer) easyList[i]).toString());

            scoreBoardLayout.addView(chunkHighScore);
        }

    }
    private void viewNormal() {
        LinearLayout scoreBoardLayout = findViewById(R.id.scoreBoardLayout);
        scoreBoardLayout.removeAllViews();

        for (int i = 0; i < normalList.length; i++) {
            View chunkHighScore = getLayoutInflater().inflate(R.layout.chunk_high_score, scoreBoardLayout, false);
            TextView rank = chunkHighScore.findViewById(R.id.rank);
            TextView score = chunkHighScore.findViewById(R.id.score);
            Integer a = i + 1;
            rank.setText(a.toString());
            if (normalList[i] < 0) {
                score.setText("-");
            } else score.setText(((Integer) normalList[i]).toString());

            scoreBoardLayout.addView(chunkHighScore);
        }

    }
    private void viewHard() {
        LinearLayout scoreBoardLayout = findViewById(R.id.scoreBoardLayout);
        scoreBoardLayout.removeAllViews();

        for (int i = 0; i < hardList.length; i++) {
            View chunkHighScore = getLayoutInflater().inflate(R.layout.chunk_high_score, scoreBoardLayout, false);
            TextView rank = chunkHighScore.findViewById(R.id.rank);
            TextView score = chunkHighScore.findViewById(R.id.score);
            Integer a = i + 1;
            rank.setText(a.toString());
            if (hardList[i] < 0) {
                score.setText("-");
            } else score.setText(((Integer) hardList[i]).toString());

            scoreBoardLayout.addView(chunkHighScore);
        }

    }



    private void updateList() {
        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroupHS);
        switch (difficultyGroup.getCheckedRadioButtonId()) {
                   case R.id.radioButtonNormalHS : viewNormal(); break;
                   case R.id.radioButtonHardHS : viewHard(); break;
            default : viewEasy();
        }
    }
}
