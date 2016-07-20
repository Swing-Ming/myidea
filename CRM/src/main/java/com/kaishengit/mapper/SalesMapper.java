package com.kaishengit.mapper;


import com.kaishengit.pojo.Sales;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SalesMapper {

    List<Sales> findByParam(Map<String, Object> params);

    Long countByParam(Map<String, Object> params);

    Long countMoneyByTime(@Param("start") String start, @Param("end") String end, @Param("state") String 完成交易);

    Long findStateCount(@Param("start") String start,@Param("end") String end, @Param("state") String 完成交易);

    List<Map<String,Object>> findAllByTime(@Param("start") String start,@Param("end") String end);

    Map<String,Object> findProgress(String start, String end);

    void saveSales(Sales sales);
}
