<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=Department.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/Department/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Department/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_MID%></td>	
				<td><s:property value='%{model.mid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_MDATE%></td>	
				<td><s:property value="%{model.mdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_UUID%></td>	
				<td><s:property value='%{model.uuid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_ORG_ID%></td>	
				<td><s:property value='%{model.orgId}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_PARENT_ID%></td>	
				<td><s:property value='%{model.parentId}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_DEPA_NAME%></td>	
				<td><s:property value='%{model.depaName}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_DEPA_DESC%></td>	
				<td><s:property value='%{model.depaDesc}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Department.ALIAS_SEQUENCE%></td>	
				<td><s:property value='%{model.sequence}'/>&nbsp;</td>
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