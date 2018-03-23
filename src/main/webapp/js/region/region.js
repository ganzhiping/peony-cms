var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/region/editRegionKeywords/" + currentNode.id);  
		
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("regionTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	

	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改地域信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { }
		});
	});

	$("#create").on("click", function() {
		jBox("iframe:"+pageContext+"/region/addRegion", {
			title : "新增地域",
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
					$.jBox.info('请先选择要删除的地域', '提示');
				} else {
					var message = '您确定要删除"' + currentNode.name + '"';
					if (currentNode.isParent || currentNode.hasUser) {
						message += '及其下面的';
						if (currentNode.isParent && currentNode.hasUser) {
							message += '地域';
						} 
					}
					message += '？';
					jBox.confirm(message, "提示", function(v, h, f) {
						if (v == 'ok') {

							$.ajax({
								type : "post",
								url : encodeURI(pageContext
										+ "/region/deleteRegion"),
								dataType : "json",
								data : {
									id : currentNode.id
								},
								success : function(data) {
									
										jBox.tip("删除成功", "success");
										var zTree = $.fn.zTree.getZTreeObj("regionTree");
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