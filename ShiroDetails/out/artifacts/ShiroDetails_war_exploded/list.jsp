<%--
  Created by IntelliJ IDEA.
  User: MrWu
  Date: 2018/8/31
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>List Page</h1>
    <h1>Welcome:<shiro:principal></shiro:principal></h1>

    <shiro:hasRole name="user">
      <br><br>
      <a href="user.jsp">User</a>
    </shiro:hasRole>

    <shiro:hasRole name="admin">
      <br><br>
      <a href="admin.jsp">Admin</a>
    </shiro:hasRole>

    <br><br>
    <a href="shiro/testShiroAnnotation">Test ShiroAnnotation</a>

    <br><br>
    <a href="/shiro/logout">Logout</a>
  </body>
</html>
