var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/menu/editMenu/" + currentNode.id);  
		
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("menuTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	

	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改菜单信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: {}
		});
	});

	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/menu/addMenu", {
			title : "新增菜单",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { }
		});
	});
	$("#delete").on(
			"click",
			function() {
				if (!currentNode) {
					$.jBox.info('请先选择要删除的菜单', '提示');
				} else {
					var message = '您确定要删除"' + currentNode.name + '"';
					if (currentNode.isParent || currentNode.hasUser) {
						message += '及其下面的';
						if (currentNode.isParent && currentNode.hasUser) {
							message += '菜单';
						} 
					}
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {

							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/menu/deleteMenu"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
									
										jBox.tip("删除成功", "success");
										var zTree = $.fn.zTree.getZTreeObj("menuTree");
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