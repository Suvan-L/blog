<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--JSTL核心标签库--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">                  <!--设置IE兼容模式 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--开启BootStrap移动设备响应式-->
    <title>文件上传</title>
</head>
<body>
<h1>文件上传程</h1>
<form method="post" action="${basePath}test/upload" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="file"/>
    <br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>