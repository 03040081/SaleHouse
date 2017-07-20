<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="Search_Bar">
	<form class="search-form">
		<div class="input-group">
			<div class="input-group-addon">
				<span><i class="glyphicon glyphicon-search"></i></span>
			</div>
			<input id="keyword-head" class="form-control" type="text" placeholder="请输入新房地址或新房名"
				value="${keyword}">
			<div class="input-group-btn">
				<button id="btn-search-head" class="btn btn-default" type="button">搜索</button>
			</div>
		</div>
	</form>
	<a class="find-hourse"> <i class="glyphicon glyphicon-map-marker"></i>地图找房
	</a> <a class="find-hourse"> <i
		class="glyphicon glyphicon-download-alt"></i>APP下载
	</a>
</div>
