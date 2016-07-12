package com.kaishengit.controller;

import com.kaishengit.dto.DataTableResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.service.UserService;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @ResponseBody
    public String editPssword (String password){
        userService.changPassword(password);
        return "success";
    }
    /*
     * 显示用户登录当前日志
     */

    @RequestMapping(value="/log",method = RequestMethod.GET)
    public String showUserLog(){

        return "setting/loglist";
    }
    /**
     * 验证原始密码是否正确使用 ajax调用
     * @param xRequestedWith
     * @param oldpassword
     * @return
     */
    @RequestMapping(value = "/validate/password",method = RequestMethod.GET)
    @ResponseBody
    public String validateOldPassword(@RequestHeader("X-Requested-With") String xRequestedWith,
                                      String oldpassword){
        if("XMLHttpRequest".equals(xRequestedWith)){
            User user = ShiroUtil.getCurrentUser();
            if(user.getPassword().equals(DigestUtils.md5Hex(oldpassword))){
                return "true";
            }else{
                return "false";
            }
        }else{
            throw new NotFoundException();
        }

    }


    /**
     * 获取用户登录日志使用dataTables显示
     */

    /*@RequestMapping(value = "/log/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTableResult userLogLoad(HttpServletRequest request) {

        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        List<UserLog> userLogList = userService.findCurrentUserLog(start, length);
        Long count = userService.finCurrentUserLogCount();


        return DataTableResult <>
    }*/
}
