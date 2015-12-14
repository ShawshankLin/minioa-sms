<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@page import="cn.edu.dglg.cis.subject.model.*"%>
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
	<form method="post">
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>角色管理</strong></div>
        <div class="padding border-bottom">
            <input type="button" class="button button-small checkall" name="checkall" checkfor="id" value="全选" />
            <input type="button" class="button button-small border-green" value="添加文章" />
            <input type="button" class="button button-small border-yellow" value="批量删除" />
            <input type="button" class="button button-small border-blue" value="回收站" />
        </div>
        <table class="table table-hover">
        	<thead>
	        	<tr>
	        		<th>选择</th>
	        		<th>序号</th>					
					<th sortColumn="roleName" ><%=Role.ALIAS_ROLE_NAME%></th>
					<th sortColumn="roleDesc" ><%=Role.ALIAS_ROLE_DESC%></th>
					<th sortColumn="roleMailNum" ><%=Role.ALIAS_ROLE_MAIL_NUM%></th>
					<th sortColumn="roleNoteNum" ><%=Role.ALIAS_ROLE_NOTE_NUM%></th>
					<th sortColumn="personMailNum" ><%=Role.ALIAS_PERSON_MAIL_NUM%></th>
					<th sortColumn="personNoteNum" ><%=Role.ALIAS_PERSON_NOTE_NUM%></th>
					<th sortColumn="noreadnum" ><%=Role.ALIAS_NOREADNUM%></th>
					<th sortColumn="mailsize" ><%=Role.ALIAS_MAILSIZE%></th>
	        		<!-- <th width="45">选择</th><th width="120">分类</th><th width="*">名称</th><th width="100">时间</th><th width="100">操作</th> -->
	        	</tr>
        	</thead>
        	<tbody>
        	<c:forEach items="${page.result}" var="item" varStatus="status">
	            <tr>
            		<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
            		<td>${page.thisPageFirstElementNumber + status.index}</td>
            		<td><c:out value='${item.tag}'/>&nbsp;</td>
            		<td><c:out value='${item.summary}'/>&nbsp;</td>
            		<td><c:out value='${item.cid}'/>&nbsp;</td>
            		<td><c:out value='${item.cdate}'/>&nbsp;</td>
            		<td><c:out value='${item.ip}'/>&nbsp;</td>
            		<td>
            			<a class="button border-dot button-little dialogs" href="javascript:void(0)" data-toggle="click" data-target="#confirmDel" data-mask="1" data-width="50%">删除</a>
            		</td>
            		<!-- 删除确认对话框 -->
					<div id="confirmDel">
					  <div class="dialog">
					    <div class="dialog-head">
					      <span class="close rotate-hover"></span>
					      <strong>消息</strong>
					    </div>
					    <div class="dialog-body">
					      	你，确定要删除吗？
					    </div>
					    <div class="dialog-foot">
					      <button class="button dialog-close">取消</button>
					      <a class="button bg-green" href="${ctx}/pages/Role/delete.do?id=${item.id}">确认</a>
					    </div>
					  </div>
					</div>
	            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="panel-foot text-center">
            <ul class="pagination"><li><a href="#">上一页</a></li></ul>
            <ul class="pagination pagination-group">
                <li><a href="#">1</a></li>
                <li class="active"><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            </ul>
            <ul class="pagination"><li><a href="#">下一页</a></li></ul>
        </div>
    </div>
    </form>
</div>
	
</body>
</html>
