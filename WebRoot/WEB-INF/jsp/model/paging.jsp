<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String paging = request.getContextPath();
String pagingPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+paging+"/";
%>
<link href="<%=pagingPath%>static/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=pagingPath%>static/js/jquery.min.js"></script>
<%
	int pageIndex = 0;
	int totalPage = 0;
	if(session.getAttribute("pageIndex")!=null)
	pageIndex = Integer.parseInt((String)session.getAttribute("pageIndex"));//当前页
	if(session.getAttribute("totalPage")!=null)
	 totalPage = Integer.parseInt((String)session.getAttribute("totalPage"));//总页数
	int preIndex = pageIndex-1<=0?pageIndex:pageIndex-1;		//上一页
	int nextIndex = pageIndex+1>totalPage?pageIndex:pageIndex+1;//下一页
%>

<div style="margin-left: 70%">
        <ul class="pagination pagination-lg">
        <li><a href="<%=pagingPath%>DetailsSearch?pageIndex=<%=preIndex %>">&laquo;</a></li>
          <%
          	for(int i = nextIndex;i<=(totalPage<nextIndex+5?totalPage:nextIndex+5);i++){
       			 out.print("<li><a href='"+pagingPath+"DetailsSearch?pageIndex="+i+"'>"+i+"</a></li>");
          	}
          %>
		<li><a href="<%=pagingPath%>DetailsSearch?pageIndex=<%=nextIndex %>">&raquo;</a></li>
</ul><br>
 </div>