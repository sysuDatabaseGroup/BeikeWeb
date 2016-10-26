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
	var $width=$('#pic_ul li').width();

	$('#list_ul li').click(function(){
		var $index=$(this).index();
		$(this).addClass('on').siblings().removeClass('on');
		$('#pic_ul').animate({'marginLeft':-$width*$index});
	});


	$("#pic_ul li").swipe( {
		swipe:function(event, direction, distance) {
			var $index=parseInt($(this).index());
			if(direction=="left"&&distance>20){
				$index+=1;
				if($index<3){
					$("#list_ul li").eq($index).addClass('on').siblings().removeClass('on');
					$('#pic_ul').animate({'marginLeft':-$width*$index});
				}else{
					$("#list_ul li").eq(0).addClass('on').siblings().removeClass('on');
					$('#pic_ul').animate({'marginLeft':0});
				}
			}else if(direction=="right"&&distance>20){
				$index-=1;
				if($index>-1){
					$("#list_ul li").eq($index).addClass('on').siblings().removeClass('on');
					$('#pic_ul').animate({'marginLeft':-$width*$index});
				}else{
					$("#list_ul li").eq(2).addClass('on').siblings().removeClass('on');
					$('#pic_ul').animate({'marginLeft':-$width*2});
				}
			}
		}
	});


	$('#header_class').toggle(
		function(){
			$(this).animate({'marginLeft':'-20px'},200);
			$('.bookClass').show();
			document.body.style.overflow='hidden';
		},
		function(){
			$(this).animate({'marginLeft':'0'},200);
			$('.bookClass').hide();
			document.body.style.overflow='';
		}
	);

});
</script>
<body>
<div class="bookClass">
	<ul id="bookClass_ul">
		<c:forEach items="${bookTypes}" var="i">
		<li><a href="#"><span><c:out value="${i.className}"/></span></a></li>
		</c:forEach>
	</ul>
</div>
	<header class="header">
		<span id="header_class"></span>
		<input type="search" name="search" id="header_search" placeholder="热门搜索：大英 毛概 高数" required="required" />
		<a href="center"><span id="header_center"></span></a>
	</header>>
	<div class="slider">
		<div id="slider_pic">
			<ul id="pic_ul">
				<!-- 需要替换images/pic.jpg -->
				<li><img src="<c:url value='images/pic.jpg'/>" alt="" /></li>
				<li><img src="images/user/photo.jpg" alt="" /></li>
				<li><img src="images/pic.jpg" alt="" /></li>
			</ul>
		</div>
		<div id="slider_list">
			<ul id="list_ul">
				<!-- 需要替换str -->
				<li class="on"><p>募捐爱心书籍活动</p></li>
				<li><p>募捐爱心书籍活动</p></li>
				<li><p>募捐爱心书籍活动</p></li>
			</ul>
		</div>
	</div>
	<div class="side">
		<h2>书籍列表</h2>
		<span>书籍支持上门自取或校内配送</span>
	</div>
	<article class="article">
		<c:forEach items="${bookInfo}" var="i">
			<a href="detail?bookClassID='${i.bookClassID}'">
			<div class="card">
				<div id="card_img">
					<img src="images/books/${i.bookClassImg}" alt="" />
				</div>
				<h3>￥<c:out value="${i.sellPrice}"/><em>起</em></h3>
				<span><c:out value="${i.bookClassName}"/></span>
			</div>
			</a>
		</c:forEach>
	</article>
	<div class="clearbox"></div>
	<footer class="footer">
		<div id="logo"></div>
		<div id="aboutus">
			<span>贝壳易书是我们几位在校大学生创办的旧书交易平台，我们希望可以利用我们平台，让同学们的旧书交易变得更加简便。毕竟每一学期课本钱真的太贵了，还是买二手书划算！</span>
		</div>
	</footer>
</body>	
</html>