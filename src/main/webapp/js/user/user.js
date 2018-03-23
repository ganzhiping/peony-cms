var pageContext;
var nameTemp = "";
var pageSize = 10;
var sortFields = "create_time";
var sortDirection = new Object();
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_user')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'get',
						"sAjaxSource" : pageContext + "/user/selectByPage",
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
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a href=\"javascript:;\" onclick=\"toEdit('"
												+ oData.userId
												+ "');\">"
												+ oData.loginName + "</a>";
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "name",
									"bSortable" : false,
								},
								{
									"mDataProp" : "email",
									"bSortable" : false,
								},
								{
									"mDataProp" : "mobile",
									"bSortable" : false,
								},
								{
									"mDataProp" : "sex",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if (oData.sex == 1) {
											$(nTd).html("男");
										} else if (oData.sex == 2) {
											$(nTd).html("女");
										}
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
												+ oData.userId
												+ "')\"  class=\"oicon o2 marAuto\" title=\"权限配置\">权限配置</a>";
										text+="||";
										text += "<a   href='javascript:;'  onclick=\"loadService('"
											+ oData.userId
											+ "')\"  title=\"用户服务\" class=\"oicon o4\">用户服务</a>";
										text+="||";
										text += "<a   href='javascript:;'  onclick=\"del('"
											+ oData.userId
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
							if ($("#dept_id").val() != ''
									&& $("#dept_id").val() != -1) {
								aoData.push({
									'name' : 'deptId',
									'value' : $("#dept_id").val()
								});
							}
							if ($("#loginName").val() != '') {
								aoData.push({
									'name' : 'loginName',
									'value' : $("#loginName").val()
								});
							}
							if ($("#name").val() != '') {
								aoData.push({
									'name' : 'name',
									'value' : $("#name").val()
								});
							}
							if ($("#userStatus").val() != '' && $("#userStatus").val() != -1) {
								aoData.push({
									'name' : 'userStatus',
									'value' : $("#userStatus").val()
								});
							}
							if ($("#deptId").val() != '') {
								aoData.push({
									'name' : 'deptId',
									'value' : $("#deptId").val()
								});
							}
							if ($("#startTime").val() != '') {
								aoData.push({
									'name' : 'startTime',
									'value' : $("#startTime").val()
								});
							}
							if ($("#endTime").val() != '') {
								aoData.push({
									'name' : 'endTime',
									'value' : $("#endTime").val()
								});
							}
						}
					});
	
	$("#create").on("click", function() {
		toAdd();
	});
	$("#searchDiv").on("click", function() {
		search();
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
	var oTable = $('#list_user').dataTable();
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
 * 修改用户停启状态
 * 
 * @param newStatus
 * @return
 */
function changeStatus(newStatus) {
	if (getCheckVal() == "") {
		$.jBox.info("请先选择" + (newStatus == 2 ? "启用" : "停用") + "内容", '提示');
		return;
	}
	var params = {};
	params.ids = getCheckVal().split(",");
	var arrayIdLength = params.ids.length;
	params.status = newStatus
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : encodeURI(pageContext + "/user/updateUserStatus/"),
				dataType : "json",
				data : params,
				success : function(data) {
					window.setTimeout(function() {
						$.jBox.tip(
								"用户" + (newStatus == 2 ? "启用" : "停用") + "成功",
								'success', 1000);
					}, 100);
					$('#chk_all').attr("checked", false);
					search();
				}
			});
		} else if (v == 'cancel') {
		}
		return true;
	};
	jBox.confirm("您确定要" + (newStatus == 2 ? "启用" : "停用") + "以下" + arrayIdLength
			+ "个用户？", "提示", submit);
}

/**
 * 加载权限
 * 
 * @return
 */
function loadFunction(id) {
	jBox("iframe:" + pageContext + "/user/findUserRoles/" + id, {
		title : "查看权限",
		width : 650,
		height : 300,
		top : '8%',
		buttons : {
		}
	});
}

/**
 * 增加用户
 * 
 * @return
 */
function toAdd() {
	jBox("iframe:" + pageContext + "/user/addUser", {
		title : "增加用户",
		width : 650,
		height : 500,
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
	jBox("iframe:" + pageContext + "/user/editUser/" + id, {
		title : "修改用户",
		width : 650,
		height : 400,
		top : '5%',
		id : 'editUser',
		buttons : {'关闭' : true}
	});
}

/**
 * 加载用户服务
 * @return
 */
function loadService(id) {
	
	jBox("iframe:" + pageContext + "/userservice/editUserService/" + id, {
		title : "用户服务",
		width : 650,
		height : 500,
		top : '5%',
		buttons : {
			'关闭' : true
		}
	});
}
function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/user/deleteUser",
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