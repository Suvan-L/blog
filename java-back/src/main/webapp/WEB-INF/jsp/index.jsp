<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%--格式化标签库--%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--响应式,移动设备兼容-->
      <meta name="description" content="Suvan Blog">
      <meta name="author" content="Suvan">
      <title>Index</title>

      <!-- CSS-->
      <link href="css/index.css" rel="stylesheet">                              <!-- 页面CSS设计-->

      <!--JavaScript-->
      <script src="${basePath}js/index.js"></script>                       <!-- 页面js -->
      <script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>            <!--jQuery-->
      <script src="${basePath}frame/jQuery/jquery.animate-colors.js"></script>    <!--jQuery颜色动画-->


  </head>
  <body onload="loadHTML()">
      <div class="animationScope">
          <img src="${basePath}img/head.png" class="an-img">
          <div class="ballOne"></div>
          <div class="ballSecond"></div>
          <div class="ballThird"></div>
      </div>
      <div class="header">
          <div class="he-navigation">
              <span class="he-nav-sign">Suvan</span>
              <%--<a href="highclassmastes" class="header-navigation-button">【职中】同学会统计</a>--%>
              <%--<a href="classmastes" class="header-navigation-button">【初中】同学会统计</a>--%>
              <c:choose>
                  <c:when test="${sessionScope.loginState}">
                      <a href="logout">注销</a>
                      <a href="toArchiving">归档页</a>
                      <a href="toBackstage">后台系统</a>
                  </c:when>
                  <c:otherwise>
                      <a href="register">注册</a>
                      <a href="login">登录</a>
                  </c:otherwise>
              </c:choose>
          </div>
      </div>
      <div class="main">
          <div class="ma-user">
              <img src="${basePath}img/head.png" class="u-img">
          </div>
            <div class="ma-articles">
                <c:forEach items="${articleList}" var="article">
                    <div class="article">
                        <div class="a-title"><a href="${basePath}toArticle/${article.id}">${article.title}</a></div>
                        <div class="a-meta">
                            <fmt:formatDate value='${article.publictime}' type='date' pattern='yyyy-MM-dd'/>
                        </div>
                        <div class="a-content">${article.content}</div>
                        <div class="a-readButton"><a href="${basePath}toArticle/${article.id}">阅读全文 »</a></div>
                    </div>
                </c:forEach>
            </div>
      </div>
      <div class="footer">
          <div class="fo-statement">
              <span>© 2017</span>
              <span>|  高调做事,低调做人</span>
              <span>|  liushuwei0925@gmail.com</span>
          </div>
      </div>
  </body>
</html>