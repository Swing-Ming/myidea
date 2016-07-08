package com.kaishengit.pojo;

import java.io.Serializable;

public class UserLog implements Serializable{
    private Integer id;
    private String logtime;
    private String loginip;
    private Integer userid;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", logtime='" + logtime + '\'' +
                ", loginip='" + loginip + '\'' +
                ", userid=" + userid +
                '}';
    }
}
