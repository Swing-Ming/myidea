package com.kaishengit.service;


import com.google.common.collect.Maps;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserLogMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.joda.time.DateTime;

@Named
public class UserService {

    @Inject
    private UserMapper userMapper;

    @Inject
    private UserLogMapper userLogMapper;
    @Inject
    private RoleMapper roleMapper;

    /**
     * 修改用户密码
     * @param password
     */
    public void changPassword (String password){
        User user =  ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));
        userMapper.updateUser(user);

    }

    /**
     * 创建用户的登录日志
     */

    public void saveUserLog(String ip){
        UserLog  userLog = new UserLog();
        userLog.setLoginip(ip);
        userLog.setLogtime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
        userLog.setUserid(ShiroUtil.getCurrentUserID());
        userLogMapper.save(userLog);

    }
    /**
     * 获取用户当前登录日志
     * @param start
     * @param length
     * @return
     */

    public List<UserLog> findCurrentUserLog(String start, String length) {
        Map<String ,Object> param = Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserID());
        param.put("start",start);
        param.put("length",length);
        return userLogMapper.findByParma(param);

    }

    /**
     * 获取当前用户的数量
     */
    public Long finCurrentUserLogCount(){
        Map<String,Object> param = Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserID());
        return userLogMapper.countByParam(param);
    }

    public List<User> findUserListByParam(Map<String, Object> params) {
       List<User>userList =  userMapper.findByParam(params);
           return userList;

    }

    public Long findUserCount() {
        return userMapper.countAll();
    }

    public Long findUserCountByParam(Map<String, Object> params) {
        return userMapper.countByParam(params);
    }

    public User findUserByUserName(String username) {
            return userMapper.findByUsername(username);
    }

    public void saveUser(User user) {
        user.setEnable(true);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userMapper.save(user);
    }

    public List<Role> findAllRole() {
            return roleMapper.findAll();
    }


    public void resetUserPassWord(Integer id) {
        User user = userMapper.findUserById(id);
        if(user != null){
            user.setPassword(DigestUtils.md5Hex("000000"));
            userMapper.updateUser(user);
        }
    }
}
