<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${ctx}/scripts/common.js"></script>
	<!-- ZTree树形插件 -->
	<link rel="stylesheet" href="${ctx}/scripts/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/scripts/zTree/js/jquery-1.4.4.min.js"></script>  
	<script type="text/javascript" src="${ctx}/scripts/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/zTree/js/jquery.ztree.excheck-3.5.js"></script>  
	<script type="text/javascript">
	var name = getUrlParam("name");
	var id=getUrlParam("id");
	console.log(name);
	console.log(id);
	var sendname=window.opener.document.getElementById(name);
	var sendid=window.opener.document.getElementById(id);
	var setting = {
			  	view: {
					showLine: false
				},
				callback:{
					onCheck:function(){
						var treeObj=$.fn.zTree.getZTreeObj("tree");
			            nodes=treeObj.getCheckedNodes(true);
			            names="";
			            ids="";
			            for(var i=0;i<nodes.length;i++){
			            	if(nodes[i].id!=0){
			            		names+=nodes[i].name + ",";
				            	ids+=nodes[i].id+",";
			            	}
			            }
			            window.opener.document.getElementById(id).value=ids;
			            window.opener.document.getElementById(name).value=names;
			            
					}
				},
				check: {
					enable: true,
					chkStyle: "checkbox"
				},
				data: {
					simpleData: {
						enable: true
					}
				}
		  };
	 	var treeNodes;
	 	$(function(){  
	 	    $.ajax({  
	 	        async : false,  
	 	        cache:false,  
	 	        type: 'POST',  
	 	        dataType : "json",  
	 	        url: "${ctx}/pages/User/getUserTree.do",//请求的action路径  
	 	        error: function () {//请求失败处理函数  
	 	            alert('请求失败');  
	 	        },  
	 	        success:function(data){ //请求成功后处理函数。    
	 	        	console.log(data);
	 	            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes 
	 	           	treeNodes.icon="${ctx}/scripts/zTree/image/user.png";
	 	        }  
	 	    });  
	 	   	$.fn.zTree.init($("#tree"), setting, treeNodes);
	 	});
	</script>
  </head>
  
  <body>
    <ul id="tree" class="ztree"></ul>
    <button id="OKbtn" onclick="javascript:window.close();">确定</button>
  </body>
</html>
