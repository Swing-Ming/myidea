package com.kaishengit.mapper;
import com.kaishengit.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> findByQueryParam(Map<String,Object> queryParam);
    User findByParam(@Param("username") String username,@Param("pwd") String password);
    List<User> finByObj(Map<String,Object> map);
    User findById(Integer id);
    void update(User user);
    List<User> findAll();
    void del(Integer id);
    void insert(User user);
    User findByMap(Map<String,Object> queryParam);






}
