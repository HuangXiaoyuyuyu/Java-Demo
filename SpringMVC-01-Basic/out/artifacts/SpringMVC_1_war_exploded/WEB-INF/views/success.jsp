<%--
  Created by IntelliJ IDEA.
  User: 25375
  Date: 2017/12/1
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Success</h1>
time:${requestScope.time} <br><br>
names:${requestScope.names}<br><br>

RequestUser:${requestScope.user}<br><br>

SessionUser:${sessionScope.user}<br><br>

RequestString:${requestScope.string}<br><br>

SessionString:${sessionScope.string}<br><br>

<fmt:message key="i18n.username" />
<br><br>
<fmt:message key="i18n.password" />
<br><br>
</body>
</html>
