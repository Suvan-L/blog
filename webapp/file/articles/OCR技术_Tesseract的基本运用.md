---
title: OCR技术_tesseract图片文字识别
date: 2017-07-11 18:04:59
tags: 路由器
categories: 路由器
---



一.目录
======================

目录
1.安装与下载
2.解析图片
<br>

---
<br><br><br>



二.内容
===================

1.下载与安装
--------------------

参考资料
+ [tesseract的Github项目地址](https://github.com/tesseract-ocr/tesseract)
+ [4.0版本下载地址](https://github.com/tesseract-ocr/tesseract/wiki/4.0-with-LSTM#400-alpha-for-windows)
<br>

```
<1>下载安装包
找到页面的`Windows Installer made with MinGW-w64 `,
	点击下载tesseract-ocr-setup-4.00.00dev.exe

<2>运行安装包,依次执行
		1.Next
		2.(打勾I accpet the....),Next
		3.根据英文语义,随意选择,Next
			 a.Install for anyone using this computer
			 b.Install just for me
		4.这里有4个默认打勾项,
			Adiitonal language data(download)是添加新的语言包
				里面打勾Chinese(Simplified)选项,这事简体中文

<3>配置环境变量
	TESSERACT
		E:\Java\tesseract【OCR图片识别】\Tesseract-OCR
	TESSDATA_PREFIX
		E:\Java\tesseract【OCR图片识别】\Tesseract-OCR\tessdata

	加入path里
		;%TESSERACT%;%TESSDATA_PREFIX%

<4>可在图片所在位置,开启cmd【shhift+右键-在此处打开命令行窗口】,执行tesseract命令

```
<br>
---
<br><br>



2.解析图片
--------------------
```
命令行
	tesseract XXX.png k   【解析XXX.png图片,将结果储存至当前目录的k.txt(新创建)】


	tesseract --list-langs	【查看有哪些可用语言】【可通过训练得到语言】
		eng[英文]
		chi_sim[简体中文]


	tesseract XXX.png k -l chi_sim 【解析图片....指定chi_sim语言】

```
<br>
---
<br><br>
