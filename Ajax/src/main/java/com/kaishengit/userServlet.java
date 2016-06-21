package com.kaishengit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user.xml")
public class userServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("<?xml version = \"1.0\" encoding=\"UTF-8\"?>");
        out.print("<users>");
        out.print("<user id = \"101\"><username>tom</username><adress>USA</adress></user>");
        out.print("<user id = \"102\"><username>jim</username><adress>UK</adress></user>");
        out.print("<user id = \"103\"><username>lili</username><adress>China</adress></user>");
        out.print("</users>");
        out.flush();
        out.close();



    }
}
