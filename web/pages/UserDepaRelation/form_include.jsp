<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.UserDepaRelation@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=UserDepaRelation.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=UserDepaRelation.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
	
	
	
		<s:select label="%{@com.minioa2.project.model.UserDepaRelation@ALIAS_USERID}" key="userid" list="%{#attr.userList }" listKey="id" listValue="id" value="%{model.userid}" />
		<s:select label="%{@com.minioa2.project.model.UserDepaRelation@ALIAS_DEPAID}" key="depaid" list="%{#attr.departmentList }" listKey="id" listValue="id" value="%{model.depaid}" />
