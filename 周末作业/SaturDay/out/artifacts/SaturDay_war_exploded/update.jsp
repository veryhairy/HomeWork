<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Y4
  Date: 2018/1/20
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑信息</title>
</head>
<body>
<%--TODO--%>
        <form method="post" action="update1.action">
            <input value="${requestScope.user.id}" name="employee.id" readonly>
            <input placeholder="姓名：${requestScope.user.name}" name="employee.name">
            <input placeholder="年龄：${requestScope.user.age}" name="employee.age">
            <input placeholder="部门：${requestScope.user.department}" name="employee.department">
            <input placeholder="入职时间：${requestScope.user.entrytime}" name="employee.entrytime">
            <input placeholder="地址：${requestScope.user.address}" name="employee.address">
            <input placeholder="号码：${requestScope.user.phnumber}" name="employee.phnumber">
            <input type="submit" value="确认修改">
        </form>

</body>
</html>
