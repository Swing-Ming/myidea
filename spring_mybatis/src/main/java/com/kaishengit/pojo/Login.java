package com.kaishengit.pojo;

import java.io.Serializable;
import java.security.Timestamp;

public class Login implements Serializable {

    private static final long serialVersionUID = 4988063503057914335L;


    private Integer id;
    private String ip;
    private Integer userid;
    private Timestamp timestamp;

    public Login(Integer userid, String ip) {
        this.userid = userid;
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", userid=" + userid +
                ", timestamp=" + timestamp +
                '}';
    }
}
