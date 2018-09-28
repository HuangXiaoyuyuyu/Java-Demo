<%--
  Created by IntelliJ IDEA.
  User: 25375
  Date: 2017/12/6
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/scripts/jquery-1.9.1.min.js" ></script>
    <script>
        $(function () {
//            alert("aaaa");
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            });
        })
    </script>
</head>
<body>
    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${empty requestScope.employees}">
        没有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="e" items="${requestScope.employees}">
                <tr>
                    <td>${e.id}</td>
                    <td>${e.lastName}</td>
                    <td>${e.email}</td>
                    <td>${e.gender == 0 ? 'Female' : 'Male'}</td>
                    <td>${e.department.departmentName}</td>
                    <td><a href="/emp/${e.id}">Edit</a></td>
                    <td><a class="delete" href="/emp/${e.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br><br>
    <a href="/emp">Add New Employee</a>
</body>
</html>
