package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false,defaultValue = "false")String vip,
                       Integer age ) {
        logger.debug("VIP:{} age:{}",vip,age);
        model.addAttribute("UserName","Spring 4.x");
        return "users/list";
    }
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET )
    public String showUser(@PathVariable("id") Integer userId, Model model){
        logger.debug("ID:{}",userId);
        return "users/show";
    }
    @RequestMapping(value="/{userId:\\d+}/photos/catalog/{catalogId:\\d+}",method = RequestMethod.GET)
    public ModelAndView showUserPhoto(@PathVariable Integer userId ,
                                      @PathVariable Integer catalogId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/show");
        modelAndView.addObject("userId",userId);
        logger.debug("userId:{} catalogId:{}",userId,catalogId);
        return modelAndView;
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String saveUser(User user, String comment){
        logger.debug("userName{},Address{},Age{},comment{}",user.getUserName(),user.getAddress(),user.getAge(),comment);
        return "users/user";
    }
    



}
