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


@WebServlet("/checks")
public class check extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(check.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
        logger.debug("username:",username);

        PrintWriter out = resp.getWriter();
        if(username.equals("tom")){
            out.print("no");
        }else{
            out.print("yes");
        }
        out.flush();
        out.close();
    }
}
