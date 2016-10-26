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
	$('.what_rent').show();
	/* 购买书本书添加 */
	$('#add').click(function(){
		var $value=parseInt($('#bookNum_input').val())+1;
		$('#bookNum_input').val($value);
		$('#num').html($value);
		$('#method_sum_price').html($value*12);
	});
	$('#reduce').click(function(){
		var $value=$('#bookNum_input').val();
		if($value>1){
			var $value=parseInt($('#bookNum_input').val())-1;
			$('#bookNum_input').val($value);
			$('#num').html($value);
			$('#method_sum_price').html($value*12);
		}
	});
});

</script>
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

	<div class="pay_address">
		<span>填写收书宿舍点</span>
		<span id="address"><c:out value="${schoolName}${districtName}"/></span>
	</div>
	<div class="pay_info">
		<div id="pay_info_top">
			<div id="info_img">
				<img src="images/books/${bookClassImg}" alt="" />
			</div>
			<div id="info_detail" class="rent_detail">
				<h5><c:out value="${bookClassName}"/></h5>
				<span>编号：<c:out value="${bookNum}"/></span>
				<div id="bookNum">
					<span id="reduce">-</span>
					<span id="add">+</span>
					<input type="text" name="bookNum_input" id="bookNum_input" value="1" />
				</div>
			</div>
			<div id="info_bookNum">
				<span id="info_bookNum_price">￥<c:out value="${borrowPrice}"/>/本</span>
			</div>
			<div class="clearbox"></div>
		</div>
		<div id="pay_info_bottom">
			<span>配送方式</span>
			<span id="delivery">上门配送  推广期间不收费</span>			
		</div>
	</div>

	<div id="explain"></div>

	<div class="pay_method">
		<div id="pay_method_top">
			<span>总价</span>
			<span id="method_sum">￥<em id="method_sum_price"><c:out value="${borrowPrice}"/></em></span>
		</div>
		<div id="pay_method_bottom">
			<span id="rent_tip">＊至租书日起，每一个月扣除1元，超出15天算0.5元</span>

			<a href="success_rent"><input type="submit" id="paying" name="paying" value="在线支付" /></a>
			<span>现只支持微信支付</span>
		</div>
	</div>

	<footer class="footer">
		<div id="logo"></div>
	</footer>
</body>	
</html>