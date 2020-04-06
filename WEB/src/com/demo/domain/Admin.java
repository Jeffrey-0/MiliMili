package com.demo.domain;

public class Admin {
    private Integer Id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin() {
    }

    public Admin(Integer id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }
}
