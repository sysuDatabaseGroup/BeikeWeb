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
		<span>明早11点放置至 <c:out value="${district.address}"/>处</span>
	</div>
	
	<div class="success_book">
		<div id="success_book_img">
			<img src="<c:url value='${dealedBook.book.coverPath}' />" alt="" />
		</div>
		<div id="success_book_info">
			<p>书名：<em><c:out value="${dealedBook.book.title}"/></em></p>
			<p>取书号：<em><c:out value="${rentingOrder.takingBookNum}"/></em></p>
			<!-- <p>配送员：<em><c:out value="${deliverName}(${deliverPhone})"/></em></p> -->
			<p>地址：<em><c:out value="${district.address}"/></em></p>
		</div>
		<div class="clearbox"></div>
	</div>

	<div class="success_btn">
		<a href="<c:url value='/index' />"><span id="continue">继续购买</span></a>
		<a href="<c:url value='center' />"><span id="center">个人中心</span></a>
	</div>
</body>	
</html>