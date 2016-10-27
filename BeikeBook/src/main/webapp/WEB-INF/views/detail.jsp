<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
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
	<a href="pay"><span id="option_buy">购买旧书</span></a>
	<a href="rent"><span id="option_rent">租书（热）</span></a>
</div>

<div class="container">
	<div class="detail">
		<div id="detail_img">
			<img src="<c:url value='${book.coverPath}' />" alt="" />
		</div>
		<div id="detail_info">
			<h4><c:out value="${book.title}"/></h4>
			<span id="info_price"><em>￥</em><c:out value="${book.sellingPrice}"/> <em>/本</em></span>
			<span id="info_service">支持： 上门配送 ｜ 自取 ｜ 租用</span>
		</div>
		<div id="detail_book">
			<span>版本：<em><c:out value="${book.edition}"/></em></span>
			<span>作者：<em><c:out value="${book.author}"/></em></span>
			<span>出版社：<em><c:out value="${book.press}"/></em></span>
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