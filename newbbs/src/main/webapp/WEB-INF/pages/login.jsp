<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/21
  Time: 上午1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="loginResult" method="post" modelAttribute="user">
    用户名<input type="text" name="userName">
    密码<input type="password" name="userPassword">
    <input type="submit">
</form:form>
</body>
</html>
