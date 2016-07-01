package com.kaishengit.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Named;

/*@Repository
@Service
@Component*/

@Named
public class UserDao implements UserDa_interface {


    public Integer save() {
        System.out.println("userdao实现接口");

       /* if(1==1){
            throw new RuntimeException();

        }*/
        return 10000;
    }
    public void run(){

        System.out.println("aaaaaaaaaaaaa");
    }
}
