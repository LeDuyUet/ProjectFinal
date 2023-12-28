package com.example.projectfinal;

public class Subject {
    private String name;
    private String des;
    private int idImage;
    private int id;

    public Subject(String name, String des, int idImage, int id) {
        this.name = name;
        this.des = des;
        this.idImage = idImage;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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
