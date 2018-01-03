<%--
  Created by IntelliJ IDEA.
  User: Y4
  Date: 2018/1/2
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    if (session.getAttribute("username")!=null){
  %>
  <h1>登录成功</h1>
  <form action="insert" method="post">
    书名：<input name="bname" type="text">
    <br>
    作者：<input name="author" type="text">
    <br>
    价格：<input name="price" type="text">
    <br>
    <input type="submit">
  </form>
  <a href="login.html">退出</a>
  <%

  }else {
  %>
  <h1><a href="login.html">请登录</a></h1>
  <%
    }
  %>

  </body>
</html>
