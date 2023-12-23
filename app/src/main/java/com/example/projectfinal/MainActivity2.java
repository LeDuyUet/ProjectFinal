package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<Quizz> listQuizz;
    ListQuizzAdapter listQuizzAdapter;
    ListView listViewQuizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        });
        listQuizz = new ArrayList<>();
        listQuizz.add(new Quizz("Lịch sử\nCác câu hỏi về sự kiện liên quan đến con người", R.drawable.unnamed,1));
        listQuizz.add(new Quizz("Địa Lý\nCác câu hỏi về vùng đất, địa hình, dân cư và các hiện tượng trên Trái Đất", R.drawable.b4c0e82a_6b49_40aa_820b_41a5afa2824c_900_900,2));
        listQuizz.add(new Quizz("Khoa Học\nCác câu hỏi về những định luật, cấu trúc và cách vận hành của thế giới tự nhiên", R.drawable.images,3));
        listQuizz.add(new Quizz("Nghệ thuật\nCác câu hỏi liên quan đến nghệ thuật, hội họa, kiến trúc", R.drawable.hoi_hoa_193552, 4));
        listQuizzAdapter = new ListQuizzAdapter(listQuizz);
        listViewQuizz = findViewById(R.id.listQuizz);
        listViewQuizz.setAdapter(listQuizzAdapter);
        Intent intent0 = new Intent(this, MainActivity4.class);
        SwitchMaterial switch1 = findViewById(R.id.switch1);
        listViewQuizz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent0.putExtra("keyPosition",position);
                intent0.putExtra("keyLevel",switch1.isChecked()?1:0);
                startActivity(intent0);
            }
        });
    }
}