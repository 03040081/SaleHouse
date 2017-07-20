<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index4.jsp' starting page</title>

  </head>
  
  <body>
  <form action="loginU">
  	<input type="text" name="username">
  	<input type="text" name="password">
  	<button type="submit">确定</button>
  </form>
  
  ----------------注册-----------------
     <form action="register">
  	u<input type="text" name="username">
  	p<input type="text" name="password">
  	l<input type="text" name="locked">
  	f<input type="text" name="faceing">
  	rolid<input type="text" name="roleId">
  	<button type="submit">确定</button>
  </form>
  
    <form action="addPremises" method="post" enctype="multipart/form-data">  
   楼盘名称	<input type="text" name="buildName">
  开盘 	<input type="text" name="inOpen">
   入住	<input type="text" name="inLive">
   	规划户口<input type="text" name="households">
   	产权<input type="text" name="propertyRight">
   	物业费用<input type="text" name="propertyCosts">
   	建筑面积<input type="text" name="buildArea">
   	占地面积<input type="text" name="floorArea">
   	地址<input type="text" name="buildAddress">
   	建筑类型<input type="text" name="buildType">
   	开发商<input type="text" name="developer">
   	区域<input type="text" name="regionId">
   	类型<input type="text" name="buildType">
   	头像图片<input type="file" name="file">
   	 选择文件:
    详细图片<input type="file" name="file" multiple="multiple">  
   <br> <input type="submit" value="提交">
   </form>
  </body>
</html>
