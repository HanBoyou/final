package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroup);
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
        RadioGroup difficultyGroup = findViewById(R.id.difficultyGroup);
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
