$(function() {
		var pageContext = $("#pageContext").val();
		$('#baseclassform').ajaxForm();
		
		$("#baseclassform").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/baseclass/saveBaseClass",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('保存成功', 'success');
			     		//refreshTree();
			     		parent.refreshTree();
						parent.showPop(); //关闭窗体
						//parent.window.location.reload();
						
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




/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}

