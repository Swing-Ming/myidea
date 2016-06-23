package com.kaishengit;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ajax_json")
public class Ajax_json extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"tom","USA"));
        list.add(new User(2,"jim","UK"));
        list.add(new User(3,"lili","中国"));
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","tom");
//        map.put("message","rain");




        resp.setContentType("application/json;charset=UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(list);
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }
}
