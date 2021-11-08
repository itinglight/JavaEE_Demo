package controller;

import java.sql.*;

public class mysql {
//   DriverManager.registerDrive()

       void domysql(){
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
