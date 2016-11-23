<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>

<body>
	<div class="sign-in">
		<div class="box">
			<div id="logo"></div>
			<form name="signIn" id="signIn" action="" method="post">
				<label>
					<span>用户名</span>
					<input type="text" name="username" id="username">
				</label>
				<label>
					<span>密码</span>
					<input type="password" name="password" id="password">
				</label>
				<h2>${message}</h2>
				<input type="submit" id="submit" value="登录">
			</form>
			<div class="boxTip">
				<a href="<c:url value='/index' />"><span>首页</span></a>
				<a href="<c:url value='/register' />"><span>注册账号</span></a>
				<!-- <a href="#"><span>忘记密码？</span></a> -->
			</div>
		</div>
	</div>
</body>	
</html>