function modify(){
	var roleIds=getCheckVal();
	var userId=$("#userId").val();
	var pageContext=$("#pageContext").val();
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/userRole/updateUserRole",
				dataType : "json",
				data : {
					roleIds : roleIds,
					userId :  userId
				},
				success : function(data) {
					parent.jBox.tip("更新成功", "success");
					parent.showPop();
					//window.location.reload();

				},
				error : function() {
					jBox.info("更新失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要修改吗？", "提示", submit);


}

function getCheckVal() {
	var v = "";
	$("input[name='chk_list']:checked").each(function() {
		if (v == "") {
			v += this.value
		} else {
			v += "," + this.value
		}
	});
	return v;
}