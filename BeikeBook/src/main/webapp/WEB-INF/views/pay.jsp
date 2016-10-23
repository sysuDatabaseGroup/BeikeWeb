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
<script src="main.js"></script>
</head>
<script type="text/javascript">
$(function(){
	/* 购买书本书添加 */
	$('#add').click(function(){
		var $value=parseInt($('#bookNum_input').val())+1;
		$('#bookNum_input').val($value);
		$('#num').html($value);
		$('#method_sum_price').html($value*5+1);
	});
	$('#reduce').click(function(){
		var $value=$('#bookNum_input').val();
		if($value>1){
			var $value=parseInt($('#bookNum_input').val())-1;
			$('#bookNum_input').val($value);
			$('#num').html($value);
			$('#method_sum_price').html($value*5+1);
		}
	});
});

</script>
<body>
	<div class="pay_address">
		<span>填写收书宿舍点</span>
		<span id="address"><c:out value="${schoolName}${districtName}"/></span>
	</div>
	<div class="pay_info">
		<div id="pay_info_top">
			<div id="info_img">
				<img src="images/books/${bookClassImg}" alt="" />
			</div>
			<div id="info_detail">
				<h5><c:out value="${bookClassName}"/></h5>
				<span>编号：<c:out value="${bookNum}"/></span>
				<div id="bookNum">
					<span id="reduce">-</span>
					<span id="add">+</span>
					<input type="text" name="bookNum_input" id="bookNum_input" value="1" />
				</div>
			</div>
			<div id="info_bookNum">
				<span id="info_bookNum_price">￥<c:out value="${sellPrice}"/>/本</span>
			</div>
			<div class="clearbox"></div>
		</div>
		<div id="pay_info_bottom">
			<span>配送方式</span>
			<span id="delivery">上门配送 ￥<c:out value="${price}"/></span>			
		</div>
	</div>

	<div id="explain"></div>

	<div class="pay_method">
		<div id="pay_method_top">
			<span>总价</span>
			<span id="method_sum">￥<em id="method_sum_price"><c:out value="${sellPrice+price}"/></em>.00</span>
		</div>
		<div id="pay_method_bottom">
			<a href="success.jsp"><input type="submit" id="paying" name="paying" value="在线支付" /></a>
			<span>现只支持微信支付</span>
		</div>
	</div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>