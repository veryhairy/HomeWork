<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Y4
  Date: 2018/1/19
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
    <s:form action="login" method="POST">
        <s:textfield type="text" name="username"/><br>
        <s:textfield type="password"/><br>
        <input type="submit">
    </s:form>
</body>
</html>
