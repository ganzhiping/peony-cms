var pageContext;
var nameTemp = "";
var pageSize = 10;
var sortFields = "create_time";
var sortDirection = new Object();
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_role')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext + "/role/selectByPage",
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
										var text = "<a href=\"javascript:;\" onclick=\"toEdit('"
												+ oData.roleId
												+ "');\">"
												+ oData.name + "</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "createTime",
									"bSortable" : false,
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
									"bSortable" : false,
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										
										var text = "<a   href='javascript:;'  onclick=\"loadFunction('"
												+ oData.roleId
												+ "')\"  class=\"oicon o2 marAuto\" title=\"查看用户\">查看用户</a>";
										text+="||";
										text += "<a   href='javascript:;'  onclick=\"loadUser('"
												+ oData.roleId
												+ "')\"  title=\"权限配置\" class=\"oicon o4\">权限配置</a>";
										text+="||";
										text += "<a   href='javascript:;'  onClick=\"del('"
											+ oData.roleId
											+ "')\"  title=\"删除\" class=\"oicon o4\">删除</a>";
										$(nTd).html(text);
									}
								} ],
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
							if ($("#status").val() != ''
									&& $("#status").val() != -1) {
								aoData.push({
									'name' : 'status',
									'value' : $("#status").val()
								});
							}
							if ($("#name").val() != '') {
								aoData.push({
									'name' : 'userName',
									'value' : $("#name").val()
								});
							}
						}
					});
	
	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/role/addRole", {
			title : "新增角色",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { }
		});
	});
	

})
/**
 * 清除检索条件
 */
function cleanAll() {
	$("#name").val("");
	var status = document.getElementsByName("status")[0];
	status.options[0].selected = true;
}
/**
 * 排序
 * 
 * @param fieldsName
 * @return
 */
function sortTbFileds(fieldsName) {
	sortFields = fieldsName;
	if (sortDirection[fieldsName] == null) {
		sortDirection[fieldsName] = "asc";
	} else {
		direction = sortDirection[fieldsName] == "asc" ? "desc" : "asc";
		sortDirection[fieldsName] = direction;
	}
	search();
}
/**
 * 根据条件查询课程
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_role').dataTable();
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

/**
 * 全选
 */
function checkAll(checkbox) {
	$("input[name='chk_list']").prop("checked", $(checkbox).prop("checked"));
}

/**
 * 得到checkebox值
 * 
 * @return
 */
function getCheckVal() {
	var v = "";
	$("input[name='chk_list']:checked").each(function() {
		if (v == "") {
			v += this.value
		} else {
			v += "," + this.value
		}
	});
	return v;
}

/**
 * 分配用户
 * 
 * @return
 */
function loadFunction(id) {
	jBox("iframe:" + pageContext + "/role/assignRole?roleId=" + id, {
		title : "查看用户",
		width : 750,
		height : 500,
		top : '8%',
		buttons : {
			
		}
	});
}


/**
 * 权限配置
 * 
 * @return
 */
function loadUser(id) {
	jBox("iframe:" + pageContext + "/menu/editRoleMenu/" + id, {
		title : "角色权限配置",
		width : 650,
		height : 500,
		buttons : {
			
		}
	});
}
/**
 * 增加角色
 * 
 * @return
 */
function toAdd() {
	jBox("iframe:" + pageContext + "/role/addRole", {
		title : "增加角色",
		width : 650,
		height : 300,
		top : '25%',
		id : 'toAddUser',
		buttons : {
			
		}
	});
}
/**
 * 修改角色
 * 
 * @return
 */
function toEdit(id) {
	jBox("iframe:" + pageContext + "/role/editRole/" + id, {
		title : "修改角色",
		width : 450,
		height : 200,
		top : '25%',
		id : 'editUser',
		buttons : {
			
		}
	});

}


function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/role/deleteRole",
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