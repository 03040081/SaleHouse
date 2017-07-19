<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String modelpath = request.getContextPath();
String modelBase = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+modelpath+"/";
%>
<hr>
<div class="model">
	<div class="modelLeft">
		<div>
			<a href="<%=modelBase%>"><img
				src="<%=modelBase%>static/images/14996453503361_3.jpg.232x174.jpg"></a>
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