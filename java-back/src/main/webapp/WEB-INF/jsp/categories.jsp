<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Article Categories">
    <meta name="author" content="Suvan">
    <title>Categories</title>

    <!--CSS-->
    <link href="${basePath}css/categories.css" rel="stylesheet">

    <!-- JavaScript -->
    <script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>            <!--jQuery-->

</head>
<body>
    <div class="header">
        <img src="${basePath}img/head.png" class="he-img">
    </div>
    <div class="container">
        <main class="main">
            <h1 class="ma-category">${category}</h1>
            <ul class="ma-article-ul">
                <!--循环年份-->
                <c:forEach items="${yearMap}" var="map">
                    <div id="year${map.key}">
                        <h3>${map.key}</h3>

                        <!--循环文章列表-->
                        <c:forEach items="${map.value}" var="article">
                            <li class="li-article">
                                <b>★</b>
                                <span class="li-ar-time"><fmt:formatDate value='${article.publictime}' pattern='MM-dd hh:mm:ss'/></span>
                                <a href="${basePath}toArticle/${article.id}" title="${article.title}" class="li-ar-title">${article.title}</a>
                            </li>

                        </c:forEach>
                    </div>
                </c:forEach>
            </ul>
        </main>
    </div>
</body>
</html>
