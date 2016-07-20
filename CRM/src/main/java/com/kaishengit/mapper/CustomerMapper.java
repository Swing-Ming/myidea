package com.kaishengit.mapper;

import com.kaishengit.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public interface CustomerMapper {

    List<Customer> findByParam(Map<String, Object> params);
    Long countByParam(Map<String, Object> params);

    Long count();

    void saveCustomer(Customer customer);



    Customer  findByCompanyId(Integer id);

    List<Customer> findAllCompany(String customerTypeCompany);

    Customer findById(Integer id);

    void updateCusomer(Customer customer);

    List<Customer> findByType(String type);

    List<Customer> findCustomerByCompanyId(Integer id);

    void del(Integer id);

    Long finCustomerByTime(@Param("start") String start, @Param("end")String end);

    List<Customer> findALLCust();

}
