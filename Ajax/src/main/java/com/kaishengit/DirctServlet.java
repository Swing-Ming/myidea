package com.kaishengit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/direct")
public class DirctServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String word =  req.getParameter("q");
        System.out.print(word);
          word = new String (word.getBytes("ISO8859-1"),"UTF-8");
            String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q=" + word;
            String xml = Httputil.httpClient(url);
            resp.setContentType("text/xml;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.print(xml);
            out.flush();
            out.close();


    }
}
