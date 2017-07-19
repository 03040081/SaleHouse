<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String modelpath = request.getContextPath();
	String modelBase = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ modelpath + "/";
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(modelBase + " " + basePath);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>SaleHouseList</title>
		<link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=basePath%>static/css/Features-Clean.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Navigation-with-Button1.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Pretty-Search-Form.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/styles.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Footer-Dark.css">
	</head>

<body>
	<!--navbar-Start-->
	<%@include file="../../model/NewHead.jsp"%>
	<!--nav-bar End-->
	
	<!-- Search-bar-Start -->
	<%@include file="../../model/SearchBar.jsp"%>
	<!-- Search-bar-End -->
	
	<div id="Search_List">
		<div class="Search_Condition">
			<p>区域:</p>
			<hr />
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li><a href="#">天河</a></li>
				<li><a href="#">天河</a></li>
				<li><a href="#">天河</a></li>
			</ul>
			<p>售价：</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li><a href="#">50万以下</a></li>
				<li><a href="#">50-80万</a></li>
				<li><a href="#">80-100万</a></li>
				<li><a href="#">100-120万</a></li>
				<li><a href="#">120-150万</a></li>
				<li><a href="#">150-200万</a></li>
				<li><a href="#">200-300万</a></li>
				<li><a href="#">300万以上</a></li>
			</ul>
			<p>类型:</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li><a href="#">住宅</a></li>
				<li><a href="#">别墅</a></li>
				<li><a href="#">写字楼</a></li>
				<li><a href="#">商铺</a></li>
				<li><a href="#">底商</a></li>
			</ul>
			<p>销售状态：</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li><a href="#">在售</a></li>
				<li><a href="#">售罄</a></li>

			</ul>


		</div>
	</div>

	<div id="Search_Tag" class="light-bg">
		<p>已选条件：</p>
		<ul style="display: inline;">
			<li style="display: inline;"><a href="#">sdd</a></li>
			<li style="display: inline;"><a href="#">sdd</a></li>
		</ul>
	</div>
	<div id="Search_Result">
		<p style="font-size: 20px; padding-left: 20px;">
			共找到&nbsp; <span
				style="font-size: 25px; font-weight: bolder; color: darkgoldenrod;">123</span>&nbsp;个楼盘
		</p>
		<hr />
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#default"
				aria-controls="default" role="tab" data-toggle="tab">默认排序</a></li>
			<li role="presentation"><a href="#price"
				aria-controls="de-price" role="tab" data-toggle="tab">价格&nbsp;↓</a></li>
			<li role="presentation"><a href="#saledtime"
				aria-controls="saledtime" role="tab" data-toggle="tab">开盘时间&nbsp;↓</a></li>
		</ul>
	<!-- 	<!-- Tab panes -->
		<div class="tab-content">
    			<div role="tabpanel" class="tab-pane active" id="home">
    				<div class="model">
					<div class="modelLeft">
					<div>
					<a href="<%=modelBase%>"><img
						src="<%=modelBase%>static/image/14996453503361_3.jpg.232x174.jpg"></a>
					</div>
					</div>
					<div class="modelRight">
				<h3>
					<b><a href="<%=modelBase%>">为你而选为你而家，绿地海顿公馆 精装10万</a></b>
				</h3>
				<br />
				<ul>
					<li>世纪新城|2厅2室|92.9平米|南 北|其他</li>
					<li>高层楼（共33层）楼板 -</li>
					<li>62人关注 | 共6次带看 | 4个月以前发布</li>
				</ul>

			</div>
					</div>
    			</div>
    			<div role="tabpanel" class="tab-pane" id="profile">aaa</div>
    			<div role="tabpanel" class="tab-pane" id="messages">aaa</div>
 		</div> -->

		<hr>
		<c:forEach items="" var="premises" varStatus="index">
			<div class="model">
				<div class="modelLeft">
					<div>
						<a href="<%=modelBase%>">
							<img src="${iconUrl}">
						</a>
					</div>
				</div>
				<div class="modelRight">
					<h3>
						<b><a href="<%=modelBase%>">为你而选为你而家，绿地海顿公馆 精装10万</a></b>
					</h3>
					<br />
					<ul>
						<li>世纪新城|2厅2室|92.9平米|南 北|其他</li>
						<li>高层楼（共33层）楼板 -</li>
						<li>62人关注 | 共6次带看 | 4个月以前发布</li>
					</ul>
				</div>
			</div>
<<<<<<< HEAD
			<div class="modelRight">
				<h3>
					<b><a href="<%=modelBase%>">为你而选为你而家，绿地海顿公馆 精装10万</a></b>
				</h3>
				<br />
				<ul>
					<li>世纪新城|2厅2室|92.9平米|南 北|其他</li>
					<li>高层楼（共33层）楼板 -</li>
					<li>62人关注 | 共6次带看 | 4个月以前发布</li>
				</ul>

			</div>
		</div>
=======
		</c:forEach>
>>>>>>> upstream/master
	</div>



	<!-- footer-Start -->
	 <%@include file="../../model/NewFooter.jsp"%>
	<!-- footer-End -->



	<!-- Bootstrap core JavaScript
			================================================== -->
	
	<script src="<%=basePath%>static/js/jquery.min.js"></script>
	<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
</body>

</html>