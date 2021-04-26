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
    <title>Register</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<h2 align="center">Register Page</h2>
<hr>

<form name="form" action="register" method="post" onsubmit="return validate()">
    <table align="center">
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="conpassword" /></td>
        </tr>
        <tr>
            <td><%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Register"></td>
        </tr>
    </table>
</form>
</body>
</html>
