package com.kaishengit.service;


import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.User;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;


import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {

    @Inject
    private UserMapper userMapper;

    /**
     * 修改用户密码
     * @param password
     */
    public void changPassword (String password){
        User user =  ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));
        userMapper.updateUser(user);

    }

}
