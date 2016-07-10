package com.kaishengit.controller;

import com.kaishengit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/user")
public class UserController {


    @Inject
    private UserService userService;

    /**
     * 修改密码
     */
    @RequestMapping(value = "/password",method = RequestMethod.GET)
    public String editPassword(){
        return "setting/password";
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @RequestBody
    public String editPssword (String password){



    return "success";
    }

    /**
     * 验证原始密码是否正确使用 ajax
     * @param xRequestedWith
     * @param oldpassword
     * @return
     */
    @RequestMapping(value = "/valadate/password",method = RequestMethod.GET)
    public String validateOldPassword(@RequestHeader("X-Requested-With") String xRequestedWith,
                                      String oldpassword){
        if(""){}



    }

}
