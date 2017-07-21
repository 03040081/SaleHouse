<%@page import="zsc.gof.entity.PageModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String paging = request.getContextPath();
	String pagingPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ paging + "/";
%>
<link href="<%=pagingPath%>static/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=pagingPath%>static/js/jquery.min.js"></script>
<%
	int pageIndex = 0;
	int totalPage = 0;
	if (request.getAttribute("pagePre") != null)
		pageIndex = ((PageModel) request.getAttribute("pagePre")).getPageIndex();//当前页
	if (request.getAttribute("totalPage") != null)
		totalPage = (Integer) request.getAttribute("totalPage");//总页数
	int preIndex = pageIndex - 1 <= 0 ? pageIndex : pageIndex - 1; //上一页
	int nextIndex = pageIndex + 1 > totalPage ? pageIndex : pageIndex + 1;//下一页
%>

<div style="margin:0 0 0 45%;">
	<ul class="pagination pagination-lg">
		<li><a
			href="<%=pagingPath%>PreviousPage?pageIndex=<%=preIndex%>">&laquo;</a></li>
		<%
			for (int i = pageIndex; i <= (totalPage < pageIndex + 5 ? totalPage : pageIndex + 5); i++) {
				out.print("<li><a href='" + pagingPath + "IndexPage?pageIndex=" + i + "'>" + i + "</a></li>");
			}
		%>
		<li><a href="<%=pagingPath%>NextPage?pageIndex=<%=nextIndex%>">&raquo;</a></li>
	</ul>
	<br>
</div>