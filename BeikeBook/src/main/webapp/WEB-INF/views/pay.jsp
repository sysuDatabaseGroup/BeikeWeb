<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>贝壳易书</title>
	<%@ include file="meta_css_js.jsp"  %>
</head>
<script type="text/javascript">
$(function(){
	/* 购买书本书添加 */
	$('#add').click(function(){
		var $value=parseInt($('#bookNum_input').val())+1;
		var $delivery = $('#deliveryMethod').val().split(',');
		var $deliveryValue = parseFloat($delivery[1]);
		if ($value <= <c:out value="${amountOfBooks}"/>) {
			$('#bookNum_input').val($value);
			$('#num').html($value);
			$('#method_sum_price').html(
					($deliveryValue + $value*<c:out value="${dealedBook.book.sellingPrice}"/>).toFixed(1)
					);
		}
	});
	$('#reduce').click(function(){
		var $value=parseInt($('#bookNum_input').val())+1;
		var $delivery = $('#deliveryMethod').val().split(',');
		var $deliveryValue = parseFloat($delivery[1]);
		if($value>1){
			var $value=parseInt($('#bookNum_input').val())-1;
			$('#bookNum_input').val($value);
			$('#num').html($value);
			$('#method_sum_price').html(
					($deliveryValue + $value*<c:out value="${dealedBook.book.sellingPrice}"/>).toFixed(1)
					);
		}
	});
	$('#deliveryMethod').change(function() {
		var $value=parseInt($('#bookNum_input').val())+1;
		var $delivery = $('#deliveryMethod').val().split(',');
		var $deliveryValue = parseFloat($delivery[1]);
		$('#method_sum_price').html(
				($deliveryValue + $value*<c:out value="${dealedBook.book.sellingPrice}"/>).toFixed(1)
		);
	});
});

</script>
<body>
	<div class="pay_address">
		<span>填写收书宿舍点</span>
		<span id="address"><c:out value="${user.school.name}  ${user.dorm}"/></span>
	</div>
	
	<form action="<c:url value='/success' />" method="POST">
	<c:set var="dealedBook" value="${dealedBook}"  scope="session"/>
	<div class="pay_info">
		<div id="pay_info_top">
			<div id="info_img">
				<img src="<c:url value='${dealedBook.book.coverPath}' />" alt="" />
			</div>
			<div id="info_detail">
				<h5><c:out value="${dealedBook.book.title}"/></h5>
				<span>编号：<c:out value="${dealedBook.dealedNum}"/></span>
				<div id="bookNum">
					<span id="reduce">-</span>
					<span id="add">+</span>
					<input type="text" name="bookNum_input" id="bookNum_input" value="1" readonly="readonly" />	
				</div>
				<span>库存： <c:out value="${amountOfBooks}" /> 本书</span>
			</div>
			<div id="info_bookNum">
				<span id="info_bookNum_price">￥<c:out value="${dealedBook.book.sellingPrice}"/>/本</span>
			</div>
			<div class="clearbox"></div>
		</div>
		<div id="pay_info_bottom">
			<span>配送方式</span>
			<span id="delivery">
				<select id="deliveryMethod" name="deliveryMethod">
					<c:forEach items="${deliveryMethods}" var="method">
					<option value ="<c:out value='${method.id},${method.price}' />">
						 <c:out value='${method.name}' /> ￥<c:out value='${method.price}' />
					</option>
				  	</c:forEach>
				</select>
			</span>
			
		</div>
	</div>

	<div id="explain"></div>

	<div class="pay_method">
		<div id="pay_method_top">
			<span>总价</span>
			<span id="method_sum">￥<em id="method_sum_price"><c:out value="${dealedBook.book.sellingPrice}"/></em></span>
		</div>
		<div id="pay_method_bottom">
			<input type="submit" id="paying" name="paying" value="在线支付" />
			<span>现只支持微信支付</span>
		</div>
	</div>
	
	</form>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>