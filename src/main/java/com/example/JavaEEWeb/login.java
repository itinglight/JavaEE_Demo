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
            System.out.println("account:"+account+"\npassword:"+password);
            resp.sendRedirect("/JavaEEWeb_war_exploded/pages/rootpages.html");
        }else{
            System.out.println("普通用户登录");
            System.out.println("account:"+account+"\npassword:"+password);
            resp.sendRedirect("/JavaEEWeb_war_exploded/pages/userpages.html");
        }

       //
        System.out.println("IP 地址为："+req.getRemoteAddr());

                try {
                    //注册驱动
                    //方法1
        //            Driver dirver = new com.mysql.jdbc.Driver();
        //            DriverManager.registerDriver(dirver);
                    Class.forName("com.mysql.jdbc.Driver");
                    // 打开链接
                    System.out.println(" 连接数据库...");
                    String url ="jdbc:mysql://127.0.0.1:3306/express";
                    String user ="root";
                    String password1="";
                    Connection conn =DriverManager.getConnection(url,user,password1);

                    Statement stmt =null;
                    stmt=conn.createStatement();
                    String sql = "select * from user";
                    ResultSet rs =null;
                    rs = stmt.executeQuery(sql);

                    System.out.println("数据库连接对象"+conn);
                    while(rs.next()){
                        String name = rs.getString("username");
                        System.out.println(name);
                    }

                } catch (ClassNotFoundException | SQLException e) {

                    e.printStackTrace();

                }
                finally {

        //           if(rs!=null){
        //
        //               rs.close();
        //           }
        }
    }
}
