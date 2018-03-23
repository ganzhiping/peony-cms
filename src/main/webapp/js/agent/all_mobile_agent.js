var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info').dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/agent/selectAllMobileByPage",
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
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"toEdit('"
												+ oData.agentId
												+ "')\" class=\"oicon\" title=\"修改\">[修改]</a>";
										text += "&nbsp;&nbsp;&nbsp;<a   href='javascript:;'  onclick=\"toDel('"
												+ oData.agentId
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
 * 更改申请查看状态
 */
function update() {
	var ids=getCheckVal();
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/apply/updateApply",
				dataType : "json",
				data : {
					id : ids
				},
				success : function(data) {
					jBox.tip("更新成功", "success");
					parent.search(); //重新查询

				},
				error : function() {
					jBox.info("更新失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要更新吗？", "提示", submit);
}

/**
 * 全选
 */
function checkAll(checkbox) {
	$("input[name='chk_list']").prop("checked", $(checkbox).prop("checked"));
}

/**
 * 得到checkebox值
 * @return
 */
function getCheckVal() {
	var v = "";
	$("input[name='chk_list']:checked").each(function() {
		if (v == "") {
			v += this.value;
		} else {
			v += "," + this.value;
		}
	});
	return v;
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
 * 修改用户
 * 
 * @return
 */
function toEdit(id) {
	jBox("iframe:" + pageContext + "/agent/editAgent/" + id, {
		title : "修改代理商",
		width : 500,
		height : 350,
		top : '25%',
		id : 'editAgent',
		buttons : {}
	});
}
/**
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_info').dataTable();
	oTable.fnPageChange("first", true);
}
function toDel(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/agent/deleteAgent",
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
 * 添加代理商
 * 
 * @return
 */
function toAdd(id) {
	jBox("iframe:" + pageContext + "/agent/toAddMobileAgent/", {
		title : "添加代理商",
		width : 500,
		height : 350,
		top : '25%',
		id : 'addAgent',
		buttons : {}
	});
}