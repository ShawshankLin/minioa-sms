<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Log.TABLE_ALIAS%> 维护</title>
	
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/Log/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=Log.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Log.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=Log.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Log.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=Log.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Log.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=Log.ALIAS_TAG%></td>		
					<td>
						<input type="text" value="${query.tag}" id="tag" name="tag" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=Log.ALIAS_REF_ID%></td>		
					<td>
						<input type="text" value="${query.refId}" id="refId" name="refId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Log.ALIAS_SUMMARY%></td>		
					<td>
						<input type="text" value="${query.summary}" id="summary" name="summary" maxlength="4000"  class=""/>
					</td>
					<td class="tdLabel"><%=Log.ALIAS_DETAILS%></td>		
					<td>
						<input type="text" value="${query.details}" id="details" name="details" maxlength="4000"  class=""/>
					</td>
					<td class="tdLabel"><%=Log.ALIAS_IP%></td>		
					<td>
						<input type="text" value="${query.ip}" id="ip" name="ip" maxlength="45"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/Log/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/Log/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/Log/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Log@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=Log.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=Log.ALIAS_CDATE%></th>
				<th sortColumn="tag" ><%=Log.ALIAS_TAG%></th>
				<th sortColumn="refId" ><%=Log.ALIAS_REF_ID%></th>
				<th sortColumn="summary" ><%=Log.ALIAS_SUMMARY%></th>
				<th sortColumn="details" ><%=Log.ALIAS_DETAILS%></th>
				<th sortColumn="ip" ><%=Log.ALIAS_IP%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.cid}'/>&nbsp;</td>
				<td><c:out value='${item.cdateString}'/>&nbsp;</td>
				<td><c:out value='${item.tag}'/>&nbsp;</td>
				<td><c:out value='${item.refId}'/>&nbsp;</td>
				<td><c:out value='${item.summary}'/>&nbsp;</td>
				<td><c:out value='${item.details}'/>&nbsp;</td>
				<td><c:out value='${item.ip}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/Log/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/Log/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Log@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

