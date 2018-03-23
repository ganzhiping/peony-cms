$(function() {
		var pageContext = $("#pageContext").val();
		$('#editForm').ajaxForm();
		$("#editForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/menu/updateMenu",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		jBox.tip('保存成功', 'success');
			     	},
					error: function(){
						jBox.tip('保存失败', 'error');
					}
				};
				curform.ajaxSubmit(options);
				
				return false;
			}
		});
	});


function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("areaTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

/**
 * 关闭iframe
 * @return
 */
function showPop() {
	$.jBox.close(true);
}

