var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/baseclass/editBaseClass/" + currentNode.id);  
	}
}



$(function() {
	pageContext = $("#pageContext").val();
	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改基础类型信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: {}
		});
	});

	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/baseclass/addBaseClass", {
			title : "新增基础类型",
			width : 500,
			id : "addDiv",
			height : 400,
			buttons: { }
		})
	})
	$("#delete").on(
			"click",
			function() {
				if (!currentNode) {
					$.jBox.info('请先选择要删除的区域', '提示');
				} else {
					var message = '您确定要删除"' + currentNode.name + '"';
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {

							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/baseclass/deleteBaseClass"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
									if (data) {
										jBox.info(data, "提示");
									} else {
										var zTree = $.fn.zTree
												.getZTreeObj("baseClassTree");
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
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}


function refreshTree(){
	var treeObj = $.fn.zTree.getZTreeObj("baseClassTree");//根据 treeId 获取 zTree 对象
	treeObj.reAsyncChildNodes(0, "refresh");
}