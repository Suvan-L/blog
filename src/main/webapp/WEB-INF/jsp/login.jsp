<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Blog Login">
        <meta name="author" content="Suvan">
        <title>Login</title>

        <!--CSS -->
        <link href="${basePath}/css/login.css" rel="stylesheet">

        <!-- JavaScript -->
        <script src="${basePath}/js/login.js"></script>

    </head>
    <body>
        <div class="container">
            <div class="header">
                <a href="${basePath}">
                    <img src="${basePath}/img/head.png" class="he-img">
                </a>
            </div>
            <div class="main">
                <div class="ma-form">
                    <form id="login-form"  action="login/loginCheck" method="post">
                        <input type="hidden" value="隐藏提交(test1)" name="test1"/>
                        <input type="hidden" value="隐藏提交(test2)" name="test2"/>

                        <div class="form-item">
                            <input type="text" class="form-input"   name="username" placeholder="请输入用户名..."/>
                        </div>
                        <div class="form-item">
                            <input type="password" class="form-input"  id="password" name="password" placeholder="请输入密码..."/>
                        </div>
                        <div class="form-item">
                                <label class="form-automaticLogin">
                                    <input type="checkbox" name="automaticLogin">7天自动登录
                                </label>
                        </div>
                        <div class="form-item">
                            <button type="submit" class="form-loginButton">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
