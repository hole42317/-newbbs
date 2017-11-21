<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/21
  Time: 上午2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert("错误");
</script>
<%--<jsp:forward page="login.jsp"></jsp:forward>--%>
<c:redirect url="login"/>
</body>
</html>
