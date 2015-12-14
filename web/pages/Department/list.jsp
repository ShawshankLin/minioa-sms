<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Department.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/Department/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=Department.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=Department.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=Department.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=Department.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=Department.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=Department.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Department.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_ORG_ID%></td>		
					<td>
						<input type="text" value="${query.orgId}" id="orgId" name="orgId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_PARENT_ID%></td>		
					<td>
						<input type="text" value="${query.parentId}" id="parentId" name="parentId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_DEPA_NAME%></td>		
					<td>
						<input type="text" value="${query.depaName}" id="depaName" name="depaName" maxlength="100"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Department.ALIAS_DEPA_DESC%></td>		
					<td>
						<input type="text" value="${query.depaDesc}" id="depaDesc" name="depaDesc" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=Department.ALIAS_SEQUENCE%></td>		
					<td>
						<input type="text" value="${query.sequence}" id="sequence" name="sequence" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/Department/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/Department/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/Department/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Department@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=Department.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=Department.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=Department.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=Department.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=Department.ALIAS_UUID%></th>
				<th sortColumn="orgId" ><%=Department.ALIAS_ORG_ID%></th>
				<th sortColumn="parentId" ><%=Department.ALIAS_PARENT_ID%></th>
				<th sortColumn="depaName" ><%=Department.ALIAS_DEPA_NAME%></th>
				<th sortColumn="depaDesc" ><%=Department.ALIAS_DEPA_DESC%></th>
				<th sortColumn="sequence" ><%=Department.ALIAS_SEQUENCE%></th>
	
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
				<td><c:out value='${item.mid}'/>&nbsp;</td>
				<td><c:out value='${item.mdateString}'/>&nbsp;</td>
				<td><c:out value='${item.uuid}'/>&nbsp;</td>
				<td><c:out value='${item.orgId}'/>&nbsp;</td>
				<td><c:out value='${item.parentId}'/>&nbsp;</td>
				<td><c:out value='${item.depaName}'/>&nbsp;</td>
				<td><c:out value='${item.depaDesc}'/>&nbsp;</td>
				<td><c:out value='${item.sequence}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/Department/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/Department/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Department@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

