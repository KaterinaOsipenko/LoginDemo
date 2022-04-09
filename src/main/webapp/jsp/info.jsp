<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InfoUser</title>
    <link rel="stylesheet" href="/css/main.css">
</head>
<style>
    <%@ include file="../css/main.css"%>
    <%@include file="../css/info.css"%>
</style>
<body>
<div class="wrapper">
    <h1>User Info</h1>
    <p><span>First name:</span> <%=session.getAttribute("firstname")%></p>
    <p><span>Last name:</span> <%=session.getAttribute("lastname")%></p>
    <p><span>Username:</span> <%=session.getAttribute("username")%></p>
    <p><span>Role:</span> <%= session.getAttribute("role")%></p>

<div class="logout">
    <a href="/Logout"><button id="btn">LogOut<img src="../sign-out-alt-solid.svg" alt="signOut"></button></a>
</div>
</div>
</body>
</html>
