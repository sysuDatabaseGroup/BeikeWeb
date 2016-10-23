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
	<div class="success">
		<span id="success_icon"></span>
		<h2>支付成功</h2>
		<span>明早11点放置至<c:out value="${districtName}"/>处</span>
	</div>
	
	<div class="success_book">
		<div id="success_book_img">
			<img src="images/books/${bookClassImg}" alt="" />
		</div>
		<div id="success_book_info">
			<p>书名：<em><c:out value="${bookClassName}"/></em></p>
			<p>取书号：<em><c:out value="${takeBookNum}"/></em></p>
			<p>配送员：<em><c:out value="${deliverName}(${deliverPhone})"/></em></p>
		</div>
		<div class="clearbox"></div>
	</div>

	<div class="success_btn">
		<a href="index.jsp"><span id="continue">继续购买</span></a>
		<a href="center.jsp"><span id="center">个人中心</span></a>
	</div>
</body>	
</html>