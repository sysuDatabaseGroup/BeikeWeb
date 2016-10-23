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

	<div class="buy_rent" style="margin-top:5px;">
		<ul id="buy_rent_ul">
			<c:forEach items="${rsBookInfo}" var="i">
				<li>
					<div id="buy_rent_img">
						<img src="images/books/${i.bookClassImg}" alt="" />
					</div>
					<div id="buy_rent_info">
						<p id="books_list_sold_info_price">￥<c:out value="${i.price}"/></p>
						<p><em>书名：</em><c:out value="${i.bookClassName}"/>
						<p><em>书籍编号：</em><c:out value="${i.bookNum}"/></p>
						<c:choose>
							<c:when test="${i.isRent}">
								<p><em>购买时间：</em><c:out value="${i.datetime}"/></p>
							</c:when>
							<c:otherwise>
								<p><em>租书时间：</em><c:out value="${i.datetime}"/></p>
							</c:otherwise>
						</c:choose>
					</div>
					<span id="buy_rent_num">x<c:out value="${i.num}"/></span>
					<c:if test="${i.isRent}">
						<div class="clearbox"></div>
						<span id="buy_rent_info_tip">已租用<em><c:out value="${i.duringTime}"/></em>
						扣除费用<em style="color:#be2222;"><c:out value="${i.money}"/>元</em></span>
					</c:if>
				</li>
			</c:forEach>
		</ul>

	</div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>