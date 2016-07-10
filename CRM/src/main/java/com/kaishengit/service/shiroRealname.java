package com.kaishengit.service;

import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ShiroRealname extends AuthorizingRealm{

    @Inject
    private UserMapper userMapper;

    @Inject
    private RoleMapper roleMapper;



    /**
     * 验证权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) principalCollection.getPrimaryPrincipal();/*user是如何获取的，user对象与下面的user查询到的user的user对像是否一致*/
        /*根据用户的roleid获取role*/
        if(user != null){
            Integer roleId = user.getRoleid();

            Role role = roleMapper.findById(roleId);
            /*将用户的角色名称赋值给info*/
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            info.addRole(role.getRolename());

            return info;

        }



        return null;
    }

    /**
     * 验证账号密码是否正确
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userMapper.findByUsername(username);
        System.out.println(user.getRoleid()+"======================");
       /* System.out.println(username);*/
        if(user != null){
            if(!user.getEnable()){
                throw new LockedAccountException("账号已被禁用");
            }
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());

        }else{
            throw new  UnknownAccountException("账号或密码错误");
        }
    }
}
