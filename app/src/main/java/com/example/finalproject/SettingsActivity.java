package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private int[] easyList;
    private int[] normalList;
    private int[] hardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        System.out.println(getIntent().getIntExtra("difficulty", R.id.radioButtonEasy)
                == R.id.radioButtonEasy);
        Intent intent = getIntent();
        easyList = intent.getIntArrayExtra("easyList");
        normalList = intent.getIntArrayExtra("normalList");
        hardList = intent.getIntArrayExtra("hardList");


        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroupHS);
        difficultyGroup.check(getIntent().getIntExtra("difficulty", R.id.radioButtonEasy));

        Button save = findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }
    private void save() {
        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroupHS);
        Intent intent = new Intent(this, MainActivity.class);
//        System.out.print("check normal ");
        System.out.println(difficultyGroup.getCheckedRadioButtonId() == R.id.radioButtonNormal);
        switch (difficultyGroup.getCheckedRadioButtonId()) {

            case R.id.radioButtonHard : intent.putExtra("difficulty", R.id.radioButtonHard); break;
            case R.id.radioButtonNormal : intent.putExtra("difficulty", R.id.radioButtonNormal); break;
            default : intent.putExtra("difficulty", R.id.radioButtonEasy);
        }
        intent.putExtra("easyList", easyList);
        intent.putExtra("normalList", normalList);
        intent.putExtra("hardList", hardList);
        startActivity(intent);
        finish();
    }
}
