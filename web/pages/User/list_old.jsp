<%@page import="cn.edu.dglg.cis.subject.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=User.TABLE_ALIAS%> 维护</title>
	
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<link href="<c:url value="/styles/style.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			// 分页需要依赖的初始化动作
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</rapid:override>

<rapid:override name="content">
	<form id="queryForm" name="queryForm" action="<c:url value="/pages/User/list.do"/>" method="post" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend>搜索</legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=User.ALIAS_CID%></td>		
					<td>
						<input type="text" value="${query.cid}" id="cid" name="cid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_CDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.cdateBegin}' pattern='<%=User.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_CDATE%>'})" id="cdateBegin" name="cdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.cdateEnd}' pattern='<%=User.FORMAT_CDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_CDATE%>'})" id="cdateEnd" name="cdateEnd"   />
					</td>
					<td class="tdLabel"><%=User.ALIAS_MID%></td>		
					<td>
						<input type="text" value="${query.mid}" id="mid" name="mid" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_MDATE%></td>		
					<td>
						<input type="text" value="<fmt:formatDate value='${query.mdateBegin}' pattern='<%=User.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_MDATE%>'})" id="mdateBegin" name="mdateBegin"   />
						<input type="text" value="<fmt:formatDate value='${query.mdateEnd}' pattern='<%=User.FORMAT_MDATE%>'/>" onclick="WdatePicker({dateFmt:'<%=User.FORMAT_MDATE%>'})" id="mdateEnd" name="mdateEnd"   />
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=User.ALIAS_UUID%></td>		
					<td>
						<input type="text" value="${query.uuid}" id="uuid" name="uuid" maxlength="45"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_USER_NAME%></td>		
					<td>
						<input type="text" value="${query.userName}" id="userName" name="userName" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_DEPA_ID%></td>		
					<td>
						<input type="text" value="${query.depaId}" id="depaId" name="depaId" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_JOB_ID%></td>		
					<td>
						<input type="text" value="${query.jobId}" id="jobId" name="jobId" maxlength="45"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=User.ALIAS_EMAIL%></td>		
					<td>
						<input type="text" value="${query.email}" id="email" name="email" maxlength="100"  class="validate-email "/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_PASSWORD%></td>		
					<td>
						<input type="text" value="${query.password}" id="password" name="password" maxlength="300"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_PHONE%></td>		
					<td>
						<input type="text" value="${query.phone}" id="phone" name="phone" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_MOBILE_PHONE%></td>		
					<td>
						<input type="text" value="${query.mobilePhone}" id="mobilePhone" name="mobilePhone" maxlength="100"  class=""/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=User.ALIAS_GENDER%></td>		
					<td>
						<input type="text" value="${query.gender}" id="gender" name="gender" maxlength="1"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_DISPLAY_NAME%></td>		
					<td>
						<input type="text" value="${query.displayName}" id="displayName" name="displayName" maxlength="100"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_IS_LOCK%></td>		
					<td>
						<input type="text" value="${query.isLock}" id="isLock" name="isLock" maxlength="1"  class=""/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_JOB_ID2%></td>		
					<td>
						<input type="text" value="${query.jobId2}" id="jobId2" name="jobId2" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=User.ALIAS_NOTE_SEND_NUM%></td>		
					<td>
						<input type="text" value="${query.noteSendNum}" id="noteSendNum" name="noteSendNum" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_MAIL_SEND_NUM%></td>		
					<td>
						<input type="text" value="${query.mailSendNum}" id="mailSendNum" name="mailSendNum" maxlength="10"  class="validate-email validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_STATUS%></td>		
					<td>
						<input type="text" value="${query.status}" id="status" name="status" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
					<td class="tdLabel"><%=User.ALIAS_CLIENTID%></td>		
					<td>
						<input type="text" value="${query.clientid}" id="clientid" name="clientid" maxlength="50"  class=""/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="查询" onclick="getReferenceForm(this).action='${ctx}/pages/User/list.do'"/>
			<input type="submit" class="stdButton" style="width:80px" value="新增" onclick="getReferenceForm(this).action='${ctx}/pages/User/create.do'"/>
			<input type="button" class="stdButton" style="width:80px" value="删除" onclick="batchDelete('${ctx}/pages/User/delete.do','items',document.forms.queryForm)"/>
		</div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.User@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="tablelist">
		  <thead>
			  
			  <tr>
				<th style="width:50px;"> </th>
				<th style="width:50px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
				<th sortColumn="CID_" ><%=User.ALIAS_CID%></th>
				<th sortColumn="CDATE_" ><%=User.ALIAS_CDATE%></th>
				<th sortColumn="MID_" ><%=User.ALIAS_MID%></th>
				<th sortColumn="MDATE_" ><%=User.ALIAS_MDATE%></th>
				<th sortColumn="UUID_" ><%=User.ALIAS_UUID%></th>
				<th sortColumn="userName" ><%=User.ALIAS_USER_NAME%></th>
				<th sortColumn="depaId" ><%=User.ALIAS_DEPA_ID%></th>
				<th sortColumn="jobId" ><%=User.ALIAS_JOB_ID%></th>
				<th sortColumn="email" ><%=User.ALIAS_EMAIL%></th>
				<th sortColumn="password" ><%=User.ALIAS_PASSWORD%></th>
				<th sortColumn="phone" ><%=User.ALIAS_PHONE%></th>
				<th sortColumn="mobilePhone" ><%=User.ALIAS_MOBILE_PHONE%></th>
				<th sortColumn="gender" ><%=User.ALIAS_GENDER%></th>
				<th sortColumn="displayName" ><%=User.ALIAS_DISPLAY_NAME%></th>
				<th sortColumn="isLock" ><%=User.ALIAS_IS_LOCK%></th>
				<th sortColumn="jobId2" ><%=User.ALIAS_JOB_ID2%></th>
				<th sortColumn="noteSendNum" ><%=User.ALIAS_NOTE_SEND_NUM%></th>
				<th sortColumn="mailSendNum" ><%=User.ALIAS_MAIL_SEND_NUM%></th>
				<th sortColumn="status" ><%=User.ALIAS_STATUS%></th>
				<th sortColumn="clientid" ><%=User.ALIAS_CLIENTID%></th>
	
				<th>操作</th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="id=${item.id}&"></td>
				
				<td><c:out value='${item.cid}'/>&nbsp;</td>
				<td><c:out value='${item.cdateString}'/>&nbsp;</td>
				<td><c:out value='${item.mid}'/>&nbsp;</td>
				<td><c:out value='${item.mdateString}'/>&nbsp;</td>
				<td><c:out value='${item.uuid}'/>&nbsp;</td>
				<td><c:out value='${item.userName}'/>&nbsp;</td>
				<td><c:out value='${item.depaId}'/>&nbsp;</td>
				<td><c:out value='${item.jobId}'/>&nbsp;</td>
				<td><c:out value='${item.email}'/>&nbsp;</td>
				<td><c:out value='${item.password}'/>&nbsp;</td>
				<td><c:out value='${item.phone}'/>&nbsp;</td>
				<td><c:out value='${item.mobilePhone}'/>&nbsp;</td>
				<td><c:out value='${item.gender}'/>&nbsp;</td>
				<td><c:out value='${item.displayName}'/>&nbsp;</td>
				<td><c:out value='${item.isLock}'/>&nbsp;</td>
				<td><c:out value='${item.jobId2}'/>&nbsp;</td>
				<td><c:out value='${item.noteSendNum}'/>&nbsp;</td>
				<td><c:out value='${item.mailSendNum}'/>&nbsp;</td>
				<td><c:out value='${item.status}'/>&nbsp;</td>
				<td><c:out value='${item.clientid}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/pages/User/show.do?id=${item.id}&">查看</a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/pages/User/edit.do?id=${item.id}&">修改</a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<s:property value="@com.minioa2.project.model.User@TABLE_ALIAS"/>列表
		</simpletable:pageToolbar>
	</div>
	</form>
</rapid:override>


<%@ include file="base.jsp" %>

