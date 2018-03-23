var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/marketmanage/selectByPage",
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
									"mDataProp" : "mobile"
								},
								{
									"mDataProp" : "email"
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
								},
								{
									"mDataProp" : "manage",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"loadFunction('"
												+ oData.userId
												+ "')\" class=\"oicon\" title=\"设置管理权限\">管理权限</a>";
											
										text +="||";
										text += "<a   href='javascript:;'  onclick=\"operateFunction('"
												+ oData.userId
											+ "')\" class=\"oicon\" title=\"设置操作权限\">操作权限</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"toEdit('"
											+ oData.userId
											+ "')\" class=\"oicon\" title=\"修改\">修改</a>";
											text += "||<a   href='javascript:;'  onclick=\"del('"
											+ oData.userId
											+ "')\"  class=\"oicon o2 marAuto\" title=\"删除\">删除</a>";
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
							if ($("#name").val() != ''
									&& $("#name").val() != null) {
								aoData.push({
									'name' : 'name',
									'value' : $("#name").val()
								});
							}
							if ($("#loginName").val() != ''&& $("#loginName").val() !=null) {
								aoData.push({
									'name' : 'loginName',
									'value' : $("#loginName").val()
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
    
    $("#create").on("click", function() {
		toAdd();
	});
});

/**
 * 增加用户
 * 
 * @return
 */
function toAdd() {
	jBox("iframe:" + pageContext + "/marketmanage/addUser", {
		title : "增加市场用户",
		width : 650,
		height : 435,
		top : '8%',
		id : 'toAddUser',
		buttons : {}
	});
}
/**
 * 修改用户
 * 
 * @return
 */
function toEdit(id) {
	jBox("iframe:" + pageContext + "/marketmanage/editUser/" + id, {
		title : "修改用户",
		width : 650,
		height : 435,
		top : '5%',
		id : 'editUser',
		buttons : {}
	});
}
function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/marketmanage/deleteUser",
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
 * 加载权限
 * 
 * @return
 */
function operateFunction(id) {
	jBox("iframe:" + pageContext + "/user/findUserRoles/" + id, {
		title : "设置权限",
		width : 650,
		height : 300,
		top : '20%',
		buttons : {
		}
	});
}
/**
 * 加载权限
 * 
 * @return
 */
function loadFunction(id) {
	jBox("iframe:" + pageContext + "/marketmanage/findUserRoles/" + id, {
		title : "设置权限",
		width : 650,
		height : 300,
		top : '20%',
		buttons : {
		}
	});
}
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

/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}