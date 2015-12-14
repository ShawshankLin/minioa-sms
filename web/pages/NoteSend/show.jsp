<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=NoteSend.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/NoteSend/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/NoteSend/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_MID%></td>	
				<td><s:property value='%{model.mid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_MDATE%></td>	
				<td><s:property value="%{model.mdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_UUID%></td>	
				<td><s:property value='%{model.uuid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_RECIPIENT%></td>	
				<td><s:property value='%{model.recipient}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_SUBJECT%></td>	
				<td><s:property value='%{model.subject}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_MESSAGE%></td>	
				<td><s:property value='%{model.message}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_NOTESTATUS%></td>	
				<td><s:property value='%{model.notestatus}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_SENDLIST%></td>	
				<td><s:property value='%{model.sendlist}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_SENDID%></td>	
				<td><s:property value='%{model.sendid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_MSG_TXT%></td>	
				<td><s:property value='%{model.msgTxt}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_TYPE%></td>	
				<td><s:property value='%{model.type}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=NoteSend.ALIAS_URL%></td>	
				<td><s:property value='%{model.url}'/>&nbsp;</td>
			</tr>
		</table>
	</s:form>
	<script>
		$(function(){
			$("tr:odd").addClass("odd");
			$("tr:even").addClass("even");
		});
	</script>
</rapid:override>


<%@ include file="base.jsp" %>