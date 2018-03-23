var pageContext;
var pageSize = 10;
var sortFields = "create_time";
var sortDirection = new Object();
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/salescount/selectAllMobileSalesCountList",
						"bPaginate" : true,
						"bSort" : true,
						"bFilter" : false,
						"bJQueryUI" : false,
						"sPaginationType" : "full_numbers",
						"sDom" : 'rt <"dongao_page"flpi>',
						"iDisplayLength" : 10,
						"aaData" : "list",
						"aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
						"aoColumns" : [
								
								{
									"mDataProp" : "comboid",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.comboid==null){
											$(nTd).html("退款");
										}else{
										var text;
										if (comboList[oData.comboid] != "" && comboList[oData.comboid] != null) {
											text=comboList[oData.comboid];
											$(nTd).html("<a  class=\"oicon o2 marAuto\" onclick=\"comboidMore("+oData.comboid+")\" href=\"javascript:;\">"+text+"</a>");
										}
										}
									}
								},
								{
									"mDataProp" : "bank",
									"bSortable" : false
								},
								{
									"mDataProp" : "bankPrice",
									"bSortable" : false
								},
								{
									"mDataProp" : "score",
									"bSortable" : false
								},
								{
									"mDataProp" : "scorePrice",
									"bSortable" : false
								}
								],
						"oLanguage" : {
							"sLengthMenu" : "每页 _MENU_ 条",
							"sZeroRecords" : "",
							"sInfo" : "当前从 _START_ 到 _END_ 条,共 _TOTAL_ 条记录",
							"sInfoEmpty" : "没有找到记录",
							"oPaginate" : {
								"sFirst" : "首页",
								"sPrevious" : "上一页",
								"sNext" : "下一页",
								"sLast" : "尾页"
							}
						},
						"fnServerParams" : function(aoData) {
							if ($("#beginime").val() != '' && $("#beginTime").val() != -1) {
								aoData.push({
									'name' : 'beginTime',
									'value' : $("#beginTime").val()
								});
							}
							if ($("#endTime").val() != '' && $("#endTime").val() != -1) {
								aoData.push({
									'name' : 'endTime',
									'value' : $("#endTime").val()
								});
							}
							if ($("#userSource").val() != ''
								&& $("#userSource").val() != -1) {
								aoData.push({
									'name' : 'userSource',
									'value' : $("#userSource").val()
								});
							}
							
							if ($("#agentId").val() != ''
								&& $("#agentId").val() != -1) {
							aoData.push({
								'name' : 'agentId',
								'value' : $("#agentId").val()
							});
							}
						}
					});

})

/**
 * 绑定搜索按钮点击事件
 */
$(function(){
    $("#searchDiv").click(function(evt){
    	search();
    });
    
    $("#create").on("click", function() {
		toAdd();
	});
    
  //市场用户下拉查询
	 $('#belongId').change(function(){ 
		 var userId=this.value;
		 if(userId>0){
			 
				$.ajax({
				    type: "GET",
				    async:false,
				    url: pageContext+"/customer/agentList",
				    data: {
				    	userId:userId
				    },
				    success: function(data){
				    	var select=$("#agentId");
				    		select.empty();
				    		select.append("<option value='-1'>--</option>");
				    	for (var i = 0; i < data.length; i++) {
		                		var agent = data[i];
		                		select.append("<option value="+agent.agentId+">"+agent.name+"</option>");
	              		}
				    }
				});
			 
			 
			 
			 
			 
		 }else{//获取所有代理商
				$.ajax({
				    type: "GET",
				    async:false,
				    url: pageContext+"/customer/agentAllList",
				    success: function(data){
				    	var select=$("#agentId");
				    		select.empty();
				    		select.append("<option value='-1'>--</option>");
				    	for (var i = 0; i < data.length; i++) {
		                		var agent = data[i];
		                		select.append("<option value="+agent.agentId+">"+agent.name+"</option>");
	              		}
				    }
				});
		 
		 }
		 
	 
	 })
    

    
    
    
    
    
});
/**
 * 加载用户服务
 * @return
 */
function loadMobileService(id) {
	
	jBox("iframe:" + pageContext + "/userservice/editMobileUserService/" + id, {
		title : "用户服务",
		width : 650,
		height : 500,
		top : '5%',
		buttons : {
			'关闭' : true
		}
	});
}
/**
 * 加载用户服务
 * @return
 */
function loadService(id) {
	
	jBox("iframe:" + pageContext + "/userservice/editUserService/" + id, {
		title : "用户服务",
		width : 650,
		height : 500,
		top : '5%',
		buttons : {
			'关闭' : true
		}
	});
}
/**
 * 增加用户
 * 
 * @return
 */
function toAdd() {
	jBox("iframe:" + pageContext + "/customer/addUser", {
		title : "增加客户",
		width : 650,
		height : 475,
		top : '8%',
		id : 'toAddUser',
		buttons : {}
	});
}
/**
 * 修改用户
 * 
 * @return
 */
function toEdit(id) {
	jBox("iframe:" + pageContext + "/customer/editUser/" + id, {
		title : "修改用户",
		width : 650,
		height : 475,
		top : '5%',
		id : 'editUser',
		buttons : {}
	});
}
function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/customer/deleteUser",
				dataType : "json",
				data : {
					id : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					search();

				},
				error : function() {
					jBox.info("删除失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要删除吗？", "提示", submit);
}
/**
 * 加载权限
 * 
 * @return
 */
function loadFunction(id) {
	jBox("iframe:" + pageContext + "/user/findUserRoles/" + id, {
		title : "设置权限",
		width : 650,
		height : 300,
		top : '20%',
		buttons : {
		}
	});
}
/**
 * 根据条件查询
 * 
 * @param currentPage
 * @param action
 * @return
 */
function search() {
	var oTable = $('#list_info').dataTable();
	oTable.fnPageChange("first", true);
}

/**
 * 关闭iframe
 * 
 * @return
 */
function showPop() {
	$.jBox.close(true);
}





/**
 * 跳转到套餐消费详细
 * 
 * @param newStatus
 * @return
 */
function comboidMore(comboidId) {
	
	window.location.href=pageContext+ "/salescount/selectMobileSalesCountListByComboidId?comboid="+comboidId;
	
	
	
	
}


function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/customer/deleteUser",
				dataType : "json",
				data : {
					ids : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					search();

				},
				error : function() {
					jBox.info("删除失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要删除吗？", "提示", submit);
}

//停止试用
function stop() {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/customer/stopUser",
				dataType : "json",
				data : {
					ids : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					search();

				},
				error : function() {
					jBox.info("删除失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要删除吗？", "提示", submit);
}

function openWindowWithPost(name, password) {
	var url="http://mdyq.peonydata.com/backloginCheck";
	var num=Math.floor(Math.random()*100); 
	
    var newWindow = window.open("", "newWin"+num);
    if (!newWindow){
        return false;
    }
  
    var html = "<html><head></head><body>";
    	html += "<form id='formid' method='post' action='"+ url+"'>";
    
    	html+="<input type='hidden' name='backloginName' value='"+name+"'/>";
    	html+="<input type='hidden' name='password' value='"+password+"'/>";
    
    	html += "</form><script type='text/javascript'>document.getElementById(\"formid\").submit()</script></body></html>";
    	newWindow.document.write(html);
    return newWindow;
}