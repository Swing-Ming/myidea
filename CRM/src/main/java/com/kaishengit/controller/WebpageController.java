package com.kaishengit.controller;

import com.kaishengit.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
public class WebpageController {

    @Inject
    private UserService userService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String webPage(){

        return "start";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String webPage(String username , String password, RedirectAttributes redirectAttributes){
        Subject subject = SecurityUtils.getSubject();
        System.out.println("=============================================="+subject);
        System.out.println("=============================================="+username);
        if(subject.isAuthenticated()){
            //当前用户已登录，则退出登录
            subject.logout();
        }
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            return "redirect:/home";
        }catch (AuthenticationException e){
          /*  e.printStackTrace();
            System.out.println("登陆错误");*/
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

}
