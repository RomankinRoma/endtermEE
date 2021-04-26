<%--
  Created by IntelliJ IDEA.
  User: Rakhmatulla
  Date: 25.04.2021
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<head>
    <title>Post</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form  name="form" action="post/" method="post" onsubmit="return validate()">
        <div style="width: 50%" class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="head">Head</span>
            </div>
            <input type="text"  name="head" class="form-control" aria-label="Default" aria-describedby="head">
        </div>
        <div style="width: 50%" class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="info">Info</span>
            </div>
            <input type="text" name="info" class="form-control" aria-label="Default" aria-describedby="info">
        </div>
    <input name="username" type="text" hidden value="<%=session.getAttribute("username")%>">


            <%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%>
            <button type="submit" class="btn btn-success">Create</button>
</form>
</body>
</html>
