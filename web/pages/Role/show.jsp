<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=Role.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/Role/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Role/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_MID%></td>	
				<td><s:property value='%{model.mid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_MDATE%></td>	
				<td><s:property value="%{model.mdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_UUID%></td>	
				<td><s:property value='%{model.uuid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_ROLE_NAME%></td>	
				<td><s:property value='%{model.roleName}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_ROLE_DESC%></td>	
				<td><s:property value='%{model.roleDesc}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_ROLE_MAIL_NUM%></td>	
				<td><s:property value='%{model.roleMailNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_ROLE_NOTE_NUM%></td>	
				<td><s:property value='%{model.roleNoteNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_PERSON_MAIL_NUM%></td>	
				<td><s:property value='%{model.personMailNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_PERSON_NOTE_NUM%></td>	
				<td><s:property value='%{model.personNoteNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_NOREADNUM%></td>	
				<td><s:property value='%{model.noreadnum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Role.ALIAS_MAILSIZE%></td>	
				<td><s:property value='%{model.mailsize}'/>&nbsp;</td>
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