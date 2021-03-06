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
								+ "/customer/selectMobileByPage",
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
									"mDataProp" : "loginName",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = oData.loginName ;
									$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "type",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										var text = oData.type;
										if(oData.type=="1"){
											text='qq';
										}else if(oData.type=="2"){
											text='微博';
										}else if(oData.type=="3"){
											text='微信';
										}else if(oData.type=="4"){
											text='qq空间';
										}else if(oData.type=="5"){
											text='手机';
										}else {
											text='--';
										}
										$(nTd).html(text);
										}
								},
								{
									"mDataProp" : "platformType",
									"fnCreatedCell" : function(nTd, sData,
											oData) {	
										var text = "";
										if(oData.platformType=="1"){
											text='正式';
										}
										if(oData.platformType=="2"){
											text='试用';
										}
										if(oData.platformType=="3"){
											text='未注册';
										}
										$(nTd).html(text);
										}
								},
								{
									"mDataProp" : "userSource",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										 var userSource=oData.userSource;
										 if(userSource=='0'){
											 $(nTd).html("直销");
										 }
										 if(userSource=='1'){
											 $(nTd).html("代理商");
										 }
									}
								},
								{
									"mDataProp" : "agentName",
									"bSortable" : false,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text;
										if (agentList[oData.agentId] != "" && agentList[oData.agentId] != null) {
											text=agentList[oData.agentId];
										}else{
											text="无";
										}
										$(nTd).html(text);
										
									}
								},
								{
									"mDataProp" : "expiryTime",
									"bSortable" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										if(oData.expiryTime==null){
											$(nTd).html("--");
										}else{
											var d = new Date();
											d.setTime(oData.expiryTime);
											$(nTd).html(
													d.format("yyyy-MM-dd"));
										}
										
									}
								},
								{
									"mDataProp" : "service",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										
											$(nTd).html("<a  class=\"oicon o2 marAuto\" onclick=\"loadMobileService("+oData.userId+")\" href=\"javascript:;\">查看</a>");
										
									}
								},
								{
									"mDataProp" : "points",
									
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										$(nTd).html(oData.points);
									}
								},
									
									{
										"mDataProp" : "createTime",
										"fnCreatedCell" : function(nTd, sData,
													oData) {
											if(oData.createTime==null){
												$(nTd).html('--');
											}else{
												var d = new Date();
												d.setTime(oData.createTime);
												$(nTd).html(
														d.format("yyyy-MM-dd"));
											}
										}
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
							if ($("#agentId").val() != ''
									&& $("#agentId").val() != -1) {
								aoData.push({
									'name' : 'agentId',
									'value' : $("#agentId").val()
								});
							}
							if ($("#type").val() != ''
								&& $("#type").val() != -1) {
							aoData.push({
								'name' : 'type',
								'value' : $("#type").val()
							});
						}
							if ($("#loginName").val() != '') {
								aoData.push({
									'name' : 'loginName',
									'value' : $("#loginName").val()
								});
							}
							if ($("#userSource").val() != ''
								&& $("#userSource").val() != -1) {
								aoData.push({
									'name' : 'userSource',
									'value' : $("#userSource").val()
								});
							}
							if ($("#platformType").val() != ''
								&& $("#platformType").val() != -1) {
								aoData.push({
									'name' : 'platformType',
									'value' : $("#platformType").val()
								});
							}
							if ($("#belongId").val() != '' && $("#belongId").val() != -1) {
								aoData.push({
									'name' : 'belongId',
									'value' : $("#belongId").val()
								});
							}
							if ($("#userStatus").val() != '' && $("#userStatus").val() != -1) {
								aoData.push({
									'name' : 'userStatus',
									'value' : $("#userStatus").val()
								});
							}
							if ($("#userType").val() != '' && $("#userType").val() != -1) {
								aoData.push({
									'name' : 'userType',
									'value' : $("#userType").val()
								});
							}
							if ($("#beginCreateTime").val() != '' && $("#beginCreateTime").val() != -1) {
								aoData.push({
									'name' : 'beginCreateTime',
									'value' : $("#beginCreateTime").val()
								});
							}
							if ($("#endCreateTime").val() != '' && $("#endCreateTime").val() != -1) {
								aoData.push({
									'name' : 'endCreateTime',
									'value' : $("#endCreateTime").val()
								});
							}
							if ($("#beginExpiryTime").val() != '' && $("#beginExpiryTime").val() != -1) {
								aoData.push({
									'name' : 'beginExpiryTime',
									'value' : $("#beginExpiryTime").val()
								});
							}
							if ($("#endExpiryTime").val() != '' && $("#endExpiryTime").val() != -1) {
								aoData.push({
									'name' : 'endExpiryTime',
									'value' : $("#endExpiryTime").val()
								});
							}
							
							aoData.push({
								'name' : 'orderFields',
								'value' : sortFields
							});
							aoData.push({
								'name' : 'order',
								'value' : sortDirection[sortFields] == null ? "desc": sortDirection[sortFields]
							});
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
 * 排序
 * @param fieldsName
 * @return
 */
function sortTbFileds(fieldsName) {
	sortFields = fieldsName;
	if (sortDirection[fieldsName] == null) {
		sortDirection[fieldsName] = "asc";
	} else {
		direction = sortDirection[fieldsName] == "asc" ? "desc" : "asc";
		sortDirection[fieldsName] =direction;
	}
	search();
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
 * 全选
 */
function checkAll(checkbox) {
	$("input[name='chk_list']").prop("checked", $(checkbox).prop("checked"));
}

/**
 * 得到checkebox值
 * @return
 */
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

/**
 * 修改用户停启状态
 * 
 * @param newStatus
 * @return
 */
function changeStatus(newStatus) {
	
	
	
	
	
	
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