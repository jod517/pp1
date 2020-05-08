<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 23.04.2020
  Time: 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style type="text/css">
    body {
        background: #080; /* Цвет фона */
        color: #fff; /* Цвет текста */
    }
</style>
<head>
    <title>Title</title>
</head>
<body>
<form action="/preproject1_war_exploded/">
    <input type="submit" value="Start page" />
</form>
    <form method="POST" action="/preproject1_war_exploded/create">


        <input type="text" name="name"/>
        <input type="text" name="login"/>
        <input type="password" name="password"/>

        <input type="submit" value="Добавить пользователя" >
    </form>



</div>
</body>
</html>
