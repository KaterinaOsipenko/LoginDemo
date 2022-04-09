<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<style>
    <%@ include file="../css/main.css"%>
    <%@include file="../css/home.css"%>
</style>
<body>
<a href="/Home">
    <div class="home-header">
        <div class="home-ref">
            <a href="#">home</a>
            <a href="${pageContext.request.contextPath}/login">LogIn</a>
            <a href="${pageContext.request.contextPath}/signin">SignIn</a>
            <a href="${pageContext.request.contextPath}/logout">LogOut</a>
        </div>
    </div>
</a>
</body>
</html>