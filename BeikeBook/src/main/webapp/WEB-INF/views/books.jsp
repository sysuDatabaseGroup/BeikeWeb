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
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
	<div class="books_tab">
		<ul id="books_tab_ul">
			<li class="tab_on"><span>未售出</span></li>
			<li><span>已售出</span></li>
		</ul>
	</div>

	<div class="books_list">
		<ul id="books_list_ul">
			<c:forEach items="${noSellBookInfo}" var="i">
				<li>
					<div id="books_list_img">
						<img src="images/books/${i.bookClassImg}" alt="" />
					</div>
					<div id="books_list_info">
						<p><em>书名：</em><c:out value="${i.bookClassName}"/>
						<p><em>书籍编号：</em><c:out value="${i.bookNum}"/></p>
						<p><em>托管单位：</em><c:out value="${i.schoolName}${i.districtName}"/></p>
						<p><em>托管时间：</em><c:out value="${i.datetime}"/></p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div class="books_list_sold" style="margin-top:30px;">
		<ul id="books_list_sold_ul">
			<c:forEach items="${selledBookInfo}" var="i">
				<li>
					<div id="books_list_sold_img">
						<img src="images/books/${i.bookClassImg}" alt="" />
					</div>
					<div id="books_list_sold_info">
						<p id="books_list_sold_info_price">￥<c:out value="${i.sellPrice}"/></p>
						<p><em>书名：</em><c:out value="${i.bookClassName}"/>
						<p><em>书籍编号：</em><c:out value="${i.bookNum}"/></p>
						<p><em>售出时间：</em><c:out value="${i.datetime}"/></p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
	
</body>	
</html>












