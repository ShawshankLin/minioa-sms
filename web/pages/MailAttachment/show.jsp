<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=MailAttachment.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/MailAttachment/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/MailAttachment/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_MID%></td>	
				<td><s:property value='%{model.mid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_MDATE%></td>	
				<td><s:property value="%{model.mdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_UUID%></td>	
				<td><s:property value='%{model.uuid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_FILENAME%></td>	
				<td><s:property value='%{model.filename}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_FILETYPE%></td>	
				<td><s:property value='%{model.filetype}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_FILESIZE%></td>	
				<td><s:property value='%{model.filesize}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=MailAttachment.ALIAS_OLDNAME%></td>	
				<td><s:property value='%{model.oldname}'/>&nbsp;</td>
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