
//左右框架切换	
$(document).ready(function(){ 
 $('.page_fold_btn').click(function (){
	$('.page_aside').animate({left: '-250px'}, 250);
	$('.main_content').animate({margin: '0 0 0 0'}, 250);
   $('.open,.page_fold_btn').toggle();
	 }); 
	 $('.open').click(function (){
	$('.page_aside').animate({left: '0'}, 250);
	$('.main_content').animate({margin: '0 0 0 250px'}, 250);
	$('.open,.page_fold_btn').toggle();
	 }); 
  
 });
 //框架高度切换
 $(window).resize(function(){
  $("#rightMain,.page_aside").css({height:$(window).height()-177});
});
$(window).ready(function(){
$("#rightMain,.page_aside").css({height:$(window).height()-177});
	});
	
	/*左侧菜单高亮显示：*/

 
 
$(document).ready(function(){  
$("dl").find("dd:first").addClass("frist_dd");

 $(".left_dh dd").click(function(){
	$(".left_dh dd").removeClass("this");
	$(this).addClass("this");
	});
 });
	
 //头部菜单联动左菜单切换	
	$(document).ready(function() {
	jQuery.jqtab = function(tabtit,tab_conbox,shijian) {
		$(tab_conbox).find("li").hide();
		$(tabtit).find("li:first").addClass("this").show(); 
		$(tab_conbox).find("div:first").show();
	
		$(tabtit).find("li").bind(shijian,function(){
			
		  $(this).addClass("this").siblings("li").removeClass("this"); 
			var activeindex = $(tabtit).find("li").index(this);
			$(tab_conbox).children().eq(activeindex).show().siblings().hide();
			return false;
		});
	
	};
 
 
 
 

	/*调用方法如下：*/
	$.jqtab(".links",".left_dh","click");
	
 
	
});


 /*ie6最小宽度*/
 $(document).ready(function() {
 $(window).resize(function bodySize(){
    var bWidth = ($(window).width() <= 1000 ) ? 1000 : '100%';
    $('body').width(bWidth);
});
bodySize();
 });
 