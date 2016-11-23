<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="current" value="<%=new java.util.Date() %>" />
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
								<c:out value="${i.dealedBooks[0].book.sellingPrice }"/>
							</c:when>
							<c:otherwise>
								<c:out value="${i.dealedBooks[0].book.rentalPrice }"/>
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
						<p><em>取书号：</em><c:out value="${i.takingBookNum}"/></p>
						<c:if test="${i.isRenting == 0}">
							<p><em>归还：</em>
								<c:choose>
								<c:when test="${i.returned == 0}">
									<c:out value="未归还" />
								</c:when>
								<c:otherwise>
									<c:out value="已归还" />
								</c:otherwise>
							</c:choose>
							</p>
						</c:if>
					</div>
					<span id="buy_rent_num">x<c:out value="${i.amount}"/></span>
					<c:if test="${i.isRenting == 0}">
						<div class="clearbox"></div> 
						<c:set var="days" value="${(current.time-i.datetime.time)/(1000*3600*24)}" />
						<fmt:parseNumber var="day" integerOnly="true" type="number" value="${days}" />
						<fmt:parseNumber var="y" integerOnly="true" type="number" value="${(day+15)/30}" />
						<fmt:parseNumber var="w" integerOnly="true" type="number" value="${y*i.amount}" />
						<span id="buy_rent_info_tip">已租用<c:out value="${day+1}" /><em>天</em>
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