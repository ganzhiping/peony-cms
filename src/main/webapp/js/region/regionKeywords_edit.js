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
					url: pageContext + "/region/updateRegionKeywords",
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