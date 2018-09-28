<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 25375
  Date: 2017/12/7
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
    <form action="testConversionServiceConverter" method="post">
        <%--格式：lastName-email-gender-department.id--%>
        <%--例如：GG-gg@163.com-0-105--%>
        Employee:<input type="text" name="employee"/>
        <input type="submit" value="Submit" />
    </form>

    <br><br>
    <form:form action="/emp" method="post" modelAttribute="employee">
        <c:if test="${employee.id == null}">
            LastName:<form:input path="lastName" />
            <form:errors path="lastName"></form:errors>
        </c:if>
        <c:if test="${employee.id != null}">
            <input type="hidden" name="_method" value="PUT"/>
            <form:hidden path="id" />
        </c:if>
        <br>
        Email:<form:input path="email" />
        <form:errors path="email"></form:errors>
        <br>
        <%
            Map<String,String> genders = new HashMap<String, String>();
            genders.put("1","Male");
            genders.put("0","Female");
            request.setAttribute("genders",genders);
        %>
        Gender:<form:radiobuttons path="gender" items="${genders}" />
        <br>
        Department:<form:select path="department.id"
                                items="${departments}" itemLabel="departmentName"
                                itemValue="id" />
        <br>
        Birth:<form:input path="birth" />
        <form:errors path="birth"></form:errors>
        <br>
        Salary:<form:input path="salary" />
        <br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
