package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Intent intent = getIntent();
        int score = intent.getIntExtra("keyScore",0);
        TextView textView = findViewById(R.id.textView7);
        textView.setText(String.valueOf(score));
    }
}