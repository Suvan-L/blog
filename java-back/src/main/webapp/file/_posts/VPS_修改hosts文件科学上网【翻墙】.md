---
title: VPS_修改hosts文件科学上网【翻墙】
date: 2016-12-08 17:27:21
tags: VPS
categories: VPS
---

资源教程
==============================

+ [老D博客](https://laod.cn/hosts/2016-google-hosts.html)



---

<br><br>

大体流程
=======================

1. 上网在老D博客提供的百度云盘,下载相应的压缩包【提取码】,根据自己系统解压相应版本【解压码】
2. 备份自己原来的hosts文件,然后根据<使用说明.txt>执行`Windows自动替换脚本.bat `,便会将hosts文件替换C:\Windows\System32\drivers\etc目录下的host【系统默认最初的】
3. 打开Ctrl+R,输入CMD,再输入ipconfig /flushdns【刷新DNS解析缓存】
4. 即可浏览[谷歌](https://www.google.com/)



<br><br>


注意：
+ 当发现无法上谷歌的时候，需要去[老D博客](https://laod.cn/hosts/2016-google-hosts.html)，更新最新的hosts
+ 不使用bat脚本也行，直接自己替换


---