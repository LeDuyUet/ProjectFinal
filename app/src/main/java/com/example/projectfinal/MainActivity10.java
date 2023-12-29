package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity10 extends AppCompatActivity {
    private int numberOfCorrectAnswer;
    private int position;
    private int level;
    private TextView textViewNumberOfTrueAnswer;
    private Button buttonComplete;
    private Button buttonPlayAgain;
    private Button buttonShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        getDataIntend();
        findViewId();
        textViewNumberOfTrueAnswer.setText(String.valueOf(numberOfCorrectAnswer));
        buttonComplete.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            intent1.putExtra("keyLevel",level);
            intent1.putExtra("keyScore",numberOfCorrectAnswer);
            startActivity(intent1);
        });
        buttonPlayAgain.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MainActivity4.class);
            intent1.putExtra("keyPosition",position);
            intent1.putExtra("keyLevel",level);
            startActivity(intent1);
        });
        buttonShare.setOnClickListener(v -> {
            Intent sendIntent =  new Intent(Intent.ACTION_SEND);
            Log.i("Value", String.valueOf(numberOfCorrectAnswer));
            String value = "Your Score is " + numberOfCorrectAnswer;
            sendIntent.putExtra(Intent.EXTRA_TEXT, value);
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }
    private void getDataIntend(){
        numberOfCorrectAnswer = getIntent().getIntExtra("keyScore",0);
        position = getIntent().getIntExtra("keyPosition",-1);
        level = getIntent().getIntExtra("keyLevel",-1);
    }
    private void findViewId(){
        textViewNumberOfTrueAnswer = findViewById(R.id.textViewNumberOfTrueAnswer);
        buttonComplete = findViewById(R.id.buttonComplete);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonShare = findViewById(R.id.buttonShare);
    }
}