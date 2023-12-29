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
        if (level == HARD) {
            if (position == 0) {
                questions.add(new Question("Chiến tranh lạnh bắt đầu vào năm nào?",
                        "1945", "1946", "1947", "1948", R.id.radio_2));
                questions.add(new Question("Tổ chức Liên Hiệp Quốc được thành lập vào năm nào?",
                        "1944", "1945", "1946", "1947", R.id.radio_3));
                questions.add(new Question("Năm nào chiến tranh thế giới thứ hai bắt đầu?",
                        "1938", "1939", "1940", "1941",R.id.radio_2));
                questions.add(new Question("Năm nào Liên Xô được thành lập?",
                        "1917", "1918", "1919", "1930", R.id.radio_4));
                questions.add(new Question("Ngày nào là ngày sụp đổ của Bức tường Berlin?",
                        "9 tháng 11, 1989", " 9 tháng 11, 1990", " 9 tháng 12, 1989", " 9 tháng 12, 1990", R.id.radio_1));
            } else if (position == 1) {
                questions.add(new Question("Địa hình nào chiếm phần lớn diện tích Trái Đất?",
                        "Đồng bằng", "Trung du và miền núi", "Đồi núi", "Đại dương", R.id.radio_2));
                questions.add(new Question("Việt Nam nằm trong vành đai khí hậu nào?",
                        "Khí hậu nhiệt đới gió mùa", "Khí hậu cận nhiệt đới gió mùa", "Khí hậu ôn đới gió mùa", "Khí hậu hàn đới gió mùa", R.id.radio_1));
                questions.add(new Question("Quốc gia nào có diện tích nhỏ nhất thế giới?",
                        "Nauru", "Monaco", "Vatican", "Tuvalu", R.id.radio_3));
                questions.add(new Question("Thủ đô của nước Mỹ là?",
                        "Chicago", "New York", "Los Angeles", "Washington, D.C.", R.id.radio_4));
                questions.add(new Question("Nhóm đất nào sau đây có diện tích phân bố rộng nhất ở nước ta?",
                        "Đất feralit đỏ vàng", "Đất phù sa sông ngòi", "Đất đen", "Đất xám bạc màu", R.id.radio_2));

            } else if (position == 2) {
                questions.add(new Question("Động vật nào không thể nhảy?",
                        "Sư tử", "Voi", "Kangaroo", "Thỏ", R.id.radio_2));
                questions.add(new Question("Hành tinh nào lớn nhất trong hệ mặt trời?",
                        "Sao Thổ", "Sao Mộc", "Sao Hải Vương", "Sao Kim", R.id.radio_3));
                questions.add(new Question("Vật chất được cấu tạo bởi gì?",
                        "Phân tử", "Nguyên tử", "Electron", "Proton",R.id.radio_2 ));
                questions.add(new Question(" Công thức hóa học của nước là gì?",
                        "CO2", "O2", "H20", "N2", R.id.radio_3));
                questions.add(new Question("Trái đất quay quanh mặt trời theo hình gì?",
                        "Hình vuông", "Hình tròn", "Hình elip", "Hình tam giác", R.id.radio_3));
            }
        } else if (level == EASY){
            if(position==0){
                questions.add(new Question("Cuộc khủng hoảng tên lửa Cuba diễn ra vào năm?",
                        "1960", "1961", "1962", "1963", R.id.radio_3));
                questions.add(new Question("Hiệp định Giơ-ne-vơ được ký kết vào năm nào?",
                        "1954", "1955", "1956", "1957", R.id.radio_1));
                questions.add(new Question("Quốc gia đầu tiên trên thế giới là gì?",
                        "Ai Cập", "Lưỡng Hà", "Hy Lạp cổ đại", " Trung Quốc cổ đại", R.id.radio_2));
                questions.add(new Question("Nạn đói Việt Nam diễn ra vào năm bao nhiêu?",
                        "1954", "1946", "1938", "1945", R.id.radio_4));
                questions.add(new Question("Cuộc khởi nghĩa nào dưới đây đánh dấu sự chấm dứt ách đô hộ của nhà Minh ở Việt Nam?",
                        "Khởi nghĩa Lam Sơn", "Khởi nghĩa Tây Sơn", "Khởi nghĩa Cần Vương", "Khởi nghĩa Yên Bái", R.id.radio_1));
            }else if (position==1){
                questions.add(new Question("Quốc gia nào có diện tích lớn nhất thế giới?",
                        "Canada", "Hoa Kỳ", "Trung Quốc", "Nga", R.id.radio_4));
                questions.add(new Question("Sông nào dài nhất thế giới?",
                        "Sông Amazon", "Sông Nile", "Sông Mississippi", "Sông Yangtze", R.id.radio_2));
                questions.add(new Question("Thành phố nào là thủ đô của Việt Nam?",
                        "Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Cần Thơ", R.id.radio_1));
                questions.add(new Question("Địa hình nào chiếm phần lớn diện tích Thành phố Hồ Chí Minh?",
                        "Đồng bằng", "Trung du và miền núi", "Đồi núi", "Đồng cỏ", R.id.radio_1));
                questions.add(new Question("Sông nào dài nhất Việt Nam?",
                        "Sông Đồng Nai", "Sông Cửu Long", "Sông Hồng", "Sông Mã", R.id.radio_3));
            }else if (position==2){
                questions.add(new Question("Cái gì giúp cây cỏ tạo ra thức ăn?",
                        "Ánh sáng mặt trời", "Nước", "Khí CO2", "Tất cả các phương án trên", R.id.radio_4));
                questions.add(new Question("Cái gì giúp chúng ta nhìn thấy vật thể?",
                        "Ánh sáng", "Âm thanh", "Mùi", "Hương vị", R.id.radio_1));
                questions.add(new Question("Động vật nào có thể sống dưới nước và trên cạn?",
                        "Cá", "Chim", "Ếch", "Sư tử", R.id.radio_3));
                questions.add(new Question("Cái gì giúp chúng ta nghe được âm thanh?",
                        "Mắt", "Tai", "Mũi", "Miệng", R.id.radio_2));
                questions.add(new Question("Động vật nào có thể thay đổi màu sắc để ngụy trang?",
                        "Báo", "Bướm", "Tắc kè", "Cá heo", R.id.radio_3));
            }
        }
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



