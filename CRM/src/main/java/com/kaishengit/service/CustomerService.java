package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.util.ShiroUtil;
import com.kaishengit.util.Strings;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class CustomerService {

    @Inject
    private CustomerMapper customerMapper;
    public List<Customer> findCustomerByParams(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        List<Customer> customerList = customerMapper.findByParam(params);
        return customerList;
    }

    public Long count() {
        if(ShiroUtil.isEmployee()){
            Map<String,Object> params = Maps.newHashMap();
            params.put("userid",ShiroUtil.getCurrentUserID());
            return  customerMapper.countByParam(params);
        }
        return customerMapper.count();
    }

    public Long countByParam(Map<String, Object> params) {
        if(ShiroUtil.isEmployee()){
            params.put("userid",ShiroUtil.getCurrentUserID());
        }
        return customerMapper.countByParam(params);
    }

    public void saveCustomer(Customer customer) {

        if(customer.getCompanyid()!= null){
           Customer company =  customerMapper.findByCompanyId(customer.getCompanyid());
            customer.setCompanyname(company.getName());
        }
        customer.setUserid(ShiroUtil.getCurrentUserID());
        customer.setPinyin(Strings.toPinyin(customer.getName()));
        customerMapper.saveCustomer(customer);
    }

    public List<Customer> findAllCompany() {
        List<Customer> customerList = customerMapper.findAllCompany(Customer.CUSTOMER_TYPE_COMPANY);
        return customerList;
    }

    public Customer findCustomerById(Integer id) {

                return customerMapper.findById(id);
    }

    public void editCustomer(Customer customer) {
        if(customer.getType().equals(Customer.CUSTOMER_TYPE_COMPANY)){
            List<Customer> customerList  = customerMapper.findCustomerByCompanyId(customer.getId());
            for (Customer cust: customerList) {
                cust.setCompanyid(customer.getId());
                cust.setCompanyname(customer.getName());
                customerMapper.updateCusomer(cust);
            }
        }else{
            if(customer.getCompanyid() != null){
              Customer cust =  customerMapper.findByCompanyId(customer.getCompanyid());
                customer.setCompanyname(cust.getName());
            }
        }
        customer.setPinyin(Strings.toPinyin(customer.getName()));
        customerMapper.updateCusomer(customer);
    }

    public void del(Integer id) {
        customerMapper.del(id);
    }

    public List<Customer> findCustomerByCompanyId(Integer id) {

            return customerMapper.findCustomerByCompanyId(id);
    }

    public List<Customer> findAllCust() {
        return customerMapper.findALLCust();
    }
}
