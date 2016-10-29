<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<body>
	<div class="buy_rent" style="margin-top:5px;">
		<ul id="buy_rent_ul">
			<c:forEach items="${orders}" var="i">
				<li>
					<div id="buy_rent_img">
						<img src="<c:url value='${i.dealedBook.book.coverPath }'/>" alt="" />
					</div>
					<div id="buy_rent_info">
						<p id="books_list_sold_info_price">
						￥
						<c:choose>
							<c:when test="${i.isRenting > 0}">
								<c:out value="${i.dealedBook.sellingPrice }"/>
							</c:when>
							<c:otherwise>
								<c:out value="${i.dealedBook.rentalPrice }"/>
							</c:otherwise>
						</c:choose>
						</p>
						<p><em>书名：</em><c:out value="${i.dealedBook.book.title}"/>
						<p><em>书籍编号：</em><c:out value="${i.dealedBook.dealedNum}"/></p>
						<c:choose>
							<c:when test="${i.isRenting > 0}">
								<p><em>购买时间：</em><c:out value="${i.datetime}"/></p>
							</c:when>
							<c:otherwise>
								<p><em>租书时间：</em><c:out value="${i.datetime}"/></p>
							</c:otherwise>
						</c:choose>
					</div>
					<span id="buy_rent_num">x<c:out value="${i.amount}"/></span>
					<c:if test="${i.isRenting == 0}">
						<div class="clearbox"></div>
						<span id="buy_rent_info_tip">已租用<em><c:out value=""/></em>
						扣除费用<em style="color:#be2222;"><c:out value=""/>元</em></span>
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