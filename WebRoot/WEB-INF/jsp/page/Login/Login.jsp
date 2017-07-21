<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >

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

<head>
<meta charset="UTF-8">
<title>Login And Sign up</title>

<link rel="stylesheet" href="<%=basePath%>static/css/Login.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>

</head>
<body>

<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>登陆</h2>
            <p>回到我爱我家</p>
            <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>注册</h2>
            <p>加入我们，一起找到你属于你的家</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="bg.jpg" alt="" /></div>
      </div>
      <div class="cont_forms" > 
        
        <div class="cont_img_back_"> <img src="bg.jpg" alt="" /></div>
        <form action="loginU" method="post">
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>登陆</h2>
          <input type="text" name="username" placeholder="账号" />
          <input type="password" name="password" placeholder="密码" />
          <button class="btn_login" onClick="cambiar_login()" type="submit">LOGIN</button>
        </div>
        </form>
        <form action="registerUser" method="post">
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>注册</h2>
          <input type="text" name="username" placeholder="邮箱" />
          <input type="text" name="password" placeholder="账号" />
          <input type="password" placeholder="密码" />
          <input type="password" placeholder="确认密码" />
          <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>




<!--Script of Login-->
<script src="<%=basePath%>static/js/Login.js"></script>

</body>
</html>