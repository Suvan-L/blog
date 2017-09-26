<%--
  Created by IntelliJ IDEA.
  User: Liu-shuwei
  Date: 17.7.9
  Time: 23:06
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
        <title>错误页面</title>


        <%
            String beforeUrl = request.getHeader("Referer");                      //前页面完整URL【EL写法:${pageContext.request.getHeader("Referer")};】
            String beforePage = beforeUrl.substring(beforeUrl.lastIndexOf("/")+1);//前页面名称
         %>

        <!-- CSS-->
        <style>
            .message{
                margin: 300px auto;

                font-size: 30px;
                letter-spacing: 2px;
                text-align: center;
            }
        </style>

        <!--JavaScript-->
        <script>

            /*倒数计时器*/
            var time = ${time};
            setTimeout('timer()',1000);
            function timer(){
                if(time == 1){
                    window.location.href="<%=beforeUrl%>";  //跳回前页面
                }

                time = time - 1;

                document.getElementById('timeSpan').innerHTML = time;

                setTimeout('timer()',1000)
            }
        </script>

    </head>
    <body>
            <div class="message">
                ${warnMessage}<br>
                <span id="timeSpan">${time}</span>后返回前置页面......
            </div>
    </body>
</html>
