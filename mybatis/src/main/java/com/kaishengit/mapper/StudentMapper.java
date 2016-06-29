package com.kaishengit.mapper;

import com.kaishengit.pojo.Student;

import java.util.List;


public interface StudentMapper {

    List<Student> findById(Integer id);



}
