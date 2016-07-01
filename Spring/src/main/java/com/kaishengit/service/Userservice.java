package com.kaishengit.service;

import com.kaishengit.dao.UserDa_interface;
import com.kaishengit.dao.UserDao;
import com.kaishengit.dao.UserDao1;
import com.sun.org.glassfish.gmbal.NameValue;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class Userservice {

    @Autowired
    private UserDa_interface userDa_interface;
//    private UserDa_interface userDa_interface1;
  /* private UserDao userDao;
    private UserDao1 userDao1;*/
   /* private UserDao1 userDao1;*/



//    public void setUserDaoX(UserDa_interface userDa_interface) {
//
//        this.userDa_interface = userDa_interface;
//
//    }

/*public Userservice(UserDa_interface userDa_interface){

    this.userDa_interface = userDa_interface;


}*/
   /* public Userservice(UserDa_interface userDa_interface,UserDa_interface userDa_interface1){
        this.userDa_interface  = userDa_interface;
        this.userDa_interface1  = userDa_interface1;
//        this.userDao1 = userDao1;
        *//*this.userDao = userDao1;*//*
        *//*this.userDao1 = userDao1;*//*

    }*/

    public void start(){
        userDa_interface.save();
//        userDa_interface1.save();

//        userDao1.run();
        /*userDao1.save();*/


    }
}
