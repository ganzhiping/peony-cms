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
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext
								+ "/pointschange/selectPointsChangeListByPage",
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
									"mDataProp" : "time",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var d = new Date();
										d.setTime(oData.time);
										$(nTd).html(
												d.format("yyyy-MM-dd hh:mm:ss"));
									}
								},
								{
									"mDataProp" : "loginName",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = oData.loginName ;
									$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "typestatus",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										var text = "";
										if(oData.typestatus=="1"){
											text='qq';
										}else if(oData.typestatus=="2"){
											text='微博';
										}else if(oData.typestatus=="3"){
											text='微信';
										}else if(oData.typestatus=="4"){
											text='qq空间';
										}else if(oData.typestatus=="5"){
											text='手机';
										}else {
											text='--';
										}
										$(nTd).html(text);
										}
								},
								{
									"mDataProp" : "instructions",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										$(nTd).html(oData.instructions);
										}
								},
								{
									"mDataProp" : "points",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text="";
										if(oData.type=="0"){
											text="+";
										}
										if(oData.type=="1"){
											text="-";
										}
										$(nTd).html(text+oData.points);
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
							if ($("#userSource").val() != ''
								&& $("#userSource").val() != -1) {
								aoData.push({
									'name' : 'userSource',
									'value' : $("#userSource").val()
								});
							}
							if ($("#agentId").val() != ''
								&& $("#agentId").val() != -1) {
							aoData.push({
								'name' : 'agentId',
								'value' : $("#agentId").val()
							});
							}
							if ($("#platformType").val() != ''
								&& $("#platformType").val() != -1) {
								aoData.push({
									'name' : 'platformType',
									'value' : $("#platformType").val()
								});
							}
							if ($("#type").val() != ''
								&& $("#type").val() != -1) {
								aoData.push({
									'name' : 'type',
									'value' : $("#type").val()
								});
							}
							if ($("#typestatus").val() != ''
								&& $("#typestatus").val() != -1) {
								aoData.push({
									'name' : 'typestatus',
									'value' : $("#typestatus").val()
								});
							}
							if ($("#loginName").val() != '') {
								aoData.push({
									'name' : 'loginName',
									'value' : $("#loginName").val()
								});
							}
						
							if ($("#beginCreateTime").val() != '' && $("#beginCreateTime").val() != -1) {
								aoData.push({
									'name' : 'beginCreateTime',
									'value' : $("#beginCreateTime").val()
								});
							}
							if ($("#endCreateTime").val() != '' && $("#endCreateTime").val() != -1) {
								aoData.push({
									'name' : 'endCreateTime',
									'value' : $("#endCreateTime").val()
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
 * 根据条件查询
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_info').dataTable();
	oTable.fnPageChange("first", true);
}
