package com.kaishengit.controller;

import com.kaishengit.pojo.User;
import com.sun.net.httpserver.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String del(@PathVariable Integer id){
        logger.debug("del object{}",id);
        return "redirect:/users";
    }

    //----------Ajax


    @RequestMapping(value="/checkuser.json",
                method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkUser(@PathVariable Integer id ){
        logger.debug("ID{}",id);
        return "success";
    }

    @RequestMapping(value="/{id},json",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User showUser(){
        User user = new User();
        user.setAddress("中国河南");
        user.setAge("23");
        user.setUserName("张三");
        return user;
    }

    //-----------native Servlet
    @RequestMapping(value = "/native")
    public String nativeHttpServlet(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session){

        ServletContext context = session.getServletContext();
        session.setAttribute("user","tom");
        return "home";

    }

    //-----------upload

    @RequestMapping(value="/avatar/upload",method=RequestMethod.GET)
    public String uploadavatar(){
        return "user/upload";
    }

   /* public String update(){
        return
    }*/








}
