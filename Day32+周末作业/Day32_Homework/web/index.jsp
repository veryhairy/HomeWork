<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <%--<c:if test="${sessionScope.username !=null}">--%>
    <h1>登录成功</h1>
    <form action="user" method="post">
      <input type="hidden" name="method" value="book">
      书名：<input type="text"  name="bkname">
      作者：<input type="text" name="author" >
      价格：<input type="text" name="price">
      <input type="submit">
    </form>
    <table border="1">

    </table>


    <form action="user" method="post">
      <input type="hidden" name="method" value="exit">
      <input type="submit" value="退出">
    </form>
  <%--</c:if>--%>
  </body>
  <script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

  $.getJSON("http://localhost:8080/user?method=showbooks",function (data, status) {

      $('table>tr').remove();

          if (status =="success") {
              $('table').append(
                          $('<tr>').append(
                              $('<th>').text("书名")
                          ).append(
                              $('<th>').text("作者")
                          ).append(
                              $('<th>').text("价格")
                  )
              );
              $.each(data, function (index, obj) {
                  $('table').append(
                      $('<tr>').append(
                          $('<td>').text(obj['bkname'])
                      ).append(
                          $('<td>').text(obj['author'])
                      ).append(
                          $('<td>').text(obj['price'])
                      )
                  )
              })

          }

      }
  )




</script>

</html>
