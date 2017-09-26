<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="注册">
    <meta name="author" content="Suvan">
    <title>Register</title>

    <!--CSS-->
    <link href="${basePath}/css/register.css" rel="stylesheet">

    <!--JavaScript -->
    <script src="${basePath}/js/register.js"></script>
    <script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script> <!-- jQuery -->


</head>
<body onload="loadHTML()">
    <div class="container">
        <div class="header">
            <h1>欢迎注册</h1>
        </div>
        <div class="main">
            <form id="registerForm" action="${basePath}/register/registerUser" method="post">
                    <div class="ma-form-tab">
                        <label>用户</label>
                        <input type="text" id="username" name="username">
                        <span id="checkUsername"></span>
                    </div>
                    <div class="ma-form-tab">
                        <label>密码</label>
                        <input type="password" id="password" name="password"><%--<i>✓</i>--%>
                        <span id="checkPassword"></span>
                    </div>
                    <div class="ma-form-tab">
                        <label>确认密码</label>
                        <input type="password" id="confirmpassword">
                        <span id="checkConfirmpassword"></span>
                    </div>
                    <div class="ma-form-tab">
                        <label>邮箱</label>
                        <input type="text" id="email" name="email">
                        <span id="checkEmail"></span>
                    </div>
                    <div class="ma-form-tab">
                        <label>
                            <button type="button" class="tab-authcodeButton" id="authcodeButton">点击获取邮箱验证码</button>
                        </label>
                        <input type="text" id="authcode">
                        <span id="checkAuthcode"></span>
                    </div>
                    <div class="ma-form-tab">
                        <div class="tab-buttonlist">
                            <button type="button" class="tab-but-submit" id="submitButton">提交</button>
                            <button type="button" class="tab-but-reset" id="resetButton">重置</button>
                        </div>
                    </div>
            </form>
        </div>
        <div class="footer">
            <span class="fo-describe">
               &copy;Suvan
            </span>
        </div>
    </body>
</html>
