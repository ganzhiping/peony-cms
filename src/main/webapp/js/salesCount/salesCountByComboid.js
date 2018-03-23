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
								+ "/salescount/selectAllMobileSalesCountListByComboid",
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
											 $(nTd).html("<a  class=\"oicon o2 marAuto\" onclick=\"showSubsidaryByUserId("+oData.userid+")\" href=\"javascript:;\">"+oData.loginName+"</a>");
									}
								},
								{
									"mDataProp" : "userSource",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										 var userSource=oData.userSource;
										 if(userSource=='0'){
											 $(nTd).html("直销");
										 }
										 if(userSource=='1'){
											 $(nTd).html("代理商");
										 }
									}
								},
								{
									"mDataProp" : "agentName",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text;
										if (agentList[oData.agentId] != "" && agentList[oData.agentId] != null) {
											text=agentList[oData.agentId];
										}else{
											text="无";
										}
										$(nTd).html(text);
										
									}
								},
								{
									"mDataProp" : "platformType",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										var text = "";
										if(oData.platformType=="1"){
											text='正式';
										}
										if(oData.platformType=="2"){
											text='试用';
										}
										if(oData.platformType=="3"){
											text='未注册';
										}
										$(nTd).html(text);
										}
								},
								{
									"mDataProp" : "expiryTime",
									"bSortable" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.expiryTime==null){
											$(nTd).html("--");
										}else{
											var d = new Date();
											d.setTime(oData.expiryTime);
											$(nTd).html(
													d.format("yyyy-MM-dd"));
										}
										
									}
								},
								{
									"mDataProp" : "time",
									"bSortable" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.time==null){
											$(nTd).html("--");
										}else{
											var d = new Date();
											d.setTime(oData.time);
											$(nTd).html(
													d.format("yyyy-MM-dd"));
										}
										
									}
								},
								{
									"mDataProp" : "bankPrice",
									"bSortable" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.buybehavior==1&&oData.buyway==1){
											$(nTd).html(oData.totalprice);
										}else{
											$(nTd).html("--");
										}
										
									}
								},
								{
									"mDataProp" : "scorePrice",
									"bSortable" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.buybehavior==1&&oData.buyway==2){
											$(nTd).html(oData.totalprice);
										}else{
											$(nTd).html("--");
										}
										
									}
								},
								{
									"mDataProp" : "number",
									"bSortable" : false
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
							if ($("#comboid").val() != '' && $("#comboid").val() != null) {
								aoData.push({
									'name' : 'comboid',
									'value' : $("#comboid").val()
								});
							}
						}
					});

})
/**
 * 跳转到该用户的消费明细
 * @param comboidId
 * @returns
 */
function showSubsidaryByUserId(userid) {
	window.location.href=pageContext+ "/salesSubsidiary/selectAllMobileSales?userId="+userid+"&&comboId="+$("#comboid").val();
}