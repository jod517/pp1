<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 23.04.2020
  Time: 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="/create">


        <label for="name">User name
            <input class="input-field" type="text" required="required" id="name" name="name">
        </label>
        <label for="login">Login
            <input class="input-field" type="text" required="required" id="login" name="login">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" required="required" id="password" name="password">
        </label>
        <input type="submit" value="Create New User">
    </form>



</div>
</body>
</html>
