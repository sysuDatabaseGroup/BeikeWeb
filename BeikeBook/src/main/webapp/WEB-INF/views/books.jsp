<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<c:forEach items="${booksViewSellingBooks}" var="i">
				<li>
					<div id="books_list_img">
						<img src="<c:url value='${i.coverPath}' />" alt="" />
					</div>
					<div id="books_list_info">
						<p><em>书名：</em><c:out value="${i.title}"/>
						<p><em>书籍编号：</em><c:out value="${i.dealedNums}"/></p>
						<span id="buy_rent_num">x<c:out value="${i.amount}"/></span>
						<p><em>托管单位：</em><c:out value="${i.schoolName} ${i.districtName}"/></p>
						<p><em>托管时间：</em><fmt:formatDate type="date" value="${i.datetime}" /></p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

	<div class="books_list_sold" style="margin-top:30px;">
		<ul id="books_list_sold_ul">
			<c:forEach items="${booksViewSoldBooks}" var="i">
				<li>
					<div id="books_list_sold_img">
						<img src="<c:url value='${i.coverPath }'/>" alt="" />
					</div>
					<div id="books_list_sold_info">
						<p id="books_list_sold_info_price">￥<c:out value="${i.sellingPrice}"/></p>
						<p><em>书名：</em><c:out value="${i.title}"/>
						<p><em>书籍编号：</em><c:out value="${i.dealedNums}"/></p>
						<span id="buy_rent_num">x<c:out value="${i.amount}"/></span>
						<p><em>售出时间：</em><fmt:formatDate type="date" value="${i.selledDatetime}" /></p>
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
