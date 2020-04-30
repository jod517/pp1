<%--
  Created by IntelliJ IDEA.
  User: Лев Лосев
  Date: 18.04.2020
  Time: 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>preproject</title>
    <style>
      body {
        background: #080; /* Цвет фона */
        color: #fff; /* Цвет текста */
      }
    </style>
  </head>
  <body>
  <h1>Start page</h1>
  <form action="/preproject1_war_exploded/read">
      <input type="submit" value="Show all users" />
  </form>


  <form action="/preproject1_war_exploded/create">
    <input type="submit" value="Create the New User" />
  </form>
  </body>
</html>
