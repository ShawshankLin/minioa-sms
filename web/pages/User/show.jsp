<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<title><%=User.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="/pages/User/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}/pages/User/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="id" id="id" value="%{model.id}"/>
	
		<table class="tablelist">
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_CID%></td>	
				<td><s:property value='%{model.cid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_CDATE%></td>	
				<td><s:property value="%{model.cdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_MID%></td>	
				<td><s:property value='%{model.mid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_MDATE%></td>	
				<td><s:property value="%{model.mdateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_UUID%></td>	
				<td><s:property value='%{model.uuid}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_USER_NAME%></td>	
				<td><s:property value='%{model.userName}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_DEPA_ID%></td>	
				<td><s:property value='%{model.depaId}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_JOB_ID%></td>	
				<td><s:property value='%{model.jobId}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_EMAIL%></td>	
				<td><s:property value='%{model.email}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_PASSWORD%></td>	
				<td><s:property value='%{model.password}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_PHONE%></td>	
				<td><s:property value='%{model.phone}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_MOBILE_PHONE%></td>	
				<td><s:property value='%{model.mobilePhone}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_GENDER%></td>	
				<td><s:property value='%{model.gender}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_DISPLAY_NAME%></td>	
				<td><s:property value='%{model.displayName}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_IS_LOCK%></td>	
				<td><s:property value='%{model.isLock}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_JOB_ID2%></td>	
				<td><s:property value='%{model.jobId2}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_NOTE_SEND_NUM%></td>	
				<td><s:property value='%{model.noteSendNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_MAIL_SEND_NUM%></td>	
				<td><s:property value='%{model.mailSendNum}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_STATUS%></td>	
				<td><s:property value='%{model.status}'/>&nbsp;</td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=User.ALIAS_CLIENTID%></td>	
				<td><s:property value='%{model.clientid}'/>&nbsp;</td>
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