package com.kaishengit.adminDao;

import com.kaishengit.pojo.Admin;

import java.util.List;

public interface AdminDao {

    void save(Admin admin);
    void del(Integer id);
    void update(AdminDao admin);
    Admin findById(Integer id);
     List<Admin> findAll();
    Admin findByName(String name);
    Long count();
}
