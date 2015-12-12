<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=Department.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_MID}" key="mid" value="%{model.mid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=Department.ALIAS_MDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.mdateString}" onclick="WdatePicker({dateFmt:'<%=Department.FORMAT_MDATE%>'})" id="mdateString" name="mdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_UUID}" key="uuid" value="%{model.uuid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_ORG_ID}" key="orgId" value="%{model.orgId}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_PARENT_ID}" key="parentId" value="%{model.parentId}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_DEPA_NAME}" key="depaName" value="%{model.depaName}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_DEPA_DESC}" key="depaDesc" value="%{model.depaDesc}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Department@ALIAS_SEQUENCE}" key="sequence" value="%{model.sequence}" cssClass="validate-integer max-value-2147483647" required="false" />
	
