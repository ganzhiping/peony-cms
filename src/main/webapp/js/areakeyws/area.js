var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$("#viewDiv").load(pageContext + "/areakeyws/areakeywsList?areaId=" + currentNode.id);
	}
}

function refreshTree() {
	var zTree = $.fn.zTree.getZTreeObj("areaTree");
	zTree.reAsyncChildNodes(null, "refresh");
}

$(function() {
	pageContext = $("#pageContext").val();



});