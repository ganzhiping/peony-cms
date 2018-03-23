$(function() {
		var pageContext = $("#pageContext").val();
		$('#areaAddForm').ajaxForm();
		
		$("#areaAddForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/area/saveArea",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
			     	success: function() {
			     		parent.jBox.tip('保存成功', 'success');
						parent.showPop(); //关闭窗体
						//parent.refreshTree();此处弹出窗口调用函数不起作用
						parent.location.reload();
						
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
 * @return
 */
function showPop() {
	$.jBox.close(true);
}

