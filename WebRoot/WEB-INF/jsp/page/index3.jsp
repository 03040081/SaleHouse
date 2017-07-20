<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index3.jsp' starting page</title>
  </head>
  
  <body>
  <p>楼盘ID：&nbsp;${pre.buildId}
  			<p>名称：&nbsp;${pre.buildName}
  			<p>开盘时间：&nbsp;${pre.inOpen}
  			<p>入住时间：&nbsp;${pre.inLive}
  			<p>规划户数：&nbsp;${pre.households}
  			<p>产权：&nbsp;${pre.propertyRight}
  			<p>物业费用：&nbsp;${pre.propertyCosts}
  			<p>建筑面积：&nbsp;${pre.buildArea}
  			<p>占地面积：&nbsp;${pre.floorArea}
  			<p>地址：&nbsp;${pre.buildAddress}
  			<p>建筑类型：&nbsp;${pre.premisetype.btypeId}&nbsp;&nbsp;${pre.premisetype.typeName}
  			<p>开发商：&nbsp;${pre.developer}
  			 <p>区域：&nbsp;${pre.region.regionId}&nbsp;&nbsp;${pre.region.regionName}
  			<p>图片：<img src="${pre.iconUrl}"> 
  			<br>
  			<hr size="10px" color="red">
  			<hr size="5px" color="yellor">
  			<c:forEach items="${pre.premisesimg}" var="preimg">
  			<img src="${preimg.imgUrl}">
  			</c:forEach>
  			<hr size="5px" color="green">
  			<c:forEach items="${listHouses}" var="hourse">
  				<p>房子ID：${hourse.houseId}
  				<p>房子介绍：${hourse.houseDesc}
  				<p>房子面积：${hourse.houseArea}
  				<p>房子价格：${hourse.housePrice}
  				<p>房子户型：${hourse.housetype.typeName}
  				<p>房子状况：${hourse.state}
  				<c:forEach items="${hourse.houseimg}" var="img">
  					<img src="${img.imgUrl}">
  				</c:forEach>
  				<p>
  				<p>
  			</c:forEach>
  
  
  <hr size="20px" color="#EEE">
  <form action="Search" method="post">
  输入<input name="keyword" type="text">
  <input name="cityId">
  <button type="submit">提交</button>
  </form>
  <br>
  
  
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
   	头像图片<input type="file" name="file">
   	 选择文件:
    详细图片<input type="file" name="file" multiple="multiple">  
   <br> <input type="submit" value="提交">   

  </body>
</html>
