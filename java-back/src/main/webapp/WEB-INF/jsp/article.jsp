<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <meta name="description" content="Blog Article">
    <meta name="author" content="Suvan">
    <title>Article</title>

    <!--CSS-->
    <link href="${basePath}css/article.css" rel="stylesheet" type="text/css">
    <link href="${basePath}extend/icon/iconfont.css" rel="stylesheet" type="text/css" >  <!--阿里巴巴矢量icon图标-->

    <!--js -->
    <script src="${basePath}js/article.js"></script>
    <script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>            <!--jQuery-->
    <script src="${basePath}frame/jQuery/jquery.animate-colors.js"></script>    <!--jQuery颜色动画-->
    <%--<script src="${basePath}js/marked.js"></script>                             <!--Markdown解析器-->--%>

</head>
<body onload="loadHTML()">
    <div class="header">
        <div class="he-inner">
            <span class="he-in-sign">Suvan</span>
            <div class="he-in-button">
                <a href="../index">首页</a>
                <a href="../toArchiving">归档</a>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="ma-article">
            <div class="ma-ar-title">${article.title}</div>
            <div class="ma-ar-meta"> 发表于 2017-09-03 |  分类于 Life  字数统计 40 |  阅读时长 1</div>
            <div class="ma-ar-content">${article.content}</div>
        </div>
        <div class="ma-comment">
            <div class="ma-co-input">
                <textarea class="inputComment-textarea" maxlength="300" placeholder="请输入评论...."></textarea>

                <button class="ma-co-publishButton" id="pulishCommentButton">发表</button>
            </div>
            <div class="ma-co-message">
                    <div class="message">
                        <img src="${basePath}img/head.png" class="message-userimg">
                        <div class="me-content">
                            <span class="me-username" id="user${comment.userId}">user${comment.userId}:</span>
                            &emsp;这篇文章挺好看的
                        </div>
                        <div class="me-publictime">
                            2016/09/25 23:54:32
                        </div>
                        <div class="me-operate" id="operate${comment.id}">
                            <i class="icon iconfont icon-dianzandian" type="agree" ></i><span>2849</span>&emsp;
                            <i class="icon iconfont icon-handagainst" type="oppose"></i><span>2000</span>
                         </div>
                    </div>
                <div class="message">
                        <img src="${basePath}img/head.png" class="message-userimg">
                        <div class="me-content">
                            <span class="me-username" id="user${comment.userId}">user${comment.userId}:</span>
                            &emsp;这篇文章挺好看的12312312313212312312312312312312
                        </div>
                        <div class="me-publictime">
                            2016/09/25 23:54:44
                        </div>
                    <div class="me-operate" id="operate${comment.id}">
                        <i class="icon iconfont icon-dianzandian" type="agree" ></i><span>31</span>&emsp;
                        <i class="icon iconfont icon-handagainst" type="oppose"></i><span>8889</span>
                    </div>
                    </div>
            </div>
             <div class="ma-co-message">
                <c:forEach items="${commentList}" var="comment">
                    <div class="message">
                        <img src="${basePath}img/head.png" class="message-userimg">
                        <div class="me-content">
                            <span class="me-username" id="user${comment.userId}">游客${comment.userId}:</span>
                            &emsp;${comment.content}
                        </div>
                        <div class="me-publictime">
                            <fmt:formatDate value='${comment.publictime}' type='data' pattern="yyyy/MM/dd hh:mm:ss" />
                        </div>
                        <div class="me-operate" id="operate${comment.id}">
                            <i class="icon iconfont icon-dianzandian"></i><span>2000</span>&emsp;
                            <i class="icon iconfont icon-handagainst"></i><span>2000</span>&emsp;
                         </div>
                    </div>
                 </c:forEach>
            </div>
                <%--<c:forEach items="${commentList}" var="comment">--%>
                    <%--<img src="${basePath}/img/head.png" class="message-userimg">--%>
                    <%--<div class="message">--%>
                        <%--<img src="${basePath}img/header.png" class="message-userimg">--%>
                        <%--<div class="message-right">--%>
                            <%--<div class="me-ri-content">--%>
                                <%--<span class="me-ri-username" id="user${comment.userId}">user${comment.userId}:</span>--%>
                                <%--&emsp;${comment.content}--%>
                            <%--</div>--%>
                            <%--<div class="me-ri-publictime">--%>
                                <%--<fmt:formatDate value='${comment.publictime}' type='date' pattern='yyyy年MM月dd日 HH:mm'/>--%>
                            <%--</div>--%>
                            <%--<div class="me-ri-operate" id="operate${comment.id}">--%>
                                <%--<i class="icon iconfont icon-dianzandian"></i><span class="agree-insert1">+1</span><span class="comment-agree">${comment.agree}</span>&emsp;--%>
                                <%--<i class="icon iconfont icon-handagainst"></i><span class="oppose-insert1">+1</span><span class="comment-oppose">${comment.oppose}</span>&emsp;--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</c:forEach>--%>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="fo-statement">
            © 2017  liushuwei
            高调做事,低调做人
        </div>
    </div>
    <div class="skidding">

    </div>

</body>
</html>