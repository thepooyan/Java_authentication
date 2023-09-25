<%@ page import="Model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 9/21/2023
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("isLoggedIn");
    if (user == null) response.sendRedirect("login.jsp");
%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>welcome to your profile!</h1>
    <h3>hello <%=user.getName()%></h3>
    <a href="index.jsp">goto home</a>
</body>
</html>
