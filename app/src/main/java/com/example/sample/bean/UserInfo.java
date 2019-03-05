package com.example.sample.bean;

public class UserInfo {
    private Long id;
    private String name;
    private Integer age;
    private String tel;

    public UserInfo(Long id, String name, Integer age, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
