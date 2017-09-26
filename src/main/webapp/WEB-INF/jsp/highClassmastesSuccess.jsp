<%--
  Created by IntelliJ IDEA.
  User: Liu-shuwei
  Date: 17.6.23
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <title>提交成功</title>
    <!-- css -->
    <link href="${basePath}frame/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table class="table">
    <h2>
         提交成功
    </h2>
    <tbody>
        <tr>
            <th scope="row">1</th>
            <td>姓名</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>手机</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>目前居住城市</td>
            <td>${user.city}</td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>通讯地址(单位或家庭)【选填】</td>
            <td>${user.area}</td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>邮编</td>
            <td>${user.postCode}</td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>参加同学(是/否)</td>
            <td>${user.join}</td>
        </tr>
        <tr>
            <th scope="row">7</th>
            <td>交通出行情况(自驾/大巴)</td>
            <td>${user.traffic}</td>
        </tr>
        <tr>
            <th scope="row">8</th>
            <td>赞助金额</td>
            <td>${user.money}</td>
        </tr>
        <tr>
            <th scope="row">9</th>
            <td>提交时间</td>
            <td><fmt:formatDate value='${user.publictime}' type='date' pattern='yyyy-MM-dd HH:mm:ss' /></td>
        </tr>
    </tbody>
</table>
</body>
</html>
