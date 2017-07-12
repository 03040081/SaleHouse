<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Object> list = new ArrayList<Object>();
	for(int i = 0;i<10;i++){
		list.add("dsada");
	}
	request.setAttribute("list", list);
%>

<html>
  <head>
  
  	<link rel="stylesheet" href="<%=basePath%>static/css/model.css?time=<%=new Date()%>">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
  		<%@include file="../model/head.jsp"%>
  		<div class="content">
  			<c:forEach items="${list}" var="key" varStatus="id" begin="0">
  				<%@include file="../model/contentModel.jsp"%>
  			</c:forEach>
  			
  		</div>
    	<%@include file="../model/footer.jsp"%>
    	
  </body>
</html>
