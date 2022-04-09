<%--
  Created by IntelliJ IDEA.
  User: Дом
  Date: 06.04.2022
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<style>
    <%@ include file="../css/main.css"%>
    <%@include file="../css/signin.css"%>
</style>
<body>
<div class="wrapper" >
    <div class="welcome-half-page">
        <div class="welcome-class">
        <p>Welcome!</p>
        <button value="Go Home"><a href="${pageContext.request.contextPath}/home">Go Home</a></button>
        </div>
        <div class="secondPartWelcome-class">
        <p>Create Account</p>
        <button value="Sign In"><a href="${pageContext.request.contextPath}/signin">Sign In</a></button>
        </div>
    </div>
    <div class="form-half-page">
        <p>Log In</p>
        <form action="${pageContext.request.contextPath}/Login" method="post">
            <div class="wrapper-form">
                <input type="text" name="username" placeholder="username" required>
                <img src="../user-pen-solid.svg" alt="">
            </div>
            <div class="wrapper-form">
                <input type="password" name="password" placeholder="password" required>
                <img src="../key-solid.svg" alt="">
            </div>
            <input type="submit" value="Send" id="btn">
        </form>
    </div>
</div>

</body>
</html>
