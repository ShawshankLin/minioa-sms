<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=Log.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/Log/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/Log/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_TAG%></td>	
				<td><s:property value='%{model.tag}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_REF_ID%></td>	
				<td><s:property value='%{model.refId}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_SUMMARY%></td>	
				<td><s:property value='%{model.summary}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_DETAILS%></td>	
				<td><s:property value='%{model.details}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=Log.ALIAS_IP%></td>	
				<td><s:property value='%{model.ip}'/>&nbsp;</td>
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