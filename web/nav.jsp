<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	if(session.getAttribute("MySession")==null){
%>	
	<script language=javascript>window.top.location.href="${ctx}/login.jsp"</script>	
<%		
	}
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>OA自动化办公系统</title>
    <link rel="stylesheet" href="${ctx}/styles/pintuer/pintuer.css">
    <link rel="stylesheet" href="${ctx}/styles/pintuer/admin.css">
    <script src="${ctx}/scripts/pintuer/jquery.js"></script>
    <script src="${ctx}/scripts/pintuer/pintuer.js"></script>
    <script src="${ctx}/scripts/pintuer/respond.js"></script>
    <script src="${ctx}/scripts/pintuer/admin.js"></script>
    <script src="${ctx}/scripts/common.js"></script>
    <link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />

</head>
<body>
<div class="lefter">
	<div class="logo"><img src="${ctx}/images/logo.png" alt="OA自动化办公系统" /></div>
	<!-- <div class="text-large">OA自动化办公系统</div> -->
</div>
<div class="righter nav-navicon" id="admin-nav">
    <div class="mainer">
        <div class="admin-navbar">
            <span class="float-right">
                <a class="button button-little bg-yellow" href="javascript:window.top.location='${ctx}/pages/User/logout.do'" >注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
                <li class="active"><a href="${ctx}/desktop_frame.jsp" target="mainFrame" class="icon-home"> 我的桌面</a>
                    <!-- <ul><li><a href="#">系统设置</a></li><li><a href="content.html">内容管理</a></li><li><a href="#">订单管理</a></li><li class="active"><a href="#">会员管理</a></li><li><a href="#">文件管理</a></li><li><a href="#">栏目管理</a></li></ul> -->
                </li>
                <li><a href="${ctx}/note_frame.jsp" target="mainFrame" class="icon-file-text"> 内部短信</a>
            		<!-- <ul><li><a href="#">未确认短信</a></li><li><a href="${ctx}/pages/NoteSend/newNote.do?nav=note&sub=new">发送内部短信</a></li><li><a href="#">已接受短信</a></li><li><a href="#">已发送短信</a></li></ul>-->
                </li>
                <li><a href="${ctx}/sys_frame.jsp" target="mainFrame" class="icon-cog"> 系统管理</a>
					<!-- <ul><li><a href="#">用户管理</a></li><li class="active"><a href="#">角色管理</a></li><li><a href="#">系统日志</a></li></ul>-->
                </li>
            </ul>
        </div>
        <div class="admin-bread">
            <span>您好， ${MySession.user.userName }，欢迎您的光临。</span>
            <ul class="bread">
                <li><a href="index.html" class="icon-home"> 开始</a></li>
                <li>后台首页</li>
            </ul>
        </div>
    </div>
</div>
<script type="text/javascript">
	$(".nav li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});

</script>
</body>
</html>



