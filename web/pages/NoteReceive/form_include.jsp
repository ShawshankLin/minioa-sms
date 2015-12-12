<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=NoteReceive.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=NoteReceive.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_MID}" key="mid" value="%{model.mid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=NoteReceive.ALIAS_MDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.mdateString}" onclick="WdatePicker({dateFmt:'<%=NoteReceive.FORMAT_MDATE%>'})" id="mdateString" name="mdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_UUID}" key="uuid" value="%{model.uuid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_RECIPIENT}" key="recipient" value="%{model.recipient}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_SUBJECT}" key="subject" value="%{model.subject}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_MESSAGE}" key="message" value="%{model.message}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_NOTESTATUS}" key="notestatus" value="%{model.notestatus}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_SENDLIST}" key="sendlist" value="%{model.sendlist}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_SENDID}" key="sendid" value="%{model.sendid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_MSG_TXT}" key="msgTxt" value="%{model.msgTxt}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_TYPE}" key="type" value="%{model.type}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.NoteReceive@ALIAS_URL}" key="url" value="%{model.url}" cssClass="" required="false" />
	
