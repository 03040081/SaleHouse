<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'file.jsp' starting page</title>
  </head>
  
  <body>
    <form action="fileUpload" method="post" enctype="multipart/form-data">  
   	<input type="text" name="buildName">
   	<input type="text" name="inOpen">
   	<input type="text" name="inLive">
   	<input type="text" name="households">
   	<input type="text" name="propertyRight">
   	<input type="text" name="propertyCosts">
   	<input type="text" name="buildArea">
   	<input type="text" name="floorArea">
   	<input type="text" name="buildAddress">
   	<input type="text" name="btypeId">
   	<input type="text" name="regionId">
   	<input type="file" name="file">
   	 选择文件:
    <input type="file" name="file" multiple="multiple">  
    <input type="submit" value="提交">   
</form>  
  </body>
</html>
