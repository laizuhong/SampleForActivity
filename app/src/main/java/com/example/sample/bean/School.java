package com.example.sample.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/12/29
 * 描述:
 */
@Entity
public class School {

    /**
     * id : 5
     * pid : 1
     * sname : 福州大学
     * cover_url : null
     */

    @Id
    private int id;
    private int pid;
    private String sname;
    private String cover_url;

    @Generated(hash = 686845923)
    public School(int id, int pid, String sname, String cover_url) {
        this.id = id;
        this.pid = pid;
        this.sname = sname;
        this.cover_url = cover_url;
    }

    @Generated(hash = 1579966795)
    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }
}
