---
title: Java_框架框架学习
date: 2017-1-2 10:05:25
tags: Java
categories: Java
---


前言
=========================
&emsp;SSM框架【Spring + SpringMVC + Mybatis】


资料：
+ [SpringMVC学习笔记](http://www.cnblogs.com/sunniest/p/4555801.html)
+ [手把手教你整合最优雅SSM框架：SpringMVC + Spring + MyBatis ](http://blog.csdn.net/qq598535550/article/details/51703190)

<br>


目录：
一.SpringMVC
二.MyBatis
三.Spring


---
<br><br><br>



一.SpringMVC
========================

次目录
1.配置文件
2.注解
<br>


1.配置文件
-------------

1. web.xml[web项目配置文件]
2. spring-mvc.xml[SpringMVC项目MVC配置文件]
3. pom.xml[Maven项目依赖包配置文件]


---
<br><br>



2.注解
-----------------
```
Controller
	@Controller			[控制器]

	@RequestMapping(	[请求映射]
				value,		(路径【配置spring-mvc.xml配置的视图解析器的前后缀】)
				method,		(请求方式)
				consumes,   (仅处理哪些Content-Type的提交)
				produces,	(指明返回的内容类型【类型必须在request中Accept头中包含】【使用@ResponseBody返回String时乱码，可以添加该属性produces="text/html;charset=UTF-8】)
				params,		(指明request中必须包含某些参数值【还可加上值的value】)
				headers,	(指定request中必须包含某些指定的hearder值)
				Path
				)

	@RequestParam(	[request参数赋值【赋给方法形参】]
			value,			(参数名)
			defaultValue	(默认值)
		)

	@PathVariable(	[获取URL中的变量【用于RESTFul风格】【在@RequestMapping中的模版变量{..}绑定到同名参数】
			value    		(参数名)
			)
	@RequestHeader	[获取HTTP头的信息]
	@CookieValue	[获取请求的Cookie数据]

	@SessionAttributes [将Model中的属性存放到HttpSession中【声明类】]
	@ModelAttribute
		 <1>ModelAttribute(value="")注释返回具体类
		 <2>@ModelAttribute注释void返回值的方法
		 <3>@ModelAttribute注释自定义类返回值的方法


	@RequestBody 	 
	@ResponseBody	 [返回对象]

```
<br>
---
<br><br><br><br><br>




二.MyBatis
========================


次目录：
1.映射语句
<br>


1.映射语句
-----------------------

用于映射文件里[.xml]
```
标签
	insert
	delete
	select
	update

	sql			[可被其他语句引用的可重用语句块]
	cache		[给定命名控件的缓存空间]
	cache-ref	[其他命名控件缓存配置的引用]
	resultMap	[描述如何从数据库结果集加载对象]

动态SQL
	if 			[加入判断语句]
		<if test="条件">...</if>
	choose		[选择语句(选其一)]
		<choose>
			<when test="条件"></when>
			<when test="条件"></when>
		</choose>
	where
	set 		[用于update更新操作]
		<set>
			<if test="条件"><</if>
			<if test="条件"><</if>
		</set>
	foreach
	bind

```
<br>
---
<br><br><br><br><br>





三.Spring
===========================



---
<br><br><br><br><br>
