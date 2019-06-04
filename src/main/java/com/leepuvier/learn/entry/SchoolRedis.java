package com.leepuvier.learn.entry;

public class SchoolRedis {

    private Integer id;

    private String name;

    private String info;

    public SchoolRedis() {
    }

    public SchoolRedis(String name, String info){
        this.name = name;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
