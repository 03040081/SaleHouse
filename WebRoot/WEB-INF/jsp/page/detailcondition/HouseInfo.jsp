<%@page import="zsc.gof.entity.House"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			<html>

			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>HouseInfo</title>
				<link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.9.0/css/lightbox.min.css" />
				<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Cookie">
				<link rel="stylesheet" href="<%=basePath%>static/css/Features-Clean.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/Navigation-with-Button1.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/Pretty-Search-Form.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/Simple-Slider.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/styles.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/Pretty-Footer.css">
				<link rel="stylesheet" href="<%=basePath%>static/css/Footer-Basic.css">
				<link rel="stylesheet" href="<%=basePath%>static/fonts/font-awesome.min.css">
				

			</head>

			<body>
					<!--navbar-Start-->
					<%@include file="../../model/NewHead.jsp"%>
					<!--nav-bar End-->

					<!-- Search-bar-Start -->
					<%@include file="../../model/SearchBar.jsp"%>
					<!-- Search-bar-End -->



					<div id="detail" style="background:url(<%=modelBase%>${premise.premisesimgLesser[0].imgUrl})">
							<div class="detail-box">
								<div class="container">
									<div class="col-md-7 box-left">
										<div class="simple-slider">
											<div class="swiper-container">
												<div class="swiper-wrapper">
												<c:forEach items="${premise.premisesimgLesser}" var="img">
													<div class="swiper-slide" style="background-image:url(<%=modelBase %>${img.imgUrl});"></div>
												</c:forEach>
												</div>
												<div class="swiper-pagination"></div>
												<div class="swiper-button-prev"></div>
												<div class="swiper-button-next"></div>
											</div>
										</div>
									</div>
									<div class="col-md-5 box-right">
										<h2 class="title">${premise.buildName}</h2><i class="state-label">在售</i>
										<p class="price">均价约<span>Text</span><em>元/平方米</em></p>
										<hr>
										<div class="head-info-list">
											<ul>
												<li class="head-info-item">楼盘别名<span>${premise.buildName}</span></li>
												<li class="head-info-item">物业类型<span>${premise.premisetype.typeName}</span></li>
												<li class="head-info-item">开盘时间<span>${premise.inOpen}</span></li>
												<li class="head-info-item">入住时间<span>${premise.inLive}</span></li>
												<li class="head-info-item">楼盘地址<span>${premise.buildAddress}</span></li>
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
									
									<c:forEach items="${listHouses}" var="hourse">
					
									<li>
										<div class="fl">
											
											<a href="${urlHouse}" target="_blank" data-lightbox="photo"><img  class="hx-list-img"  src="${urlHouse}"/></a>
											<div class="hx-list-txt">
												<p>
													<strong>${premise.buildName}
													<span>${hourse.houseDesc}，${hourse.houseArea}平米</span>
													</strong>
												</p>
												<p>详细的户型解读，请拨打我们的热线电话:400-8820-8820</p>
											</div>
										</div>
										<div class="fr">
											<p class="price-zero">
												<span class="downpayment">参考总价:</span>
												<span class="price-one">${hourse.housePrice}</span>
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
												<span class="payment">3220   </span>
												<span class="price-two">元/月</span>
											</p>
										</div>
									</li>
								</c:forEach>
								</ul>
							</div>
							<a id="houseinfo"></a>
							<div class="detail-content">
								<p class="tit clearfix">楼盘信息</p>
								<div class="detail-data">
									<div class="data-box">
										<p class="data-tit">
										<strong>${premise.buildName}</strong>
										</p>
									</div>
									<div class="data-box parameter">
										<p class="data-tit clearfix">
										<strong>楼盘参数</strong>
										</p>
										<dl class="parameter-one">
											<dt style="display: none;"></dt>
											<dd>楼盘地址： ${premise.buildAddress}</dd>
											<dd>开发商：${premise.developer} </dd>
											<dd>产权： ${premise.propertyRight}</dd>
											<dd>区域： ${premise.region.regionName}</dd>
											<dd>楼盘类型： ${premise.premisetype.typeName}</dd>
											<dd>占地面积： ${premise.floorArea}</dd>
										</dl>
										<dl class="parameter-two">
											<dt style="display: none;"></dt>
											<dd>开盘时间：  ${premise.inOpen}</dd>
											<dd>入住时间： ${premise.inLive}</dd>
											<dd>建筑面积： ${premise.buildArea}</dd>
											<dd>物业费用： ${premise.propertyCosts}</dd>
											<dd>规划户数： ${premise.households}</dd>
										</dl>
									</div>
								</div>
							</div>
							<a id="houseimg"></a>
							<div class="detail-content">
								<p class="tit clearfix">楼盘相册</p>
								<div class="photo-wrap">
									<ul class="photo-list">
										<li style="background: url(${premise.premisesimg[0].imgUrl}) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
										<li style="background: url(${premise.premisesimg[1].imgUrl}) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
										<li style="background: url(${premise.premisesimg[2].imgUrl}) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
										<li style="background: url(${premise.premisesimg[3].imgUrl}) center 1px no-repeat;" href="#" data-toggle="modal" data-target="#PhotoCondition"></li>
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
						<p style="font-size: 23px; font-weight:200; ">万科商业城</p>
						<p style="font-size: 23px; font-weight:200; ">3室2厅1卫, 约79平方米</p>
						<hr />
						<div class="head-info-list">
							<ul>
								<li class="head-info-item">楼盘别名<span>Text</span></li>
								<li class="head-info-item">物业类型<span>Text</span></li>
								<li class="head-info-item">开盘时间<span>Text</span></li>
								<li class="head-info-item">入住时间<span>Text</span></li>
								<li class="head-info-item">楼盘地址<span>Text</span></li>
								<li class="head-info-item">建筑面积<span>Text</span></li>
							</ul>
						</div>
						<hr />
						<p style="color: rgb(268,199,1);font-size: 28px;">
							<i class="fa fa-phone"></i>
							400-8820-8820
						</p>
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
	<div class="modal fade" id="UserLogin" tabindex="-1" role="dialog" aria-labelledby="ModalLabel">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="ModalLabel">欢迎登陆我爱我家</h4>
      			</div>
     			<div class="modal-body">
        			<div class="row" >
						 <div class="col-md-12">
                			<div class="login-panel panel panel-default">
                   			 	<div class="panel-heading">
                       		 	<h3 class="panel-title">请登录</h3>
                    			</div>
                   			 <div class="panel-body">
                        	<form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="账号" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住我的账号
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="index.html" class="btn btn-lg btn-success btn-block">登陆</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
  
					</div>
				</div>
			</div>
		</div>
	</div>

		<!-- Modal for House-Img-Condition -->
		


		
		
		
		
		<script src="<%=basePath%>static/js/jquery.min.js"></script>
		<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.9.0/js/lightbox-plus-jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
		<script src="<%=basePath%>static/js/Simple-Slider.js"></script>
</body>
</html>