<%--
  Created by IntelliJ IDEA.
  User: 25375
  Date: 2017/12/6
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="scripts/jquery-1.9.1.min.js"></script>
    <script>
       $(function () {
           $("#testJson").click(function () {
               var url = this.href;
               var args = {};
               $.post(url,args,function (data) {
                   for(var i=0; i<data.length; i++) {
                      var id = data[i].id;
                      var laseName = data[i].lastName;

                      alert(id+":"+laseName);
                   }
               })
               return false;
           })
       })
    </script>
  </head>
  <body>
  <form action="testFileUpLoad" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file" />
    Desc:<input type="text" name="desc" />
    <input type="submit" value="Submit" />
  </form>
  <br><br>

  <a href="/emps">List All Employees</a>
  <br><br>

  <a href="testJson" id="testJson">Test Json</a>
  <br><br>

  <form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File:<input type="file" name="file"/>
    Desc:<input type="text" name="desc" />
    <input type="submit" value="Submit"/>
  </form>
  <br><br>

  <a href="testResponseEntity">Test ResponseEntity</a>
  <br><br>
  <br><br>
  <a href="i18n">I18N Page</a>

  <br><br>
  <a href="testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>

  <br><br>
  <a href="testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
  </body>
</html>
