$(function(){
var pageContext = $("#pageContext").val();
 $('#editForm').ajaxForm();
		$("#editForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/user/updatePassword",
					type: 'post',
					data: null,
					dataType: 'json',
					async: false,
			     	success: function(data) {
			     	if(data.status==1){
			     		jBox.tip('修改成功', 'success');
			     		}
			     	if(data.status==0){
			     		jBox.tip('请先登录系统', 'error');
			     	}	
					if(data.status==2){
			     		jBox.tip('原始密码输入不正确', 'error');
			     	}
			     	},
					error: function(){
						jBox.tip('修改失败', 'error');
					}
				};
				curform.ajaxSubmit(options);
				
				return false;
			}
		});

});
