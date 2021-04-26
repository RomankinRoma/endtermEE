<%@ page import="kz.iitu.endtermEE.model.User" %>
<%@ page import="kz.iitu.endtermEE.dao.PostDao" %><%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 26.04.2021
  Time: 7:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<style>
    .grid-container {
        display: grid;
        grid-template-columns: auto auto;
        padding: 10px;
        text-align: left;
        justify-content: center;
        align-items: center;
    }

    .grid-container > div {
        padding: 20px;
    }
</style>
<head>
    <title>Profile</title>
</head>
<body>
<% PostDao postDao=new PostDao();
    User user = (User) session.getAttribute("user");
    user.setPosts(postDao.getAllByUser(user.getId())); %>
<jsp:include page="Header.jsp"></jsp:include>
<h3>Id:<%=user.getId()%></h3>
<h3>Username:<%=user.getUsername()%></h3>
<div class="grid-container">
<%int i = 0;
    while (user.getPosts().size()>i) {
%>
<div><h1><%=user.getPosts().get(i).getHead()%>
</h1></div>
<div><a href="post/<%=user.getPosts().get(i).getId()%>">More</a></div>
<%
    i++;}
%>
</div>

</body>
</html>
