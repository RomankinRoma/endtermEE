<%@ page import="kz.iitu.endtermEE.dao.UserDao" %>
<%@ page import="kz.iitu.endtermEE.model.User" %>
<%@ page import="kz.iitu.endtermEE.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 26.04.2021
  Time: 3:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <%
        Post post = (Post) request.getAttribute("post");
    %>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center"><%=post.getHead()%></h1>
<h3 align="center"><%=post.getInfo()%></h3>
<%
    UserDao userDao=new UserDao();
    if (session.getAttribute("username")!=null){
        User user=userDao.getByUsername(String.valueOf(session.getAttribute("username")));
        if (post.getUser_id()==user.getId()){
        session.setAttribute("post",post);%>
<button>Edit</button>
<a href="/delete/post">Delete</a>
<%}%>
<%}%>
</body>
</html>
