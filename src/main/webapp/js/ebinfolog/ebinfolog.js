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
								+ "/ebinfolog/selectByPage",
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
									"mDataProp" : "clicks",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a style=\"color: blue;text-decoration: underline;\" onclick=\"loadClicksService('"
												+ oData.infoLogId
												+ "');\">"
												+ oData.clicks + "</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "forwards",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a style=\"color: blue;text-decoration: underline;\" href=\"javascript:;\" onclick=\"loadForwardsService('"
												+ oData.infoLogId
												+ "');\">"
												+ oData.forwards + "</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "collects",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a style=\"color: blue;text-decoration: underline;\" href=\"javascript:;\" onclick=\"loadCollectsService('"
												+ oData.infoLogId
												+ "');\">"
												+ oData.collects + "</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "module",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var module=oData.module;
										if(module==1){
											$(nTd).html("热点时评");
										}else if(module==2){
											$(nTd).html("热点新闻");
										}else if(module==3){
											$(nTd).html("政务动态");
										}else if(module==4){
											$(nTd).html("地域舆情");
										}else if(module==5){
											$(nTd).html("事件专题");
										}else if(module==6){
											$(nTd).html("定制舆情");
										}else if(module==7){
											$(nTd).html("舆情预警");
										}									
									}
								},
								{
									"mDataProp" : "type",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.type;
										if(type==1){
											$(nTd).html("新闻");
										}else if(type==2){
											$(nTd).html("论坛");
										}else if(type==3){
											$(nTd).html("微博");
										}else if(type==4){
											$(nTd).html("博客");
										}else if(type==5){
											$(nTd).html("报刊");
										}else if(type==6){
											$(nTd).html("境外");
										}else if(type==7){
											$(nTd).html("微信");
										}								
									}
								},
								{
									"mDataProp" : "website"
								},
							    {
										"mDataProp" : "publishDate",
										"fnCreatedCell" : function(nTd, sData,
												oData) {
											var d = new Date();
											d.setTime(oData.publishDate);
											$(nTd).html(
													d.format("yyyy-MM-dd hh:mm:ss"));
										}
								},
								{
									"mDataProp" : "title"
								},
								{
									"mDataProp" : "url"
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
							if ($("#sortCondition").val() != ''&& $("#sortCondition").val() != -1 && $("#sortCondition").val() == 1) {
								aoData.push({
									'name' : 'sortCondition',
									'value' : $("#sortCondition").val()
								});
							}
							if ($("#sortCondition").val() != ''&& $("#sortCondition").val() != -1 && $("#sortCondition").val() == 2) {
								aoData.push({
									'name' : 'sortCondition',
									'value' : $("#sortCondition").val()
								});
							}
							if ($("#sortCondition").val() != ''&& $("#sortCondition").val() != -1 && $("#sortCondition").val() == 3) {
								aoData.push({
									'name' : 'sortCondition',
									'value' : $("#sortCondition").val()
								});
							}
							if ($("#beginTime").val() != '' && $("#beginTime").val() != -1) {
								aoData.push({
									'name' : 'beginTime',
									'value' : $("#beginTime").val()
								});
							}
							if ($("#endTime").val() != '' && $("#endTime").val() != -1) {
								aoData.push({
									'name' : 'endTime',
									'value' : $("#endTime").val()
								});
							}
							if ($("#module").val() != '' && $("#module").val() != -1) {
								aoData.push({
									'name' : 'module',
									'value' : $("#module").val()
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
 * 加载用户及日志信息 + operationType
 * @return
 */
function loadClicksService(infoLogId) {
	
	jBox("iframe:" + pageContext + "/ebinfodetaillog/ebInfoDetailLogList?infoLogId=" + infoLogId +"&operationType=1", {
		title : "用户日志信息",
		width : 650,
		height : 435,
		top : '5%',
		buttons : {
			'关闭' : true
		}
	});
}
/**
 * 加载用户及日志信息 + operationType
 * @return
 */
function loadForwardsService(infoLogId) {
	
	jBox("iframe:" + pageContext + "/ebinfodetaillog/ebInfoDetailLogList?infoLogId=" + infoLogId +"&operationType=2", {
		title : "用户日志信息",
		width : 650,
		height : 435,
		top : '5%',
		buttons : {
			'关闭' : true
		}
	});
}
/**
 * 加载用户及日志信息 + operationType
 * @return
 */
function loadCollectsService(infoLogId) {
	
	jBox("iframe:" + pageContext + "/ebinfodetaillog/ebInfoDetailLogList?infoLogId=" + infoLogId +"&operationType=3", {
		title : "用户日志信息",
		width : 650,
		height : 435,
		top : '5%',
		buttons : {
			'关闭' : true
		}
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
