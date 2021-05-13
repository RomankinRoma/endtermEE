<%@ page import="kz.iitu.endtermEE.dao.UserDao" %>
<%@ page import="kz.iitu.endtermEE.model.User" %>
<%@ page import="kz.iitu.endtermEE.model.Post" %>
<%@ page import="kz.iitu.endtermEE.model.Comment" %>
<%@ page import="java.util.List" %><%--
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
    <jsp:useBean id="userDao" class="kz.iitu.endtermEE.dao.UserDao"></jsp:useBean>
    <jsp:useBean id="postDao" class="kz.iitu.endtermEE.dao.PostDao"></jsp:useBean>
    <%
        Post post = (Post) request.getAttribute("post");
    %>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center"><%=post.getHead()%></h1>
<h3 align="center"><%=post.getInfo()%></h3>
<%
    if (session.getAttribute("username")!=null){
        User user=userDao.getByUsername(String.valueOf(session.getAttribute("username")));
        if (post.getUser_id()==user.getId()){
        session.setAttribute("post",post);%>
<a href="/EditPost.jsp"><button>Edit</button></a>
<a href="/delete/post">Delete</a>
<%}%>
<%}%>
<%List<Comment> comments = postDao.getAllByPost(post.getId());
int i = 0;
while (comments.size()>i){%>
    <div align="center">
        <h4><%=comments.get(i).getComment()%></h4>
        <h5 align="right"><%=comments.get(i).getUsername()%></h5>
    </div>
<%i++;}%>
<% session.setAttribute("head",post.getHead());%>
<% session.setAttribute("id",post.getId());%>
<a href="/CreateComment.jsp">Add Comment</a>
</body>
</html>
