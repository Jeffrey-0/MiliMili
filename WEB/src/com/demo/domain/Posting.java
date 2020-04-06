package com.demo.domain;

public class Posting {
    private Integer post_id;
    private Integer post_uid;
    private String post_title;
    private String post_name;

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getPost_uid() {
        return post_uid;
    }

    public void setPost_uid(Integer post_uid) {
        this.post_uid = post_uid;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public Posting() {
    }

    public Posting(Integer post_id, Integer post_uid, String post_title, String post_name) {
        this.post_id = post_id;
        this.post_uid = post_uid;
        this.post_title = post_title;
        this.post_name = post_name;
    }
}
