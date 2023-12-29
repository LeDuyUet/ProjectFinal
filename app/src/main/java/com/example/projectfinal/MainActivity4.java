package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    private int index = 0;
    private int position;
    private int level;
    private static final int EASY = 0;
    private static final int HARD = 1;
    private Question questions;
    private Button button;
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findViewId();
        getDataIntent();
        questions = chooseQues(position,level,index);
        setQuestionContent();
        intent1 = new Intent(this, MainActivity10.class);
        putDataIntent();
        button.setOnClickListener(v -> {
            chooseAnswer();
        });
    }
    private void getDataIntent(){
        position = getIntent().getIntExtra("keyPosition", -1);
        level = getIntent().getIntExtra("keyLevel", -1);
    }
    private void putDataIntent(){
        intent1.putExtra("keyPosition", position);
        intent1.putExtra("keyLevel", level);
    }
    private void findViewId(){
        button = findViewById(R.id.button_answer);
        textView = findViewById(R.id.textview);
        radioGroup = findViewById(R.id.radio_group);
        radioButton1 = findViewById(R.id.radio_1);
        radioButton2 = findViewById(R.id.radio_2);
        radioButton3 = findViewById(R.id.radio_3);
        radioButton4 = findViewById(R.id.radio_4);
    }
    private Question chooseQues(int position, int level,int index){
        Question questions = null;
        if(level == HARD){
            questions = Data.hardQuestion[position][index];
        }else if (level == EASY){
            questions = Data.easyQuestion[position][index];
        }
        return questions;
    }

    private void setQuestionContent() {
        textView.setText(questions.getQuestion());
        radioButton1.setText(questions.getAnswerA());
        radioButton2.setText(questions.getAnswerB());
        radioButton3.setText(questions.getAnswerC());
        radioButton4.setText(questions.getAnswerD());
    }
    private void chooseAnswer(){
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == questions.getCorrectAnswerId()) {
            index++;
            if (index == 5) {
                intent1.putExtra("keyScore", index);
                startActivity(intent1);
                return;
            }
            questions = chooseQues(position,level,index);
            setQuestionContent();
        }else{
            intent1.putExtra("keyScore", index);
            startActivity(intent1);
        }
        radioGroup.clearCheck();
    }
}



