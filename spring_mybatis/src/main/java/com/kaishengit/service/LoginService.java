package com.kaishengit.service;


import com.kaishengit.mapper.LoginMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Login;
import com.kaishengit.pojo.User;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class LoginService {
    @Inject
    private User user;
    @Inject
    private UserMapper userMapper;
    @Inject
    private LoginMapper loginMapper;



   /* public void findUser(Integer id){
       user  = userMapper.findById(id);
    }
*/

    public void loginService(String username ,String password, String ip){
       user =  userMapper.findByName(username);
        if(username!=null && user.getPwd().equals(password)){
            loginMapper.save(new Login(user.getId(),ip));

        }

    }

}
