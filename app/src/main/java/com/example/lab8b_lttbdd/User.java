package com.example.lab8b_lttbdd;

public class User {
    private String name;
    private String password;
    private int normal;
    private int happy;
    private int sad;
    private String email;

    public User() {
    }

    public User(String name, String password, int normal, int happy, int sad, String email) {
        this.name = name;
        this.password = password;
        this.normal = normal;
        this.happy = happy;
        this.sad = sad;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getSad() {
        return sad;
    }

    public void setSad(int sad) {
        this.sad = sad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
