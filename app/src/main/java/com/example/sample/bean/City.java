package com.example.sample.bean;

import java.util.List;

/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/12/29
 * 描述:
 */
public class City {

    /**
     * id : 1
     * name : 福建省
     */

    private int id;
    private String name;
    private List<School> schools;

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


}
