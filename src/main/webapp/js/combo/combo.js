var pageContext;
var nameTemp = "";
var pageSize = 10;
var sortFields = "create_time";
var sortDirection = new Object();
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_combo')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext + "/combo/selectByPage",
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
									"mDataProp" : "name",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text =  oData.name;
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "keywordnumber",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text =  oData.keywordnumber;
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "topicnumber",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text =  oData.topicnumber;
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "introduce",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text =  oData.introduce;
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "price",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text =  oData.price;
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "opt",
									"bSortable" : false,
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										
										var text = "<a   href='javascript:void(0);'  onclick=\"editComber('"
												+ oData.id
												+ "')\"  class=\"oicon o2 marAuto\" title=\"修改\">修改</a>";
										text+="||";
										text += "<a   href='javascript:void(0);'  onclick=\"delComber('"
												+ oData.id
												+ "')\"  title=\"删除\" class=\"oicon o4\">删除</a>";
										
										$(nTd).html(text);
									}
								}],
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
					
					});
	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/combo/addCombo", {
			title : "新增套餐",
			width : 500,
			id : "editDiv",
			height : 350,
			buttons: { }
		});
	});
})
	/**
	 * 关闭iframe
	 * 
	 * @return
	 */
	function showPop() {
		$.jBox.close(true);
	}
/**
 * 查询套餐
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_combo').dataTable();
	oTable.fnPageChange("first", true);
}
/**
 * 删除套餐
 * @param id
 */
function delComber(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/combo/deleteCombo",
				dataType : "json",
				data : {
					id : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					search();

				},
				error : function() {
					jBox.info("删除失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要删除吗？", "提示", submit);
}
/**
 * 修改套餐
 * 
 * @return
 */
function editComber(id) {
	jBox("iframe:" + pageContext + "/combo/editCombo/" + id, {
		title : "修改套餐",
		width : 450,
		height : 350,
		top : '25%',
		id : 'updCombo',
		buttons : {
			
		}
	});

}