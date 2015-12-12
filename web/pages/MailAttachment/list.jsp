<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=MailAttachment.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/MailAttachment/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=MailAttachment.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=MailAttachment.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailAttachment.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=MailAttachment.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailAttachment.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=MailAttachment.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailAttachment.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=MailAttachment.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailAttachment.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=MailAttachment.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_FILENAME%></td>		
					<td>
						<input type="text" value="${query.filename}" id="filename" name="filename" maxlength="200"  class=""/>
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_FILETYPE%></td>		
					<td>
						<input type="text" value="${query.filetype}" id="filetype" name="filetype" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=MailAttachment.ALIAS_FILESIZE%></td>		
					<td>
						<input type="text" value="${query.filesize}" id="filesize" name="filesize" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=MailAttachment.ALIAS_OLDNAME%></td>		
					<td>
						<input type="text" value="${query.oldname}" id="oldname" name="oldname" maxlength="200"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/MailAttachment/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/MailAttachment/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/MailAttachment/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.MailAttachment@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=MailAttachment.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=MailAttachment.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=MailAttachment.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=MailAttachment.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=MailAttachment.ALIAS_UUID%></th>
				<th sortColumn="filename" ><%=MailAttachment.ALIAS_FILENAME%></th>
				<th sortColumn="filetype" ><%=MailAttachment.ALIAS_FILETYPE%></th>
				<th sortColumn="filesize" ><%=MailAttachment.ALIAS_FILESIZE%></th>
				<th sortColumn="oldname" ><%=MailAttachment.ALIAS_OLDNAME%></th>
	
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
				<td><c:out value='${item.filename}'/>&nbsp;</td>
				<td><c:out value='${item.filetype}'/>&nbsp;</td>
				<td><c:out value='${item.filesize}'/>&nbsp;</td>
				<td><c:out value='${item.oldname}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/MailAttachment/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/MailAttachment/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.MailAttachment@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

