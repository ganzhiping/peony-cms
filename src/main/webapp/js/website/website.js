var pageContext;
var pageSize = 10;
$(function() {
	pageContext = $("#pageContext").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/website/selectByPage",
						"bPaginate" : true,
						"bSort" : false,
						"bFilter" : false,
						"bJQueryUI" : false,
						"sPaginationType" : "full_numbers",
						"sDom" : 'rt <"dongao_page"flpi>',
						"iDisplayLength" : 10,
						"aaData" : "list",
						"aLengthMenu" : [ [ 10, 50, 100 ], [ 10, 50, 100 ] ],
						"aoColumns" : [
								{
									"mDataProp" : "name"
								},
								{
									"mDataProp" : "mediaType",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.mediaType;
										if(type==1){
											$(nTd).html("新闻");
										}
										if(type==2){
											$(nTd).html("论坛");
										}
										if(type==3){
											$(nTd).html("微博");
										}
										if(type==4){
											$(nTd).html("博客");
										}
										if(type==5){
											$(nTd).html("报纸");
										}
										if(type==6){
											$(nTd).html("twitter");
										}
									}
								},
								{
									"mDataProp" : "url"
								},
								{
									"mDataProp" : "ip"
								},
								{
									"mDataProp" : "company"
								},
								{
									"mDataProp" : "nature",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var type=oData.nature;
										if(type==1){
											$(nTd).html("企业");
										}
										if(type==2){
											$(nTd).html("政府机关");
										}
										if(type==3){
											$(nTd).html("事业单位");
										}
										if(type==4){
											$(nTd).html("社会团体");
										}
										if(type==5){
											$(nTd).html("个人");
										}
									}
								},
								{
									"mDataProp" : "record"
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"del('"
												+ oData.websiteId
												+ "')\" class=\"oicon\" title=\"删除\">删除</a>";
										
										text+="||<a   href='javascript:;'  onclick=\"toEdit('"
											+ oData.websiteId 
											+ "')\" class=\"oicon\" title=\"编辑\">编辑</a>";
										
										$(nTd).html(text);
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
							if ($("#name").val() != ''&& $("#name").val() !=null) {
							aoData.push({
								'name' : 'name',
								'value' : $("#name").val()
							});
						}
						if ($("#mediaType").val() != ''&& $("#mediaType").val() != -1) {
							aoData.push({
								'name' : 'mediaType',
								'value' : $("#mediaType").val()
							});
						}
						}
					});


})

function toEdit(id) {
	jBox("iframe:" + pageContext + "/website/editWebSite/" + id, {
		title : "修改网站信息",
		width : 650,
		height : 400,
		top : '5%',
		id : 'editWebsite',
		buttons : {}
	});
}
function toAdd() {
	jBox("iframe:" + pageContext + "/website/addWebSite", {
		title : "新增网站信息",
		width : 650,
		height : 400,
		top : '5%',
		id : 'addWebsite',
		buttons : {}
	});
}

function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/website/deleteWebSite",
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
 * 绑定搜索按钮点击事件
 */
$(function(){
    $("#searchDiv").click(function(evt){
    	search();
    });
});
/**
 * 根据条件查询课程
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