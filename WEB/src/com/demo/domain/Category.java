package com.demo.domain;

public class Category {
    private Integer id;
    private String name;
    private String descn;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descn='" + descn + '\'' +
                '}';
    }

    public Category() {
    }

    public Integer getId() {
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

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }

    public Category(Integer id, String name, String descn) {
        this.id = id;
        this.name = name;
        this.descn = descn;
    }
}
