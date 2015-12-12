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
    <!-- KindEditor编辑器插件 -->
    <link rel="stylesheet" href="../../kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="../../kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="../../kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="../../kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="../../kindeditor/plugins/code/prettify.js"></script>
    
    <script type="text/javascript">
	  KindEditor.ready(function(K) {
	
			var editor = K.create('textarea[name="message"]', {
	
				cssPath : '../../kindeditor/plugins/code/prettify.css',
	
				uploadJson : '../../kindeditor/jsp/upload_json.jsp',
	
				fileManagerJson : '../../kindeditor/jsp/file_manager_json.jsp',
	
				allowFileManager : true,
	
				afterCreate : function() {
	
					var self = this;
	
					K.ctrl(document, 13, function() {
	
						self.sync();
	
						document.forms['memo'].submit();
	
					});
	
					K.ctrl(self.edit.doc, 13, function() {
	
						self.sync();
	
						document.forms['memo'].submit();
	
					});
	
				}
	
			});
	
			prettyPrint();
		});
	  //清空发件人
	  function clearup(){
	  	$("#sendname").val("");
	  	$("#sendid").val("");
	  }
	</script>
</head>

<body>
<div class="admin">
	<div class="line-big">
		<form method="post" class="form-x" name="memo" action="${ctx}/pages/NoteSend/save.do">
		  <div class="form-group">
		    <div class="label"><label for="username">收件人</label></div>
		    <div class="field">
		    	<input type="hidden" id="sendid" name="sendid" value="${user.id}"/>
		    	<textarea name="sendname" id="sendname" readonly="readonly"  class="input" rows="5" cols="5"  style="width:600px;height:50px;display:inline">${user.userName}</textarea>
		    	<a href="javascript:void(0)" onclick="javascript:var popWin=window.open('../Tree/user_tree.jsp?name=sendname&amp;id=sendid', '选择发送人', 'height=500, width=350, top=10, left=600, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no, alwaysRaised=yes');popWin.focus();" class="text-big">选择收件人</a>
		    	<a href="javascript:void(0)" onclick="clearup()" class="text-big text-dot">清空</a>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="label"><label>内容</label></div>
		    <div class="field">
		      <textarea name="message" cols="108" rows="15" id="message"></textarea>
		    </div>
		  </div>
		  <div class="form-button"><button class="button bg-main" type="submit">发送短信</button></div>
		</form>
	</div>
</div>

</body>
</html>
