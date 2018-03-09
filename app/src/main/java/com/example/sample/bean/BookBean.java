package com.example.sample.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 *
 * Created by 赖祖宏 on 2017/5/15.
 */
@Entity
public class BookBean {
    @Id
    private String name;
    private String price;


    @Generated(hash = 11124809)
    public BookBean(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Generated(hash = 269018259)
    public BookBean() {
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

    @Override
    public String toString() {
        return "BookBean{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
