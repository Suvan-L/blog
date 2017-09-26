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
        <source src="${basePath}/music/highStudent.mp3" type="audio/mp3" />
        <embed height="0" width="0" src="${basePath}/music/highStudent.mp3" />
    </audio>

    <div class="container-fluid">
        <main class="main">
                    <div class="ma-top">
                        <span>大埔县湖寮高级职业中学30周年(1987 ~ 2017) 联谊活动登记表</span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="musicButton" class="glyphicon glyphicon-music musicButton" aria-hidden="true"></span>
                    </div>
                   <div class="main-content">
                       <div class="row">
                           <div class="ma-left col-md-5 col-md-offset-2 col-xs-12">
                               <div class="ma-le-introduction">
                                   各位同学：<br>
                                   &nbsp;&nbsp;为完善同学们的通讯信息,
                                   及安排三十周年同学联谊活动,
                                   请大家认真填写登记表,谢谢合作!<br>
                                   【注:要求填写通讯地址主要是为了方便给同学们快递物件(可选填)】
                               </div>
                           </div>
                           <div class="ma-right col-md-5 col-sm-6 col-xs-12">
                                   <form id="classMastesForm" class="" method="POST" action="${basePath}toHighClassmatesSucess"  role="search" onsubmit="return checkAll()">
                                       <table class="table">
                                           <h2>活动登记表</h2>
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
                                               <td>通讯地址(单位或家庭)【选填】</td>
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
                                               <td><span class="star">*</span>参加同学聚会(是/否)</td>
                                               <td>
                                                   <input id="join" name="join" type="text" class="form-control" placeholder="">
                                                   <span id="checkJoin" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>交通出行情况(自驾/大巴/拼车)</td>
                                               <td>
                                                   <input id="traffic" name="traffic" type="text" class="form-control" placeholder="">
                                                   <span id="checkTraffic" class="checkFont"></span>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td><span class="star">*</span>赞助金额(元)</td>
                                               <td>
                                                   <input id="money" name="money" type="text" class="form-control" placeholder="">
                                                   <span id="checkMoney" class="checkFont"></span>
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
<script script src="${basePath}js/highclassmastes.js"></script>
<%--<script src="${basePath}frame/jQuery/jQuery-1.12.4.js"></script>--%>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>                      <!--CDN 加速服务-->
<script src="frame/jQuery/jquery.animate-colors.js"></script>    <!--jQuery颜色动画-->
<%--<script src="https://cdn.jsdelivr.net/jquery.color-animation/1.6.0/jquery.animate-colors-min.js"></script>    <!--CDN 加速服务-->--%>
</html>
