package com.kaishengit.service;

import com.kaishengit.adminDao.AdminDao;
import com.kaishengit.adminDao.LoginDao;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.pojo.Admin;
import com.kaishengit.pojo.Login;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class LoginService {


    @Inject
    private AdminDao adminDao;
    @Inject
    private  LoginDao loginDao;
    @Inject
    private SendEmail sendEmail;

    public Admin  findByAdminId(Integer AdminId){
        return  adminDao.findById(AdminId);

    }
    public Admin login(String adminName , String password, String ip){

        Admin admin = adminDao.findByName(adminName);

        if(admin != null && admin.getPwd().equals(password)){

            loginDao.save(new Login(ip,admin.getId()));

            sendEmail.save();

        }else{
            throw new ServiceException("账号或密码错误");
        }
        return admin;

    }


}
