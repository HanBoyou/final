package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        System.out.println(1);


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
        switch (difficultyGroup.getCheckedRadioButtonId()) {
            case R.id.radioButtonHard : intent.putExtra("difficulty", R.id.radioButtonHard);
            case R.id.radioButtonNormal :intent.putExtra("difficulty", R.id.radioButtonNormal);
            default : intent.putExtra("difficulty", R.id.radioButtonEasy);
        }
        startActivity(intent);
        finish();
    }
}
