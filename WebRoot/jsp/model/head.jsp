<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
	String indexpath = request.getContextPath();
	String indexBase = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ indexpath + "/";
%>



	<div>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<%=indexBase%>index">SaleHouse</a>
				</div>
				<div>
					<div style="float:left;">
						<ul class="nav navbar-nav">
							<li><a href="<%=indexBase%>">首页</a></li>
							<li><a href="<%=indexBase + ""%>">二手房</a></li>
							<li><a href="<%=indexBase + ""%>">新房</a></li>

							<li><a href="<%=indexBase%>">租房</a></li>
						</ul>
					</div>
					<div style="float:right;">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">登录/注册${status} <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="${account_login_link}">登录${ account_Login}</a></li>
									<li><a href="${logout_register_link }">注册${logout_register }</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	</div>


	

<script>
	$(document).ready(function() {
		//下拉菜单
		//		$('.dropdown-toggle').dropdown();
		$(".prev,.next").hover(function() {
			$(this).stop(true, false).fadeTo("show", 0.9);
		}, function() {
			$(this).stop(true, false).fadeTo("show", 0.4);
		});
		$(".banner-box").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "fold",
			interTime : 3500,
			delayTime : 500,
			autoPlay : true,
			autoPage : true,
			trigger : "click"
		});
	});
</script>
