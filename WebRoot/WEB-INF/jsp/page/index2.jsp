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
    
    <title>My JSP 'index2.jsp' starting page</title>
  </head>
  
  <body>
  <table>
  <form action="changeC" method="post">
    	</form>
	<tr>
	区域：
  		<c:forEach items="${region}" var="reg">
  			<a href="changeC?regionId=${reg.regionId}">${reg.regionName}</a>&nbsp;&nbsp;
  		</c:forEach>
  	</tr><br>
  	<tr>
  	类型：
  		<c:forEach items="${premistype}" var="pret">
  			<a href="changeC?buildType=${pret.btypeId}">${pret.typeName}</a>&nbsp;&nbsp;
  		</c:forEach>
  	</tr><br>
  	<tr>
  	类型：
  		<c:forEach items="${housetype}" var="hout">
  			<a href="changeC?housetype=${hout.htypeId}">${hout.typeName}</a>&nbsp;&nbsp;
  		</c:forEach>
  	</tr><br/>

  	<tr>
  		总页数：${totalPage}
  	</tr><br>
  	<tr>
  	<hr size="10px" color="red">
  		<c:forEach items="${lists}" var="pre">
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
  			<hr size="5px" color="yellor">
  		</c:forEach>
  	</tr>
  	 </table>
  </body>
</html>
