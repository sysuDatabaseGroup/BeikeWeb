<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>贝壳易书</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; maximum-scale=1.0;" />
	<meta http-equiv="X-UA-Compatible" content="IE=9" />
	<meta name="format-detection" content="telephone=no" />
	<meta name="format-detection" content="email=no" />
	<meta name="format-detection" content="address=no;">
	<meta name="keywords" content="大学生,二手书,大学教材" />
	<meta name="description" content="大学生自己的二手书阁" />
	<meta name="author" content="Pang Lin" />
<link rel="stylesheet" type="text/css" href="css/CSS.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- <script src="http://code.jquery.com/jquery-1.8.3.min.js"></script> -->
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
			<span id="message_btn_none">无法获取</div>
		</div>
	</div>

	<div class="clearbox"></div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>