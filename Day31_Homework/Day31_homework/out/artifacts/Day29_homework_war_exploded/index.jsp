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
    if (session.getAttribute("username") !=null){
  %>
  <h1>登录成功</h1>
  <form action="book" method="post">
    书名：<input type="text"  name="bkname">
    作者：<input type="text" name="author" >
    价格：<input type="text" name="price">
    <input type="submit">
  </form>
  <table border="1">

  </table>


  <form action="exit" method="post">
    <input type="submit" value="退出">
  </form>
  <%
  }else {
  %>
  <h1><a href="login.jsp">请登录</a></h1>
  <%
    }
  %>




  </body>
  <script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

  $.getJSON("http://localhost:8080/book",function (data, status) {

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
              )

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
