var pageContext;
var pageSize = 10;
var channelId;
$(function() {
	pageContext = $("#pageContext").val();
	channelId=$("#channelId").val();
	var oTable = $('#list_info')
			.dataTable(
					{
						"bProcessing" : true,
						"bServerSide" : true,
						"sServerMethod" : 'POST',
						"sAjaxSource" : pageContext
								+ "/pubInfo/selectByPage?channelId="+channelId,
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
									"mDataProp" : "title"
								},
								{
									"mDataProp" : "author"
								},
								{
									"mDataProp" : "time",
									"fnCreatedCell" : function(nTd, sData,
                                                                                         oData) {
                                            var d = new Date();
                                            d.setTime(oData.time);
                                            $(nTd).html(
                                                d.format("yyyy-MM-dd  hh:mm"));
									}
								},
								{
									"mDataProp" : "caseRecommend",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text ;
										
										if(oData.caseRecommend==1){
											 text = "<a   href='javascript:;'  onclick=\"caseRecommend('"
													+ oData.pubinfoId+ "','"+ oData.caseRecommend
													+ "' )\" class=\"oicon\" title=\"状态\">已推荐</a>";
										}else{
											 text = "<a   href='javascript:;'  onclick=\"caseRecommend('"
													+ oData.pubinfoId+ "','"+ oData.caseRecommend
													+ "' )\" class=\"oicon\" title=\"状态\">未推荐</a>";
										}
										
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "subjectRecommend",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text ;
										
										if(oData.subjectRecommend==1){
											 text = "<a   href='javascript:;'  onclick=\"subRecommend('"
													+ oData.pubinfoId+ "','"+ oData.subjectRecommend
													+ "','"+ oData.image+ "','"+oData.bigImage+"')\" class=\"oicon\" title=\"状态\">已推荐</a>";
										}else{
											 text = "<a   href='javascript:;'   onclick=\"subRecommend('"
													+ oData.pubinfoId+ "','"+ oData.subjectRecommend
													+ "','"+ oData.image+ "','"+oData.bigImage+"')\"  class=\"oicon\" title=\"状态\">未推荐</a>";
										}
										
										$(nTd).html(text);
									}
								},
								{
									"mDataProp" : "opt",
									"bVisible" : true,
									"fnCreatedCell" : function(nTd, sData,
											oData) {
										var text = "<a   href='javascript:;'  onclick=\"edit('"
												+ oData.pubinfoId
												+ "')\" class=\"oicon\" title=\"修改\">修改</a>";
										text += "||<a   href='javascript:;'  onclick=\"del('"
												+ oData.pubinfoId
												+ "')\"  class=\"oicon o2 marAuto\" title=\"删除\">删除</a>";
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
							if ($("#title").val() != '') {
								aoData.push({
									'name' : 'title',
									'value' : $("#title").val()
								});
							}

						}
					});


	 $("#searchDiv").click(function(evt){
	    	search();
	    });
})

function del(id) {
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/pubInfo/deletePubInfo",
				dataType : "json",
				data : {
					pubinfoId : id
				},
				success : function(data) {
					jBox.tip("删除成功", "success");
					showPop(); //关闭窗体
					search(); //重新查询
					

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
 * 编辑关键字
 */
function edit(id) {
	
	var iTop = (window.screen.availHeight-30-700)/2;        
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-10-1024)/2;      
	window.open (pageContext + "/pubInfo/editPubInfo?pubinfoId="+id,'newwindow','height=700,width=1024,top='+iTop+',left='+iLeft+', toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
	

}

/**
 * 添加关键字
 */
$("#add").on("click", function() {
	var iTop = (window.screen.availHeight-30-700)/2;        
    //获得窗口的水平位置
    var iLeft = (window.screen.availWidth-10-1024)/2;      
	window.open (pageContext + "/pubInfo/addPubInfo?channelId="+channelId,'newwindow','height=700,width=1024,top='+iTop+',left='+iLeft+', toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
	
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

function subRecommend(pubinfoId,subjectRecommend,img,bigImg) {
	if(img=="null"){
		jBox.tip("未设置pc图片", "error");
		return;
		
	}else{
		if(bigImg=="null"){
			jBox.tip("未设置pad大图", "error");
			return;
		}
		
		if(subjectRecommend==0){
			subjectRecommend=1;
		}else{
			subjectRecommend=0;
		}
		
		var submit = function(v, h, f) {
			if (v == 'ok') {
				$.ajax({
					type : "post",
					url : pageContext + "/pubInfo/recommend",
					dataType : "json",
					data : {
						pubinfoId : pubinfoId,
						subjectRecommend:subjectRecommend
					},
					success : function(data) {
						jBox.tip("设置成功", "success");
						showPop(); //关闭窗体
						search(); //重新查询
						

					},
					error : function() {
						jBox.info("设置成功", "提示");
					}
				});
			}
			return true;
		};

		$.jBox.confirm("是否确认推荐该专题？", "提示", submit);
		
	}
	
	
	
	
	
}
function caseRecommend(pubinfoId,caseRecommend) {
	if(caseRecommend==0){
		caseRecommend=1;
	}else{
		caseRecommend=0;
	}
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/pubInfo/recommend",
				dataType : "json",
				data : {
					pubinfoId : pubinfoId,
					caseRecommend:caseRecommend
				},
				success : function(data) {
					jBox.tip("设置成功", "success");
					showPop(); //关闭窗体
					search(); //重新查询
					

				},
				error : function() {
					jBox.info("设置成功", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("是否确信推荐该信息？", "提示", submit);
	
}

