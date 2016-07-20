package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.Sales;
import com.kaishengit.util.ShiroUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class SalesService {

    @Inject
    private SalesMapper salesMapper;
    @Inject
    private CustomerMapper customerMapper;

    public List<Sales> findByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid", ShiroUtil.getCurrentUserID());
        }
        return salesMapper.findByParam(params);
    }

    public Long countByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid", ShiroUtil.getCurrentUserID());
        }
            return salesMapper.countByParam(params);
    }


    public Long count() {
        Map<String,Object> params = Maps.newHashMap();
        if(ShiroUtil.isEmployee()){
            params.put("userid", ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(params);
    }

    public void addSales(Sales sales) {
        sales.setUserid(ShiroUtil.getCurrentUserID());
        sales.setCustname(customerMapper.findById(sales.getCustid()).getName());
       sales.setUsername(ShiroUtil.getCurrentUserRealname());
        salesMapper.saveSales(sales);
    }
}
