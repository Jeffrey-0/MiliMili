package com.demo.domain;

public class Resource {
    private int id;
    private String name;
    private String category;
    private String descn;
    private String code;
    private String img;
    private String date;
    private int uploader;
    private String level;

    public Resource() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUploader() {
        return uploader;
    }

    public void setUploader(int uploader) {
        this.uploader = uploader;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Resource(int id, String name, String category, String descn, String code, String img, String date, int uploader, String level) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.descn = descn;
        this.code = code;
        this.img = img;
        this.date = date;
        this.uploader = uploader;
        this.level = level;
    }
}
