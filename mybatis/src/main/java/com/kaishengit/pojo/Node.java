package com.kaishengit.pojo;

import java.io.Serializable;

public class Node implements Serializable {

    private static final long serialVersionUID = -2646296217687394620L;
    private Integer id;

    private String nodename;

    public Node() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }
}
