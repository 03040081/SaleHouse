<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>

  </head>
  <body>
  <table>
  	<tr>
  	<c:forEach items="${list}" var="s">
  		<td>${s.buildName}</td>
  		<td>${s.inOpen}</td>
  		<td>${s.inLive}</td>
  		<td>${s.households}</td>
  		<td>${s.propertyRight}</td>
  		<td>${s.propertyCosts}</td>
  		<td>${s.buildArea}</td>
  		<td>${s.floorArea}</td>
  		<td>${s.buildAddress}</td>
  		
  	</c:forEach>	
  	</tr>
  </table>
  </body>
</html>
