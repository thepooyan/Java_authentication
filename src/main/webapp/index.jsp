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
    <%
        if (user != null) {
    %>
        <a href="profile.jsp">profile</a>
        <a href="logout">logout</a>
    <%} else {%>
        <a href="login.jsp">login</a>
        <a href="signup.jsp">signup</a>
    <%}%>
</body>
</html>