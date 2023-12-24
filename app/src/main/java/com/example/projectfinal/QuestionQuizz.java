package com.example.projectfinal;

public class QuestionQuizz {
    String name;
    String level;
    int id;

    public QuestionQuizz(String name, String level, int id) {
        this.name = name;
        this.level = level;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
