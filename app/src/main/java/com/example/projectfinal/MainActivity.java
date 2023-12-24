package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttonStart);
        Intent intent = getIntent();
        int level = intent.getIntExtra("keyLevel",-1);
        int score = intent.getIntExtra("keyScore",0);
        button.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, MainActivity2.class);
            intent1.putExtra("keyLevel",level);
            intent1.putExtra("keyScore",score);
            startActivity(intent1);
        });
    }
}