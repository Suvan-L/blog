---
title: intellijIDEA_错误记录
date: 2017-04-27 08:50:41
tags: Eclipse
categories: Eclipse
---

一.目录
=======================

参考资料：
+ [IntelliJ IDEA 简体中文专题教程](https://github.com/judasn/IntelliJ-IDEA-Tutorial)

目录：
1. 将项目远程提交到Github
2. 设置Tomcat热更新[静态动态网页文件]
3. 安装JRebel插件,实现热部署[java文件]
4. idea的代码生成器[Live Templates]
5. 自动提示方法参数[鼠标移动到方法名]
6. 配置SFTP[远程服务器用于上传文件]
7. idea每次运行Java文件,提示Warning:java:资源值1.5已过时
8.idea常用快捷键

---
<br><br><br>


二.错误
=======================

1.将项目远程提交到Github
-------------------------
```
1.菜单栏VCS
	-> Import into Version Control
		 ->	Share project on GitHub

2.Settings
	->	Version Control
		->	Github 填入帐号密码
		->  Git 安装Git，并指定git.exe路径，Test测试

3.提交
	VSC -> Update Project...[更新项目]
		-> Commit Changes...[提交修改]

	 ->右键项目
	 	->Git 
	 		-> Repository -> Pull..【下载】
	 						 Push..【提交】

```
---
<br><br>


2.设置Tomcat热更新[静态动态网页文件]
-------------------
```
顶部菜单
Run
	->Edit Comfigurations
		->配置Tomcat Server
			(1)->点击Deployment,添加Deploy at the server startup【相当于部署】
				->'+'号,点击Artifact..
				->选择项目名:war exploded【exploded是部署到Tomcat的webapps目录下,效率个人能更高】

				【可选：可删除底部的Build(提高效率)】

			(2)->回到Server
				On 'Update' action 和On frame deactivation 
				这两项目一定要选择 Update classes and resources


		->Apple  ->OK  【配置成功】


```
---
<br><br>


3. 安装JRebel插件,实现热部署[java文件]
------------------------------------

参考资料
+ [IDEA 破解激活Jrebel6.4使用教程.zip【百度云】](https://pan.baidu.com/s/1bpsMm3l)
+ [IntelliJ IDEA - JRebel安装使用教程](http://www.jianshu.com/p/008bd27bbd77)
<br>




安装+破解步骤
```
<1>安装
        a.【直接搜索插件下载】
                IDEA --- File ---Settings --- Plugins --- Browse reponsitories 在搜索框输入 Jrebel 即可安装下载
        b.【压缩包安装】
                IDEA --- File ---Settings --- Plugins---Install plugin from disk...  -->jr-ide-idea-6.4.0-idea-13-15.zip

<2>破解
            a.解压"jrebel-6.4.0-Enterprise.Cracked-ZCT.zip"
            b.将解压出来的
                    jrebel 
                    jrebel6
                    jrebel.lic(许可证)
                 直接拉到C:\Users\sun\.IntelliJIdea15\config\plugins\jr-ide-idea\lib目录,覆盖

            c.File--settings ---Jrebel --- 右上角 Open Activation Dialog,弹框 --》
                中间那行License file from the hard drive,选择Browse,选择上述的jrebe.lic文件


            d.窗口内容改变,变成JRebel activated，激活陈功

```
<br>

---
<br><br>


4.idea的代码生成器[Live Templates]
---------------------

```
顶部菜单 -> File -> Settings【快捷键打开：ctrl + ald + s】
						-> Editor
							-> Live Templates  


java
	sout	-> 	(System.out.printl)
	psvm	->  (main()-主函数)

```

---
<br><br>


5. 自动提示方法参数[鼠标移动到方法名]
-------------
```
ctrl + alt + s  
	->Editor -> General 

		-> 右边窗:Show quick documentation on mouse move Delay

``


---
<br><br>


6. 配置SFTP[远程服务器用于上传文件]
-----------------------

流程：
1. 在远程服务器(windows Server)上安装FreeSSHhd软件[FreeHd官网](http://www.freesshd.com/)
2. 在idea配置sftp服务器
3. 上传文件
<br>

```
1. 
 	a.根据提示一步步安装->安装完成后会弹框2个[中译:是否安装密钥 + 是否安装成系统服务]
    b.安装后 Servert status -> 开启SSH server is running[如果报错则吧系统服务关闭后，关闭软件,以系统管理员身份启动]
    c.Authentication 
    		->Password authentication设置成Allow(或者 Required)
    		->Public key authentication 设置成 Disbled
    d.SSH
    	->Listen address设置成 <服务器ip>
    e.SFTP
    	->SFTP home path(上传根目录)
    f.Users
    	->Add(添加用户)
    		->Login [登录名]
 			->Authroization [验证方式]
 			->User can use [权限，打勾SFTP]


****************************************************

2.idea操作
	Settings[快捷键:ctrl + alt + s]
		-> Build,Execution,Deployment
			->Deployment
				->'+'号
					Name [昵称(随意填写)]
					Connection
						<1>Type		[sftp类型]
						<2>SFTP host	[服务器ip]【Test SFTP..测试是否能连接服务器】
						<3>Port			[SSH端口]
						<4>Root path	[根据FreeSSHhd的设置路径后的继续路径]
					Mappings
						<1>Deployment path on server[根路径后的部署路径]


3.


```
<br>
---
<br><br>


7. idea每次运行Java文件,提示Warning:java:资源值1.5已过时
-----------------------------

```
提示报错
	Warning:java:源值1.5已过时,将在未来所有发行版中删除
	Warning:java:目标值1.5已过时,将在未来所有发行版中删除
	Warning:java:要隐藏有关已过时选项的警告,请使用-Xlint:-options


解决办法
	快捷键”Ctrl+Alt+S”打开设置，
	   ->搜索”Java Compiler”
	   ->将默认jdk和当前modual的jdk版本切换为1.8即可

```
<br>


---
<br><br>


8.idea常用快捷键
-----------------------------------------
```

ESC  关闭弹窗

Alt + INS  新疆类or方法
Alt + NUM (数字键)  切换窗口

shrit + F6  文件重命名
shift + shift 搜索框(任意文件)
shift + ESC 关闭窗体模块

ctrl + D 复制行
Ctrl + E 打开最近编辑过的文件
Ctrl + F 文本搜索框(当前页)
Ctrl + H 查看类的层次
Ctrl + j  查看模版
Ctrl + N 搜索类
Ctrl + W 层级选中
Ctrl + Y 删除行


Ctrl + Tab 切换标签

Ctrl + F4 关闭当前页面
ctrl + F12 查看类的所有方法


Ctrl + shift + 空格  智能补全
Ctrl + shift + F10  运行类


ctrl+shift+A 查找所有Intellij命令


```
---
<br><br>
