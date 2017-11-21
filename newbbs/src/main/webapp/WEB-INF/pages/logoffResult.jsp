<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/21
  Time: 下午4:06
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
        out.print(session.getAttribute("user"));
    }else {
        out.print("0");
    }



%>
</body>
</html>
