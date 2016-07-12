package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Inject
    private UserService userService;
    @Inject
    private RoleMapper roleMapper;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userList(Model model){
        List<Role> roleList = userService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "admin/userList";
    }

    @RequestMapping(value = "/users/load" , method = RequestMethod.GET)
    @ResponseBody
    public DataTableResult<User> userload(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyWord = request.getParameter("search[value]");

        Map<String , Object> params = Maps.newHashMap();
        params.put("keyword",keyWord);
        params.put("start",start);
        params.put("length",length);

        List<User> userList = userService.findUserListByParam(params);
        Long count = userService.findUserCount();
        Long filterCount = userService.findUserCountByParam(params);

        DataTableResult <User> dataTableResult = new DataTableResult<>(draw,userList,count,filterCount);
        return dataTableResult;
    }

    /**
     * ajax 调用验证用户名是否可用
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/checkusername",method = RequestMethod.GET)
    @ResponseBody
    public String checkUser(String username){
        User user = userService.findUserByUserName(username);
        if(user == null){
            return "true";

        }else{
            return "false";
        }

    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping(value = "/users/new",method = RequestMethod.POST )
    @ResponseBody
    public String saveUser(User user){

        System.out.println(user.getUsername());
        userService.saveUser(user);

        return "success";

    }

    @RequestMapping(value="/users/resetpwd",method = RequestMethod.POST)
    @ResponseBody
    public String resetPassWord(Integer id){
        userService.resetUserPassWord(id);
        return "success";

    }


}
