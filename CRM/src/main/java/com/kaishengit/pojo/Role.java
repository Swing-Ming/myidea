package com.kaishengit.pojo;

import java.io.Serializable;

public class Role implements Serializable {


    private Integer id;
    private String rolename;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolename() {
        return rolename;
    }


}
