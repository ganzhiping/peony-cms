var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$('#viewframe').attr("src",pageContext + "/baseClasskeyws/baseClasskeywsList?baseclassId=" + currentNode.id);  
		
	
	
	}
}

$(function() {
	pageContext = $("#pageContext").val();
	$("#viewDiv").on("click", "a.popup", function() {
		jBox("iframe:" + $(this).data("href"), {
			title : "修改区域信息",
			width : 500,
			id : "editDiv",
			height : 400,
			buttons: { }
		});
	});



});