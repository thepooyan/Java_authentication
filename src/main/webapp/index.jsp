<%@ page import="Model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
   User user = (User) request.getSession().getAttribute("isLoggedIn");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <a href="login.jsp">login</a>
    <%
        if (user != null) {
    %>
    <a href="Profile.jsp">profile</a>
    <%}%>
</body>
</html>