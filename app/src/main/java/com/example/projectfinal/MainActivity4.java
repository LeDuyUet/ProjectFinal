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
    private static final int EASY = 0;
    private static final int HARD = 1;
    private List<Question> questions;
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = findViewById(R.id.textview);
        radioGroup = findViewById(R.id.radio_group);
        radioButton1 = findViewById(R.id.radio_1);
        radioButton2 = findViewById(R.id.radio_2);
        radioButton3 = findViewById(R.id.radio_3);
        radioButton4 = findViewById(R.id.radio_4);

        int position = getIntent().getIntExtra("keyPosition", -1);
        int level = getIntent().getIntExtra("keyLevel", -1);
        initializeQuestions(position, level);

        Collections.shuffle(questions);


        setQuestionContent();

        Button button = findViewById(R.id.button_answer);
        Intent intent1 = new Intent(this, MainActivity10.class);
        intent1.putExtra("keyPosition", position);
        intent1.putExtra("keyLevel", level);

        button.setOnClickListener(v -> {
            int id = radioGroup.getCheckedRadioButtonId();

            if (id == -1) {
                Toast.makeText(MainActivity4.this, "Vui lòng chọn đáp án.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (id == questions.get(index).getCorrectAnswerId()) {

                index++;
                if (index == questions.size()) {
                    intent1.putExtra("keyScore", index);
                    startActivity(intent1);
                    return;
                }
                setQuestionContent();
            } else {
                intent1.putExtra("keyScore", index);
                startActivity(intent1);
            }
            radioGroup.clearCheck();
        });
    }

    private void initializeQuestions(int position, int level) {
        questions = new ArrayList<>();
       questions=chooseQues(position,level);
    }
    private List<Question> chooseQues(int position, int level){
        List<Question> questions = new ArrayList<>();
        if(level ==HARD){
            for(int i=0; i<5; i++){
                questions.add(Data.hardQuestion[position][i]);
            }
        }else if (level == EASY){
            for(int i=0; i<5; i++){
                questions.add(Data.EasyQuestion[position][i]);
            }
        }

        return questions;
    }

    private void setQuestionContent() {
        Question currentQuestion = questions.get(index);
        textView.setText(currentQuestion.getQuestion());
        radioButton1.setText(currentQuestion.getAnswerA());
        radioButton2.setText(currentQuestion.getAnswerB());
        radioButton3.setText(currentQuestion.getAnswerC());
        radioButton4.setText(currentQuestion.getAnswerD());
    }

}



