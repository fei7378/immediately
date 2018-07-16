
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
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <title>即刻导航</title>
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
    <script src="<%=basePath%>/JKCJ/js/common.js"></script>
</head>
<body>

<!--<header class="header">-->
<nav class="layui-nav jk-nav">
    <div class="jk-nav-content">
        <a class="layui-logo jk-logo"></a>

        <ul class="jk-menu">
            <li><a href="HomePage">快讯</a></li>
            <li><a href="PolicyPage">政策</a></li>
            <li class="active"><a href="NavigateContext">导航</a></li>
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
            <div class="left-content" style="min-height: 1200px">
                <div class="left-nav-block">
                    <h2>现货交易平台</h2>
                    <span>将手上持有的币种，换成其他想持有的币种</span>
                </div>

                <!--导航网站-->
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                                入门介绍
                            </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list1}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                          
               
                            </div>
                        </div>
                    </div>


                </div>



 <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                                行业背景
                            </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list2}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>

<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                              技术原理  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list3}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>


<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                              中文媒体  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list4}"  varStatus="status">
                             
  <a href="${fei.gw_url}" target="_blank"><img src="${fei.img_url}">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>




<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                              外文媒体  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list5}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>





<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             行业微博  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list6}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             交易平台  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list7}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank"><img src="${fei.img_url}">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>
<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             数字货币  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list8}"  varStatus="status">
                             
  <a href="${fei.gw_url}" target="_blank" title="${fei.content}"><img src="${fei.img_url}">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>


                </div>





<div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             电报群  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list9}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                
                
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                            矿机  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list10}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                
                
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             云算力  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list11}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                
                
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                         矿池  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list12}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                
                
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             钱包  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list13}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                
                
                <div class="weblist-content">
                    <div class="weblist-block">
                        <div class="weblist-item">
                            <div class="weblist-item-title">
                             官方钱包  </div>
                            <div class="weblist-item-list">
                             <s:forEach var="fei" items="${list14}"  varStatus="status">
  <a href="${fei.gw_url}" target="_blank">${fei.title}</a>
		</s:forEach>
                              
               
                            </div>
                        </div>
                    </div>

                </div>
                
                
                <!--<div class="left-contet-list"></div>-->
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