
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
					url: pageContext + "/area/updateArea",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('保存成功', 'success');
			     	},
					error: function(){
						parent.jBox.tip('保存失败', 'error');
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