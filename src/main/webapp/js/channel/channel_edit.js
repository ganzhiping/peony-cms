
$(function() {
		var pageContext = $("#pageContext").val();
		$("#editForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			beforeSubmit: function(curform){
				$.ajax({
				    type: "POST",
				    async:false,
				    url:pageContext + "/channel/updateChannel",
				    data:$("#editForm").serialize(),
				    dataType: "json",
				    success: function(data){
				    	parent.jBox.tip('修改成功', 'success');
				    	parent.location.reload();
				    },
				    error:function(data){
				    	parent.jBox.tip('修改失败', 'error');
				    }
				});
			}
		});
	});

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("channelTree");
	zTree.reAsyncChildNodes(null, "refresh");
}