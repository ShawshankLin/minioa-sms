<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript">
   	$(document).ready(function(){
   	 setInterval(function () {
 		$.get("${ctx}/pages/NoteReceive/getNoseeNoteNum.do?sendid="+${MySession.user.id}+"&nocache="+new Date().getTime(),function(data){
 			var noseeNoteNum=data;
 			console.log(noseeNoteNum);
 			if(noseeNoteNum!=0){
 				$("#noseeNoteNum").text(noseeNoteNum).show();
 			}else{
 				$("#notice").hide();
 			}
 			
 		});
     }, 60000);
   	});
    </script>
</head>

<body>
<div class="admin">
	<div class="line-big">
    	<div class="xm3">
        	<div class="panel border-back">
            	<div class="panel-body text-center">
                	<img src="images/avatar4.png" width="80" class="radius-circle" /><br />
                     ${MySession.user.userName }
                </div>
                <div class="panel-foot bg-back border-back">您好，  ${MySession.user.userName }，这是您第${MySession.loginNum } 次登录，上次登录为${MySession.lastLoginTime }。</div>
            </div>
            <!--  <br />
        	<div class="panel">
            	<div class="panel-head"><strong>站点统计</strong></div>
                <ul class="list-group">
                	<li><span class="float-right badge bg-red">88</span><span class="icon-user"></span> 会员</li>
                    <li><span class="float-right badge bg-main">828</span><span class="icon-file"></span> 文件</li>
                    <li><span class="float-right badge bg-main">828</span><span class="icon-shopping-cart"></span> 订单</li>
                    <li><span class="float-right badge bg-main">828</span><span class="icon-file-text"></span> 内容</li>
                    <li><span class="float-right badge bg-main">828</span><span class="icon-database"></span> 数据库</li>
                </ul>
            </div>
            <br />-->
        </div>
        <div class="xm9">
        	<div id="notice" class="alert alert-green" style="display:none"><span class="close"></span><strong>注意：</strong>您有<span id="noseeNoteNum"></span>条未读短息，<a href="${ctx}/pages/NoteReceive/getNoseeNote.do">点击查看</a>。</div>
		<!--<div class="alert">
                <h4>拼图前端框架介绍</h4>
                <p class="text-gray padding-top">拼图是优秀的响应式前端CSS框架，国内前端框架先驱及领导者，自动适应手机、平板、电脑等设备，让前端开发像游戏般快乐、简单、灵活、便捷。</p>
            	<a target="_blank" class="button bg-dot icon-code" href="pintuer2.zip"> 下载示例代码</a> 
            	<a target="_blank" class="button bg-main icon-download" href="http://www.pintuer.com/pintuer.zip"> 下载拼图框架</a> 
            	<a target="_blank" class="button border-main icon-file" href="http://www.pintuer.com/"> 拼图使用教程</a>
            </div>
            <div class="panel">
            	<div class="panel-head"><strong>系统信息</strong></div>
                <table class="table">
                	<tr><th colspan="2">服务器信息</th><th colspan="2">系统信息</th></tr>
                    <tr><td width="110" align="right">操作系统：</td><td>Windows 2008</td><td width="90" align="right">系统开发：</td><td><a href="http://www.pintuer.com" target="_blank">拼图前端框架</a></td></tr>
                    <tr><td align="right">Web服务器：</td><td>Apache</td><td align="right">主页：</td><td><a href="http://www.pintuer.com" target="_blank">http://www.pintuer.com</a></td></tr>
                    <tr><td align="right">程序语言：</td><td>PHP</td><td align="right">演示：</td><td><a href="http://demo.pintuer.com" target="_blank">http://demo.pintuer.com</a></td></tr>
                    <tr><td align="right">数据库：</td><td>MySQL</td><td align="right">群交流：</td><td><a href="http://shang.qq.com/wpa/qunwpa?idkey=a08e4d729d15d32cec493212f7672a6a312c7e59884a959c47ae7a846c3fadc1" target="_blank">201916085</a> (点击加入)</td></tr>
                </table>
            </div> -->
        </div>
    </div>

</div>

</body>
</html>
