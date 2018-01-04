---
title: Bootstrap_知识体系
date: 2017-05-10 14:15:08
tags: 前端
categories: 前端
---




一.前言
=======================
<br>

参考资料：
+ [Bootstrap中文文档【官方】](http://v3.bootcss.com/)
+ [bootstrap学习记录【nav属性,导航元素的使用】](http://www.jianshu.com/p/4ef75b89785a)
<br>


目录：
1. 导航
2. 栅格系统
3. 页面底部规范
4. JavaScript插件



---
<br><br><br>


二.目录
===========================

1.导航
-------------------
```
navbar-导航条,nav-导航

布局容器【div】
	container 		[居中]
	container-fluid	[100%]

导航条样式
	navbar-default	[默认白]
	navbar-inverse  [黑色]

文本
	navbar-brand    [字体大一号]【常用与到汉兰的a标签】

浮动
	navbar-right	[左浮动]
	navbar-left		[右浮动]

位置
	navbar-fixed-top    [顶部固定]
	navbar-fixed-bottom [底部固定]	
	navbar-static-top   [顶部-可随屏幕滚动]



表单
	navbar-form		
	form-group		[表单组]

ul【无序列表】
	nav 			[导航样式]
	navbar-nav   	[垂直]

	nav-tabs		[标签样式]
		nav-justified	[标签样式-两端对齐(等宽)]
	nav-pills		[胶囊样式(默认是水平)]
		nav-stacked		[胶囊样式-垂直堆叠排列]

	dropdown-menu	[下拉菜单]【需要有<a>标签声明class="dropdown-toggle" data-toggle="dropdown"】

li【列表元素】
	active			[活动状态]
	disabled		[禁用状态]
	divider			[分隔符]

```



---
<br><br>


2.栅格系统
-------------------------
```
在<div class="row"></div>范围内的divide样式
	col-xs-*	[*(长度-范围1 ~ 12)]
	col-sm-*
	col-md-*
	col-lg-*

列偏移【重置偏移, 拉回和推后】
		col-*-offset-^  [^(重置位置-范围1 ~ 12)]
		col-*-pull-^ 	[^(横向拉拉回(左移)-范围1 ~ 12)]
		col-*-push-^ 	[^(横向推(右移)-范围1 ~ 12)]


列嵌套【范围同样是0 ~ 12】
	<div class="row" style="background-color: yellow;">
                    <div class="col-lg-1 col-lg-offset-2 col-lg-pull-2 " style="background-color: blue;">
                        <div class="row" style="background-color: red;">
                            <div class="col-lg-1 col-lg-offset-12" style="background-color: blue;">皮</div>
                        </div>
                    </div>
            </div>



```


---
<br><br>



3.页面底部规范
-----------------------


+ [网页底部正确的版权格式规范 ](http://paituwang.com/node/39)
+ [网站网页底部设计的正确版权格式规范](http://adophper.com/tag-%25e7%25bd%2591%25e7%25ab%2599%25e7%25bd%2591%25e9%25a1%25b5%25e5%25ba%2595%25e9%2583%25a8%25e8%25ae%25be%25e8%25ae%25a1%25e7%259a%2584%25e6%25ad%25a3%25e7%25a1%25ae%25e7%2589%2588%25e6%259d%2583%25e6%25a0%25bc%25e5%25bc%258f%25e8%25a7%2584%25e8%258c%2583.html)


---
<br><br>

4.JavaScript插件
-----------------------

+ [Bootstrap3的JavaScript插件【官网】](http://v3.bootcss.com/javascript/)
+ [Bookstrap2的JS插件](http://v2.bootcss.com/javascript.html)
---
<br><br>