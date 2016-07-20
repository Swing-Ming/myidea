package com.kaishengit.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.service.ChartService;
import com.kaishengit.service.SalesService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.ModalExclude;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/chart")
public class ChartController {

    @Inject
    private ChartService chartService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model ,
                       @RequestParam(required = false,defaultValue = "") String start,
                       @RequestParam(required = false,defaultValue = "") String end){
        Long newCustomerCount = chartService.findNewCustomerCount(start,end);
        Long salesMoney = chartService.findSalesMoney(start,end);
        Long salesCount = chartService.findSalesCount(start,end);

        model.addAttribute("newCustomerCount",newCustomerCount);
        model.addAttribute("salesMoney",salesMoney);
        model.addAttribute("salesCount",salesCount);

        return "/chart/list";
    }

    @RequestMapping(value = "/user/money",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> bar(@RequestParam(required = false,defaultValue ="") String start ,
                      @RequestParam(required = false,defaultValue = "") String end){
    List<Map<String,Object>> data = chartService.loadAll(start , end);
        List<String> name = Lists.newArrayList();
        List<Object> value = Lists.newArrayList();

        for(Map<String,Object> map : data){
            for(Map.Entry<String,Object> entry : map.entrySet()){
                if(entry.getKey().equals("realname")){
                    name.add(entry.getValue().toString());
                }else if(entry.getKey().equals("price")){
                    value.add(entry.getValue().toString());
                }
            }
        }
        Map<String,Object> result = Maps.newHashMap();
        result.put("name",name);
        result.put("value",value);

        return result;
    }

    @RequestMapping(value = "/progress/data",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> pie(@RequestParam(required = false,defaultValue ="")String start,
                      @RequestParam(required = false,defaultValue ="")String end){

        return chartService.findProgressByTime(start,end);
    }
}
