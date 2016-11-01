<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate var="currentTime" pattern="D" type="date" value="<%=new java.util.Date() %>" />
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
						<img src="<c:url value='${i.dealedBooks[0].book.coverPath }'/>" alt="" />
					</div>
					<div id="buy_rent_info">
						<p id="books_list_sold_info_price">
						￥
						<c:choose>
							<c:when test="${i.isRenting > 0}">
								<c:out value="${i.dealedBooks[0].sellingPrice }"/>
							</c:when>
							<c:otherwise>
								<c:out value="${i.dealedBooks[0].rentalPrice }"/>
							</c:otherwise>
						</c:choose>
						</p>
						<p><em>书名：</em><c:out value="${i.dealedBooks[0].book.title}"/>
						<p><em>书籍编号：</em><c:out value="${i.dealedBooks[0].dealedNum}"/></p>
						<c:choose>
							<c:when test="${i.isRenting > 0}">
								<p><em>购买时间：</em><fmt:formatDate type="date" value="${i.datetime}" /></p>
							</c:when>
							<c:otherwise>
								<p><em>租书时间：</em><fmt:formatDate type="date" value="${i.datetime}" /></p>
							</c:otherwise>
						</c:choose>
					</div>
					<span id="buy_rent_num">x<c:out value="${i.amount}"/></span>
					<c:if test="${i.isRenting == 0}">
						<div class="clearbox"></div> 
						<fmt:formatDate var="rentedDay" pattern="D" type="date" value="${i.datetime}" />
						<fmt:parseNumber var="w" integerOnly="true" type="number" value="${((currentTime-rentedDay+15)/30)*i.amount}" />
						<span id="buy_rent_info_tip">已租用<c:out value="${currentTime-rentedDay+1}" /><em>天</em>
						扣除费用<em style="color:#be2222;"><c:out value="${w}"/>元</em></span>
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