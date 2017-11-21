<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/21
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>announce</title>
</head>
<body>
<h2>主题帖:${announce.topic}</h2>
<p>主楼:${announce.userName}+${announce.announcesBody}</p>
<c:forEach items="${reply}" var="reply">
    <p>用户名:${reply.userName}+${reply.replyBody}</p>

</c:forEach>

<form:form action="sendReply" method="post">
    <input type="text" name="replyBody">
    <input type="hidden" name="Aid" value="${announce.aid}">
    <input type="submit">
</form:form>
</body>
</html>
