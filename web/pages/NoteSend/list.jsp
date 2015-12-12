<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@page import="com.minioa2.project.model.*"%>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
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
    <script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
    <link type="image/x-icon" href="http://www.pintuer.com/favicon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
    <script type="text/javascript">
    $(document).ready(function() {
		// 分页需要依赖的初始化动作
		window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
	});
	//批量删除短信
	function delBatch(){
		if($(":checked[name]").length>0){
			$("#queryForm").attr("action","${ctx}/pages/NoteSend/delBatch.do").submit();
		}else{
			alert("请选择删除的行！");
		}
		return false;	
	}
	//搜索发送短信
	function search(){
		var searchInfo=$("#searchInfo").val().trim();
		var searchType= $("ul[id='searchType']").find("li[class='bg-main']").attr("value");
		window.location.href=encodeURI(encodeURI("${ctx}/pages/NoteSend/search.do?searchType="+searchType+"&searchInfo="+searchInfo));
		return false;
	}

    </script>
</head>

<body>
<div class="admin">
	<form method="post" id="queryForm" action="${ctx}/pages/NoteSend/list.do">
    <div class="panel admin-panel">
    	<div class="panel-head"><strong>已发送短信</strong></div>
        <div class="line">
		  <div class="x7 padding">
		  	<input type="button" class="button button-small checkall" name="checkall" checkfor="items" value="全选" />
            <button type="button" class="button button-small border-dot" onclick="delBatch()">批量删除</button>
		  </div>
	      <div class="x5 padding">
	      	<div class="form-group">
			    <div class="field">
			      <div class="input-group">
			        <input type="text" class="input " name="keywords" size="50" placeholder="请输入收件人ID" id="searchInfo"//>
			        <div class="addbtn">
			          <div class="button-group">
					  <button type="button" class="button bg-main" onclick="search()">搜索</button>
					  <button type="button" class="button bg-main dropdown-toggle"><span class="downward"></span></button>
					  <ul class="drop-menu" id="searchType">
					    <li value="sendid" class="bg-main"><a href="javascript:void(0)" onclick="setSearchType(this)">收件人ID</a></li>
					    <li value="recipient"><a href="javascript:void(0)" onclick="setSearchType(this)" >收件人名称</a></li>
					    <li value="message"><a href="javascript:void(0)" onclick="setSearchType(this)">短信内容</a></li>
					  </ul>
					  </div>
			
			        </div>
			
			      </div>
			    </div>
			  </div>
	      </div>
		</div>
        <table class="table table-hover table-condensed">
        	<thead>
	        	<tr>
	        		<th>选择</th>
	        		<th>序号</th>
					<th sortColumn="notestatus" ><%=NoteSend.ALIAS_NOTESTATUS%></th>
					<th sortColumn="recipient" ><%=NoteSend.ALIAS_RECIPIENT%></th>
					<th sortColumn="message" ><%=NoteSend.ALIAS_MESSAGE%></th>
					<th sortColumn="CDATE_" ><%=NoteSend.ALIAS_CDATE%></th>
					<th>操作</th>
	        		<!-- <th width="45">选择</th><th width="120">分类</th><th width="*">名称</th><th width="100">时间</th><th width="100">操作</th> -->
	        	</tr>
        	</thead>
        	<tbody>
        	<c:forEach items="${page.result}" var="item" varStatus="status">
	            <tr>
            		<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
            		<td>${page.thisPageFirstElementNumber + status.index}</td>
            		<td>
            			<c:choose>
            				<c:when test="${item.notestatus=='see'}"><img alt="已读" src="${ctx}/images/note_read_see.gif"/></c:when>
            				<c:otherwise><img alt="未读" src="${ctx}/images/note_read_nosee.gif"/></c:otherwise>
            			</c:choose>
            		</td>
					<td><c:out value='${item.recipient}'/>&nbsp;</td>
					<td><a href="javascript:void(0)" data-toggle="click" data-target="#${item.id}" data-mask="1" data-width="50%"><c:out value='${item.message}'/></a>&nbsp;</td>
					<td><c:out value='${item.cdateString}'/>&nbsp;</td>
            		<td>
            			<a class="button border-blue button-little dialogs" href="javascript:void(0)" data-toggle="click" data-target="#${item.id}" data-mask="1" data-width="50%">查看详情</a> 
            			<a class="button border-blue button-little" href="${ctx}/pages/NoteSend/resend.do?id=${item.id}">重发</a> 
						<a class="button border-dot button-little dialogs"  href="javascript:void(0)" data-toggle="click" data-target="#confirmDel" data-mask="1" data-width="50%">删除</a>
            		</td>
	            </tr>
	            <!-- 短信详情对话框 -->
	            <div id="${item.id}">
				  <div class="dialog">
				    <div class="dialog-head">
				      <span class="close rotate-hover"></span>
				      <strong>收信人：${item.recipient}</strong>
				    </div>
				    <div class="dialog-body">
				      ${item.message}
				    </div>
				    <!-- <div class="dialog-foot">
				      <button class="button dialog-close">取消</button>
				      <button class="button bg-green">确认</button>
				    </div> -->
				  </div>
				</div>
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
				      <a class="button bg-green" href="${ctx}/pages/NoteSend/delete.do?id=${item.id}">确认</a>
				    </div>
				  </div>
				</div>
            </c:forEach>
            </tbody>
        </table>
        <div class="panel-foot text-center">
            <simpletable:pageToolbar page="${page}">
			</simpletable:pageToolbar>
        </div>
    </div>
    </form>
</div>


	
</body>
</html>
