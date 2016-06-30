package com.kaishengit.dao;

public class UserDao {
    
    
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void init(){
        System.out.println("init.....");
    }
    public void save(){
        System.out.println("ssssss");
    }

    public UserDao(){
        System.out.println("userDao实例化对象");
    }

    public void destoy() {
        System.out.println("destoy....");
    }
}
