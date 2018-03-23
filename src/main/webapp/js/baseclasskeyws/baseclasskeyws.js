var pageContext;
var pageSize = 10;
var baseclassId;
$(function() {
	pageContext = $("#pageContext").val();
	baseclassId=$("#baseclassId").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext
								+ "/baseClasskeyws/selectByPage?baseclassId="+baseclassId,
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
									"mDataProp" : "createTime",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var d = new Date();
										d.setTime(oData.createTime);
										$(nTd).html(
												d.format("yyyy-MM-dd  hh:mm"));
									}
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"edit('"
												+ oData.baseclassKeywsId
												+ "')\" class=\"oicon\" title=\"修改\">[修改]</a>";
										text += "<a   href='javascript:;'  onclick=\"del('"
												+ oData.baseclassKeywsId
												+ "')\"  class=\"oicon o2 marAuto\" title=\"删除\">[删除]</a>";
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

						}
					});

})

function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/baseClasskeyws/deleteBaseClassKeyws",
				dataType : "json",
				data : {
					baseclassKeywsId : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					showPop(); //关闭窗体
					search(); //重新查询
					

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
 * 编辑关键字
 */
function edit(id) {
	jBox("iframe:"+pageContext + "/baseClasskeyws/editBaseClasskeyws?baseclassKeywsId="+id, {
		title : "编辑",
		width : 600,
		id : "editDiv",
		height : 400,
		buttons : {}
	});

}

/**
 * 添加关键字
 */
$("#add").on("click", function() {
	jBox("iframe:"+pageContext + "/baseClasskeyws/addBaseClasskeyws?baseclassId="+baseclassId, {
		title : "添加",
		width : 500,
		id : "addDiv",
		height : 400,
		buttons : {}
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
