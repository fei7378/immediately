<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.*"  import ="java.util.Date"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
   
    
   
   
   
   
    <title>即刻快讯</title>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
    <link href="<%=basePath%>/JKCJ/images/logoTitle.png" rel="SHORTCUT ICON" />
    
    
    
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/JKCJ/layui/css/layui.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/JKCJ/css/iconfont.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/JKCJ/css/style.css">
    <script src="<%=basePath%>/JKCJ/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>/JKCJ/js/jquery.rotate.min.js"></script>
    <script src="<%=basePath%>/JKCJ/js/common.js"></script>
    
   
</head>
<body>

<!--<header class="header">-->
    <nav class="layui-nav jk-nav">
        <div class="jk-nav-content">
            <a class="layui-logo jk-logo"></a>

            <ul class="jk-menu">
                <li class="active"><a href="HomePage">快讯</a></li>
                <li><a href="PolicyPage">政策</a></li>
                <li><a href="NavigateContext">导航</a></li>
                <li><a href="APP">APP</a></li>
                
            </ul>

            <div class="jk-nav-right-block">
                <button class="layui-btn">登录</button>
                <button class="layui-btn">注册</button>
            </div>
        </div>
    </nav>
<!--</header>-->

<div class="body-content">

<main class="jk-main">
    <!--主体部分-->
    <div class="layui-container">
       <!--列表内容-->
       <div class="left-content">
           <h1 class="kx-title">即刻快讯</h1>
<% long date = new Date().getTime(); request.setAttribute("date", date); %>
<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
		String now = df.format(d);
		
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String currSun = dateFm.format(date);
		System.out.println(currSun);
	%>
           <h2 class="kx-title-sub">今天·<%=now%>·<%=currSun%></h2>

           <!--列表-->
           
        <s:forEach var="fei" items="${news}"  varStatus="status">
      
       <a class= "${status.index== 0 ? 'left-list-block first-list':'left-list-block' }" href="GoldenContext?new_id=${fei.new_id}">
      
      
           <jsp:useBean id="dateObject" class="java.util.Date" scope="page"></jsp:useBean>
			 <jsp:setProperty property="time" name="dateObject" value="${fei.created_id}000"/>
               <span class="time-text"><fmt:formatDate value="${dateObject}" pattern="HH:mm" /> </span><span class="title-text"> ${fei.title}</span>
               <p class="content-text">${fei.content}</p>
               <label class="list-bottom"><span><i class="iconfont icon-tubiaoshangshengqushi"></i>看多:${fei.up}</span><span><i class="iconfont icon-tubiaoshangshengqushi1"></i>看空:${fei.down}</span></label>
        	  </a>
          
		</s:forEach>

             <div class="left-contet-list"><span class="load-more" id="kx-load"><i class="iconfont icon-shuaxin"></i>点击加载更多</span></div>
       </div>

       <!--右侧广告栏-->
       <div class="right-adv-block">
           <div class="adv-img-block">
              <img src="upload/${imageAdvertisingOne}">
           </div>
           <div class="adv-img-block">
               <img src="upload/${imageAdvertisingTwo}">
           </div>
       </div>


       <!--返回顶部-->
        <div class="top-back" title="点击返回顶部"><i class="layui-icon layui-icon-top"></i></div>
    </div>


    <!--底部-->
    <footer class="layui-footer jk-footer">
        <div class="jk-nav-content jk-footer-content">
            <div class="footer-top">
                <div class="jk-footer-block">
                    <h2>友情链接</h2>
                </div>
                <div class="jk-footer-block">
                    <h2>商业合作</h2>
                </div>
                <a class="footer-logo"></a>
            </div>
            <hr class="footer-hr"/>
            <div class="footer-bottom">
                <span>蜀ICP备16049139号Copyright © 即刻财经 版权所有</span>
                <ul class="footer-links">
                    <li><a>关于我们</a></li>
                    <li><a>加入我们</a></li>
                    <li><a>联系我们</a></li>
                    <li><a>版权申明</a></li>
                    <li><a>API</a></li>
                </ul>
            </div>
        </div>
    </footer>
</main>

    </div>



</body>
</html>