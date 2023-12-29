package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.Objects;

public class MainActivity5 extends AppCompatActivity {
    private Question question;

    private int indexTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent = getIntent();
        String nameTopic = intent.getStringExtra("keyNameTopic");
        int position = intent.getIntExtra("keyPosition",-1);
        Button buttonLevel = findViewById(R.id.buttonLevel);
        TextView textViewQuiz = findViewById(R.id.nameQuizz);
        TextInputLayout textInputLayoutA = findViewById(R.id.answerA);
        TextInputLayout textInputLayoutB = findViewById(R.id.answerB);
        TextInputLayout textInputLayoutC = findViewById(R.id.answerC);
        TextInputLayout textInputLayoutD = findViewById(R.id.answerD);
        TextView textViewAnswer = findViewById(R.id.answerTrue);
        indexTopic = chooseIndexTopic(nameTopic);
        if(position >= 0 && position <= 4){
            buttonLevel.setText("Dễ");
            question = Data.easyQuestion[indexTopic][position];
        }
        else if(position >=5 && position <= 9){
            buttonLevel.setText("Khó");
            buttonLevel.setBackgroundColor(Color.RED);
            question = Data.hardQuestion[indexTopic][position-5];
        }
        textViewQuiz.setText(question.getQuestion());
        Objects.requireNonNull(textInputLayoutA.getEditText()).setText(question.getAnswerA());
        Objects.requireNonNull(textInputLayoutB.getEditText()).setText(question.getAnswerB());
        Objects.requireNonNull(textInputLayoutC.getEditText()).setText(question.getAnswerC());
        Objects.requireNonNull(textInputLayoutD.getEditText()).setText(question.getAnswerD());
        textViewAnswer.setText(String.format("Đáp án đúng: %s",question.getTrueAns()) );
    }
    private int chooseIndexTopic(String nameTopic){
        int indexTopic = -1;
        if(Objects.equals(nameTopic, "Lịch Sử")){
            indexTopic = 0;
        }
        else if(Objects.equals(nameTopic, "Địa Lý")){
            indexTopic = 1;
        }
        else if(Objects.equals(nameTopic, "Khoa Học")){
            indexTopic = 2;
        }
        return indexTopic;
    }
}