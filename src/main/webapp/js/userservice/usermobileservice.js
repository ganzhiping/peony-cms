$(function() {
		var pageContext = $("#pageContext").val();
		$('#usereditform').ajaxForm();
		$("#usereditform").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/userservice/updateMobileUserService",
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
	});



/**
 * 得到checkebox值
 * @return
 */
function getCheckVal() {
	var v = "";
	$("input[name='send']:checked").each(function() {
		if (v == "") {
			v += this.value
		} else {
			v += "," + this.value
		}
	});
	return v;
}