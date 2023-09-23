<%@ page import="Model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 9/22/2023
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    User isLoggedIn = (User) request.getSession().getAttribute("isLoggedIn");
    if (isLoggedIn != null)
        response.sendRedirect("Profile.jsp");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<style>
    .error {
        background: red;
        color: white;
        font-weight: bold;
    }
</style>
<h1>welocme!</h1>
<%
    Object errorMsg = request.getSession().getAttribute("error");
    if (errorMsg != null) {
%>
<h3 class="error"><%=errorMsg%></h3>
<%}%>

<form action="login" method="post">
    <label>
        username:
        <input type="text" name="username">
    </label>
    <label>
        password:
        <input type="password" name="password">
    </label>
    <button type="submit">Login</button>
</form>

<a href="index.jsp">goto home</a>

</body>
</html>
