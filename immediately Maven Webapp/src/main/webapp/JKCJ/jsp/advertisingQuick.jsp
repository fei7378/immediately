
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" %>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.text.*"  import ="java.util.Date"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%if(request.getSession().getAttribute("name")==null){
response.sendRedirect("../../Login");
}
 %>
 <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>后台首页|快讯广告页</title>
    <link href="<%=basePath%>/JKCJ/images/logoTitle.png" rel="SHORTCUT ICON" />
    <link rel="stylesheet" href="<%=basePath%>/JKCJ/layui/css/layui.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>/JKCJ/css/adminstyle.css" type="text/css">
    <script src="<%=basePath%>/JKCJ/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><img src="<%=basePath%>/JKCJ/images/logo.png"></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!--<li class="layui-nav-item"><a href="">控制台</a></li>-->
            <!--<li class="layui-nav-item"><a href="">商品管理</a></li>-->
            <!--<li class="layui-nav-item"><a href="">用户</a></li>-->
            <!--<li class="layui-nav-item">-->
                <!--<a href="javascript:;">其它系统</a>-->
                <!--<dl class="layui-nav-child">-->
                    <!--<dd><a href="">邮件管理</a></dd>-->
                    <!--<dd><a href="">消息管理</a></dd>-->
                    <!--<dd><a href="">授权管理</a></dd>-->
                <!--</dl>-->
            <!--</li>-->
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                   <%=request.getSession().getAttribute("name") %>
                </a>
                <dl class="layui-nav-child">
                    <dd><a class="edit-password">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="Login" class="login-out">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">广告位管理</a>
                    <dl class="layui-nav-child">
                        <dd class="layui-this"><a href="Quick">快讯广告</a></dd>
                        <dd><a href="Policy">政策广告</a></dd>
                        <dd><a href="Navigate">导航广告</a></dd>
                    </dl>
                </li>
                <!--<li class="layui-nav-item"><a href="">云市场</a></li>-->
                <!--<li class="layui-nav-item"><a href="">发布商品</a></li>-->
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="advertis-content">

            <h2>快讯广告设置</h2>
           <div class="advertis-block">
               <span>广告位1</span>
  <form method="post" action="ImageDate" class="layui-form">
               <img title="点击图片选择需要更换的图片" src="upload/${a1}" class="adv-img-btn1" ><!--  -->
         <input type="hidden" id="id1" name="id" value="1"></input>
             <input type="hidden" id="a1" name="aa"></input>
            
             <input type="hidden" id="type1" name="type" value="1"></input>
               <div class="adv-btns">
                   <button class="layui-btn" type="submit" lay-submit lay-filter="imgform1">保存</button>
              
                <!--   <button class="layui-btn layui-btn-danger" type="button" id="1">禁用</button> --> 
               </div>
               </form>

           </div>

            <div class="advertis-block">
                <span>广告位2</span>
                 <form method="post" action="ImageDate" class="layui-form">
                <img title="点击图片选择需要更换的图片" src="upload/${a2}" class="adv-img-btn2" ><!--  -->
          <input type="hidden" id="id2" name="id" value="2"></input>
             <input type="hidden" id="a2" name="aa"></input>
            
             <input type="hidden" id="type2" name="type" value="1"></input>
               <div class="adv-btns">
                   <button class="layui-btn" type="submit" lay-submit lay-filter="imgform2">保存</button>
              
                <!--   <button class="layui-btn layui-btn-danger" type="button" id="1">禁用</button> --> 
               </div>
               </form>
            </div>

            <div class="advertis-block">
                <span>广告位3</span>
                  <form method="post" action="ImageDate" class="layui-form">
                 <img title="点击图片选择需要更换的图片" src="upload/${a3}" class="adv-img-btn3" ><!--  -->
         <input type="hidden" id="id3" name="id" value="3"></input>
             <input type="hidden" id="a3" name="aa"></input>
            
             <input type="hidden" id="type3" name="type" value="1"></input>
             
               <div class="adv-btns">
                   <button class="layui-btn" type="submit" lay-submit lay-filter="imgform3">保存</button>
              
                <!--   <button class="layui-btn layui-btn-danger" type="button" id="1">禁用</button> --> 
               </div>
               </form>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 即刻财经后台
    </div>
</div>
<script src="<%=basePath%>/JKCJ/layui/layui.js"></script>
<script src="<%=basePath%>/JKCJ/js/admin.js"></script>


</body>
</html>