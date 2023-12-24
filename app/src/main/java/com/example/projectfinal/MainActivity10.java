package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Intent intent = getIntent();
        int score = intent.getIntExtra("keyScore",0);
        int position = intent.getIntExtra("keyPosition",-1);
        int level = intent.getIntExtra("keyLevel",-1);
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText(String.valueOf(score));
        Button buttonComplete = findViewById(R.id.buttonComplete);
        Button buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        Button buttonShare = findViewById(R.id.buttonShare);
        buttonComplete.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.putExtra("keyLevel",level);
            intent1.putExtra("keyScore",score);
            startActivity(intent1);
        });
        buttonPlayAgain.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity4.class);
            intent1.putExtra("keyPosition",position);
            intent1.putExtra("keyLevel",level);
            startActivity(intent1);
        });
    }
}