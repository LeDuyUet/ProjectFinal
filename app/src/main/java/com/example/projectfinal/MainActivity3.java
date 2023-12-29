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
        setupQuestionList();
        setupAutoCompleteTextView();
    }

    private void setupQuestionList() {
        listQuestion = new ArrayList<>();
        listQuestion.add(new QuestionQuizz("Câu 1",getString(R.string.question_level_easy),1));
        listQuestion.add(new QuestionQuizz("Câu 2",getString(R.string.question_level_easy),2));
        listQuestion.add(new QuestionQuizz("Câu 3",getString(R.string.question_level_easy),3));
        listQuestion.add(new QuestionQuizz("Câu 4",getString(R.string.question_level_easy),4));
        listQuestion.add(new QuestionQuizz("Câu 5",getString(R.string.question_level_easy),5));
        listQuestion.add(new QuestionQuizz("Câu 1",getString(R.string.question_level_hard),6));
        listQuestion.add(new QuestionQuizz("Câu 2",getString(R.string.question_level_hard),7));
        listQuestion.add(new QuestionQuizz("Câu 3",getString(R.string.question_level_hard),8));
        listQuestion.add(new QuestionQuizz("Câu 4",getString(R.string.question_level_hard),9));
        listQuestion.add(new QuestionQuizz("Câu 5",getString(R.string.question_level_hard),10));
        listQuestionAdapter = new ListQuestionAdapter(listQuestion);
        listViewQuestion = findViewById(R.id.listViewQuestion);
        listViewQuestion.setAdapter(listQuestionAdapter);
    }

    private void setupAutoCompleteTextView() {
        Intent intent = new Intent(this, MainActivity5.class);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoComplete);

        listViewQuestion.setOnItemClickListener((parent, view, position, id) -> {
            String nameTopic = autoCompleteTextView.getText().toString();
            intent.putExtra("keyPosition", position);
            intent.putExtra("keyNameTopic", nameTopic);
            startActivity(intent);
        });
    }
}
