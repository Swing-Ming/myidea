package com.kaishengit.controller;


import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.pojo.Customer;
import com.kaishengit.service.CustomerService;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.GenericFilterBean;

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

    @RequestMapping(value="/{id:\\d+}",method = RequestMethod.GET)
    public String view(@PathVariable Integer id, Model model){
       Customer customer =  customerService.findCustomerById(id);
        if(customer.getType().equals(Customer.CUSTOMER_TYPE_COMPANY)){
            List<Customer> customerList = customerService.findCustomerByCompanyId(id);
            model.addAttribute("customerList",customerList);
        }

        model.addAttribute("customer",customer);

        return "/customer/view";
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    @RequestMapping(value="/del/{id:\\d+}",method = RequestMethod.GET )
    @ResponseBody
    public String del(@PathVariable Integer id){
        customerService.del(id);

        return "success";
    }

    /**
     * 编辑用户
     * @param customer
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public String edit(Customer customer){
        customerService.editCustomer(customer);
        return "success";
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id:\\d+}.json" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String ,Object> edit(@PathVariable Integer id ){
        List<Customer> companyList = customerService.findAllCompany();
      Customer customer = customerService.findCustomerById(id);

        Map<String,Object> result = Maps.newHashMap();
        if(customer == null){
            result.put("state","error");
            result.put("message","找不到对应客户");
        }else{
            result.put("state","success");
            result.put("customer",customer);
            result.put("companyList",companyList);
        }
        return result;
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
        keyword =  Strings.toUTF8(keyword);
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
