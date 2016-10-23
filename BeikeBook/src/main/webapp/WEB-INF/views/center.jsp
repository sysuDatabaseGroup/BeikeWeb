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
	<div class="center">
		<div id="center_top">
			<span id="center_photo">
				<img src="images/user/${wx_photo}" alt="" />
			</span>
			<span id="center_username"><c:out value="${userNum}"/></span>
		</div>
		<div id="center_bottom">
			<ul id="center_ul">
				<a href="buy_rent.jsp">
				<li>
					<h6><c:out value="${rsBookNum}"/></h6>
					<span>购书｜租书</span>
				</li>
				</a>
				<a href="books.jsp">
				<li>
					<h6><c:out value="${bkBookNum}"/></h6>
					<span>托管出售的书</span>
				</li>
				</a>
				<a href="alipay.jsp">
				<li>
					<h6><c:out value="${moneyNum}"/></h6>
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
				<span id="city" class="center_info_item"><c:out value="${cityName}"/></span>
			</li>
			<li>
				<span>学校</span>
				<span id="school" class="center_info_item"><c:out value="${schoolName}"/></span>
			</li>
			<li>
				<span>宿舍</span>
				<span id="dorm" class="center_info_item"><c:out value="${dorm}"/></span>
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
			<a href="index.jsp">
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












