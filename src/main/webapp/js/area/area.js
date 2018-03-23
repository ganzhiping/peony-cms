var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/area/editArea/" + currentNode.id);  
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("areaTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	

	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/area/addArea", {
			title : "新增区域",
			width : 500,
			id : "addDiv",
			height : 400,
			buttons: { '关闭': true }
		});
	});
	$("#delete").on(
			"click",
			function() {
				if (!currentNode) {
					$.jBox.info('请先选择要删除的区域', '提示');
				} else {
					var message = '您确定要删除"' + currentNode.name + '"';
					if (currentNode.isParent || currentNode.hasUser) {
						message += '及其下面的';
						if (currentNode.isParent && currentNode.hasUser) {
							message += '区域及关键字';
						} else if (currentNode.isParent) {
							message += '区域';
						} else if (currentNode.hasUser) {
							message += '关键字';
						}
					}
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {

							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/area/deleteArea"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
									if (data) {
										jBox.info(data, "提示");
									} else {
										var zTree = $.fn.zTree
												.getZTreeObj("areaTree");
										zTree.removeNode(currentNode);
										currentNode = null;
										$("#viewframe").attr("src","");
										jBox.tip("删除成功", "success");
									}
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
