package com.kaishengit.mapper;

import com.kaishengit.pojo.User;


public interface UserMapper {

    User findByName(String name);

}
