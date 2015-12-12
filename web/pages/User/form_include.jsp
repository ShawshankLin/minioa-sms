<%@page import="com.minioa2.project.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

	<s:hidden id="id" name="id" />

<!-- ONGL access static field: @package.class@field or @vs@field -->
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_CID}" key="cid" value="%{model.cid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=User.ALIAS_CDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.cdateString}" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_CDATE%>'})" id="cdateString" name="cdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_MID}" key="mid" value="%{model.mid}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
	<tr>	
		<td class="tdLabel">
			<%=User.ALIAS_MDATE%>:
		</td>	
		<td>
		<input type="text" value="${model.mdateString}" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_MDATE%>'})" id="mdateString" name="mdateString"   class="" />
		</td>
	</tr>
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_UUID}" key="uuid" value="%{model.uuid}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_USER_NAME}" key="userName" value="%{model.userName}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_DEPA_ID}" key="depaId" value="%{model.depaId}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_JOB_ID}" key="jobId" value="%{model.jobId}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_EMAIL}" key="email" value="%{model.email}" cssClass="validate-email " required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_PASSWORD}" key="password" value="%{model.password}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_PHONE}" key="phone" value="%{model.phone}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_MOBILE_PHONE}" key="mobilePhone" value="%{model.mobilePhone}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_GENDER}" key="gender" value="%{model.gender}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_DISPLAY_NAME}" key="displayName" value="%{model.displayName}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_IS_LOCK}" key="isLock" value="%{model.isLock}" cssClass="" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_JOB_ID2}" key="jobId2" value="%{model.jobId2}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_NOTE_SEND_NUM}" key="noteSendNum" value="%{model.noteSendNum}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_MAIL_SEND_NUM}" key="mailSendNum" value="%{model.mailSendNum}" cssClass="validate-email validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_STATUS}" key="status" value="%{model.status}" cssClass="validate-integer max-value-2147483647" required="false" />
	
	
			<s:textfield label="%{@com.minioa2.project.model.User@ALIAS_CLIENTID}" key="clientid" value="%{model.clientid}" cssClass="" required="false" />
	
