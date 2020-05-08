<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 08.05.2020
  Time: 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update?id=${col.id}" method="POST">

    <h2> User update page:</h2><br>
    <h4><a href="${pageContext.request.contextPath}/read">Go to read page </a></h4>
    <div class="form-group">
        <label for="userName">User name</label>
        <input placeholder="${col.name}" type="text" width=100px name="name" class="form-control" id="userName" aria-describedby="userNameHelp">
        <small id="userNameHelp" class="form-text text-muted">Enter user name</small>
    </div>


        <div class="form-group">
            <label for="userLogin">User login</label>
            <input placeholder="${col.login}" type="text"  width=100px name="login" class="form-control" id="userLogin" aria-describedby="userLoginHelp">
            <small id="userLoginHelp" class="form-text text-muted">Enter user login</small>
        </div>


    <div class="form-group">
        <label for="userPassword">User password</label>
        <input placeholder="${col.password}" type="password"  width=100px name="password" class="form-control" id="userPassword" aria-describedby="userPasswordHelp">
        <small id="userPasswordHelp" class="form-text text-muted">Enter user password</small>
    </div>

    <button type="submit" class="btn btn-primary">Update user</button>
</form>
</body>
</html>
