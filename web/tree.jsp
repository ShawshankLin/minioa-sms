<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" “http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="<%=basePath%>/scripts/zTree/js/jquery-1.4.4.min.js"></script>

	<script type="text/javascript" src="<%=basePath%>/scripts/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/zTree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript" src="<%=basePath%>/scripts/zTree/js/jquery.ztree.exedit-3.5.js"></script>
<link href="<%=basePath%>/scripts/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">

	var zTree;
	var setting = {
		view : {
			selectedMulti : false
		},
		edit : {

			enable : true,
			editNameSelectAll : true,
			removeTitle : "删除",
			renameTitle : "重命名"
		},
		data : {
			keep : {
				parent : true,
				leaf : true
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeRemove : beforeRemove,//点击删除时触发，用来提示用户是否确定删除
			beforeEditName : beforeEditName,//点击编辑时触发，用来判断该节点是否能编辑
			beforeRename : beforeRename,//编辑结束时触发，用来验证输入的数据是否符合要求
			onRemove : onRemove,//删除节点后触发，用户后台操作
			onRename : onRename,//编辑后触发，用于操作后台
			beforeDrag : beforeDrag,//用户禁止拖动节点
			onClick : clickNode,//点击节点触发的事件
			beforeDrag: beforeDrag
		}
	};
	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "父节点 1",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "去百度",
		url : 'http://www.baidu.com',
		target : '_blank'
	}, {
		id : 12,
		pId : 1,
		name : "叶子节点 1-2"
	}, {
		id : 13,
		pId : 1,
		name : "叶子节点 1-3"
	}, {
		id : 2,
		pId : 0,
		name : "父节点 2",
		open : true
	}, {
		id : 21,
		pId : 2,
		name : "叶子节点 2-1"
	}, {
		id : 22,
		pId : 2,
		name : "叶子节点 2-2"
	}, {
		id : 23,
		pId : 2,
		name : "叶子节点 2-3"
	}, {
		id : 3,
		pId : 0,
		name : "父节点 3",
		open : true
	}, {
		id : 31,
		pId : 3,
		name : "叶子节点 3-1"
	}, {
		id : 32,
		pId : 3,
		name : "叶子节点 3-2"
	}, {
		id : 33,
		pId : 3,
		name : "叶子节点 3-3"
	} ];
	$(document).ready(function() {
		zTree = $.fn.zTree.init($("#tree"), setting, zNodes);
	});
	function beforeDrag(treeId, treeNodes) {
		for (var i=0,l=treeNodes.length; i<l; i++) {
			if (treeNodes[i].drag === false) {
				return false;
			}
		}
		return true;
	}
	function beforeRemove(e, treeId, treeNode) {
		return confirm("你确定要删除吗？");
	}
	function onRemove(e, treeId, treeNode) {
		if (treeNode.isParent) {
			var childNodes = zTree.removeChildNodes(treeNode);
			var paramsArray = new Array();
			for (var i = 0; i < childNodes.length; i++) {
				paramsArray.push(childNodes[i].id);
			}
			alert("删除父节点的id为：" + treeNode.id + "\r\n他的孩子节点有："
					+ paramsArray.join(","));
			return;
		}
		alert("你点击要删除的节点的名称为：" + treeNode.name + "\r\n" + "节点id为："
				+ treeNode.id);
	}
	function beforeEditName(treeId, treeNode) {
		if (treeNode.isParent) {
			alert("不准编辑非叶子节点！");
			return false;
		}
		return true;
	}
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length < 3) {
			alert("名称不能少于3个字符！");
			return false;
		}
		return true;
	}
	function onRename(e, treeId, treeNode, isCancel) {
		alert("修改节点的id为：" + treeNode.id + "\n修改后的名称为：" + treeNode.name);
	}
	function clickNode(e, treeId, treeNode) {
		if (treeNode.id == 11) {
			location.href = treeNode.url;
		}
	}
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
</script>
<body>
	<ul id="tree" class="ztree"></ul>
</body>
</html>