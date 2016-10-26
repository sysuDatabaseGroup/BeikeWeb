<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
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











