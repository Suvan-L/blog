---
title: Sublime Text 3_错误记录
date: 2016-04-17 15:04:32
tags: Sublime Text 3
categories: Sublime Text 3
---


一.目录
======================

1. 使用sublime text 3打开文件，文件名显示乱码
2. 替换整个文件夹多个文件的内容【指定内容】


---
<br><br><br>



二.错误
======================


1.使用sublime text 3打开文件，文件名显示乱码
-------------------
```
　以sublime text 3工具随意一个文档
　　　菜单栏 Preference, 
　　　  进入Settings-User
　            最后加上一行
　         "dpi_scale": 1.0【覆盖操作系统设置的DPI】



举例：Settings-User
	{
	"font_face": "Consolas",
	"font_size": 15,
	"ignored_packages":
	[
	"Vintage"
	],
	"line_padding_bottom": 1,
	"line_padding_top": 1,
	"tab_size": 4,
	"translate_tabs_to_spaces": true,
	"word_wrap": "true",
	"dpi_scale": 1.0 #主要是这行生效！
	} 
```


---
<br><br>


2.破解Sublime Text 3
--------------
```
　  随便点击一个文档，用Sublime方式打开，
　　  点击Help
　　 下拉框Enter License
　　 将下面代码复制进去
　　   （一个3103 可以用的key）

>—– BEGIN LICENSE —–
Nicolas Hennion
Single User License
EA7E-866075
8A01AA83 1D668D24 4484AEBC 3B04512C
827B0DE5 69E9B07A A39ACCC0 F95F5410
729D5639 4C37CECB B2522FB3 8D37FDC1
72899363 BBA441AC A5F47F08 6CD3B3FE
CEFB3783 B2E1BA96 71AAF7B4 AFB61B1D
0CC513E7 52FF2333 9F726D2C CDE53B4A
810C0D4F E1F419A3 CDA0832B 8440565A
35BF00F6 4CA9F869 ED10E245 469C233E
—— END LICENSE ——

　　　　点击Use License



```

---
<br><br>


3.汉化
---------------
```
汉化
网上下载Default.sublime-package 文件。

打开sublime text 3，
　 preferences->
　      Browse Packages：
　     显示出文件管理器
 

　      返回上一层到sublime text 3 文件夹，
　      打开“Installed Packages”文件夹。
　        粘贴汉化包文件“Default.sublime-package”
　     到“Installed 
　　Packages”文件夹下面，无需刷新即可看到汉化效果。不够　汉化不是很完整。

Sublime Text 3汉化包

```
---
<br><br>


2. 替换整个文件夹多个文件的内容【指定内容】
----------------------------

+ [2. 替换整个文件夹多个文件的内容【指定内容】](http://heipark.iteye.com/blog/2124040)

---
<br><br>