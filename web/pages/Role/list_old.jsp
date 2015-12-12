<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=Role.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/Role/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=Role.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=Role.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=Role.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=Role.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=Role.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=Role.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Role.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_ROLE_NAME%></td>		
					<td>
						<input type="text" value="${query.roleName}" id="roleName" name="roleName" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_ROLE_DESC%></td>		
					<td>
						<input type="text" value="${query.roleDesc}" id="roleDesc" name="roleDesc" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_ROLE_MAIL_NUM%></td>		
					<td>
						<input type="text" value="${query.roleMailNum}" id="roleMailNum" name="roleMailNum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Role.ALIAS_ROLE_NOTE_NUM%></td>		
					<td>
						<input type="text" value="${query.roleNoteNum}" id="roleNoteNum" name="roleNoteNum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_PERSON_MAIL_NUM%></td>		
					<td>
						<input type="text" value="${query.personMailNum}" id="personMailNum" name="personMailNum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_PERSON_NOTE_NUM%></td>		
					<td>
						<input type="text" value="${query.personNoteNum}" id="personNoteNum" name="personNoteNum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=Role.ALIAS_NOREADNUM%></td>		
					<td>
						<input type="text" value="${query.noreadnum}" id="noreadnum" name="noreadnum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=Role.ALIAS_MAILSIZE%></td>		
					<td>
						<input type="text" value="${query.mailsize}" id="mailsize" name="mailsize" maxlength="10"  class="validate-email validate-integer max-value-2147483647"/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/Role/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/Role/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/Role/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Role@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=Role.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=Role.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=Role.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=Role.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=Role.ALIAS_UUID%></th>
				<th sortColumn="roleName" ><%=Role.ALIAS_ROLE_NAME%></th>
				<th sortColumn="roleDesc" ><%=Role.ALIAS_ROLE_DESC%></th>
				<th sortColumn="roleMailNum" ><%=Role.ALIAS_ROLE_MAIL_NUM%></th>
				<th sortColumn="roleNoteNum" ><%=Role.ALIAS_ROLE_NOTE_NUM%></th>
				<th sortColumn="personMailNum" ><%=Role.ALIAS_PERSON_MAIL_NUM%></th>
				<th sortColumn="personNoteNum" ><%=Role.ALIAS_PERSON_NOTE_NUM%></th>
				<th sortColumn="noreadnum" ><%=Role.ALIAS_NOREADNUM%></th>
				<th sortColumn="mailsize" ><%=Role.ALIAS_MAILSIZE%></th>
	
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
				<td><c:out value='${item.roleName}'/>&nbsp;</td>
				<td><c:out value='${item.roleDesc}'/>&nbsp;</td>
				<td><c:out value='${item.roleMailNum}'/>&nbsp;</td>
				<td><c:out value='${item.roleNoteNum}'/>&nbsp;</td>
				<td><c:out value='${item.personMailNum}'/>&nbsp;</td>
				<td><c:out value='${item.personNoteNum}'/>&nbsp;</td>
				<td><c:out value='${item.noreadnum}'/>&nbsp;</td>
				<td><c:out value='${item.mailsize}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/Role/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/Role/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.Role@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

