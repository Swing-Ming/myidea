package com.kaishengit.util;

import com.kaishengit.pojo.User;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {
    public static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
    public static Integer getCurrentUserID(){
        return getCurrentUser().getId();

    }

    public static String getCurrentUsername(){
        return getCurrentUser().getUsername();
    }

    public static String getCurrentUserRealname(){
        return getCurrentUser().getRealname();
    }
    public static boolean isEmployee(){
        String name = getCurrentUser().getRole().getRolename();
        System.out.println(name);
        return getCurrentUser().getRole().getRolename().equals("员工");
    }
    public static boolean isManager() {
        return getCurrentUser().getRole().getRolename().equals("经理");
    }
    public static boolean isAdmin() {
        return getCurrentUser().getRole().getRolename().equals("管理员");
    }
}
