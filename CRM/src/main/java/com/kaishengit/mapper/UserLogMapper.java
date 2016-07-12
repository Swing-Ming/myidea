package com.kaishengit.mapper;

import com.kaishengit.pojo.UserLog;

import java.util.List;
import java.util.Map;

public interface UserLogMapper {

    void save(UserLog userlog);

    List<UserLog> findByParma(Map<String, Object> param);

    Long countByParam(Map<String, Object> param);
}
