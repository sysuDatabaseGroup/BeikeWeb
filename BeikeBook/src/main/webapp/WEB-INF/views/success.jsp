<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<body>
	<div class="success">
		<span id="success_icon"></span>
		<h2>支付成功</h2>
		<span>请于三日内到<c:out value="${districtName}"/>领取书本</span>
	</div>
	
	<div class="success_book">
		<div id="success_book_img">
			<img src="images/books/${bookClassImg}" alt="" />
		</div>
		<div id="success_book_info">
			<p>书名：<em><c:out value="${bookClassName}"/></em></p>
			<p>取书号：<em><c:out value="${takeBookNum}"/></em></p>
			<p>地址：<em><c:out value="${address}"/></em></p>
		</div>
		<div class="clearbox"></div>
	</div>

	<div class="success_btn">
		<a href="index"><span id="continue">继续购买</span></a>
		<a href="center"><span id="center">个人中心</span></a>
	</div>
</body>	
</html>