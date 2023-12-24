package com.example.projectfinal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListQuestionAdapter extends BaseAdapter {
    final ArrayList<QuestionQuizz> listQuestion;

    public ListQuestionAdapter(ArrayList<QuestionQuizz> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @Override
    public int getCount() {
        return listQuestion.size();
    }

    @Override
    public Object getItem(int position) {
        return listQuestion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listQuestion.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewListQuizz;
        if(convertView == null){
            viewListQuizz = View.inflate(parent.getContext(),R.layout.question_view,null);
        }
        else{
            viewListQuizz = convertView;
        }
        QuestionQuizz questionQuizz = (QuestionQuizz) getItem(position);
        ((TextView) viewListQuizz.findViewById(R.id.nameQuizz)).setText(questionQuizz.name);
        ((TextView) viewListQuizz.findViewById(R.id.levelQuizz)).setText(questionQuizz.level);
        return viewListQuizz;
    }
}
