<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Y4
  Date: 2018/1/16
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>注册</h1>
<form action="register.action" method="post">
    用户名：   <input type="text" name="username"><s:fielderror fieldName="username"/><br>
    密码：   <input type="password" name="password"><s:fielderror fieldName="password"/><br>
    <input type="submit">
</form>

</body>
</html>
