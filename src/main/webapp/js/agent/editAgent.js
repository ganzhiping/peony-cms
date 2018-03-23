$(function() {
	var pageContext = $("#pageContext").val();
	$("#agentEditform").Validform({
		btnSubmit:"#subBtn",
		tiptype:1,
		ajaxPost:true,
		postonce:true,
		beforeSubmit: function(curform){
			var options = {
				url: pageContext + "/agent/updateAgent",
				type: 'post',
				data: null,
				dataType: 'script',
				async: false,
		     	success: function() {
		     		parent.jBox.tip('保存成功', 'success');
					parent.search(); //重新查询
					parent.showPop(); //关闭窗体
		     	},
				error: function(){
					parent.jBox.tip('保存失败', 'error');
				}
			};
			curform.ajaxSubmit(options);
			
			return false;
		}
	});
	
	 $('#userId').change(function(){  
		 	var userName=$("#userId").find("option:selected").text();
			$("#userName").val(userName);
	 })
	
	
	 	var userName=$("#userId").find("option:selected").text();
		$("#userName").val(userName);
	
});

