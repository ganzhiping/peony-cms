var pageContext;
var roleId;
$(function() {
	pageContext = $("#pageContext").val();
	roleId=$("#roleId").val();
})

$("#assignButton").click(function(){
				top[0].$.jBox.open("iframe:"+pageContext+"/role/roleManager/"+roleId, "分配角色",800,$(top.document).height()-440,{
					buttons:{"确定分配":"ok", "关闭":true}, bottomText:"通过选择部门，然后为列出的人员分配角色。",submit:function(v, h, f){
						var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
						var ids = h.find("iframe")[0].contentWindow.ids;
						//nodes = selectedTree.getSelectedNodes();
						if (v=="ok"){
							var tips="";
							// 删除''的元素
							if(ids[0]==''){
								ids.shift();
								pre_ids.shift();
							}
							if(pre_ids.sort().toString() == ids.sort().toString()){
								top[0].$.jBox.tip("未给角色【"+$("#roleName").val()+"】分配新成员！", 'info');
								return false;
							};
					    	// 执行保存
					    	//loading('正在提交，请稍等...');
					    	var idsArr = "";
					    	for (var i = 0; i<ids.length; i++) {
					    		idsArr = (idsArr + ids[i]) + (((i + 1)== ids.length) ? '':',');
					    	}
					    	$('#assignRoleForm').attr('action',pageContext+'/userRole/saveUserRole?roleId='+roleId+'&userIds='+idsArr+'&pre_userIds='+pre_ids);
					    	
					    	 $("#assignRoleForm").ajaxSubmit({
					           success: function (html, status) {
					           tips="保存成功";
					           top[0].$.jBox.tip(tips, 'success');
					           window.location.reload();
					           },
					           error:function(){
					            tips="保存失败";
					            top[0].$.jBox.tip(tips, 'info');
					           }
			           
			     			  });
					    	return true;
						} else if (v=="clear"){
							h.find("iframe")[0].contentWindow.clearAssign();
							return false;
		                }
					}, loaded:function(h){
						$(".jbox-content", top.document).css("overflow-y","hidden");
					}
				});
			});


function del(userId,roleId){
	var submit = function (v, h, f) {
			    if (v == 'ok'){
			    	top[0].$.jBox.tip("ok", 'info');
			    } else if (v == 'cancel'){
			    	// 取消
			    	top[0].$.jBox.tip("取消清除操作！", 'info');
			    }
			    return true;
			};
			tips="确定清除角色下的已选人员？";
			top[0].$.jBox.confirm(tips, "清除确认", submit);
	
	}
			