<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  
  	<link rel="stylesheet" href="<%=basePath%>static/css/model.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
  		<%@include file="../model/head.jsp"%>
		    	
  		<div class="content">
  		</div>
    	<%@include file="../model/footer.jsp"%>
    	
  </body>
</html>
