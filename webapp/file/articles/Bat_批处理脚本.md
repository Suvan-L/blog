---
title: Bat_批处理脚本
date: 2016-12-05 08:50:28
tags: Bat
categories: Bat
---

一.介绍
=====================
<br>

+ [百度百科](http://baike.baidu.com/link?url=dkXLa2AqCxTY1YkPUqK4WhsnuigQfXCZvnCZZ-iFs19VNtxCNmZDnAlWeqX0b-X3)



---

<br><br><br>

二.可学习资源
===================
<br>

+ [运行bat文件如何才能不弹出DOS黑窗口](https://zhidao.baidu.com/question/2056499451200504427.html)


---
<br><br><br>


三.简单运用
=====================
<br>

1.启动Redis
-------------------------
<br>
&emsp;在E盘创建BatScript目录，用于存放Bat脚本
配置环境变量
+ BatScript
+ E:\BatScript
+ 在path变量结尾添加%BatScript%;

<br><br>

A.开启Reids数据库和开启Reids命令界面
```
将
【redis.bat】
start "" "startRedisService.bat"
start "" "redisDOS.bat"


****************************
【startRedisService.bat】   ---启动Redis数据库
cd e:java/redis/3.2.100
e:
redis-server.exe redis.windows.conf


****************************
【redisDOS.bat】   ---编程界面
cd e:java/redis/3.2.100
e:
redis-cli.exe  


运行：
直接Ctrl+R或者在DOS界面,输入redis,即可启动Redis数据库并进入编程界面


```

---
<br>

B.执行完任务后停留在DOS界面
```
cmd /k echo        执行完此命令后保留窗口
```

---
<br><br>


2.启动屏幕截取工具【2017.1.2】
---------------------------


A.新建XY_BAT.bat
```
cd..
cd class
java GetScreen_XY
exit
```

<br>

B.新建XY.vbe【用于运行bat脚本的时候不弹黑窗口】
```
set ws=wscript.createobject("wscript.shell")
ws.run "XY_BAT.bat /start",0
```

---
<br><br>


3.
-----------

