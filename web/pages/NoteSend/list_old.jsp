<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=NoteSend.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/NoteSend/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=NoteSend.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=NoteSend.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=NoteSend.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=NoteSend.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=NoteSend.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=NoteSend.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=NoteSend.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=NoteSend.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=NoteSend.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=NoteSend.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_RECIPIENT%></td>		
					<td>
						<input type="text" value="${query.recipient}" id="recipient" name="recipient" maxlength="65535"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_SUBJECT%></td>		
					<td>
						<input type="text" value="${query.subject}" id="subject" name="subject" maxlength="200"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_MESSAGE%></td>		
					<td>
						<input type="text" value="${query.message}" id="message" name="message" maxlength="65535"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=NoteSend.ALIAS_NOTESTATUS%></td>		
					<td>
						<input type="text" value="${query.notestatus}" id="notestatus" name="notestatus" maxlength="32"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_SENDLIST%></td>		
					<td>
						<input type="text" value="${query.sendlist}" id="sendlist" name="sendlist" maxlength="2048"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_SENDID%></td>		
					<td>
						<input type="text" value="${query.sendid}" id="sendid" name="sendid" maxlength="65535"  class=""/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_MSG_TXT%></td>		
					<td>
						<input type="text" value="${query.msgTxt}" id="msgTxt" name="msgTxt" maxlength="65535"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=NoteSend.ALIAS_TYPE%></td>		
					<td>
						<input type="text" value="${query.type}" id="type" name="type" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=NoteSend.ALIAS_URL%></td>		
					<td>
						<input type="text" value="${query.url}" id="url" name="url" maxlength="2048"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/NoteSend/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/NoteSend/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/NoteSend/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.NoteSend@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=NoteSend.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=NoteSend.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=NoteSend.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=NoteSend.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=NoteSend.ALIAS_UUID%></th>
				<th sortColumn="recipient" ><%=NoteSend.ALIAS_RECIPIENT%></th>
				<th sortColumn="subject" ><%=NoteSend.ALIAS_SUBJECT%></th>
				<th sortColumn="message" ><%=NoteSend.ALIAS_MESSAGE%></th>
				<th sortColumn="notestatus" ><%=NoteSend.ALIAS_NOTESTATUS%></th>
				<th sortColumn="sendlist" ><%=NoteSend.ALIAS_SENDLIST%></th>
				<th sortColumn="sendid" ><%=NoteSend.ALIAS_SENDID%></th>
				<th sortColumn="msg_txt" ><%=NoteSend.ALIAS_MSG_TXT%></th>
				<th sortColumn="type" ><%=NoteSend.ALIAS_TYPE%></th>
				<th sortColumn="url" ><%=NoteSend.ALIAS_URL%></th>
	
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
				<td><c:out value='${item.recipient}'/>&nbsp;</td>
				<td><c:out value='${item.subject}'/>&nbsp;</td>
				<td><c:out value='${item.message}'/>&nbsp;</td>
				<td><c:out value='${item.notestatus}'/>&nbsp;</td>
				<td><c:out value='${item.sendlist}'/>&nbsp;</td>
				<td><c:out value='${item.sendid}'/>&nbsp;</td>
				<td><c:out value='${item.msgTxt}'/>&nbsp;</td>
				<td><c:out value='${item.type}'/>&nbsp;</td>
				<td><c:out value='${item.url}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/NoteSend/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/NoteSend/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.NoteSend@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

