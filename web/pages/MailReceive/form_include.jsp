<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=MailReceive.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=MailReceive.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_MID}" key="mid" value="%{model.mid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=MailReceive.ALIAS_MDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.mdateString}" onclick="WdatePicker({dateFmt:'<%=MailReceive.FORMAT_MDATE%>'})" id="mdateString" name="mdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_UUID}" key="uuid" value="%{model.uuid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_RECIPIENT}" key="recipient" value="%{model.recipient}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_SUBJECT}" key="subject" value="%{model.subject}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_MESSAGE}" key="message" value="%{model.message}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_SENDTYPE}" key="sendtype" value="%{model.sendtype}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_MAILSTATUS}" key="mailstatus" value="%{model.mailstatus}" cssClass="validate-email " required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_SENDUSERLIST}" key="senduserlist" value="%{model.senduserlist}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_SENDID}" key="sendid" value="%{model.sendid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_MAILTYPE}" key="mailtype" value="%{model.mailtype}" cssClass="validate-email " required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_MSG_TXT}" key="msgTxt" value="%{model.msgTxt}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.MailReceive@ALIAS_SIZE}" key="size" value="%{model.size}" cssClass="" required="false" />
	
