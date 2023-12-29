package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int level;
    private int score;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        getDataIntent();
        Button button = findViewById(R.id.buttonStart);
        button.setOnClickListener(view -> openMainActivity2(level, score));
    }

    private void openMainActivity2(int level, int score) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("keyLevel", level);
        intent.putExtra("keyScore", score);
        startActivity(intent);
    }
    private void getDataIntent(){
        level = intent.getIntExtra("keyLevel", -1);
        score = intent.getIntExtra("keyScore", 0);
    }
}