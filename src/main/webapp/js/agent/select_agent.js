var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info').dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext
								+ "/agent/selectAgentByPage",
						"bPaginate" : true,
						"bFilter" : false,
						"bSort" : false,
						"bJQueryUI" : false,
						"sPaginationType" : "full_numbers",
						"sDom" : 'rt <"dongao_page"flpi>',
						"iDisplayLength" : 10,
						"aaData" : "list",
						"aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
						"aoColumns" : [
								{
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "userName"
								},
								{
									"mDataProp" : "relationName"
								},
								{
									"mDataProp" : "phone"
								},
								{
									"mDataProp" : "email"
								},
								{
									"mDataProp" : "fax"
								},
								{
									"mDataProp" : "region"
								},
								{
									"mDataProp" : "address"
								},
								{
									"mDataProp" : "createUser"
								},
								{
									"mDataProp" : "createTime",
									"fnCreatedCell" : function(nTd, sData,
												oData) {
										var d = new Date();
										d.setTime(oData.createTime);
										$(nTd).html(
												d.format("yyyy-MM-dd"));
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

						if ($("#name").val() != '') {
							aoData.push({
								'name' : 'name',
								'value' : $("#name").val()
							});
						}
						if ($("#userId").val() != ''
							&& $("#userId").val() != -1) {
							aoData.push({
								'name' : 'userId',
								'value' : $("#userId").val()
							});
						}
						if ($("#relationName").val() != '') {
							aoData.push({
								'name' : 'relationName',
								'value' : $("#relationName").val()
							});
						}
						if ($("#phone").val() != '') {
							aoData.push({
								'name' : 'phone',
								'value' : $("#phone").val()
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
	 $("#searchDiv").click(function(evt){
	    	search();
	    });
}
);



/**
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_info').dataTable();
	oTable.fnPageChange("first", true);
}
