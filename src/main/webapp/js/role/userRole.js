var pageContext;
var pageSize = 10;
var order = 1;
$(function() {
	var roleId=$("#roleId").val();
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info').dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext + "/role/selectUserByRoleId?roleId="+roleId,
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
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"del('"
												+ oData.userId+"','"+roleId+
												 "')\"  class=\"oicon o2 marAuto\" title=\"移除\">移除</a>";
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

function del(userId,roleId) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/userRole/deleteUserRole",
				dataType : "json",
				data : {
					userId : userId,
					roleId :  roleId
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					parent.search(); //重新查询

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
