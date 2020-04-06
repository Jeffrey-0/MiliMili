package com.demo.domain;

public class User {
    private int id;
    private String name;
    private String password;
    private String selfdescn;
    private int speak;
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User(int id, String name, String password, String selfdescn, int speak, String number) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.selfdescn = selfdescn;
        this.speak = speak;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSelfdescn() {
        return selfdescn;
    }

    public void setSelfdescn(String selfdescn) {
        this.selfdescn = selfdescn;
    }

    public int getSpeak() {
        return speak;
    }

    public void setSpeak(int speak) {
        this.speak = speak;
    }

    public User() {
    }


}
