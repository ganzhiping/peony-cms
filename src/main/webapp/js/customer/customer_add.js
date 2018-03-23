var pageContext;

$(function() {
	pageContext = $("#pageContext").val();

	$('#userForm').ajaxForm();
	$("#userForm").Validform({
		btnSubmit : "#subBtn",
		tiptype : 1,
		ajaxPost : true,
		postonce : true,
		beforeSubmit : function(curform) {
			var options = {
				url : pageContext + "/customer/saveUser",
				type : 'post',
				data : null,
				dataType : 'script',
				async : false,
				success : function() {

					parent.search();
					parent.showPop();
					parent.jBox.tip('保存成功', 'success');
				},
				error : function() {
					parent.jBox.tip('保存失败', 'error');
				}
			};
			var loginName = $("#loginName").val();
			if (loginName == "")
				return;
			$.ajax({
				type : "POST",
				async : false,
				url : pageContext + "/user/checkLoginName",
				data : {
					loginName : loginName
				},
				success : function(data) {
					if (data.status == 1) {
						curform.ajaxSubmit(options);
					} else {
						parent.jBox.tip('用户名已存在', 'error');

					}

				}
			});

			return false;
		}
	});

	// 市场用户下拉
	$('#belongId').change(function() {
		clear_radio();// 客户类型重置
		$("#agent_span").html("");

	})

	// 点击直销radio
	$("input[id=commonUser]").click(function() {
		$("#agent_span").html("");
	})

	// 代理商radio 点击
	$("input[id=agentUser]")
			.click(
					function() {

						$("#agent_span").html("");
						var userId = $("#belongId").val();
						$
								.ajax({
									type : "GET",
									async : false,
									url : pageContext + "/customer/agentList",
									data : {
										userId : userId
									},
									success : function(data) {

										var text = '选择代理商<select name="agentId" id="agentId" style="width:100px"></select>  &nbsp;&nbsp;使用代理商logo:<input type="radio" name="useAgentLogo" value="1"  checked />是  <input type="radio" name="useAgentLogo" value="0" />否 ';
										$("#agent_span").append(text);
										var select = $("#agentId");

										for ( var i = 0; i < data.length; i++) {
											var agent = data[i];
											select.append("<option value="
													+ agent.agentId + ">"
													+ agent.name + "</option>");
										}
									}
								});

					});

})

/**
 * 选择地域
 */
function selectRegion() {
	jBox("iframe:" + pageContext + "/region/userSelectRegion", {
		title : "选择地域",
		width : 300,
		height : 400,
		top : '2%',
		buttons : {}
	});
}

function clear_radio() {
	// 客户类型重置
	$('input:radio[id=commonUser]').attr('checked', true);
}

$(function() {
	// 客户范围下拉
	$('#userType')
			.change(
					function() {
						var id = $(this).val();
						var parentCode = "";
						if (id == 2) {
							// 清除区域span
							$("#dept_span").html("");
							var area_text = '所在区域 ： <a href="#" onClick="selectRegion();" >选择</a>';
							$("#area").append(area_text);
							// 后台数据库写死
							parentCode = 41
							$
									.ajax({
										type : "GET",
										async : false,
										url : pageContext
												+ "/customer/baseclassList/"
												+ parentCode,
										success : function(data) {
											var text = '部门：<select name="baseclassId" id="dept"></select>';
											$("#dept_span").append(text);
											var select = $("#dept");

											for ( var i = 0; i < data.length; i++) {
												var baseclass = data[i];
												select.append("<option value="
														+ baseclass.baseclassId
														+ ">" + baseclass.name
														+ "</option>");
											}
										}
									});

						} else {
							// 清除区域span
							$("#dept_span").html("");
							// 后台数据库写死
							if (id == 1) {
								parentCode = 243;
							} else if (id == 3) {
								parentCode = 150;
							} else if (id == 4) {
								parentCode = 152;
							}
							$
									.ajax({
										type : "GET",
										async : false,
										url : pageContext
												+ "/customer/baseclassList/"
												+ parentCode,
										success : function(data) {
											var text = '行业：<select name="baseclassId" id="dept"></select>';
											$("#dept_span").append(text);
											var select = $("#dept");

											for ( var i = 0; i < data.length; i++) {
												var baseclass = data[i];
												select.append("<option value="
														+ baseclass.baseclassId
														+ ">" + baseclass.name
														+ "</option>");
											}
										}
									});

							// 清除区域span
							$("#area").html("");
							// 清除区域显示名称
							$("#areaName").html("");
						}

					})
})

// 子页面调用 设置regionId 和地域显示名称
function setRegionId(id, name) {
	$("#regionId").val(id);
	$("#areaName").text(name);
}

function showPop() {
	$.jBox.close(true);
}
