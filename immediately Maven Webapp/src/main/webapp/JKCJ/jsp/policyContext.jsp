
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
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <title>${policy.title}</title>
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
        <a class="layui-logo jk-logo" href="HomePage"></a>

        <ul class="jk-menu">
            <li ><a href="HomePage">快讯</a></li>
            <li class="active"><a href="PolicyPage">政策</a></li>
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
                <div class="zc-detail-block">
                    <!--面包屑-->
                   <div class="zc-detail-bread"><a href="PolicyPage">政策</a> > 正文 </div>
                    <!--标题-->
                   <h2 class="zc-detail-title">${policy.title}</h2>
                    <!--副标题-->
                      <jsp:useBean id="dateYang" class="java.util.Date" scope="page"></jsp:useBean>
			 <jsp:setProperty property="time" name="dateYang" value="${policy.published_at}000"/>
                   <p  class="zc-detail-subtitle"><span class="detail-time"><fmt:formatDate value="${dateYang}" pattern="MM-dd HH:mm" /></span><span></span><span><i class="iconfont icon-yanjing"></i>${policy.look}</span></p>
                  <!--这是摘要内容-->
                   <div class="abstract">
                      <p>${policy.summary}</p>
                   </div>
                    <!--正文-->
                    <div class="zc-detail-content">
						${policy.text}
                       

                    </div>

                    <!--作者-->
                    <div class="authorcontainer">
                        <span>编辑：${policy.author}</span>
                    </div>

                    <!--标签-->
                    <div class="tag-containe">
                        <span class="tag-icon"><i class="iconfont icon-biaoqian"></i></span>
                        <span class="tag">${policy.source}</span>
                    </div>

                    <!--申明-->
                    <div class="equity">
                        <p>版权声明：本文为转载内容，所有版权归币XXX所有，转载请注明来自币世界并附上本站链接。</p>
                    </div>

                </div>

                <!--上一篇和下一篇-->
                <div class="zc-bottom">
                    <div class="leftbtn prevPage">
                        <a href="PolicyContext?id=${policy1.id}">
                            <p>上一篇</p>
                            <span>${policy1.title}</span>
                        </a>
                    </div>

                    <div class="rightbtn nextPage">
                        <a href="PolicyContext?id=${policy2.id}">
                            <p>下一篇</p>
                            <span>${policy2.title}</span>
                        </a>
                    </div>

                </div>


            </div>

            <!--右侧广告栏-->
            <div class="right-adv-block">
                <div class="adv-img-block">
              <img src="upload/${imageAdvertisingOne}">
           </div>
                <div class="adv-list-block">
                   <h2><span></span>精选文章</h2>
                   <s:forEach var="ffei" items="${coin}">
                 <label><span>${ffei.issue_time}</span><a title="${ffei.abstract_str}" href="CoinContext?id=${ffei.id}">${ffei.title}</a></label>
                
                    </s:forEach>
                    
                </div>

                <div class="adv-list-block">
                    <h2  class="not-border"><span></span>快讯</h2>
                    
                    
                    <% long date = new Date().getTime(); request.setAttribute("date", date); %>
<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
		String now = df.format(d);
		
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String currSun = dateFm.format(date);
		System.out.println(currSun);
	%>
           <h3 class="kx-title-sub not-mg">今天·<%=now%>·<%=currSun%></h3>
                 
                    
                    <s:forEach var="fei" items="${quick}">
           <jsp:useBean id="dateObject" class="java.util.Date" scope="page"></jsp:useBean>
			 <jsp:setProperty property="time" name="dateObject" value="${fei.created_id}000"/>
			 
			  <label><span><fmt:formatDate value="${dateObject}" pattern="HH:mm" /></span><a title="${fei.content}" href="GoldenContext?new_id=${fei.new_id}">${fei.title}</a></label>
              
        	 
          
		</s:forEach>
                   

                </div>
            </div>


            <!--返回顶部-->
            <!--<div class="top-back" title="点击返回顶部"><i class="layui-icon layui-icon-top"></i></div>-->
        </div>


      <!--底部-->
        <footer class="layui-footer jk-footer">
            <div class="jk-nav-content jk-footer-content">
                <div class="footer-top">
                    <div class="jk-footer-block">
                        <h2>友情链接</h2>
                        <div class="jk-links">
                            <a href="https://www.aicoin.net.cn/" target="_blank">AICoin</a>
                            <a href="http://www.babifinance.com/" target="_blank">BABI财经</a>
                            <a href="https://www.ihuoqiu.com" target="_blank">火球财经</a>
                            <a href="http://chainknow.com" target="_blank">知链</a>
                            <a href="http://www.5bite.com/" target="_blank">区块链之家</a>
                            <a href="http://www.weilaicaijing.com/" target="_blank">未来财经</a>
                            <a href="http://www.8btm.com/MChain.php" target="_blank">币猫商城</a>
                            <a href="http://www.lianjie2100.com/" target="_blank">链接财经</a>
                            <a href="http://bcsky.pro/" target="_blank">链天下</a>
                            <a href="http://bc.jrj.com.cn/" target="_blank">金融界区块链</a>
                            <a href="http://www.qukuaiwang.com.cn" target="_blank">区块网</a>
                            <a href="https://www.okb.com" target="_blank">OKEX</a>
                            <a href="http://www.finacerun.com/" target="_blank">奔跑财经</a>
                            <a href="http://www.beyouvoice.com" target="_blank">BEYOU财经</a>
                            <a href="https://www.hqz.com" target="_blank">HQZ行情站</a>
                            <a href="https://www.xcj.com" target="_blank">新财经</a>
                            <a href="http://www.qifengle.com/" target="_blank">起风财经</a>
                            <a href="http://www.coinla.com" target="_blank">考拉行情</a>
                            <a href="https://www.coingogo.com" target="_blank">币源社区</a>
                            <a href="https://www.btcside.com" target="_blank">比特帮</a>
                            <a href="http://www.a5.net" target="_blank">A5交易</a>
                        </div>
                    </div>
                    <div class="jk-footer-block">
                        <h2>商业合作</h2>
                        <dl class="jk-bottom-list">
                            <dd>微信号：376250980</dd>
                            <dd>邮箱：media@supportjkcj.com</dd>
                        </dl>
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