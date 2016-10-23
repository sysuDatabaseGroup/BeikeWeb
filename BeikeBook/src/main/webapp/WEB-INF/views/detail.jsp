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
<div class="what_rent">
	<div id="whatBox">
		<div id="whatBox_top">
			<h3>经济实惠新方式</h3>
			<h3>在贝壳易书上可租旧课本啦</h3>
		</div>
		<div id="whatBox_words">
			<p>提供旧课本的租用服务，需支付12元的租书费用，每月扣除1元，请在不使用旧书后及时归还，扣除每月租金后把余款退还至账户。</p>
		</div>
		<span id="whatBox_close">好的</span>
	</div>
</div>

<div class="option">
	<span id="option_what"></span>
	<a href="pay.jsp"><span id="option_buy">购买旧书</span></a>
	<a href="rent.jsp"><span id="option_rent">租书（热）</span></a>
</div>

<div class="container">
	<div class="detail">
		<div id="detail_img">
			<img src="images/books/${bookClassImg}" alt="" />
		</div>
		<div id="detail_info">
			<h4><c:out value="${bookClassName}"/></h4>
			<span id="info_price"><em>￥</em><c:out value="${sellPrice}"/> <em>/本</em></span>
			<span id="info_service">支持： 上门配送 ｜ 自取 ｜ 租用</span>
		</div>
		<div id="detail_book">
			<span>版本：<em><c:out value="${version}"/></em></span>
			<span>作者：<em><c:out value="${author}"/></em></span>
			<span>出版社：<em><c:out value="${company}"/></em></span>
		</div>
	</div>

	<div class="detail_place">
		<div id="place_info">
			<span>托管点存放情况</span>
			<span id="place_more">托管点详情 ></span>
		</div>
		<div class="place_num">
			<ul id="place_num_ul">
				<c:forEach items="${districtInfo}" var="i">
					<li>
						<h5><c:out value="${i}"/></h5>
						<span><c:out value="${i.districtName}"/></span>
						<c:choose>
							<c:when test="${i.num > 0}">
								<em><c:out value="${i.num}"/>本</em>
							</c:when>
							<c:otherwise>
								<em>暂无</em>
							</c:otherwise>
						</c:choose>
					</li>
				</c:forEach>
			</ul>		
			<div class="clearbox"></div>	
		</div>
	</div>

</div>
</body>	
</html>