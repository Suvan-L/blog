<%--
  Created by IntelliJ IDEA.
  User: Liu-shuwei
  Date: 17.6.28
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>股票统计</title>

    <!-- CSS-->
    <link href="" rel="stylesheet">
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <link href="${basePath}frame/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <!--JavaScript-->
    <script src=""></script>

</head>
<body>
    <main class="main">
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>列名</th>
                        <th>值</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${colName}" var="cn" varStatus="status"> <!--varStatus="status"定义遍历状态值-->
                        <tr>
                            <th scope="row">${status.index}</th>
                            <td>${cn}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    <footer class="footer"></footer>
</body>
</html>
