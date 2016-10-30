<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<body>
	<div class="center">
		<div id="center_top">
			<span id="center_photo">
				<img src="<c:url value='${user.wxPhoto}' />" alt="" />
			</span>
			<span id="center_username"><c:out value="${user.wxName}"/></span>
		</div>
		<div id="center_bottom">
			<ul id="center_ul">
				<a href="buy_rent">
				<li>
					<h6><c:out value="${amountOfboughtAndRentedBook}"/></h6>
					<span>购书｜租书</span>
				</li>
				</a>
				<a href="books">
				<li>
					<h6><c:out value="${amountOfBook}"/></h6>
					<span>托管出售的书</span>
				</li>
				</a>
				<a href="alipay">
				<li>
					<h6><c:out value="${user.withdrawalAmount}"/></h6>
					<span>可提现费用</span>
				</li>
				</a>
			</ul>
		</div>
	</div>
	<div class="center_info">		
		<ul id="center_info_ul">
			<li>
				<span>城市</span>
				<span id="city" class="center_info_item"><c:out value="${user.city.name}"/></span>
			</li>
			<li>
				<span>学校</span>
				<span id="school" class="center_info_item"><c:out value="${user.school.name}"/></span>
			</li>
			<li>
				<span>宿舍</span>
				<span id="dorm" class="center_info_item"><c:out value="${user.dorm}"/></span>
			</li>
		</ul>
	</div>

	<div class="center_option">
		<ul id="center_option_ul">
			<a href="#">
				<li>
					<h6 id="icon_sellBook"></h6>
					<span>我要卖书</span>
					<span id="city" class="center_option_item">可上门收书，让旧书卖钱</span>
				</li>
			</a>
			<a href="#">
				<li>
					<h6 id="icon_helpCenter"></h6>
					<span>帮助中心</span>
					<span id="school" class="center_option_item">你想知道的这里都有</span>
				</li>
			</a>
			<a href="index">
				<li>
					<h6 id="icon_buyBook"></h6>
					<span>继续购书</span>
					<span id="school" class="center_option_item">前往首页</span>
				</li>
			</a>
		</ul>		
	</div>	
	
</body>	
</html>












