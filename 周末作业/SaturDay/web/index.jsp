<%--
  Created by IntelliJ IDEA.
  User: Y4
  Date: 2018/1/19
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script type="text/css">
      tr{
        display: inline-block;
      }
    </script>
  </head>
  <body>

  <h1>添加员工信息</h1>
  <form action="add.action" method="post">
      <input placeholder="姓名" name="employee.name">
      <input placeholder="年龄" name="employee.age">
      <input placeholder="部门" name="employee.department">
      <input placeholder="入职时间" name="employee.entrytime">
      <input placeholder="地址" name="employee.address">
      <input placeholder="号码" name="employee.phnumber">
      <input type="submit" value="确认添加">


  </form>
  <a href="query.action" id="dianji">查询员工信息</a>

  <c:if test="${requestScope.users !=null}">
  <table border="1px">

      <tr>
          <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>部门</th>
        <th>入职时间</th>
        <th>家庭住址</th>
        <th>电话号码</th>
        <th>编辑</th>
      </tr>
<c:forEach var="msg" items="${requestScope.users}">
      <tr>
          <td>${msg.id}</td>
        <td>${msg.name}</td>
        <td>${msg.age}</td>
        <td>${msg.department}</td>
        <td>${msg.entrytime}</td>
        <td>${msg.address}</td>
        <td>${msg.phnumber}</td>
        <td><a href="queryById.action?id=${msg.id}">编辑</a></td>
      </tr>
</c:forEach>

  </table>
  </c:if>
  </body>
<%--<script type="text/javascript">--%>

 <%--$('#dianji').click(function () {--%>
     <%--$.getJSON("homework/query.action",function (jsondate) {--%>

        <%--if (jsondate !=null){--%>
           <%--$('table').append($('<tr>')).append($('<td>').text("姓名")).--%>
                                        <%--append($('<td>').text("年龄")).--%>
                                        <%--append($('<td>').text("部门")).--%>
                                        <%--append($('<td>').text("入职时间")).--%>
                                        <%--append($('<td>').text("家庭住址")).--%>
                                        <%--append($('<td>').text("电话号码"))--%>

        <%--}--%>

 <%--})--%>

 <%--})--%>




<%--</script>--%>
</html>
