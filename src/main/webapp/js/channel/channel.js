var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/channel/editChannel/" + currentNode.id);  
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("channelTree");
	zTree.reAsyncChildNodes(0, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/channel/addChannel", {
			title : "新增分类",
			width : 500,
			id : "addDiv",
			height : 400,
			buttons: {  }
		});
	});
	$("#delete").on(
			"click",
			function() {
				if (!currentNode) {
					$.jBox.info('请先选择要删除的节点', '提示');
				} else {
					if(currentNode.id==2 || currentNode.id==3 ||currentNode.id==4 ||currentNode.id==5 || currentNode.id==7 || currentNode.id==8){
						jBox.info('固定分类不允许删除！', '提示');
						return;
					}
					var message = '您确定要删除"' + currentNode.name + '"';
					if (currentNode.isParent || currentNode.hasUser) {
						message += '及其下面的';
						if (currentNode.isParent && currentNode.hasUser) {
							jBox.info("分类下有案例,不允许删除", "提示");
							return;
						} else if (currentNode.isParent) {
							jBox.info("分类下有案例,不允许删除", "提示");
							return;
						} else if (currentNode.hasUser) {
							message += '案例';
						}
					}
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {
							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/channel/deleteChannel"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
									if (data) {
										jBox.info(data, "提示");
									} else {
										var zTree = $.fn.zTree.getZTreeObj("channelTree");
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
