var pageContext = $("#pageContext").val();
$(function() {
	 $('#userInfoForm').ajaxForm();
		$("#userInfoForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			postonce:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/user/updateUserInfo",
					type: 'post',
					data: null,
					dataType: 'script',
					async: false,
					success: function () {
		            	jBox.tip("修改成功", "success");
		               },
		         error:function(){
		            	  jBox.info("修改失败", "提示");
		              }
				};
				var submit = function(v, h, f) {
					if (v == 'ok') {
						  $("#userInfoForm").ajaxSubmit(options);
					} else if (v == 'cancel') {
					}
					return true;
				};
				jBox.confirm("确认修改", "提示", submit);
				return false;
			}
		});
});
