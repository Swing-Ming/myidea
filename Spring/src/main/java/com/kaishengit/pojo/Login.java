package com.kaishengit.pojo;

import java.security.Timestamp;

public class Login {
    private  Integer id ;
    private String ip;
    private Timestamp timestamp;
    private Integer usrid;


    public Login() {

    }

    public Login(String ip, Integer usrid) {
        this.ip = ip;
        this.usrid = usrid;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getUsrid() {
        return usrid;
    }

    public void setUsrid(Integer usrid) {
        this.usrid = usrid;
    }

    @Override
    public String toString() {
        return "login{" +
                "id=" + id +
                ", Ip='" + ip + '\'' +
                ", timestamp=" + timestamp +
                ", usrid=" + usrid +
                '}';
    }
}
