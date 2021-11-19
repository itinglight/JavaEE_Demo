<%--
  Created by IntelliJ IDEA.
  User: tinglight
  Date: 2021/9/13
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin:0;
            padding:0;
        }



        body{
            background-color:#00A19D;
            text-align:center;
        }

        h1{
            margin: 60px auto;
            color:#FFB344;;
            font-size:48px
        }
        div{
            color:#FFB344;
            font-size: 34px;
        }

    </style>
</head>
<body>
    <h1>完全平方数</h1>
<%
    int a,b,c,d;
    for(int x=1000;x<10000;x++){
        a=x/1000;
        b=x/100-a*10;
        c=x/10-a*100-b*10;
        d=x-a*1000-b*100-c*10;
        if(a==b && c==d){
        %>
    <div>
        <%=x%>

    </div>

    <%
        }


    }

%>
</body>
</html>
