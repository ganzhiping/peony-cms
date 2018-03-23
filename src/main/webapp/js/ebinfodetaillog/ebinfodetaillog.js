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
								+ "/ebinfodetaillog/selectByPage",
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
									"mDataProp" : "loginName"
								},				
								{
									"mDataProp" : "userSource",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.userSource;
										if(type==0){
											$(nTd).html("直销客户");
										}else if(type==1){
											$(nTd).html("代理商客户");
										}								
									}	
								},
								{
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "platformType",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.platformType;
										if(type==1){
											$(nTd).html("正式用户");
										}else if(type==2){
											$(nTd).html("试用用户");
										}else if(type==3){
											$(nTd).html("演示用户");
										}									
									}
								},
							    {
										"mDataProp" : "time",
										"fnCreatedCell" : function(nTd, sData,
												oData) {
											var d = new Date();
											d.setTime(oData.time);
											$(nTd).html(
													d.format("yyyy-MM-dd hh:mm:ss"));
										}
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
							
							if ($("#infoLogId").val() != '' && $("#infoLogId").val() != -1) {
								aoData.push({
									'name' : 'infoLogId',
									'value' : $("#infoLogId").val()
								});
							}
							if ($("#operationType").val() != '' && $("#operationType").val() != -1) {
								aoData.push({
									'name' : 'operationType',
									'value' : $("#operationType").val()
								});
							}
						}
					});

});

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
