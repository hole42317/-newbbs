<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forem" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lui.db.announces.AnnouncesEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    if(session.getAttribute("user")!=null){
        out.print("用户: "+session.getAttribute("user")+" "+"<a href=\"logoff\">注销</a>");
    }
    else {
        out.print("<a href=\"login\">登录</a>");
    }
%>

<c:forEach items="${announces}" var="item">
    <a href="announce/${item.aid}">${item.topic}</a>
</c:forEach>
<br>
<forem:form action="sendAnnocune" method="post">
    主题<input type="text" name="topic"><br>
    内容<input type="text" name="announceBody">
    <input type="submit">
</forem:form>
</body>
</html>
