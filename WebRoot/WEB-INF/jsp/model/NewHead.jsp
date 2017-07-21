<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!--navbar-Start-->
	<div>
		<nav class="navbar navbar-default navigation-clean-button">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand navbar-link" href="#"
					style="font-size: 20px;">我爱我家</a>
				<button class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#navcol-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="navcol-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false" href="#"><i
							class="glyphicon glyphicon-map-marker"></i>广州<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a href="#">深圳</a></li>
							<li role="presentation"><a href="#">佛山</a></li>
							<li role="presentation"><a href="#">惠州</a></li>
							<li role="presentation"><a href="#">中山</a></li>
						</ul></li>
					<li role="presentation"><a href="#">成交</a></li>
					<li role="presentation"><a href="#">小区</a></li>
				</ul>
				<p class="navbar-text navbar-right actions">
					<c:choose>
						<c:when test="${empty userInfo}">
							<a class="navbar-link login" href="#" ></a> 
						</c:when>
						<c:otherwise>
							<a class="navbar-link login" href="#" >${userInfo}</a> 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty }">
							<a class="btn btn-default action-button" role="button" data-toggle="modal" data-target="#UserLogin" href="#" style="background-color:rgb(268,199,1)">
							登陆
							</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-default action-button" role="button" href="/logout" style="background-color:#F1F1F1">
							注销
							</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		</nav>
	</div>
	<!--nav-bar End-->