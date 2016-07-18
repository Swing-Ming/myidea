package com.kaishengit.mapper;


import com.kaishengit.pojo.Sales;

import java.util.List;
import java.util.Map;

public interface SalesMapper {

    List<Sales> findByParam(Map<String, Object> params);

    Long countByParam(Map<String, Object> params);
}
