<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="favicon.ico">
		<title>SaleHome-Page</title>
		<!-- Bootstrap core CSS -->
		<link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<link href="<%=basePath%>static/css/owl.carousel.css" rel="stylesheet">
		<link href="<%=basePath%>static/css/owl.theme.default.min.css"  rel="stylesheet">
		<link href="<%=basePath%>static/css/animate.css" rel="stylesheet">
		<link href="<%=basePath%>static/css/style.css" rel="stylesheet">
		<link href="<%=basePath%>static/css/styles.css" rel="stylesheet">
		<script src="<%=basePath%>static/js/jquery.min.js"></script>
		
	</head>
	
	<body id="page-top">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container"> 
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header page-scroll">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand page-scroll" href="#page-top"><img src="images/logo.png" alt="Sanza theme logo"></a>
					<%-- 定位 --%>
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">
								<i class="glyphicon glyphicon-map-marker"></i>${currCity.cityName}
								<span class="caret"></span>
							</a>
							<ul id="ul_region" class="dropdown-menu" role="menu">
								<c:forEach items="${listCity}" var="city">
									<c:if test="${city.cityId != currCity.cityId}">
										<li class="region-info" role="presentation">
											<a href="City?cityId=${city.cityId}">${city.cityName}</a>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</ul>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li>
							<a class="page-scroll" href="#about">房源类型</a>
						</li>
						
						<li>
							<a class="page-scroll" href="#portfolio">高端房源</a>
						</li>
						<li>
							<a class="page-scroll" href="#partners">我们的团队</a>
						</li>
						<li>
							<a class="page-scroll" href="#team">合作伙伴</a>
						</li>
						<li>
							<a class="page-scroll" href="#contact">联系我们</a>
						</li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- Header -->
		<header>
		<div id="promo" style="height:580px;">
		<div class="jumbotron">
			<h1>我爱我家</h1>
			<p>随时随地任性找房，IM匿名咨询让您放心，消息动态推送让您省心，服务承诺让您安心，数据百科锦囊让您感受贴心漫漫找房路，我们努力为您想更多</p>
			<div class="search_box">
				<div class="search_box_inner">
					<p id="searchTabs" class="search_tab">
						<span class="cur" data-type="newhouse">找新房</span>
						<span class="cur" data-type="sale">找二手房</span>
						<span class="cur" data-type="rent">找租房</span>
					</p>
					<div class="ipt_box">
						<input id="keyword" type="text" class="seek fl" style="height:50px;width:600px;" placeholder="请输入房源特征，房型，地址或小区名">
						<button id="btn_search" href="#" class="ipt_button fl"> <i class="icons"> </i></button>
					</div>
				</div>
			</div>
		</div>
		</div>
       </header>

		<section id="about" class="light-bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-title">
							<h2>找房就找我们</h2>
							<p>随时随地任性找房，IM匿名咨询让您放心，消息动态推送让您省心，
								服务承诺让您安心，数据百科锦囊让您感受贴心漫漫找房路，我们努力为您想更多</p>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- about module -->
					<div class="col-md-3 text-center">
						<div class="mz-module">
							<div class="mz-module-about">
								<i class="fa color2 ot-circle" style="background-image:url(images/php6ifmLs.png); background-repeat: no-repeat;" ></i>
								<h3>找新房</h3>
								<p>全新房屋，全新生活，给你满意的</p>
								<p>优质新盘</p>
							</div>
							<a href="#" class="mz-module-button">查看更多</a>
						</div>
					</div>
					<!-- end about module -->
					<!-- about module -->
					<div class="col-md-3 text-center">
						<div class="mz-module">
							<div class="mz-module-about">
								<i class="fa color1 ot-circle" style="background-image: url(images/phpe022WE.png);background-repeat: no-repeat;"></i>
								<h3>找二手房</h3>
								<p>真实二手房源，链家承诺真实在售</p>
								<p>所见即真</p>
							</div>
							<a href="#" class="mz-module-button">查看更多</a>
						</div>
					</div>
					<!-- end about module -->
					<!-- about module -->
					<div class="col-md-3 text-center">
						<div class="mz-module">
							<div class="mz-module-about">
								<i class="fa  color3 ot-circle" style="background-image: url(images/php4TtmtO.png); background-repeat: no-repeat;"></i>
								<h3>地图找房</h3>
								<p>为您精确定位，位置周边配套设施</p>
								<p>一览无余</p>
							</div>
							<a href="#" class="mz-module-button">查看更多</a>
						</div>
					</div>
					<!-- end about module -->
					<!-- about module -->
					<div class="col-md-3 text-center">
						<div class="mz-module">
							<div class="mz-module-about">
								<i class="fa  color4 ot-circle" style="background-image: url(images/phpDVtHdC1456382078.png); background-repeat: no-repeat;"></i>
								<h3>找地铁房</h3>
								<p>房源紧邻地铁站，交通出行更方便</p>
								<p>说走就走</p>
							</div>
							<a href="#" class="mz-module-button">查看更多</a>
						</div>
					</div>
					<!-- end about module -->
				</div>
			</div>
			<!-- /.container -->
		</section>

        <section id="portfolio">
			<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="section-title">
						<h2>更多精品房源</h2>
						<p>高端精品房源社区，周边配套设施一应俱全，致力打造五星级居家环境</p>
					</div>
				</div>
			</div>
			<div class="row row-0-gutter">
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter mg">
					<div class="ot-portfolio-item pd">
						<figure class="effect-bubba">
							<img src="images/house/琶洲壹号.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>琶洲壹号</h2>
								<p>7500万/套</p>
								<a href="#" data-toggle="modal" data-target="#Modal-1">详情咨询</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter mg">
					<div class="ot-portfolio-item pd" >
						<figure class="effect-bubba">
							<img src="images/house/帝景山庄.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>帝景山庄</h2>
								<p>3400万/套</p>
								<a href="#" data-toggle="modal" data-target="#Modal-2">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
				<!-- start portfolio item -->
				<div class="col-md-4 col-0-gutter mg">
					<div class="ot-portfolio-item pd">
						<figure class="effect-bubba">
							<img src="images/house/侨鑫汇悦台.jpg" alt="img02" class="img-responsive" />
							<figcaption>
								<h2>侨鑫汇悦台</h2>
								<p>均价 130000元/平</p>
								<a href="#" data-toggle="modal" data-target="#Modal-3">View more</a>
							</figcaption>
						</figure>
					</div>
				</div>
				<!-- end portfolio item -->
			</div>
			</div><!-- end container -->
		</section>

        <section id="team" class="light-bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-title">
							<h2>我们的团队</h2>
							<p>这里的每一位都是我们的得力助手 为客户精挑细选 处处留心 致力于为每一位客户搭建理想的家 我们就在这里</p>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- team member item -->
					<div class="col-md-3">
						<div class="team-item">
							<div class="team-image">
								<img src="images/staff/链家董事长.jpg" class="img-responsive" alt="author">
							</div>
							<div class="team-text">
								<h3>左晖</h3>
								<div class="team-position">董事长</div>
								<p>现担任链家董事长<br />
								中国房地产估价师<br />
								房地产经纪人学会副会长<br />
								北京市房地产中介行业协会副会长<br />
							    全联房地产商会副会长</p>
								<!--[endif]-->
								<div class="team-socials">
									<a href="#"><i class="fa fa-wechat"></i></a>
									<a href="#"><i class="fa fa-qq"></i></a>
									<a href="#"><i class="fa fa-weibo"></i></a>
									<a href="#"><i class="fa fa-phone"></i></a>
								</div>
							</div>
						</div>
					</div>
					<!-- end team member item -->
					<!-- team member item -->
					<div class="col-md-3">
						<div class="team-item">
							<div class="team-image">
								<img src="images/staff/链家董事长.jpg" class="img-responsive" alt="author">
							</div>
							<div class="team-text">
								<h3>左晖</h3>
								<div class="team-position">董事长</div>
								<p>现担任链家董事长<br />
								中国房地产估价师<br />
								房地产经纪人学会副会长<br />
								北京市房地产中介行业协会副会长<br />
							    全联房地产商会副会长</p>
								<!--[endif]-->
								<div class="team-socials">
									<a href="#"><i class="fa fa-wechat"></i></a>
									<a href="#"><i class="fa fa-qq"></i></a>
									<a href="#"><i class="fa fa-weibo"></i></a>
									<a href="#"><i class="fa fa-phone"></i></a>
								</div>
							</div>
						</div>
					</div>
					<!-- end team member item -->
					<!-- team member item -->
					<div class="col-md-3">
						<div class="team-item">
							<div class="team-image">
								<img src="images/staff/链家董事长.jpg" class="img-responsive" alt="author">
							</div>
							<div class="team-text">
								<h3>左晖</h3>
								<div class="team-position">董事长</div>
								<p>现担任链家董事长<br />
								中国房地产估价师<br />
								房地产经纪人学会副会长<br />
								北京市房地产中介行业协会副会长<br />
							    全联房地产商会副会长</p>
								<!--[endif]-->
								<div class="team-socials">
									<a href="#"><i class="fa fa-wechat"></i></a>
									<a href="#"><i class="fa fa-qq"></i></a>
									<a href="#"><i class="fa fa-weibo"></i></a>
									<a href="#"><i class="fa fa-phone"></i></a>
								</div>
							</div>
						</div>
					</div>
					<!-- end team member item -->
					<!-- team member item -->
					<div class="col-md-3">
						<div class="team-item">
							<div class="team-image">
								<img src="images/staff/链家董事长.jpg" class="img-responsive" alt="author">
							</div>
							<div class="team-text">
								<h3>左晖</h3>
								<div class="team-position">董事长</div>
								<p>现担任链家董事长<br />
								中国房地产估价师<br />
								房地产经纪人学会副会长<br />
								北京市房地产中介行业协会副会长<br />
							    全联房地产商会副会长</p>
								<!--[endif]-->
								<div class="team-socials">
									<a href="#"><i class="fa fa-wechat"></i></a>
									<a href="#"><i class="fa fa-qq"></i></a>
									<a href="#"><i class="fa fa-weibo"></i></a>
									<a href="#"><i class="fa fa-phone"></i></a>
								</div>
							</div>
						</div>
					</div>
					<!-- end team member item -->
				</div>
			</div>
		</section>

		<section id="partners" >
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-title">
							<h2>我们的合作伙伴</h2>
							<p>宜家  居园之家 教育之家 链家.......</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="owl-partners owl-carousel">
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-1.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-2.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-3.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-4.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-5.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-6.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-7.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-8.png" alt="partners"></div>
							</div>
							<div class="item">
								<div class="partner-logo"><img src="images/demo/partners-9.png" alt="partners"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<section id="contact" class="dark-bg">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<div class="section-title">
							<h2>联系我们</h2>
							<p>如果你有一些问题需要我们的帮助，请联系我们！<br>
							
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="section-text">
							<h4>Our Business Office</h4>
							<p>3422 Street, Barcelona 432, Spain, New Building North, 15th Floor</p>
							<p><i class="fa fa-phone"></i> +101 377 655 22125</p>
							<p><i class="fa fa-envelope"></i> mail@yourcompany.com</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="section-text">
							<h4>Business Hours</h4>
							<p><i class="fa fa-clock-o"></i> <span class="day">Weekdays:</span><span>9am to 8pm</span></p>
							<p><i class="fa fa-clock-o"></i> <span class="day">Saturday:</span><span>9am to 2pm</span></p>
							<p><i class="fa fa-clock-o"></i> <span class="day">Sunday:</span><span>Closed</span></p>
						</div>
					</div>
					<div class="col-md-6">
						<form name="sentMessage" id="contactForm" novalidate="">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Your Name *" id="name" required="" data-validation-required-message="Please enter your name.">
										<p class="help-block text-danger"></p>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="email" class="form-control" placeholder="Your Email *" id="email" required="" data-validation-required-message="Please enter your email address.">
										<p class="help-block text-danger"></p>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<textarea class="form-control" placeholder="Your Message *" id="message" required="" data-validation-required-message="Please enter a message."></textarea>
										<p class="help-block text-danger"></p>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="row">
								<div class="col-lg-12 text-center">
									<div id="success"></div>
									<button type="submit" class="btn">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<p id="back-top">
			<a href="#top"><i class="fa fa-angle-up"></i></a>
		</p>
	
		<!-- Modal for portfolio item 1 -->
		<div class="modal fade" id="Modal-1" tabindex="-1" role="dialog" aria-labelledby="Modal-label-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="Modal-label-1">琶洲壹号</h4>
					</div>
					<div class="modal-body">
						<img src="images/house/琶洲壹号01.jpg" class="img-responsive" />
						<div class="modal-works"><span>广州市海珠区</span><span>别墅</span><span>7室5厅6卫 建面 526m²（南朝向)</span></div>
						<p>卧室：主卧独立层，双开门设计，双阳台设计，南北对流，通风采光好 地下室：层高近6米，布局紧凑实用大气 其它：天面层采用空中花园加按摩池设计，充分享受娱乐休闲。</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal for portfolio item 2 -->
		<div class="modal fade" id="Modal-2" tabindex="-1" role="dialog" aria-labelledby="Modal-label-2">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="Modal-label-2">帝景山庄</h4>
					</div>
					<div class="modal-body">
						<img src="images/house/帝景山庄的01.jpg" alt="img01" class="img-responsive" />
						<div class="modal-works"><span>广州市天河区</span><span>别墅</span><span>5室3厅6卫 建面 430m²（南,北朝向）</span></div>
						<p>&nbsp;花园：自带独立花园，更显气派，也拥有更大的活动空间 餐厅：餐厅面积大，能够容纳十人餐桌不显拥挤，十分气派</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal for portfolio item 3 -->
		<div class="modal fade" id="Modal-3" tabindex="-1" role="dialog" aria-labelledby="Modal-label-3">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="Modal-label-3">侨鑫汇悦台</h4>
					</div>
					<div class="modal-body">
						<img src="images/house/侨鑫汇悦台01.jpg" alt="img01" class="img-responsive" />
						<div class="modal-works"><span>广州市天河区</span><span>住宅</span><span>大户型</span><span>车位充足</span></div>
						<p>侨鑫汇悦台在售平层建面235-435平单位，3.5米层高，售价13万/平起，非毛坯发售；另有复式建面435-1538平，售价约15万/平</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="<%=basePath%>static/js/homeJs.js"></script>
		<script src="<%=basePath%>static/js/jquery.easing.min.js"></script>
		<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>static/js/owl.carousel.min.js"></script>
		<script src="<%=basePath%>static/js/cbpAnimatedHeader.js"></script>
		<script src="<%=basePath%>static/js/jquery.appear.js"></script>
		<script src="<%=basePath%>static/js/SmoothScroll.min.js"></script>
		<script src="<%=basePath%>static/js/theme-scripts.js"></script>
	</body>
</html>