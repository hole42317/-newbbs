<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/21
  Time: 上午2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(session.getAttribute("user")!=null){
%>
<script>
    alert("登陆成功");
    window.location="index";
</script>
<%
    }
    else {
%>

<script>
    alert("登录失败");
    window.location = "login";
</script>
<%
    }
%>
</body>
</html>
