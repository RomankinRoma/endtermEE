<%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 25.04.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<form action="login" method="post">
        <h2 align="center">Login Page</h2>
        <hr>
        <table align="center">
            <tr><td>Username</td><td><input type="text" name="username"/></td>
            <tr><td>Password</td><td><input type="password" name="password"/></td></tr>

            <tr><td></td><td><input type="submit" value="Log in"/></td></tr>
        </table>
</form>
</body>
</html>
