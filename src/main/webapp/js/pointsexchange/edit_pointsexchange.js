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
					url: pageContext + "/pointsexchange/updatePointsexchange",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('修改成功', 'success');
						parent.search(); //重新查询
						parent.showPop(); //关闭窗体
			     	},
					error: function(){
						parent.jBox.tip('修改失败', 'error');
					}
				};
				curform.ajaxSubmit(options);
				
				return false;
			}
		});
	});