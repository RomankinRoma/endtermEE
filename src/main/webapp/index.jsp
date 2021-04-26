<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<head>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center"><%= "Home Page" %>
</h1>
<hr>
<div align="center">
    <%if (session.getAttribute("username")==null){%>
    <a href="Register.jsp">
        <button class="btn btn-success" type="button">Register</button>
    </a>
    <a href="Login.jsp">
        <button class="btn btn-success" type="button">Login</button>
    </a>
    <%}%>

    <a href="Posts.jsp">
        <button class="btn btn-success" type="button">Posts</button>
    </a>
</div>
</body>
<jsp:include page="Footer.jsp"></jsp:include>
</html>
