<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=Log.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=Log.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_TAG}" key="tag" value="%{model.tag}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_REF_ID}" key="refId" value="%{model.refId}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_SUMMARY}" key="summary" value="%{model.summary}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_DETAILS}" key="details" value="%{model.details}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Log@ALIAS_IP}" key="ip" value="%{model.ip}" cssClass="" required="false" />
	
