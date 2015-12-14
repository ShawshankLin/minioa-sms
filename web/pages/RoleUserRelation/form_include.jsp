<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.RoleUserRelation@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=RoleUserRelation.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=RoleUserRelation.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
	
	
	
		<s:select label="%{@com.minioa2.project.model.RoleUserRelation@ALIAS_ROLE_ID}" key="roleId" list="%{#attr.roleList }" listKey="id" listValue="id" value="%{model.roleId}" />
		<s:select label="%{@com.minioa2.project.model.RoleUserRelation@ALIAS_USER_ID}" key="userId" list="%{#attr.userList }" listKey="id" listValue="id" value="%{model.userId}" />
