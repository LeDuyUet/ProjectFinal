package com.example.projectfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity5 extends AppCompatActivity {
    private static final String[] AnswerEasyGeography = {"Trái đất","3","Thái Bình Dương","Châu Á","Sông Nile"};
    private static final String[] arrayAnswerEasyGeographicalTopicA = {"Vũ trụ","1","Đại Tây Dương","Châu Á","Sông Amazon"};
    private static final String[] arrayAnswerEasyGeographicalTopicB = {"Trái đất","2","Ấn Độ Dương","Châu Âu","Sông Nile"};
    private static final String[] arrayAnswerEasyGeographicalTopicC = {"Mặt trăng","3","Thái Bình Dương","Châu Mỹ","Sông Mississippi"};
    private static final String[] arrayAnswerEasyGeographicalTopicD = {"Mặt trời","4","Bắc Băng Dương","Châu Phi","Sông Yangtze"};
    private static final String[] arrayEasyGeographicalTopic = {"Địa lý học là khoa học nghiên cứu về gì?","Trái đất có bao nhiêu lớp vỏ?","Đại dương nào là lớn nhất thế giới?","Châu lục nào lớn nhất thế giới?","Sông nào dài nhất thế giới?"};

    private static final String[] AnswerHardGeography = {"Núi Everest","Đại dương","Trung du và miền núi","Nga","Trung Quốc"};
    private static final String[] arrayAnswerHardGeographicalTopicA = {"Núi Everest","Đồng bằng","Đồng bằng","Canada","Ấn Độ"};
    private static final String[] arrayAnswerHardGeographicalTopicB = {"Núi K2","Trung du và miền núi","Trung du và miền núi","Hoa Kỳ","Hoa Kỳ"};
    private static final String[] arrayAnswerHardGeographicalTopicC = {"Núi Kangchenjunga","Đồi núi","Đồi núi","Trung Quốc","Trung Quốc"};
    private static final String[] arrayAnswerHardGeographicalTopicD = {"Núi Lhotse","Đại dương","Đại dương","Nga","Indonesia"};
    private static final String[] arrayHardGeographicalTopic = {"Núi nào cao nhất thế giới?","Địa hình nào chiếm phần lớn diện tích Trái Đất?","Địa hình nào chiếm phần lớn diện tích lục địa?","Quốc gia nào có diện tích lớn nhất thế giới?","Quốc gia nào có dân số đông nhất thế giới?"};

    private static final String[] AnswerEasyHistory = {"1939","Neville Chamberlain","1942-1943","8 tháng 5, 1945","Đức"};
    private static final String[] arrayAnswerEasyHistoryTopicA = {"1938","Winston Churchill","1941-1942","7 tháng 5, 1945","Mỹ"};
    private static final String[] arrayAnswerEasyHistoryTopicB = {"1939","Neville Chamberlain","1942-1943","8 tháng 5, 1945","Anh"};
    private static final String[] arrayAnswerEasyHistoryTopicC = {"1940","Franklin D. Roosevelt","1943-1944","9 tháng 5, 1945","Pháp"};
    private static final String[] arrayAnswerEasyHistoryTopicD = {"1941","Joseph Stalin","1944-1945","10 tháng 5, 1945","Đức"};
    private static final String[] arrayEasyHistoryTopic = {"Năm nào chiến tranh thế giới thứ hai bắt đầu?","Ai là người đã ký vào Hiệp định Munich năm 1938?","Trận Stalingrad diễn ra trong khoảng thời gian nào?","Ngày nào là ngày kết thúc chiến tranh thế giới thứ hai?","Hội nghị Potsdam diễn ra ở quốc gia nào?"};

    private static final String[] AnswerHardHistory = {"Winston Churchill, Franklin D. Roosevelt, và Joseph Stalin","1946","1945","1954","1962"};
    private static final String[] arrayAnswerHardHistoryTopicA = {"Winston Churchill, Franklin D. Roosevelt, và Joseph Stalin","1945","1944","1952","1960"};
    private static final String[] arrayAnswerHardHistoryTopicB = {"Neville Chamberlain, Franklin D. Roosevelt, và Joseph Stalin","1946","1945","1953","1961"};
    private static final String[] arrayAnswerHardHistoryTopicC = {"Winston Churchill, Harry S. Truman, và Joseph Stalin","1947","1946","1954","1962"};
    private static final String[] arrayAnswerHardHistoryTopicD = {"Winston Churchill, Franklin D. Roosevelt, và Benito Mussolini","1948","1947","1955","1963"};
    private static final String[] arrayHardHistoryTopic = {"Ai là người đã ký vào Hiệp định Yalta?","Chiến tranh lạnh bắt đầu vào năm nào?","Tổ chức Liên Hiệp Quốc được thành lập vào năm nào?","Hiệp định Genève về Việt Nam được ký vào năm nào?","Cuộc khủng hoảng tên lửa Cuba diễn ra vào năm nào?"};

    private static final String[] AnswerEasyScience = {"8","Sao Kim","Rùa","4","Cây sequoia"};
    private static final String[] arrayAnswerEasyScienceTopicA = {"7","Trái Đất","Rùa","3","Cây thông"};
    private static final String[] arrayAnswerEasyScienceTopicB = {"8","Sao Hỏa","Voi","4","Cây sồi"};
    private static final String[] arrayAnswerEasyScienceTopicC = {"9","Sao Kim","Cá voi","5","Cây sequoia"};
    private static final String[] arrayAnswerEasyScienceTopicD = {"10","Sao Thổ","Chim","6","Cây cỏ voi"};
    private static final String[] arrayEasyScienceTopic = {"Hệ mặt trời của chúng ta gồm bao nhiêu hành tinh?","Hành tinh nào gần mặt trời nhất?","Loài động vật nào có tuổi thọ lâu nhất?","Cơ thể người có bao nhiêu bộ phận chính?","Loài cây nào cao nhất thế giới?"};

    private static final String[] AnswerHardScience = {"206","Voi","Sao Mộc","Tất cả các phương án trên","Ánh sáng"};
    private static final String[] arrayAnswerHardScienceTopicA = {"206","Sư tử","Sao Thổ","Ánh sáng mặt trời","Ánh sáng"};
    private static final String[] arrayAnswerHardScienceTopicB = {"207","Voi","Sao Mộc","Nước","Âm thanh"};
    private static final String[] arrayAnswerHardScienceTopicC = {"208","Kangaroo","Sao Hải Vương","Khí CO2","Mùi"};
    private static final String[] arrayAnswerHardScienceTopicD = {"209","Thỏ","Sao Kim","Tất cả các phương án trên","Hương vị"};
    private static final String[] arrayHardScienceTopic = {"Cơ thể người có bao nhiêu xương?","Động vật nào không thể nhảy?","Hành tinh nào lớn nhất trong hệ mặt trời?","Cái gì giúp cây cỏ tạo ra thức ăn?","Cái gì giúp chúng ta nhìn thấy vật thể?"};

    private String[] answer;
    private String[] arrayAnswerA;
    private String[] arrayAnswerB;
    private String[] arrayAnswerC;
    private String[] arrayAnswerD;
    private String[] arrayTopic;
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
        if(0<= position && position <=4){
            buttonLevel.setText("Dễ");
            if(Objects.equals(nameTopic, "Khoa Học")){
                arrayTopic = arrayEasyScienceTopic;
                arrayAnswerA = arrayAnswerEasyScienceTopicA;
                arrayAnswerB = arrayAnswerEasyScienceTopicB;
                arrayAnswerC = arrayAnswerEasyScienceTopicC;
                arrayAnswerD = arrayAnswerEasyScienceTopicD;
                answer = AnswerEasyScience;
            }
            if(Objects.equals(nameTopic, "Địa Lý")){
                arrayTopic = arrayEasyGeographicalTopic;
                arrayAnswerA = arrayAnswerEasyGeographicalTopicA;
                arrayAnswerB = arrayAnswerEasyGeographicalTopicB;
                arrayAnswerC = arrayAnswerEasyGeographicalTopicC;
                arrayAnswerD = arrayAnswerEasyGeographicalTopicD;
                answer = AnswerEasyGeography;
            }
            if(Objects.equals(nameTopic, "Lịch Sử")){
                arrayTopic = arrayEasyHistoryTopic;
                arrayAnswerA = arrayAnswerEasyHistoryTopicA;
                arrayAnswerB = arrayAnswerEasyHistoryTopicB;
                arrayAnswerC = arrayAnswerEasyHistoryTopicC;
                arrayAnswerD = arrayAnswerEasyHistoryTopicD;
                answer = AnswerEasyHistory;
            }
            textViewQuiz.setText(arrayTopic[position]);
            Objects.requireNonNull(textInputLayoutA.getEditText()).setText(arrayAnswerA[position]);
            Objects.requireNonNull(textInputLayoutB.getEditText()).setText(arrayAnswerB[position]);
            Objects.requireNonNull(textInputLayoutC.getEditText()).setText(arrayAnswerC[position]);
            Objects.requireNonNull(textInputLayoutD.getEditText()).setText(arrayAnswerD[position]);
            textViewAnswer.setText(String.format("Đáp án đúng: %s",answer[position]));
        }
        else{
            buttonLevel.setText("Khó");
            if(Objects.equals(nameTopic, "Khoa Học")){
                arrayTopic = arrayHardScienceTopic;
                arrayAnswerA = arrayAnswerHardScienceTopicA;
                arrayAnswerB = arrayAnswerHardScienceTopicB;
                arrayAnswerC = arrayAnswerHardScienceTopicC;
                arrayAnswerD = arrayAnswerHardScienceTopicD;
                answer = AnswerHardScience;
            }
            if(Objects.equals(nameTopic, "Địa Lý")){
                arrayTopic = arrayHardGeographicalTopic;
                arrayAnswerA = arrayAnswerHardGeographicalTopicA;
                arrayAnswerB = arrayAnswerHardGeographicalTopicB;
                arrayAnswerC = arrayAnswerHardGeographicalTopicC;
                arrayAnswerD = arrayAnswerHardGeographicalTopicD;
                answer = AnswerHardGeography;
            }
            if(Objects.equals(nameTopic, "Lịch Sử")){
                arrayTopic = arrayHardHistoryTopic;
                arrayAnswerA = arrayAnswerHardHistoryTopicA;
                arrayAnswerB = arrayAnswerHardHistoryTopicB;
                arrayAnswerC = arrayAnswerHardHistoryTopicC;
                arrayAnswerD = arrayAnswerHardHistoryTopicD;
                answer = AnswerHardHistory;
            }
            textViewQuiz.setText(arrayTopic[position-5]);
            Objects.requireNonNull(textInputLayoutA.getEditText()).setText(arrayAnswerA[position-5]);
            Objects.requireNonNull(textInputLayoutB.getEditText()).setText(arrayAnswerB[position-5]);
            Objects.requireNonNull(textInputLayoutC.getEditText()).setText(arrayAnswerC[position-5]);
            Objects.requireNonNull(textInputLayoutD.getEditText()).setText(arrayAnswerD[position-5]);
            textViewAnswer.setText(String.format("Đáp án đúng: %s",answer[position-5]));
        }
    }
}