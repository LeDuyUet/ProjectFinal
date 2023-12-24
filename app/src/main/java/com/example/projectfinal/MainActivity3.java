package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    ArrayList<QuestionQuizz> listQuestion;
    ListQuestionAdapter listQuestionAdapter;
    ListView listViewQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listQuestion = new ArrayList<>();
        listQuestion.add(new QuestionQuizz("Câu 1","Cấp độ: Dễ",1));
        listQuestion.add(new QuestionQuizz("Câu 2","Cấp độ: Dễ",2));
        listQuestion.add(new QuestionQuizz("Câu 3","Cấp độ: Dễ",3));
        listQuestion.add(new QuestionQuizz("Câu 4","Cấp độ: Dễ",4));
        listQuestion.add(new QuestionQuizz("Câu 5","Cấp độ: Dễ",5));
        listQuestion.add(new QuestionQuizz("Câu 1","Cấp độ: Khó",6));
        listQuestion.add(new QuestionQuizz("Câu 2","Cấp độ: Khó",7));
        listQuestion.add(new QuestionQuizz("Câu 3","Cấp độ: Khó",8));
        listQuestion.add(new QuestionQuizz("Câu 4","Cấp độ: Khó",9));
        listQuestion.add(new QuestionQuizz("Câu 5","Cấp độ: Khó",10));
        listQuestionAdapter = new ListQuestionAdapter(listQuestion);
        listViewQuestion = findViewById(R.id.listViewQuestion);
        listViewQuestion.setAdapter(listQuestionAdapter);
        Intent intent = new Intent(this, MainActivity5.class);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoComplete);
        listViewQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nameTopic = autoCompleteTextView.getText().toString();
                intent.putExtra("keyPosition",position);
                intent.putExtra("keyNameTopic",nameTopic);
                startActivity(intent);
            }
        });
    }
}