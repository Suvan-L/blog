<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <title>首页</title>
    <!-- CSS -->
    <link rel="stylesheet" href="${basePath}/frame/layui/css/layui.css">
    <link rel="stylesheet" href="${basePath}/css/backstage.css">

    <!-- JS -->
    <script src="${basePath}/frame/layui/layui.js"></script>
    <script src="${basePath}/js/backstage_layui.js"></script>
</head>
<body>
<!--layui布局容器-->
<div class="layui-layout layui-layout-admin">
    <!--************************************* 顶部[导航] ******************************************** -->
    <div class="layui-header">
        <div class="layui-main">

            <div class="top-left">
                <a href="#"><img src="${basePath}/img/head.png"></a>             <!-- 页面标志 -->
                <a href="javascript:;" class="hide-left-menu">
                    <i class="layui-icon" icon="left">&#xe603;</i>    <!-- 侧滑栏按钮【&#xe603;-向左，&#xe602;-向右】 -->
                </a>
            </div>

            <div class="top-middle">
                <ul class="layui-nav" lay-filter="top-menu">                  <!-- lay-filter-设置监听事件 -->
                    <li class="layui-nav-item layui-this"><a>博文</a></li>    <!-- layui-this-选中此项 -->
                    <li class="layui-nav-item"><a>数据分析</a></li>
                    <li class="layui-nav-item"><a>爬虫</a></li>
                    <li class="layui-nav-item"><a>直播录像</a></li>
                    <li class="layui-nav-item"><a>APP</a></li>
                </ul>
            </div>

            <div class="top-right">
                <ul class="layui-nav">
                    <li class="layui-nav-item"><a href="${basePath}">首页</a></li>
                    <li class="layui-nav-item">
                        <a href="#">
                            <img src="${basePath}/img/head.png">        <!-- 用户头像 -->
                            ${user.name}
                        </a>
                        <dl class="layui-nav-child">
                            <dd><a href="#">修改密码</a></dd>
                            <dd><a href="#">注销</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>

        </div>
    </div>

    <!--************************************* 左侧滑栏[导航] ******************************************** -->
    <div class="layui-side layui-bg-black left-menu-all">
        <div class="layui-side-scroll">
            <!--博客管理-->
            <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">
                <li class="layui-nav-item">
                    <a>用户</a>
                    <dl class="layui-nav-child">  <!--data-id="1" 是Tab选项卡的id -->
                        <dd><a href="javascript:;" data-url="" data-id="a_11">管理博文</a></dd>
                        <dd><a href="javascript:;" data-url="../html/register.html" data-id="a_12">注册</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-id="a_21">好友</a>
                </li>
            </ul>
            <!--数据分析-->
            <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-id="b_1">博客用户公共数据</a>
                </li>
            </ul>
            <!--爬虫-->
            <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">>
                <li class="layui-nav-item">
                    <a>影视大全</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="c_11">电影</a></dd>
                        <dd><a href="javascript:;" data-id="c_12">美剧</a></dd>
                    </dl>
                </li>
            </ul>
            <!--直播录像-->
            <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-id="d_1">个人直播</a>
                </li>
            </ul>
            <!--爬虫-->
            <ul class="layui-nav layui-nav-tree left-menu" lay-filter="left-menu">>
                <li class="layui-nav-item">
                    <a>APP</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-id="e_1">Android版</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>


    <!--*************************************中部[内容] ******************************************** -->

    <div class="layui-body">

        <!-- 选项卡 -->
        <div class="layui-tab layui-tab-card" lay-filter="body-top-tab" lay-allowClose="true"><!--lay-allowClose设置true,允许选项卡关闭 -->
            <ul class=layui-tab-title""></ul>        <!-- 标题标签 -->
            <div class="layui-tab-bar">              <!-- 刷新按钮 -->
                <a href="javascript:;"><i class="layui-icon">&#x1002;</i></a>
            </div>
            <div class="layui-tab-content"> <!-- 内容 -->
                <table class="body-table layui-table" lay-skin="row">
                    <colgroup><col width="30%"><col width="70%"></colgroup> <!--第一列的宽度-->
                    <thead>
                        <tr><th>属性</th><th>值</th></tr>
                    </thead>
                    <tbody>
                        <tr><td>id</td><td>${user.id}</td></tr>
                        <tr><td>用户名</td><td>${user.name}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>密码</td><td>${user.password}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>性别</td><td>${user.sex}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>出生年月日</td><td>${user.birthday}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>所在地</td><td>${user.address}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>电话</td><td>${user.phone}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>邮箱</td><td>${user.email}<button class="layui-btn layui-btn-small table-btn">修改</button></td></tr>
                        <tr><td>注册时间</td><td>${user.registertime}</td></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>



    <!--************************************* 底部[导航] ******************************************** -->
    <div class="layui-footer">
        <p>Suvan</p>
    </div>
</div>
</body>
</html>
