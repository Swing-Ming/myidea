package com.kaishengit.controller;


import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.pojo.Customer;
import com.kaishengit.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(){


        return "/customer/list";
    }

    /**
     * 查询所有公司
     * @return
     */
    @RequestMapping(value="/company.json",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> allCompany(){

        return customerService.findAllCompany();
    }

    /**
     * 新增用户
     * @return
     */
    @RequestMapping(value = ("/new"),method = RequestMethod.POST)
    @ResponseBody
    public String newCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "success";
    }

    /**
     * 查询所有
     * @param request
     * @return
     */
    @RequestMapping(value ="/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTableResult<Customer> load(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");

        Map<String ,Object> params = Maps.newHashMap();
        params.put("start",start);
        params.put("length",length);
        params.put("keyword",keyword);

        List<Customer> customerList = customerService.findCustomerByParams(params);
        Long count = customerService.count();
        Long filterCount = customerService.countByParam(params);

        return new DataTableResult<>(draw,count,filterCount,customerList);

    }





}
