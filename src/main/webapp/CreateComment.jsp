<%@ page import="kz.iitu.endtermEE.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 26.04.2021
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:useBean id="user" class="kz.iitu.endtermEE.model.User"></jsp:useBean>
<%user=(User) session.getAttribute("user"); %>
<form  name="form" action="comment" method="post" onsubmit="return validate()">
  <div style="width: 50%" class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" id="head">Head</span>
    </div>
    <input type="text"  name="head" class="form-control" value="<%=session.getAttribute("head")%>" disabled aria-label="Default" aria-describedby="head">

  </div>
  <div style="width: 50%" class="input-group mb-3">
    <div class="input-group-prepend">
      <span class="input-group-text" id="text">text</span>
    </div>
    <input type="text" name="comment" class="form-control" aria-label="Default" aria-describedby="info">
  </div>
  <input name="username" type="text" hidden value="<%=user.getUsername()%>">
  <input name="id" type="number" hidden value="<%=session.getAttribute("id")%>">


  <%=(request.getAttribute("errMessage") == null) ? ""
          : request.getAttribute("errMessage")%>
  <button type="submit" class="btn btn-success">Create</button>
</form>
</body>
</html>
