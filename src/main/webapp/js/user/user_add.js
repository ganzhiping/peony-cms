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
					url: pageContext + "/user/saveUser",
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
				
				var loginName=$("#loginName").val();
				if(loginName=="")return;
				$.ajax({
			    type: "POST",
			    async:false,
			    url: pageContext+"/user/checkLoginName",
			    data: {
			    	loginName:loginName
			    },
			    dataType: "json",
			    success: function(data){
			    	if(data.status==1){
			    		curform.ajaxSubmit(options);
			    	}else{
			    		parent.jBox.tip('用户名已存在', 'error');
			    		
			    	}
			    	
			    }
			});
				
				
				return false;
			}
		});
	});



