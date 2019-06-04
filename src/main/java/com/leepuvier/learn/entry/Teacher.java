package com.leepuvier.learn.entry;


import org.springframework.data.annotation.Id;

public class Teacher {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    private String info;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
