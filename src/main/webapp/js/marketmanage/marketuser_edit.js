var pageContext;
$(function() {
		 pageContext = $("#pageContext").val();
		$('#userForm').ajaxForm();
		
		$("#userForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/marketmanage/updateUser",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('保存成功', 'success');
						parent.showPop(); //关闭窗体
						parent.window.location.reload();
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



