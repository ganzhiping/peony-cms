var pageContext;
var pageSize = 10;
var order = 1;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info').dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext + "/apply/selectByPage",
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
									"mDataProp" : "checkbox",
									"fnCreatedCell" : function(nTd, sData,oData) {
										$(nTd).html("<input type=\"checkbox\" name=\"chk_list\" value=\""+ oData.applyId + "\">");
									}
								},
								{
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "email"
								},
								{
									"mDataProp" : "qq"
								},
								{
									"mDataProp" : "mobile"
								},
								{
									"mDataProp" : "department"
								},
								{
									"mDataProp" : "phone"
								},

								{
									"mDataProp" : "time",
									"fnCreatedCell" : function(nTd, sData,oData) {
										var d = new Date();
										d.setTime(oData.time);
										$(nTd).html(d.format("yyyy-MM-dd  hh:mm"));
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
									&& $("#name").val() != -1) {
								aoData.push({
									'name' : 'name',
									'value' : $("#name").val()
								});
							}
							if ($("#status").val() != ''
								&& $("#status").val() != -1) {
							aoData.push({
								'name' : 'status',
								'value' : $("#status").val()
							});
						}
						}
					});

})

function del() {
	var ids=getCheckVal();
	if(ids==""){jBox.tip("请选择要删除的记录", "success");return;}
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/apply/deleteApply",
				dataType : "json",
				data : {
					id : ids
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
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
 * 更改申请查看状态
 */
function update() {
	var ids=getCheckVal();
	if(ids==""){jBox.tip("请选择要更新的记录", "success");return;}
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
 * 绑定搜索按钮点击事件
 */
$(function(){
    $("#search").click(function(evt){
    	search();
    });
    
    $("#isread").click(function(evt){
    	update();
    });
    $("#delete").click(function(evt){
    	del();
    });
});






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
			v += this.value
		} else {
			v += "," + this.value
		}
	});
	return v;
}
/**
 * 已查看 未查看 查询
 * @param status
 */
function change(status){
	$("#status").val(status);
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
