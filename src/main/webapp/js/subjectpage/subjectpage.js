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
								+ "/subjectpage/selectByPage",
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
										"mDataProp" : "checkbox",
										"fnCreatedCell" : function(nTd, sData,
												oData) {
											$(nTd).html(
													"<input type=\"checkbox\" name=\"chk_list\" value=\""
															+ oData.id + "\">");
										}
									},
								{
									"mDataProp" : "title",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"load('"
											+ oData.id
											+ "')\" class=\"oicon\" title=\"查看详细\">"+oData.title+"</a>";
											$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "publishdate",
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var d = new Date();
										d.setTime(oData.publishdate);
										$(nTd).html(
												d.format("yyyy-MM-dd  hh:mm"));
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
							if ($("#title").val() != ''
								&& $("#title").val() != null) {
							aoData.push({
								'name' : 'title',
								'value' : $("#title").val()
							});
						}
						if ($("#userId").val() != ''
							&& $("#userId").val() != null) {
						aoData.push({
							'name' : 'userIds',
							'value' : $("#userId").val()
						});
						}
						if ($("#polarity").val() != ''
							&& $("#polarity").val() != null) {
						aoData.push({
							'name' : 'polarity',
							'value' : $("#polarity").val()
						});
						}
						}
					});

	  $("#delete").on("click", function() {
		  del();
		});
	  $("#searchDiv").on("click", function() {
		  search();
		});
	  
	  
})
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
function del() {
	var ids=getCheckVal();
	if(ids==""){
		jBox.info("请选择", "提示");
		return;
	}
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/subjectpage/deleteSubjectPage",
				dataType : "json",
				data : {
					ids : ids
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
 * 设置正负面
 * @param polarity
 */
function updateState(polarity) {
	
	var ids=getCheckVal();
	if(ids==""){
		jBox.info("请选择", "提示");
		return;
	}
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/subjectpage/updateSubjectPageState",
				dataType : "json",
				data : {
					ids : ids,
					polarity:polarity
				},
				success : function(data) {
					jBox.tip("设置成功", "success");
					search();

				},
				error : function() {
					jBox.info("设置失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要修改吗？", "提示", submit);
}
function change(status){
	$("#polarity").val(status);
	search();
}

/**
 * 发送预警
 * 
 */
function sendWarning() {
	
	var ids=getCheckVal();
	if(ids==""){
		jBox.info("请选择", "提示");
		return;
	}
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "get",
				url : pageContext + "/warning/saveWarning",
				dataType : "json",
				data : {
					ids : ids
				},
				success : function(data) {
					jBox.tip("发送成功", "success");

				},
				error : function() {
					jBox.info("发送失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要发送预警吗？", "提示", submit);
}
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

function load(id){
	var num=Math.floor(Math.random()*100); 
	var iTop = (window.screen.availHeight-30-700)/2;        
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-10-1024)/2;      
	window.open (pageContext + "/subjectpage/loadSubjectPage?id="+id,'newwindow'+num,'height=700,width=1024,top='+iTop+',left='+iLeft+', toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
}