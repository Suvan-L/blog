<%--
  Created by IntelliJ IDEA.
  User: Liu-shuwei
  Date: 17.6.23
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <title>同学会信息登记</title>

    <!--CSS-->
    <link href="${basePath}css/classmates.css" rel="stylesheet">
    <%--<link href="${basePath}frame/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">  <!--CDN 加速服务-->

</head>
<body onload="loadHTML()">
    <!--音频播放-->
    <audio id="music" play="yes" autoplay>
        <source src="${basePath}/music/classmass_student.mp3" type="audio/mp3" />
        <embed height="0" width="0" src="${basePath}/music/classmass_student.mp3" />
    </audio>

    <div class="container-fluid">
        <main class="main">
                    <div class="ma-top">
                        <span>恭中85届32周年(1985 ~ 2017) 联谊活动登记表</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="musicButton" class="glyphicon glyphicon-music musicButton" aria-hidden="true"></span>
                    </div>
                   <div class="main-content">
                       <div class="row">
                           <div class="ma-left col-md-5 col-md-offset-2 col-xs-12">
                               <div class="ma-le-introduction">
                                   各位同学：<br>
                                   &nbsp;&nbsp;我们为完善恭中85届同学们的通讯信息,请同学们认真填写该信息登记表,
                                   详细地址可以是单位或者家庭,是为了稍后给每位同学快递"同学纪念册"用途,
                                   我们也将根据此份信息来寄送物件.请务必准确无误,谢谢合作!
                               </div>
                           </div>
                           <div class="ma-right col-md-5 col-sm-6 col-xs-12">
                                   <form id="classMastesForm" class="" method="POST" action="${basePath}toClassmatesSucess"  role="search" onsubmit="return checkAll()">
                                       <table class="table">
                                           <h2>信息登记</h2>
                                           <tbody>
                                           <tr>
                                               <td><span class="star">*</span>姓名</td>
                                               <td>
                                                   <input id="name" name="name" type="text" class="form-control" placeholder="">
                                                   <span id="checkName" class="checkFont"></span>
                                               </td>

                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>手机</td>
                                               <td>
                                                   <input id="phone" name="phone" type="text" class="form-control" placeholder="">
                                                   <span id="checkPhone" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>目前居住城市</td>
                                               <td>
                                                   <input id="city" name="city" type="text" class="form-control" placeholder="">
                                                   <span id="checkCity" class="checkFont" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>详细地址(单位或家庭)</td>
                                               <td>
                                                   <input id="area" name="area" type="text" class="form-control" placeholder="">
                                                   <span id="checkArea" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>邮编</td>
                                               <td>
                                                   <input id="postCode" name="postCode" type="text" class="form-control" placeholder="">
                                                   <span id="checkPostCode" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td></td>
                                               <td>
                                                   <button type="submit" class="btn btn-default">提交</button>
                                                   <button  id="reset" type="reset" class="btn btn-default">重置</button>
                                               </td>
                                           </tr>
                                           </tbody>
                                       </table>
                                   </form>
                           </div>
                       </div>
                   </div>
        </main>
    </div>
    <footer class="footer">
        <p class="statement">
            Copyright © 2017 Suvan. All rights reserved.
            &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
            liushuwei0925@gmail.com
        </p>
    </footer>
</body>

<!--js -->
<script script src="${basePath}js/classmastesuser.js"></script>
<%--<script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>--%>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>                      <!--CDN 加速服务-->
<script src="frame/jQuery/jquery.animate-colors.js"></script>    <!--jQuery颜色动画-->
<%--<script src="https://cdn.jsdelivr.net/jquery.color-animation/1.6.0/jquery.animate-colors-min.js"></script>    <!--CDN 加速服务-->--%>
</html>
