<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
											<a href="City?pageNo=2&cityId=${city.cityId}">${city.cityName}</a>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
						<li role="presentation"><a href="#">成交</a></li>
						<li role="presentation"><a href="#">小区</a></li>
					</ul>
				<p class="navbar-text navbar-right actions">
					<c:choose>
						<c:when test="${empty userInfo}">
							<a class="navbar-link login" href="#" ></a> 
						</c:when>
						<c:otherwise>
							<a class="navbar-link login" href="#" >${userInfo.username}</a> 
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${empty userInfo}">
							<a class="btn btn-default action-button" role="button"  href="Login" style="background-color:rgb(268,199,1)">
							登陆
							</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-default action-button" role="button" href="Logout" style="background-color:#F1F1F1">
							</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		</nav>
	</div>