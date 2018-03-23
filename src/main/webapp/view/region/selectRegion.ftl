<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>地域管理</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body class="baody2">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="bianji_tbale teji_table">
<div style="float:left;">
<ul class="tree_ul ztree" id="regionTree" style="width:175px;"></ul></td>
</div>
  
  </div>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">

$(function() {
	var pageContext = $("#pageContext").val();
	function configTree() {
		setting = {data: {
				simpleData: {
					enable: true
				}
			},
			async: true,
			view : {
				expandSpeed : ""
			},
			callback : {
				onClick : function(event, treeId, treeNode) {
					currentNode = treeNode;
					parent.document.getElementById("region").value=currentNode.name;
					parent.showPop();
					
				}
			}
		};
		return setting;
	}
	$.fn.zTree.init($("#regionTree"), configTree(),${nodeList});
});
	</SCRIPT>
</body>
</html>
