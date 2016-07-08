package com.kaishengit.pojo;

import java.io.Serializable;
import java.security.Timestamp;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Timestamp createTime;
    private String wenxin;
    private String realname;
    private Boolean enable;
    private Integer roleid;
    private Role role;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getWenxin() {
        return wenxin;
    }

    public void setWenxin(String wenxin) {
        this.wenxin = wenxin;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "roleid=" + roleid +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", wenxin='" + wenxin + '\'' +
                ", realname='" + realname + '\'' +
                ", enable=" + enable +
                '}';
    }
}
