$(function() {
		var pageContext = $("#pageContext").val();
		$("#loginForm").ajaxForm();
		$("#loginForm").Validform({
			btnSubmit:"#subBtn",
			tiptype:1,
			ajaxPost:true,
			beforeSubmit: function(curform){
				var options = {
					url: pageContext + "/user/loginCheck",
					type: 'POST',
					dataType: 'json',
					async: false,
			     	success: function(data) {
			     		if(data==1){
			     				window.location.href=pageContext+"/user/index";
			     		}else{
			     			jBox.tip('用户名或密码错误','error');
			     		}
			     	},
					error: function(){
						jBox.tip('登陆失败', 'error');
					}
				};
				curform.ajaxSubmit(options);
				
				return false;
			}
		});
	});