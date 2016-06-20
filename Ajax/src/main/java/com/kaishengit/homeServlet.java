package com.kaishengit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class homeServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(homeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =req.getParameter("username");
        logger.debug("用户名:{}",username);
        PrintWriter out = resp.getWriter();
        if("tom".equals(username)){
            out.print("no");

        }else{
            out.print("yes");
        }
        out.flush();
        out.close();
    }
}
