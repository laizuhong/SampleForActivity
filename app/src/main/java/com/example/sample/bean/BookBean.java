package com.example.sample.bean;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */

public class BookBean {
    private String name;
    private String price;

    public BookBean(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
