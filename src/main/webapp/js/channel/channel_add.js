$(function() {
		var pageContext = $("#pageContext").val();
		$("#channelAddForm").Validform({
			btnSubmit:"#subBtn",
			beforeSubmit: function(curform){
				$.ajax({
				    type: "POST",
				    async:false,
				    url:pageContext + "/channel/saveChannel",
				    data:$("#channelAddForm").serialize(),
				    dataType: "json",
				    success: function(data){
				    	parent.jBox.tip('保存成功', 'success');
				    	parent.showPop(); //关闭窗体
				    	parent.location.reload();
				    		
				    },
				    error:function(data){
						jBox.tip('登陆失败', 'error');
				    }
				});
				
			}
		});
	});




/**
 * 关闭iframe
 * @return
 */
function showPop() {
	$.jBox.close(true);
}

