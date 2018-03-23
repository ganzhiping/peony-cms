var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext
								+ "/operationlog/selectebInfoByPage",
						"bPaginate" : true,
						"bSort" : false,
						"bFilter" : false,
						"bJQueryUI" : false,
						"sPaginationType" : "full_numbers",
						"sDom" : 'rt <"dongao_page"flpi>',
						"iDisplayLength" : 10,
						"aaData" : "list",
						"aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
						"aoColumns" : [
								
								{
									"mDataProp" : "time",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var d = new Date();
										d.setTime(oData.time);
										$(nTd).html(
												d.format("yyyy-MM-dd  hh:mm"));
									}
								},
								{
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "loginType",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.loginType;
										if(type==1){
											$(nTd).html("手机");
										}else if(type==2){
											$(nTd).html("微信");
										}else if(type==3){
											$(nTd).html("微博");
										}
									
									}
								},
								{
									"mDataProp" : "type",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.type;
										if(type==1){
											$(nTd).html("登录日志");
										}else if(type==2){
											$(nTd).html("操作日志");
										}
									
									}
								},
								{
									"mDataProp" : "operateModule",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.operateModule;
										if(type==1){
											$(nTd).html("首页");
										}else if(type==2){
											$(nTd).html("热点时评");
										}else if(type==3){
											$(nTd).html("热点新闻");
										}else if(type==4){
											$(nTd).html("政务动态");
										}else if(type==5){
											$(nTd).html("地域舆情");
										}else if(type==6){
											$(nTd).html("定制舆情");
										}else if(type==7){
											$(nTd).html("事件专题");
										}else if(type==8){
											$(nTd).html("舆情预警");
										}else if(type==9){
											$(nTd).html("个人中心");
										}
									
									}
								},
								{
									"mDataProp" : "content"
								}
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
						
							if ($("#type").val() != ''&& $("#type").val() != -1) {
								aoData.push({
									'name' : 'type',
									'value' : $("#type").val()
								});
							}
							if ($("#loginType").val() != ''&& $("#loginType").val() != -1) {
								aoData.push({
									'name' : 'loginType',
									'value' : $("#loginType").val()
								});
							}
						}
					});

})

/**
 * 绑定搜索按钮点击事件
 */
$(function(){
    $("#searchDiv").click(function(evt){
    	search();
    });
});
/**
 * 根据条件查询课程
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_info').dataTable();
	oTable.fnPageChange("first", true);
}

/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}
