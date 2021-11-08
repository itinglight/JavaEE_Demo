package com.example.JavaEEWeb;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello login service");
        String account=req.getParameter("account");
        String password=req.getParameter("password");
        String identity=req.getParameter("identity");
        System.out.println(identity);
        if(identity.equals("root")){
            System.out.println("超级管理员登录");
            System.out.println("account:"+account+
                    "\npassword:"+password);
            resp.sendRedirect("/JavaEEWeb_war_exploded/pages/rootpages.html");
        }else{
            System.out.println("普通用户登录");
            System.out.println("account:"+account+
                    "\npassword:"+password);

            resp.sendRedirect("/JavaEEWeb_war_exploded/pages/userpages.html");

            
        }





       //
        System.out.println("IP 地址为："+req.getRemoteAddr());


    }
}
