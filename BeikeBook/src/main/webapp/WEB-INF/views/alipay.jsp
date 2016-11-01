<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<body>
	<div class="alipay">
		<span id="alipay_method">提现方式</span>
		<span id="alipay_tip">可提现余额    <em>￥<c:out value="${user.withdrawalAmount}"/></em></span>
	</div>
	<form action="<c:url value='/alipay'/>" method="post">
	<div class="alipay_info">
		<input type="text" name="alipayAccount" id="account" placeholder="请输入支付宝账号" required />
		<input type="text" name="alipayName" id="aliname" placeholder="请输入真实姓名" required />
		<div id="alipay_info_message">
			<span>短信验证码</span>
			<input type="text" name="phone" id="phone" placeholder="请输入手机号码" required />
			<input type="text" name="message" id="message" placeholder="请输入验证码" required />
			<span id="message_btn">获取验证码</span>
		</div>
	</div>

	<div class="clearbox"></div>
	
	<input type="submit" name="alipay_apply" id="alipay_apply" value="申请提现" />
	</form>
	<c:out value="${message}"></c:out>
	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>