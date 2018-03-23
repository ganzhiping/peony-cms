var pageContext;
var currentNode;

function loadView() {
	if (currentNode) {
		$("#viewDiv").load(pageContext + "/menu/editMenu/" + currentNode.id);
	}
}



