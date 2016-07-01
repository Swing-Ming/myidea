package com.kaishengit.service;

import com.kaishengit.dao.UserDa_interface;
import com.kaishengit.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bookservice {

    private  String bookName;
    private  Integer num;
    private List<String> lists;
    private Set<String> sets;
    private Map<String,Object> maps;
    Properties properties ;
    UserDa_interface userDa_interface;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserDa_interface(UserDa_interface userDa_interface) {
        this.userDa_interface = userDa_interface;
    }



    public void show(){

        System.out.println("Bookservice{" +
                "bookName='" + bookName + '\'' +
                ", num=" + num +
                ", lists=" + lists +
                ", sets=" + sets +
                ", maps=" + maps +
                ", properties=" + properties +
                ", userDa_interface=" + userDa_interface +
                '}');

    }
}
