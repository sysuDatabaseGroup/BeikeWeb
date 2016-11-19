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
		<c:choose>
			<c:when test="${sellingOrder.deliveryMethodId == 1}">
				<span>请于三日内到 <c:out value="${district.name}"/> 领取书本</span>
			</c:when>
			<c:otherwise>
				<span>届时将送到你的宿舍 <c:out value="${user.dorm}"/> </span>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="success_book">
		<div id="success_book_img">
			<img src="<c:url value='${dealedBook.book.coverPath}' />" alt="" />
		</div>
		<div id="success_book_info">
			<p>书名：<em><c:out value="${dealedBook.book.title}"/></em></p>
			<c:if test="${sellingOrder.deliveryMethodId == 1}">
				<p>取书号：<em><c:out value="${sellingOrder.takingBookNum}"/></em></p>
				<p>地址：<em><c:out value="${district.address}"/></em></p>
			</c:if>
		</div>
		<div class="clearbox"></div>
	</div>

	<div class="success_btn">
		<a href="<c:url value='/index' />"><span id="continue">继续购买</span></a>
		<a href="<c:url value='/center' />"><span id="center">个人中心</span></a>
	</div>
</body>	
</html>