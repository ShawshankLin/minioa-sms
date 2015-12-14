<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=MailSend.TABLE_ALIAS%> 维护</title>
	
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
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/MailSend/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=MailSend.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=MailSend.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailSend.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=MailSend.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailSend.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=MailSend.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailSend.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=MailSend.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=MailSend.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=MailSend.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_RECIPIENT%></td>		
					<td>
						<input type="text" value="${query.recipient}" id="recipient" name="recipient" maxlength="2147483647"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_SUBJECT%></td>		
					<td>
						<input type="text" value="${query.subject}" id="subject" name="subject" maxlength="200"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_MESSAGE%></td>		
					<td>
						<input type="text" value="${query.message}" id="message" name="message" maxlength="65535"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=MailSend.ALIAS_SENDTYPE%></td>		
					<td>
						<input type="text" value="${query.sendtype}" id="sendtype" name="sendtype" maxlength="10"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_MAILSTATUS%></td>		
					<td>
						<input type="text" value="${query.mailstatus}" id="mailstatus" name="mailstatus" maxlength="32"  class="validate-email "/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_SENDUSERLIST%></td>		
					<td>
						<input type="text" value="${query.senduserlist}" id="senduserlist" name="senduserlist" maxlength="2147483647"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_SENDID%></td>		
					<td>
						<input type="text" value="${query.sendid}" id="sendid" name="sendid" maxlength="2147483647"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=MailSend.ALIAS_MAILTYPE%></td>		
					<td>
						<input type="text" value="${query.mailtype}" id="mailtype" name="mailtype" maxlength="32"  class="validate-email "/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_MSG_TXT%></td>		
					<td>
						<input type="text" value="${query.msgTxt}" id="msgTxt" name="msgTxt" maxlength="65535"  class=""/>
					</td>
					<td class="tdLabel"><%=MailSend.ALIAS_SIZE%></td>		
					<td>
						<input type="text" value="${query.size}" id="size" name="size" maxlength="45"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/MailSend/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/MailSend/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/MailSend/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.MailSend@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=MailSend.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=MailSend.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=MailSend.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=MailSend.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=MailSend.ALIAS_UUID%></th>
				<th sortColumn="recipient" ><%=MailSend.ALIAS_RECIPIENT%></th>
				<th sortColumn="subject" ><%=MailSend.ALIAS_SUBJECT%></th>
				<th sortColumn="message" ><%=MailSend.ALIAS_MESSAGE%></th>
				<th sortColumn="sendtype" ><%=MailSend.ALIAS_SENDTYPE%></th>
				<th sortColumn="mailstatus" ><%=MailSend.ALIAS_MAILSTATUS%></th>
				<th sortColumn="senduserlist" ><%=MailSend.ALIAS_SENDUSERLIST%></th>
				<th sortColumn="sendid" ><%=MailSend.ALIAS_SENDID%></th>
				<th sortColumn="mailtype" ><%=MailSend.ALIAS_MAILTYPE%></th>
				<th sortColumn="msg_txt" ><%=MailSend.ALIAS_MSG_TXT%></th>
				<th sortColumn="size" ><%=MailSend.ALIAS_SIZE%></th>
	
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
				<td><c:out value='${item.sendtype}'/>&nbsp;</td>
				<td><c:out value='${item.mailstatus}'/>&nbsp;</td>
				<td><c:out value='${item.senduserlist}'/>&nbsp;</td>
				<td><c:out value='${item.sendid}'/>&nbsp;</td>
				<td><c:out value='${item.mailtype}'/>&nbsp;</td>
				<td><c:out value='${item.msgTxt}'/>&nbsp;</td>
				<td><c:out value='${item.size}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/MailSend/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/MailSend/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.MailSend@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

