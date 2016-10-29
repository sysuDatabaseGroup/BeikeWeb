<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>贝壳图书管理后台登陆</title>
<link href="/admin/stylesheets/style_log.css" rel="stylesheet" type="text/css">
<style>
.rem_sub{
display: inline-block;
width: 100%;
margin-top: 15px;
text-align: center;
}
html{
font-family: '微软雅黑';
}
body{
font-family: '微软雅黑';
}
input{
font-family: '微软雅黑' !important;
}
.login_m{
margin-top: 180px;
}
.login_boder h2{
font-size: 15px;
}
.error_msg{
color: red;
font-size: 12px;
}
.error_msg:before{
content: "*";
}
</style>
</head>

<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div style="text-align: center; font-size: 30px;font-family: '微软雅黑';margin-bottom: 15px;">贝壳图书管理后台</div>
		<form class="login_boder" action="/backend/login" method="POST">
			<div class="login_padding" id="login_model">

				<h2>用户名</h2>
				<label>
					<input type="text" id="username" name="name" class="txt_input txt_input2" placeholder="请输入用户名">
				</label>
				<h2>密码</h2>
				<label>
					<input type="password" name="password" id="userpwd" class="txt_input" value="" placeholder="请输入密码">
				</label>
				<c:if test="${! empty error_msg}">
				<p class="error_msg">${error_msg}</p>
				</c:if>
				<div class="rem_sub">
					<label>
						<input type="submit" class="sub_button" name="button" id="button" value="登陆" style="opacity: 0.7;float: none;">
					</label>
				</div>
			</div>
		</form>
	</div>
</body></html>