---
title: Maven_错误记录
date: 2017-04-29 10:43:40
tags: Maven
categories: Maven
---


目录
=====================

参考资料：
+ [构建工具-Maven-相关知识-整理专题](https://github.com/judasn/IntelliJ-IDEA-Tutorial)
+ [IntelliJ IDEA 15 创建maven项目【图文教程】](http://www.cnblogs.com/wql025/p/5215570.html#autoid-0-0-0)
+ [解决intellij idea新建maven项目，加载archetype模型很慢 ](https://my.oschina.net/boltwu/blog/713523)

目录：
1.本地安装Maven
2. 创建maven项目【无模版-基本环境搭建】
3. 创建maven项目【使用模版】
4. idea的java项目添加Maven支持

---
<br><br><br>


错误
============================

1.本地安装Maven
-----------------------
```
官网：http://maven.apache.org/download.cgi
    下载apache-maven-3.3.9-bin.zip

配置环境变量:
    MAVEN_HOME:E:\Java\Maven\apache-maven-3.3.9\bin
    Path: ......%MAVEN_HOME%;e

验证
    打开cmd 输入 mvn -v 【验证是否配置成功】


更换中央仓库：【修改maven根目录下的conf文件中的setting.xml文件】
  <mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
  </mirrors>

```
---
<br><br>



2. 创建maven项目【无模版-基本环境搭建】
------------------------
```
1. 创建Maven项目【不使用模版】,自定义GroupId和Arifactld
2. 部署项目[Porject Structure]
	A.添加Modules【选web模版】
		(a1)修改资源目录[Web Resource Directories]
			E:\Java\Intellij IDEA\项目\My_Blog\src\main\webapp
			 ~~~【这里指定src\main文件，并输入webapp】
		(a2)修改描述文件[Deployment Descriptor]
			E:\Java\Intellij IDEA\项目\My_Blog\src\main\webapp\WEB-INF\web.xml
			~~~【这里同样将目录指定到webapp】
	B.添加Artifacts【描述了当前项目的发布信息】
		'+' 号 
			-> Web Application Exploded
			-> From Modules...
			-> 选择当前项目
			【左列表出现已有的发布项目，右列表的output root目录描述了当前项目的编译目录及适配服务】
3.在webapp\WEB-INF\目录下 -> 新建lib目录
4.部署服务器
	菜单栏Run
		(A)
		->Edit Configurations
		-> '+' 号
		-> Tomcat Server ==> Local
		->右界面Deployment【第二列菜单栏】
		->'+' 号 ==>  Artifact...

		(B)
		->回到Server【第二列菜单栏】
			在[On 'Update' action]
			  [On frame deactivation]
			  		==> 都选择Update classes and resources

		(C)
		->回到Server【第二列菜单栏】
			选择默认浏览器

5.添加Tomcat依赖
	部署项目[Project Structure] 
		-> Modules 
		-> 右界面选择项目 ==> Dependencies[依赖]
	    -> '+'号  ==>  Library...
	    -> Application Server Libraries ==> 选择相应Tomcat版本


6.项目结构
	My_Blog
		out  【编译文件目录】
		src  
			main  【主要源码目录】
			 	java
			 	resources
			 	webapp
			 		_lib         【存放扩展jar包】
			 		_WEB-INF
			 			web.xml  【web项目配置文件】
			test   【测试目录】
				java
		target
		My_Blog.iml
		pom.xml    【Maven配置文件】
	External Libraries  【库】


**********************************************
	若需要用模版创建则在New Project时
		[打勾][Create from archetype]
		然后选择
			org.appache.maven.archetypes:maven-archetype-webapp

```

---
<br><br>


3. 创建maven项目【使用模版】
----------------
```
File -> Close Project -> Create New Projcet
 选择Maven
 	找到org.apache.maven.archetype:maven-archtype-webapp【可以手动输入关键字模糊匹配】


```


4. idea的java项目添加Maven支持
----------------
```
	先新建项目
		->在左侧边栏右键项目 -> Add Framwork Support... 
		-> 找到Maven

```
<br>
---
<br><br>


---
<br><br><br>