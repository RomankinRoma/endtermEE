<%@ page import="kz.iitu.endtermEE.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 26.04.2021
  Time: 7:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%
Post post = (Post) session.getAttribute("post");
%>
<jsp:include page="Header.jsp"></jsp:include>
<form  name="form" action="/delete/" method="post" onsubmit="return validate()">
    <div style="width: 50%" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="id">ID</span>
        </div>
        <input type="int"  name="id" class="form-control" value="<%=post.getId()%>" aria-label="Default" aria-describedby="id">
    </div>
    <div style="width: 50%" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="head">Head</span>
        </div>
        <input type="text"  name="head" class="form-control" value="<%=post.getHead()%>" aria-label="Default" aria-describedby="head">
    </div>
    <div style="width: 50%" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="info">Info</span>
        </div>
        <input type="text" name="info" value="<%=post.getInfo()%>" class="form-control" aria-label="Default" aria-describedby="info">
    </div>
    <input name="username" type="text" hidden value="<%=session.getAttribute("username")%>">


    <%=(request.getAttribute("errMessage") == null) ? ""
            : request.getAttribute("errMessage")%>
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>
