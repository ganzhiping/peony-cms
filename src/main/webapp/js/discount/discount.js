var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_discount')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/discount/selectByPage",
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
									"mDataProp" : "name"
									
								},
								{
									"mDataProp" : "beginday",
									
								},
								{
									"mDataProp" : "endday",
									
								},
								{
									"mDataProp" : "discount",
									
								},
								{
									"mDataProp" : "time",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var d= new Date();
										d.setTime(oData.time);
										$(nTd).html(
												d.format("yyyy-MM-dd"));
									}
								},
								{
									"mDataProp" : "opt",
									"bSortable" : false,
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										
										var text = "<a   href='javascript:void(0);'  onclick=\"editDiscount('"
												+ oData.id
												+ "')\"  class=\"oicon o2 marAuto\" title=\"修改\">修改</a>";
										text+="||";
										text += "<a   href='javascript:void(0);'  onclick=\"delDiscount('"
												+ oData.id
												+ "')\"  title=\"删除\" class=\"oicon o4\">删除</a>";
										
										$(nTd).html(text);
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
							if ($("#comboid").val() != ''
								&& $("#comboid").val() != null 
								) {
							aoData.push({
								'name' : 'comboid',
								'value' : $("#comboid").val()
							});
						}
						
						
						}
					});
	/**
	 * 绑定点击事件
	 */
	 $("#comboid").on("change", function() {
		  search();
		});
	 $("#create").on("click", function() {
			toAdd();
		});
})
/**
 * 根据条件查询课程
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_discount').dataTable();
	oTable.fnPageChange("first", true);
}
/**
 * 增加折扣
 * 
 * @return
 */
function toAdd() {
	jBox("iframe:" + pageContext + "/discount/addDiscount", {
		title : "增加折扣",
		width : 550,
		height : 275,
		top : '8%',
		id : 'toAddDiscount',
		buttons : {}
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
/**
 * 删除折扣
 * @param id
 */
function delDiscount(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/discount/deleteDiscount",
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
 * 修改折扣
 * 
 * @return
 */
function editDiscount(id) {
	jBox("iframe:" + pageContext + "/discount/editDiscount/" + id, {
		title : "修改套餐",
		width : 550,
		height : 275,
		top : '8%',
		id : 'updDiscount',
		buttons : {
			
		}
	});

}