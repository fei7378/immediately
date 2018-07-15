<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>即刻财经后台管理|登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
     <link href="<%=basePath%>/JKCJ/images/logoTitle.png" rel="SHORTCUT ICON" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/JKCJ/layui/css/layui.css">

    <link rel="stylesheet" href="<%=basePath%>/JKCJ/layui/css/layui.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>/JKCJ/css/adminstyle.css" type="text/css">
    <script src="<%=basePath%>/JKCJ/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="video_mask"></div>
<div class="login">
    <h1>即刻财经-管理登录</h1>
    <div class="layui-form" >
    <form action="Login" method="POST">
        <div class="layui-form-item">
            <input class="layui-input" name="username" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" lay-verify="required|password" type="password" autocomplete="off">
        </div>
        <button class="layui-btn login_btn"   type="submit">登录</button>
    </form>
    </div>
</div>
<script src="<%=basePath%>/JKCJ/layui/layui.js"></script>
<script src="<%=basePath%>/JKCJ/js/admin.js"></script>
</body>
</html>