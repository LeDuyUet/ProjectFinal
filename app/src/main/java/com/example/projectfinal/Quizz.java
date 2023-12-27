package com.example.projectfinal;


public class Quizz{
    String text;
    int idImage;
    int id;
    public Quizz(String text, int idImage, int id) {
        this.text = text;
        this.idImage = idImage;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
