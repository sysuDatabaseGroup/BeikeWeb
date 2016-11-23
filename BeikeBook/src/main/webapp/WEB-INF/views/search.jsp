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
		<a href="<c:url value='/index' />"><li><span>首页</span></li></a>
		<c:forEach items="${bookCategories}" var="i">
		<a href="<c:url value='/search?bookCategoryId=${i.id}' />"><li><span><c:out value="${i.title}"/></span></li></a>
		</c:forEach>
	</ul>
</div>
	<header class="header">
		<form action="<c:url value='/search'/>" method="get">
		<span id="header_class"></span>
			<input type="search" name="bookTitle" id="header_search" placeholder="热门搜索：大英 毛概 高数" required="required" />
		<a href="<c:url value='/center'/>"><span id="header_center"></span></a>
		</form>
	</header>
	<div class="side">
		<h2>书籍列表</h2>
		<span>书籍支持上门自取或校内配送</span>
	</div>
	<article class="article">
		<c:forEach items="${bookInfos}" var="i">
			<a href="<c:url value='/detail/${i.id}'/>">
			<div class="card">
				<div id="card_img">
					<img src="<c:url value='${i.coverPath}'/>" alt="" />
				</div>
				<h3>￥<c:out value="${i.sellingPrice}"/><em>起</em></h3>
				<span><c:out value="${i.title}"/></span>
			</div>
			</a>
		</c:forEach>
	</article>
	<div class="clearbox"></div>
	<footer class="footer">
		<div id="logo"></div>
		<div id="aboutus">
		</div>
	</footer>
</body>	
</html>