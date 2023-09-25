<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 9/23/2023
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>

<h1>signup</h1>
<%
    Object errorMsg = request.getSession().getAttribute("error");
    if (errorMsg != null) {
%>
<h3 class="error"><%=errorMsg%></h3>
<%}%>

<form action="signup" method="post">
    <label>
        name:
        <input type="text" name="name">
    </label>
    <label>
        last name:
        <input type="text" name="lastName">
    </label>
    <label>
        username:
        <input type="text" name="username">
    </label>
    <label>
        password:
        <input type="password" name="password">
    </label>
    <button type="submit">signup!</button>
</form>
</body>
</html>
