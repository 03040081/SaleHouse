<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String modelpath = request.getContextPath();
	String modelBase = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ modelpath + "/";
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" href="<%=basePath%>static/css/Pretty-Footer.css">
<link rel="stylesheet" href="<%=basePath%>static/css/Footer-Basic.css">
<link rel="stylesheet" href="<%=basePath%>static/fonts/font-awesome.min.css">


<style type="text/css">
	.condition-list {
		display: inline;
		margin: 5px 0;
	}
	
	.condition-name{
		background: #fff;
		padding: 1px 5px;
		margin: 0px;
		cursor: pointer;
	}
	
	.condition-close {
		background: #efefef;
		padding: 1px 3px;
		margin: 0px;
		cursor: pointer;
	}
	
	.condition {
		display: none;
		margin: 0 5px;
	}
	
	.condition-show {
		display: inline;
		margin: 0 5px;
	}
	
	.condition-close a{
		text-decoration: none;
	}
	
	.condition-selected {
		color: navy;
	}
</style>


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
				<c:forEach items="${region}" var="reg" varStatus="index">
					<c:choose>
						<c:when test="${reg.regionId == regId}">
							<li><a href="DetailsSearch?regionId=${reg.regionId}" class="condition-selected"><b>${reg.regionName}</b></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="DetailsSearch?regionId=${reg.regionId}">${reg.regionName}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<p>售价：</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li>
					<c:choose>
						<c:when test="${min==0 && max == 50}">
							<a class='condition-selected' href="DetailsSearch?min=0&max=50">50万以下</a></li>
						</c:when>
						<c:otherwise>
							<a href="DetailsSearch?min=0&max=50">50万以下</a></li>
						</c:otherwise>
					</c:choose>
				<li><a href="DetailsSearch?min=0&max=80">50-80万</a></li>
				<li><a href="DetailsSearch?min=0&max=100">80-100万</a></li>
				<li><a href="DetailsSearch?min=0&max=120">100-120万</a></li>
				<li><a href="DetailsSearch?min=0&max=150">120-150万</a></li>
				<li><a href="DetailsSearch?min=0&max=200">150-200万</a></li>
				<li><a href="DetailsSearch?min=200&max=300">200-300万</a></li>
				<li><a href="DetailsSearch?min=300">300万以上</a></li>
			</ul>
			<p>类型:</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<c:forEach items="${premisetype}" var="pretype" varStatus="index">
					<c:choose>
						<c:when test="${pretype.btypeId == btype}">
							<li><a class="condition-selected" href="DetailsSearch?buildType=${pretype.btypeId}"><b>${pretype.typeName}</b></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="DetailsSearch?buildType=${pretype.btypeId}">${pretype.typeName}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<p>户型：</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<c:forEach items="${housetype}" var="type" varStatus="index">
					<c:choose>
						<c:when test="${type.htypeId == htype}">
							<li><a class="condition-selected" href="DetailsSearch?houseType=${type.htypeId}"><b>${type.typeName}</b></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="DetailsSearch?houseType=${type.htypeId}">${type.typeName}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<p>销售状态：</p>
			<ul>
				<li class="headlight"><a href="#">不限</a></li>
				<li><a href="#" class="conditon-selected"><b>在售</b></a></li>
				<li><a href="#">售罄</a></li>
			</ul>
		</div>
	</div>

	<div id="Search_Tag" class="light-bg">
		<span>已选条件：</span>
		<div class="condition-list">
			<!-- 区域 -->
			<c:forEach items="${region}" var="reg" varStatus="index">
				<c:if test="${reg.regionId == regId}">
					<div class="condition-show">
						<span class="condition-name">${reg.regionName}</span><span
							class="condition-close"><a>×</a></span>
					</div>
				</c:if>
			</c:forEach>
			<div class="condition">
				<span class="condition-name">50万以下</span><span class="condition-close"><a>×</a></span>
			</div>
			<!-- 户型 -->
			<c:forEach items="${housetype}" var="type" varStatus="index">
				<c:choose>
					<c:when test="${type.htypeId == htype}">
						<div class="condition-show">
							<span class="condition-name">${type.typeName}</span><span class="condition-close"><a>×</a></span>
						</div>
					</c:when>
					<c:otherwise>
						<div class="condition">
							<span class="condition-name">${type.typeName}</span><span class="condition-close"><a>×</a></span>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 类型 -->
			<c:forEach items="${premisetype}" var="pretype" varStatus="index">
				<c:if test="${pretype.btypeId == btype}">
					<div class="condition-show">
						<span class="condition-name">${pretype.typeName}</span><span class="condition-close"><a>×</a></span>
					</div>
				</c:if>
			</c:forEach>
			<!-- 在售 -->
			<div class="condition-show">
				<span class="condition-name">在售</span><span class="condition-close"><a>×</a></span>
			</div>
		</div>
	</div>
	<div id="Search_Result">
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active"><a href="#default"
				aria-controls="default" role="tab" data-toggle="tab">默认排序</a></li>
			<li role="presentation"><a href="#price"
				aria-controls="de-price" role="tab" data-toggle="tab">价格&nbsp;↓</a></li>
			<li role="presentation"><a href="#saledtime"
				aria-controls="saledtime" role="tab" data-toggle="tab">开盘时间&nbsp;↓</a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<%-- 默认排序 --%>
			<div role="tabpanel" class="tab-pane active" id="home">

					<!-- Tab panel-->
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="home">
							<div class="detail-content">
								<div class="tit clearfix productTit">
									<p style="font-size: 20px; padding-left: 20px;">
										共找到&nbsp; <span
											style="font-size: 25px; font-weight: bolder; color: darkgoldenrod;">${pagePre.totalRecords != null ? pagePre.totalRecords : 0}</span>&nbsp;个楼盘
									</p>
								</div>
								<ul class="hx-list">
									<c:forEach items="${pagePre.list}" var="premises" varStatus="index">
									<li>
										<div class="fl">
											<a href="HouseInfo?buildId=${premises.buildId}" target="_blank"
												data-lightbox="photo"><img class="hx-list-img"
												src="<%=modelBase%>${premises.iconUrl != null ? premises.iconUrl : 'upload/m_size/example.jpg'}" /></a>
											<div class="show-title">
												<p class="head"><a href="HouseInfo?buildId=${premises.buildId}">${premises.buildName}</a></p>
												<p class="show-detail">主推户型：
													<c:forEach items="${premises.houses}" var="house">
														${house.houseDesc}&nbsp;
													</c:forEach>
												</p>
												<p class="show-detail">开盘时间：${premises.inOpen}</p>
												<p class="show-detail">入住时间：${premises.inLive}</p>
												<p class="show-detail">详细地址：${premises.buildAddress}</p>
											</div>
										</div>
										<div class="fr">
											<p class="price-zero">
												<c:choose>
													<c:when test="${avgPrices[index.index] == 0}">
														<span class="price-one">价格待定</span>
													</c:when>
													<c:otherwise>
														<span class="price-one">${avgPrices[index.index]}</span> <span class="price-two">万</span>
														<span class="price-three"> 
															<em style="font-size: inherit;">(222<em> 元/平方米)
														</span>
													</c:otherwise>
												</c:choose>
											</p>
											<p style="font-size: 20px; margin-right: 45px;">
												<i class="glyphicon glyphicon-earphone"></i> 400-8820-8820 转
												38
											</p>
										</div>
									</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="profile"></div>
						<div role="tabpanel" class="tab-pane" id="messages"></div>
					</div>
			</div>
		<%-- 排序2 --%>
		<div role="tabpanel" class="tab-pane" id="profile"></div>
		<%-- 排序3 --%>
		<div role="tabpanel" class="tab-pane" id="messages"></div>
	</div>
	<%@include file="../../model/paging.jsp"%>
	<hr>
	</div>


	<!-- footer-Start -->
	<%@include file="../../model/NewFooter.jsp"%>
	<!-- footer-End -->


	<!-- Modal for Login -->
	<!-- <div class="modal fade" id="UserLogin" tabindex="-1" role="dialog" aria-labelledby="ModalLabel">
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
                        	<form role="form" action="Login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="账号" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">记住我的账号
                                    </label>
                                </div>
                                Change this to a button or input when using this as a form
                                <button type="submit" class="btn btn-lg btn-success btn-block">登陆</button>
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
		
 -->



 
	<!-- Bootstrap core JavaScript
			================================================== -->

	<script src="<%=basePath%>static/js/jquery.min.js"></script>
	<script src="<%=basePath%>static/js/bootstrap.min.js"></script>
</body>

</html>