package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Subject> listQuizz;
    SubjectAdapter listQuizzAdapter;
    ListView listViewQuizz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupButton();
        setupSubjectList();
        setupScoreText();
        setupSwitchAndListClick();
    }

    private void setupButton() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
    }

    private void setupSubjectList() {
        listQuizz = new ArrayList<>();
        listQuizz.add(new Subject("Lịch sử", "Các câu hỏi về sự kiện liên quan đến con người", R.drawable.history, 1));
        listQuizz.add(new Subject("Địa lý","Các câu hỏi về vùng đất, địa hình, dân cư và các hiện tượng trên Trái Đất",R.drawable.geography, 2));
        listQuizz.add(new Subject("Khoa Học","Các câu hỏi về những định luật, cấu trúc và cách vận hành của thế giới tự nhiên", R.drawable.science,3));

        listQuizzAdapter = new SubjectAdapter(listQuizz);
        listViewQuizz = findViewById(R.id.listQuizz);
        listViewQuizz.setAdapter(listQuizzAdapter);
    }

    private void setupScoreText() {
        Intent intent1 = getIntent();
        int level = intent1.getIntExtra("keyLevel", -1);
        int score = intent1.getIntExtra("keyScore", 0);

        TextView textViewScore = findViewById(R.id.textViewScore);
        textViewScore.setText(String.valueOf(calculateScore(level, score)) + " pts");
    }

    private int calculateScore(int level, int score) {
        return (level == 1) ? score * 2 : score;
    }

    private void setupSwitchAndListClick() {
        Intent intent0 = new Intent(this, MainActivity4.class);
        SwitchMaterial switch1 = findViewById(R.id.switch1);
        listViewQuizz.setOnItemClickListener((parent, view, position, id) -> {
            intent0.putExtra("keyPosition", position);
            intent0.putExtra("keyLevel", switch1.isChecked() ? 1 : 0);
            startActivity(intent0);
        });
    }
}
