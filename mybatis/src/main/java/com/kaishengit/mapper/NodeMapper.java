package com.kaishengit.mapper;

import com.kaishengit.pojo.Node;
import com.kaishengit.pojo.User;

import java.util.List;

public interface NodeMapper {
    void bathSave(List<User> userList);
    void del(List<Integer> userList);
    List<User> findAll();
    Node findById(Integer id);



}
