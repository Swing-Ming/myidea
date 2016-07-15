package com.kaishengit.mapper;

import com.kaishengit.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    List<Customer> findByParam(Map<String, Object> params);
    Long countByParam(Map<String, Object> params);

    Long count();

    void saveCustomer(Customer customer);

    List<Customer> findAllCompany();
}
