
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String modelpath = request.getContextPath();
	String modelBase = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ modelpath + "/";
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>HouseInfo</title>
		<link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Features-Clean.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Navigation-with-Button1.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Pretty-Search-Form.css">
		<link rel="stylesheet" href="<%=basePath%>static/css/Simple-Slider.css">
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



	<div id="detail">
			<div class="detail-box">
				<div class="container">
					<div class="col-md-7 box-left">
						<div class="simple-slider">
							<div class="swiper-container">
								<div class="swiper-wrapper">
									<div class="swiper-slide" style="background-image:url();"></div>
									<div class="swiper-slide" style="background-image:url();"></div>
									<div class="swiper-slide" style="background-image:url();"></div>
								</div>
								<div class="swiper-pagination"></div>
								<div class="swiper-button-prev"></div>
								<div class="swiper-button-next"></div>
							</div>
						</div>
					</div>
					<div class="col-md-5 box-right">
						<h2 class="title">万科商景城</h2><i class="state-label">在售</i>
						<p class="price">均价约<span>Text</span><em>元/平方米</em></p>
						<hr>
						<div class="head-info-list">
							<ul>
								<li class="head-info-item">楼盘别名<span>Text</span></li>
								<li class="head-info-item">物业类型<span>Text</span></li>
								<li class="head-info-item">开盘时间<span>Text</span></li>
								<li class="head-info-item">入住时间<span>Text</span></li>
								<li class="head-info-item">楼盘地址<span>Text</span></li>
							</ul>
						</div>
						<div class="tel-style"><i class="icons glyphicon glyphicon-earphone"> </i><b>400-8820-8820 转38</b></div>
					</div>
				</div>
			</div>
		</div>
		<div class="page-nav">
				<div class="wrap">
					<ul class="clearfix">
						<li class="current"><a href="#houses">在售户型</a></li>
						<li><a href="#houseinfo">楼盘信息</a></li>
						<li><a href="#houseimg">楼盘相册</a></li>
						<li><a href="#houseard">周边配套</a></li>
					</ul>
				</div>
		</div>
		<div class="detail-wrap">
			<a id="houses"></a>
			<div class="detail-content">
				<div class="tit clearfix productTit">
					<span>在售户型</span>
				</div>
				<ul class="hx-list">
					<!--<c:forEach items="${list}" var='h'}-->
					<li>
						<div class="fl">
							<a href="#"><img  class="hx-list-img"  src="assets/img/loft.jpg"/></a>
							<div class="hx-list-txt">
								<p>
									<strong>楼盘名字
										<span>房子名字，房子面积</span>
									</strong>
								</p>
								<p>详细的户型解读，请拨打我们的热线电话:400-8820-8820</p>
							</div>
						</div>
						<div class="fr">
							<p class="price-zero">
								<span class="downpayment">参考总价:</span>
								<span class="price-one">222</span>
								<span class="price-two">万</span>
								<span class="price-three">
									<em style="font-size: inherit;">(222</em>
									元/平方米)
								</span>
							</p>
							<p>
								<span class="downpayment">参考首付:</span>
								<span class="payment">222</span>
								<span class="price-two">万</span>
								<span class="downpayment-1">参考月供:</span>
								<span class="payment">222</span>
								<span class="price-two">元/月</span>
							</p>
						</div>
					</li>
					<!--</c:forEach>-->
				</ul>
			</div>
			<a id="houseinfo"></a>
			<div class="detail-content">
				<p class="tit clearfix">楼盘信息</p>
				<div class="detail-data">
					<div class="data-box">
						<p class="data-tit">
							<strong>楼盘名字</strong>
						</p>
					</div>
					<div class="data-box parameter">
						<p class="data-tit clearfix">
							<strong>楼盘参数</strong>
						</p>
						<dl class="parameter-one">
							<dt style="display: none;"></dt>
							<dd>楼盘地址： </dd>
							<dd>开发商： </dd>
							<dd>产权： </dd>
							<dd>区域： </dd>
							<dd>楼盘类型： </dd>
							<dd>占地面积： </dd>
						</dl>
						<dl class="parameter-two">
							<dt style="display: none;"></dt>
							<dd>开盘时间： </dd>
							<dd>入住时间： </dd>
							<dd>建筑面积： </dd>
							<dd>物业费用： </dd>
							<dd>规划户数： </dd>
						</dl>
					</div>
				</div>
			</div>
			<a id="houseimg"></a>
			<div class="detail-content">
				<p class="tit clearfix">楼盘相册</p>
				<div class="photo-wrap">
					<ul class="photo-list">
						<li style="background: url(assets/img/loft.jpg) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
						<li style="background: url(assets/img/loft.jpg) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
						<li style="background: url(assets/img/loft.jpg) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
						<li style="background: url(assets/img/loft.jpg) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
					</ul>
				</div>
			</div>
			<a id="houseard"></a>
			<div class="detail-content">
				<p class="tit clearfix">周边配套</p>
				
			</div>
		</div>
	




		<!-- footer-Start -->
	 	<%@include file="../../model/NewFooter.jsp"%>
		<!-- footer-End -->


		<!-- Modal for House-Img-Condition -->
		<div class="modal fade bs-example-modal-lg" id="PhotoCondition" tabindex="-1" role="dialog" aria-labelledby="Modal-label-2">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h2 class="modal-title" id="Modal-label-2">万科商景城</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-8">
								<div class="simple-slider modal-bg">
									<div class="swiper-container">
										<div class="swiper-wrapper">
											<div class="swiper-slide" style="background-image:url();"></div>
											<div class="swiper-slide" style="background-image:url();"></div>
											<div class="swiper-slide" style="background-image:url();"></div>
										</div>
										<div class="swiper-pagination"></div>
										<div class="swiper-button-prev"></div>
										<div class="swiper-button-next"></div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<h2 class="list-group-item-heading">万科商业城</h2>
								<div class="head-info-list">
									<ul>
										<li class="head-info-item">楼盘别名<span>Text</span></li>
										<li class="head-info-item">物业类型<span>Text</span></li>
										<li class="head-info-item">开盘时间<span>Text</span></li>
										<li class="head-info-item">入住时间<span>Text</span></li>
										<li class="head-info-item">楼盘地址<span>Text</span></li>
										<li class="head-info-item">建筑面积<span>Text</span></li>
										<li class="head-info-item">物业费用<span>Text</span></li>
									</ul>
								</div>
			</div>
			</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
				</div>
			</div>
		</div>	
		<!-- Modal for Login -->

		<!-- Modal for House-Img-Condition -->
		


		
		
		
		
		<script src="<%=basePath%>static/js/jquery.min.js"></script>
		<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
		<script src="<%=basePath%>static/js/Simple-Slider.js"></script>
</body>
</html>