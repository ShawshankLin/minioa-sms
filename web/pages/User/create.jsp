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
<div class="admin">
	<form method="post" class="form-x" action="${ctx}/pages/User/save.do">
	  <div class="form-group">
	    <div class="label"><label for="userName">用户名：</label></div>
	    <div class="field">
	      <input type="text" class="input" id="userName" name="userName" size="30" placeholder="必填" required="required"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label for="displayName">显示名称：</label></div>
	    <div class="field">
	      <input type="text" class="input" id="displayName" name="displayName" size="30" placeholder="必填" required="required"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label for="password">密码：</label></div>
	    <div class="field">
	      <input type="password" class="input" id="password" name="password" size="30" placeholder="必填" required="required"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label for="phone">电话：</label></div>
	    <div class="field">
	      <input type="text" class="input" id="phone" name="phone" size="30" placeholder="选填" />
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label for="mobilePhone">手机号码：</label></div>
	    <div class="field">
	      <input type="text" class="input" id="mobilePhone" name="mobilePhone" size="30" placeholder="选填" />
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label for="email">电子邮件：</label></div>
	    <div class="field">
	      <input type="email" class="input" id="email" name="email" size="30" placeholder="选填" />
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label>性别：</label></div>
	    <div class="field">
	      <div class="button-group radio">
	        <label class="button active"><input name="gender" value="Y" checked="checked" type="radio"><span class="icon icon-male"></span> 男</label>
	        <label class="button"><input name="gender" value="N" type="radio"><span class="icon icon-female"></span> 女</label>
	      </div>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="label"><label>锁定：</label></div>
	    <div class="field">
	      <div class="button-group radio">
	        <label class="button"><input name="isLock" value="Y" type="radio"><span class="icon icon-lock"></span> 是</label>
	        <label class="button active"><input name="isLock" value="N" checked="checked"  type="radio"><span class="icon icon-unlock"></span> 否</label>
	      </div>
	    </div>
	  </div>
	  <div class="form-button">
	  	<button class="button bg-main" type="submit">保存</button>
	  	<button class="button bg-main" type="button" onclick="history.back()">返回</button>
	  </div>
	</form>
</div>
	
</body>
</html>
