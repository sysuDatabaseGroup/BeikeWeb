$(function(){
	/* 租书介绍 */
	$('#option_what').click(function(){
		$('.what_rent').show();
	});
	$('#whatBox_close').click(function(){
		$('.what_rent').hide();
	});

	/* 切换已售出和未售出 */
	$('#books_tab_ul li').click(function(){
		var $num=$(this).index();
		$(this).addClass('tab_on').siblings().removeClass('tab_on');
		if($num==0){
			$('.books_list').show();
			$('.books_list_sold').hide();
		}else if($num==1){
			$('.books_list').hide();
			$('.books_list_sold').show();			
		}
	});

})