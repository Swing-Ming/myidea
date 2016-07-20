package com.kaishengit.service;

import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.pojo.Customer;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class ChartService {

    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private SalesMapper  salesMapper;


    public Long findNewCustomerCount(String start, String end) {

        DateTime now = DateTime.now();
        if(StringUtils.isEmpty(start)){
            start = now.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd");
        }
        if(StringUtils.isEmpty(end)){
            end = now.toString("yyyy-MM-dd");
        }

        return customerMapper.finCustomerByTime(start,end);
    }


    public Long findSalesMoney(String start, String end) {
        DateTime now = DateTime.now();
        if(StringUtils.isEmpty(start)){
            start = now.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd");
        }
        if(StringUtils.isEmpty(end)){
            end = now.toString("yyyy-MM-dd");
        }
            return salesMapper.countMoneyByTime(start,end,"完成交易");
    }

    public Long findSalesCount(String start, String end) {
        DateTime now = DateTime.now();
        if(StringUtils.isEmpty(start)){
            start = now.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd");
        }
        if(StringUtils.isEmpty(end)){
            end = now.toString("yyyy-MM-dd");
        }
            return salesMapper.findStateCount(start,end,"完成交易");
    }

    public List<Map<String, Object>> loadAll(String start, String end) {
        DateTime now = DateTime.now();
        if(StringUtils.isEmpty(start)){
            start = now.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd");
        }
        if(StringUtils.isEmpty(end)){
            end = now.toString("yyyy-MM-dd");
        }
            return salesMapper.findAllByTime(start,end);
    }

    public Map<String,Object> findProgressByTime(String start ,String end) {

        return salesMapper.findProgress(start,end);
    }
}
