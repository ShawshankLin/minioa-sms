<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=Role.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_MID}" key="mid" value="%{model.mid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=Role.ALIAS_MDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.mdateString}" onclick="WdatePicker({dateFmt:'<%=Role.FORMAT_MDATE%>'})" id="mdateString" name="mdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_UUID}" key="uuid" value="%{model.uuid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_ROLE_NAME}" key="roleName" value="%{model.roleName}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_ROLE_DESC}" key="roleDesc" value="%{model.roleDesc}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_ROLE_MAIL_NUM}" key="roleMailNum" value="%{model.roleMailNum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_ROLE_NOTE_NUM}" key="roleNoteNum" value="%{model.roleNoteNum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_PERSON_MAIL_NUM}" key="personMailNum" value="%{model.personMailNum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_PERSON_NOTE_NUM}" key="personNoteNum" value="%{model.personNoteNum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_NOREADNUM}" key="noreadnum" value="%{model.noreadnum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.Role@ALIAS_MAILSIZE}" key="mailsize" value="%{model.mailsize}" cssClass="validate-email validate-integer max-value-2147483647" required="false" />
	
