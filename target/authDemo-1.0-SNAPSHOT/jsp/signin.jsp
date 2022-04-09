
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SignIn</title>
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
                <p>Already have an account?</p>
                <button value="Log In"><a href="${pageContext.request.contextPath}/login">Log In</a></button>
                </div>
            </div>
            <div class="form-half-page">
                <p>Create Account</p>
                <form action="${pageContext.request.contextPath}/Signin" method="post">
                    <div class="wrapper-form">
                            <input type="text" name="firstname" placeholder="firstname" required>
                    </div>
                    <div class="wrapper-form">
                            <input type="text" name="lastname" placeholder="lastname" required>
                    </div>
                    <div class="wrapper-form">
                            <input type="text" name="username" placeholder="username" required>
                        <img src="../user-pen-solid.svg" alt="">
                    </div>
                    <div class="wrapper-form">
                            <input type="password" name="password" placeholder="password" required>
                        <img src="../key-solid.svg" alt="">
                    </div>
                    <div class="wrapper-form">
                            <select name="role" required>
                                <option value="admin">admin</option>
                                <option value="user">user</option>
                            </select>
                    </div>
                    <input type="submit" value="Send" id="btn">
                </form>
            </div>
        </div>
    </body>
</html>
