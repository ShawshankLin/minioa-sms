<%@ page language="java" import="java.util.*,java.net.URLDecoder" pageEncoding="utf-8"%>
<%@page import="com.dispensary.project.model.*" %>
<%@ include file="/commons/taglibs.jsp" %>
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
    <link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>

<%  
        out.print("["+request.getLocalAddr()+":" +request.getLocalPort()+"]" + "<br/>session id:" + session.getId());   
    %>  
<div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br /><br />
            <div class="media media-y">
               <img src="images/login_logo.png" class="radius" alt="MINIOA_LOGO" />
            </div>
            <br /><br />
            <form action="${ctx}/pages/User/login.do" method="post">
            <div class="panel">
                <div class="panel-head"><strong>欢迎登录minioa</strong></div>
                <div class="panel-body" style="padding:30px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input" name="userName" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key"></span>
                        </div>
                    </div>
                    <!-- <div class="form-group">
                        <div class="field">
                            <input type="text" class="input" name="passcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                            <img  width="80" height="32" class="passcode" src="${ctx}/validatecode.jsp" onclick="javscript:$('loginform:vCode').src='../../validatecode.jsp?'+Math.random();" />
                        </div>
                    </div> -->
                </div>
                <div class="panel-foot text-center"><button class="button button-block bg-main text-big">登录</button></div>
            </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>