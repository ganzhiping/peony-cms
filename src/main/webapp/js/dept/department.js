var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/dept/editDept/" + currentNode.id); 
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("departmentTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	

	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改部门信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { '关闭': true }
		});
	});

	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/dept/addDept", {
			title : "新增部门",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { '关闭': true }
		});
	});
	$("#delete").on(
			"click",
			function() {
				if (!currentNode) {
					$.jBox.info('请先选择要删除的部门', '提示');
				} else {
					var message = '您确定要删除"' + currentNode.name + '"';
					if (currentNode.isParent || currentNode.hasUser) {
						message += '及其下面的';
						if (currentNode.isParent && currentNode.hasUser) {
							message += '部门和用户';
						} else if (currentNode.isParent) {
							message += '部门';
						} else if (currentNode.hasUser) {
							message += '用户';
						}
					}
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {

							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/dept/deleteDept"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
										jBox.tip("删除成功", "success");
										//window.location.reload();
										var zTree = $.fn.zTree.getZTreeObj("departmentTree");
										zTree.removeNode(currentNode);
										currentNode = null;
										$("#viewframe").attr("src","");
								},
								error : function() {
									jBox.info("删除失败", "提示");
								}
							});
						}
						return true;
					});
				}
			});

});
/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}