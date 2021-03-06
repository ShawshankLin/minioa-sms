<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<ul class="nav nav-inline admin-nav">
	<li class="active">
	 <ul>
		 <%-- <li><a href="${ctx}/pages/NoteReceive/getNoseeNote.do" target="noteRightFrame">未确认短信</a></li> --%>
		 <li class="active"><a href="${ctx}/pages/NoteSend/newNote.do" target="noteRightFrame">快速发送短信</a></li>
		 <%-- <li><a href="${ctx}/pages/NoteReceive/list.do" target="noteRightFrame">已接受短信</a></li>
		 <li><a href="${ctx}/pages/NoteSend/list.do" target="noteRightFrame">已发送短信</a></li> --%>
	 </ul>
	</li>
</ul>
<script type="text/javascript">
	$(".nav li ul li").click(function(){
		$(this).addClass("active").siblings().removeClass("active");
	});

</script>
</body>
</html>

