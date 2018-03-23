var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		if(currentNode.isParent==false){
			$('#viewframe').attr("src",pageContext + "/pubInfo/infoList?channelId=" + currentNode.id);  
		}else{
			$('#viewframe').attr("src","");  
		}
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("channelTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();
	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改区域信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { '关闭': true }
		});
	});



});