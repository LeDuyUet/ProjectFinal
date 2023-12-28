package com.example.projectfinal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectAdapter extends BaseAdapter {

    final ArrayList<Subject> listQuizz;

    public SubjectAdapter(ArrayList<Subject> listQuizz) {
        this.listQuizz = listQuizz;
    }

    @Override
    public int getCount() {
        return listQuizz.size();
    }

    @Override
    public Object getItem(int position) {
        return listQuizz.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listQuizz.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewQuizz;
        if(convertView ==null){
            viewQuizz = View.inflate(parent.getContext(),R.layout.quizz_view,null);
        }
        else {
            viewQuizz = convertView;
        }
        Subject quizz = (Subject) getItem(position);
        ((ImageView)viewQuizz.findViewById(R.id.imageViewQuizz)).setImageResource(quizz.getIdImage());
        ((TextView)viewQuizz.findViewById(R.id.textViewQuizz)).setText(String.format("%s",quizz.getName()));
        ((TextView)viewQuizz.findViewById(R.id.detail)).setText(String.format("%s",quizz.getDes()));
        return viewQuizz;
    }
}
