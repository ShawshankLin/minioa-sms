<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="page" required="true" type="cn.org.rapid_framework.page.Page" description="Page.java" %>
<%@ attribute name="pageSizeSelectList" type="java.lang.Number[]" required="false"  %>
<%@ attribute name="isShowPageSizeList" type="java.lang.Boolean" required="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	// set default values
	Integer[] defaultPageSizes = new Integer[]{10,50,100};
	if(jspContext.getAttribute("pageSizeSelectList") == null) {
		jspContext.setAttribute("pageSizeSelectList",defaultPageSizes); 
	}
	
	if(jspContext.getAttribute("isShowPageSizeList") == null) {
		jspContext.setAttribute("isShowPageSizeList",true); 
	} 
%>

<ul class="pagination">
		<c:choose>
		<c:when test="${page.firstPage}"><li><a href="javascript:void(0)" disabled="disabled">第一页</a></li></c:when>
		<c:otherwise><li><a href="javascript:simpleTable.togglePage(1);">第一页</a></li></c:otherwise>
		</c:choose>
		<c:choose>
		<c:when test="${page.hasPreviousPage}"><li><a href="javascript:simpleTable.togglePage(${page.previousPageNumber});">上一页</a></li></c:when>
		<c:otherwise><li><a href="javascript:void(0);" disabled="disabled">上一页</a></li></c:otherwise>
		</c:choose>
</ul>
    <ul class="pagination pagination-group"> 
        <c:forEach var="item" items="${page.linkPageNumbers}">
		<c:choose>
		<c:when test="${item == page.thisPageNumber}"><li class="active"><a href="javascript:void(0)">${item}</a></li></c:when>
		<c:otherwise><li><a href="javascript:simpleTable.togglePage(${item});">${item}</a></li></c:otherwise>
		</c:choose>
		</c:forEach>
    </ul>
<ul class="pagination">
		<c:choose>
		<c:when test="${page.hasNextPage}"><li><a href="javascript:simpleTable.togglePage(${page.nextPageNumber});">下一页</a></li></c:when>
		<c:otherwise><li><a href="javascript:void(0)">下一页</a></li></c:otherwise>
		</c:choose>
		<c:choose>
		<c:when test="${page.lastPage}"><li><a href="javascript:void(0)">最后一页</a></li></c:when>
		<c:otherwise><li><a href="javascript:simpleTable.togglePage(${page.lastPageNumber});">最后一页</a></li></c:otherwise>
		</c:choose>
</ul>