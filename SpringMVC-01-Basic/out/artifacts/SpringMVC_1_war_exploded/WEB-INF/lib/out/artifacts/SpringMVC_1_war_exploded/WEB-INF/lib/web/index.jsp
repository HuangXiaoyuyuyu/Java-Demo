<%--
  Created by IntelliJ IDEA.
  User: 25375
  Date: 2017/12/1
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/springmvc/testViewAndViewResolver">testViewAndViewResolver</a>
  <br><br>

  <form action="/springmvc/testModelAttribute">
      <input type="hidden" name="id" value="1"/>
    username:<input type="text" name="username" value="Tom"/><br>
    email:   <input type="email" name="email" value="253757635@qq.com"/><br>
    age:     <input type="text" name="age" value="15"/><br>
    <input type="submit" value="submit" />
  </form>
  <br><br>

  <a href="/springmvc/testSessionAttributes">testSessionAttributes</a>
  <br><br>

  <a href="/springmvc/testMap">testMap</a>
  <br><br>

  <a href="/springmvc/ModelAndView">testModelAndView</a>
  <br><br>

  <a href="/springmvc/testServletAPI Write">testServletAPI Write</a>
  <br><br>

  <a href="/springmvc/testServletAPI">testServletAPI</a>
  <br><br>

  <form action="/springmvc/testPOJO">
    username:<input type="text" name="username"/><br>
    password:<input type="password" name="password"/><br>
    email:   <input type="email" name="email" /><br>
    age:     <input type="text" name="age"/><br>
    province:<input type="text" name="address.province"/><br>
    city:    <input type="text" name="address.city"/><br>
    <input type="submit" value="testPOJO" />
  </form>
  <br><br>

  <a href="/springmvc/testCookieValue">testCookieValue</a>
  <br><br>

  <a href="/springmvc/testRequestParam?username=hxy">testRequestParam</a>
  <br><br>

  <form action="/springmvc/testRest Put/1" method="post">
    <input type="hidden" name="_method" value="PUT" />
    <input type="submit" value="testRest Put" />
  </form>
  <br><br>

  <form action="/springmvc/testRest Delete/1" method="post">
    <input type="hidden" name="_method" value="DELETE" />
    <input type="submit" value="testRest Delete" />
  </form>
  <br><br>

  <form action="/springmvc/testRest Post" method="post">
    <input type="submit" value="testRest Post" />
  </form>
  <br><br>

  <a href="/springmvc/testRest Get/1">testRest Get</a>
  <br><br>

  <a href="/springmvc/testPathVariable/1">testPathVariable</a>
  <br><br>

  <a href="/springmvc/aaa/testAntUrl">testAntUrl</a>
  <br><br>

  <a href="/springmvc/testParamsAndHeaders?username=hxy&age=10">testParamsAndHeaders</a>
  <br><br>

  <form action="/springmvc/testMethod" method="post">
    <input type="submit" value="sumit" />
  </form>
  <br><br>

  <a href="/springmvc/testMethod">testMethod</a>
  <br><br>

  <a href="/springmvc/testRequestMapping">testRequestMapping</a>
  <br><br>

  <a href="helloworld">HelloWorld</a>
  </body>
</html>
