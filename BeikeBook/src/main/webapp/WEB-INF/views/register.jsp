<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<script type="text/javascript">
	$(function(){
		$("#repassword").keyup(function(){
			var $pw=$("#password").val();
			var $rpw=$("#repassword").val();
			if($pw==$rpw){
				$("#tip").css({'display':'none'});
			}else{
				$("#tip").css({'display':'block'});
			}
		})
	});
	
</script>
<body>
	<div class="sign-in">
		<div class="box">
			<div id="logo"></div>
			<form name="signIn" id="signIn" action="" method="post">
				<label>
					<span>用户名</span>
					<input type="text" name="username" id="username" required="required">
				</label>
				<label>
					<span>密码</span>
					<input type="password" name="password" id="password" required="required">
				</label>
				<label>
					<span>确认密码</span>
					<input type="password" name="repassword" id="repassword"  required="required">
					<span id="tip">* 两次密码输入不同</span>
				</label>
				<input type="submit" id="submit" value="注册">
			</form>
			<div class="boxTip">
				<a href="<c:url value='/login'/>"><span>已有账号？</span></a>
			</div>
		</div>
	</div>
</body>	
</html>