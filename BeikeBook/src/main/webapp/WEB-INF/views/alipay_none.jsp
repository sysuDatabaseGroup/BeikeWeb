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
		<span id="alipay_tip">可提现余额<em>￥<c:out value="${moneyNum}"/></em></span>
	</div>

	<div class="alipay_info">
		<input type="text" name="account" id="account" placeholder="暂不可提现，需满5元以上才可提现" required />
		<input type="text" name="aliname" id="aliname" placeholder="暂不可提现，需满5元以上才可提现" required />
		<div id="alipay_info_message">
			<span>短信验证码</span>
			<input type="text" name="message" id="message" placeholder="请输入验证码" required />
			<span id="message_btn_none">无法获取</span>
		</div>
	</div>

	<div class="clearbox"></div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>