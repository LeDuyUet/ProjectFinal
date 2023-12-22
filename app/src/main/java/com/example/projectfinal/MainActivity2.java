package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Quizz> listQuizz;
    ListQuizzAdapter listQuizzAdapter;
    ListView listViewQuizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listQuizz = new ArrayList<>();
        listQuizz.add(new Quizz("Lịch sử\nCác câu hỏi về sự kiện liên quan đến con người", R.drawable.unnamed,1));
        listQuizz.add(new Quizz("Địa Lý\nCác câu hỏi về vùng đất, địa hình, dân cư và các hiện tượng trên Trái Đất", R.drawable.b4c0e82a_6b49_40aa_820b_41a5afa2824c_900_900,2));
        listQuizz.add(new Quizz("Khoa Học\nCác câu hỏi về những định luật, cấu trúc và cách vận hành của thế giới tự nhiên", R.drawable.images,3));
        listQuizzAdapter = new ListQuizzAdapter(listQuizz);
        listViewQuizz = findViewById(R.id.listQuizz);
        listViewQuizz.setAdapter(listQuizzAdapter);
    }
}