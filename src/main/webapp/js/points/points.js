var pageContext;
var pageSize = 10;
var sortFields = "create_time";
var sortDirection = new Object();
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/points/selectAllpoints",
						"bPaginate" : true,
						"bSort" : true,
						"bFilter" : false,
						"bJQueryUI" : false,
						"sPaginationType" : "full_numbers",
						"sDom" : 'rt <"dongao_page"flpi>',
						"iDisplayLength" : 10,
						"aaData" : "list",
						"aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
						"aoColumns" : [
								
								{
									"mDataProp" : "loginName",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text="";
											 if(oData.type==1){
												 text="登录";
											 }
											 if(oData.type==2){
												 text="转发";
											 }
											 if(oData.type==3){
												 text="注册(首次)";
											 }
											 if(oData.type==4){
												 text="购买";
											 }
											 $(nTd).html(text);
									}
								},
								{
									"mDataProp" : "points",
									"bSortable" : false
								},
								{
									"mDataProp" : "",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										var text = "<a   href='javascript:;'  onclick=\"edit('"
											+ oData.type
											+ "')\"  class=\"oicon o2 marAuto\" title=\"修改\">修改</a>";
										$(nTd).html(text);
										}
								},
								],
						"oLanguage" : {
							"sLengthMenu" : "每页 _MENU_ 条",
							"sZeroRecords" : "",
							"sInfo" : "当前从 _START_ 到 _END_ 条,共 _TOTAL_ 条记录",
							"sInfoEmpty" : "没有找到记录",
							"oPaginate" : {
								"sFirst" : "首页",
								"sPrevious" : "上一页",
								"sNext" : "下一页",
								"sLast" : "尾页"
							}
						},
						"fnServerParams" : function(aoData) {
							
						}
					});

})
function edit(type){
	jBox("iframe:"+pageContext + "/points/toEdit/"+type, {
	    title: "修改积分",
	    width: 400,
	    height: 206,
		top: '15%',
		id:'addAttention',
	    buttons: {}
	});
}
/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}