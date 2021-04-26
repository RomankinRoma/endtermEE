<%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 25.04.2021
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/Posts.jsp">PostIn</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/index.jsp">Home <span class="sr-only"></span></a>
            </li>
           <%if (session.getAttribute("username")==null){%> <li class="nav-item">
                <a class="nav-link" href="/Login.jsp">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="/Register.jsp">Register</a>
            </li>
               <%}%>
            <%if (session.getAttribute("username")!=null){%>
            <li class="nav-item">
            <li class="nav-item">
                <a class="nav-link " href="/Profile.jsp">Profile</a>
            </li>
                <form action="Logout" method="post">
                    <input class="nav-link" style="border:none" type="submit" value="Log out"/>
                </form>
            </li>
               <%}%>
        </ul>

    </div>
</nav>
</html>
