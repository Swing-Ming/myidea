package com.kaishengit.dao;

import com.kaishengit.dao.UserDao;

public class User {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void run(){
        System.out.println("sayhi#######");
        userDao.save();
    }
}
