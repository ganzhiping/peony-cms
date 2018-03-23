$(document).ready(function() {
jQuery.tanchukuang = function(tabtit,tabtit2,shijian) {
$(tabtit).bind(shijian,function(){
	
$(tabtit2).toggle();
$("body").append("<div class='tneirong_3'></div>");
 var br_height = $(window).height()
 function dibugaodu() {
	 var br_height = $(window).height()
$(".tneirong_3").height(br_height);};
$(window).load(function() {   dibugaodu();});
$(window).resize(function() {  dibugaodu();});
$(".tneirong_3").height(br_height);
 var div_height = -$(tabtit2).find(".tneirong_1").height()/2
 var div_width = -$(tabtit2).find(".tneirong_1").width()/2
$(tabtit2).children(".tneirong_1").css("margin-top",div_height).css("margin-left",div_width);});
$(tabtit2).find(".fabiao1,.fabiao2a,.guanbi,.tneirong_3").bind(shijian,function(){
	$(".tneirong_3").remove();
$(tabtit2).toggle();});};
	/*调用方法如下：*/
	$.tanchukuang(".grzx_znxx_a",".grzx_znxx","click");
	$.tanchukuang(".xtpz_jsgl_fpjs_a",".xtpz_jsgl_fpjs","click");
	$.tanchukuang(".xtpz_jsgl_addjs_a",".xtpz_jsgl_addjs","click");
	$.tanchukuang(".xtpz_yhgl_addyh_a",".xtpz_yhgl_addyh","click");
	$.tanchukuang(".xtpz_yhgl_xiugai_a",".xtpz_yhgl_xiugai","click");
	$.tanchukuang(".grzx_fwsz_a",".grzx_fwsz","click");
	$.tanchukuang(".xtpz_dl_add_a",".xtpz_dl_add","click");
	$.tanchukuang(".xtpz_dl_xiugai_a",".xtpz_dl_xiugai","click");
	$.tanchukuang(".gjccwh_qu_add_a",".gjccwh_qu_add","click");
	$.tanchukuang(".gjccwh_jc_add_a",".gjccwh_jc_add","click");
	$.tanchukuang(".xxgl_anli_add_a",".xxgl_anli_add","click");
}); 



 