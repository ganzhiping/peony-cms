function modify(){
	var userIds=getCheckVal();
	var managerUserId=$("#managerUserId").val();
	var pageContext=$("#pageContext").val();
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/marketmanage/updateUserRole",
				dataType : "json",
				data : {
					userIds : userIds,
					managerUserId :  managerUserId
				},
				success : function(data) {
					parent.jBox.tip("更新成功", "success");
					parent.showPop();
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