<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <meta name="description" content="Blog Archiving">
    <meta name="author" content="Suvan">
    <title>Archiving</title>


    <!--CSS-->
    <link href="${basePath}css/archiving.css" rel="stylesheet">
    <link href="${basePath}frame/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"> <!--Bootstrap-->

    <!--js-->
    <script src="${basePath}js/archiving.js"></script>
    <script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>            <!--jQuery-->


</head>
<body onload="loadHTML()">
   <div class="container">
       <div class="main">

           <div class="row">
               <div class="col-md-1 col-md-push-11 col-sm-push-5 col-xs-push-4">
                   <img src="${basePath}img/head.png" class="ma-img">
               </div>
               <div class="col-md-3 col-sm-12 col-xs-12">

                   <div class="ma-leftBox">
                       <div class="ma-leftBox-title">文章分类</div>
                       <div class="ma-leftBox-content">
                           <c:forEach items="${categoriesSet}" var="category">
                               <a href="${basePath}/categories/${category}">${category}</a>
                           </c:forEach>
                       </div>
                   </div>
                   <div class="ma-leftBox hidden-xs"><!--xs屏幕隐藏-->
                       <div class=ma-leftBox-title">网站标签</div>
                       <div class="ma-leftBox-content" id="webTab">
                           <a>个人建站</a>
                           <a>Suvan</a>
                           <a>爬虫</a>
                           <a>liushuwei@gmail.com</a>
                           <a>Google</a>
                           <a>维护网站</a>
                           <a>找工作</a>
                           <a>Github Daily</a>
                       </div>
                   </div>
               </div>

               <div class="col-md-8 col-md-push-1 col-sm-12 col-xs-12">
                   <h1 class="h1">Article</h1>

                   <!-- 文章列表遍历-->
                   <ul class="ma-right-articleList" id="articleList">
                       <%--页循环--%>
                       <c:forEach var="page" begin="1" end="${totalPages}">
                           <div id="pageIndex${page}">
                               <%--文章循环--%>
                               <c:forEach items="${articleList}" var="article" begin="${(page-1)*pageArticles}" end="${(page-1)*pageArticles+(pageArticles-1)}">
                                   <li>
                                       <span><fmt:formatDate value='${article.publictime}' type='date' pattern='yyyy-MM-dd'/></span>
                                       <a href="${basePath}article/toArticle/${article.id}" title="${article.title}">${article.title}</a>
                                   </li>
                               </c:forEach>
                           </div>
                       </c:forEach>
                   </ul>

                   <!--页数-->
                   <div class="ma-page" id="Paging">
                       <ul class="pagination pagination-lg">
                           <c:forEach  var="page" begin="1" end="${totalPages}">
                               <li><a>${page}</a></li>
                           </c:forEach>
                       </ul>
                   </div>
               </div>
           </div>
       </div>
   </div>

   <div class="footer">
       <p class="fo-statement">
           Copyright © 2017 Suvan. All rights reserved.
           &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
           liushuwei0925@gmail.com
       </p>
   </div>
</body>
</html>