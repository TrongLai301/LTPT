package com.example.quanlidiemso;

public class Student {
    private Integer id;
    private String name;
    private String nameClass;
    private String gender;
    private String gmail;
    private Integer score;

    public Student() {
    }

    public Student(Integer id, String name, String nameClass, String gender, String gmail, Integer score) {
        this.id = id;
        this.name = name;
        this.nameClass = nameClass;
        this.gender = gender;
        this.gmail = gmail;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
