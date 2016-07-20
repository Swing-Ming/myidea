package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTableResult;
import com.kaishengit.pojo.Sales;
import com.kaishengit.service.CustomerService;
import com.kaishengit.service.SalesService;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/sales")
public class SalesController {

    @Inject
    private SalesService salesService;
    @Inject
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
            model.addAttribute("custList",customerService.findAllCust());
        return "/sales/list";

    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public DataTableResult<Sales> load(HttpServletRequest request) {
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        String name = request.getParameter("name");
        name = Strings.toUTF8(name);
        String progress = request.getParameter("progress");
        progress = Strings.toUTF8(progress);
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        Map<String,Object> params = Maps.newHashMap();
        params.put("draw",draw);
        params.put("start",start);
        params.put("length",length);
        params.put("name",name);
        params.put("progress",progress);
        params.put("startdate",startDate);
        params.put("endDate",endDate);

        List<Sales> salesList = salesService.findByParam(params);
        Long countParam = salesService.countByParam(params);
        Long count = salesService.count();

        return  new DataTableResult<>(draw,count,countParam,salesList);
    }

    @RequestMapping(value = "/newsales" ,method = RequestMethod.POST)
    @ResponseBody
    public String addSales(Sales sales){

        salesService.addSales(sales);

        return "success";
    }
}
