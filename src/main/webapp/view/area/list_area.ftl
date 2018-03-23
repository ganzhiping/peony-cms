<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>区域管理</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body class="baody2">
<div class="tb mianbaoxue">首页 &gt;&gt; 关键词维护 &gt;&gt; 区域维护</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="bianji_tbale teji_table">
<div class="tianjia">
  <div class="tb baocunanniu color_bai" id="create">添 加</div>
  <div class="tb baocunanniu color_bai" id="delete">删除</div>
</div>
<div style="float:left;">
<ul class="tree_ul ztree" id="areaTree" style="width:175px;"></ul></td>
</div>
   <div style="float:left;">
   <iframe width="420" height="330" frameborder="0" id="viewframe" scrolling="auto" src=""></iframe>
  </div>
</div>
	<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
		<script src="${request.getContextPath()}/js/area/area.js"></script>
<SCRIPT type="text/javascript">

$(function() {
	var pageContext = $("#pageContext").val();
	function configTree() {
		setting = {data: {
				simpleData: {
					enable: true
				}
			},
			view : {
				expandSpeed : ""
			},
			callback : {
				onClick : function(event, treeId, treeNode) {
					currentNode = treeNode;
					loadView();
				}
			}
		};
		return setting;
	}
	$.fn.zTree.init($("#areaTree"), configTree(),${nodeList});
});
	</SCRIPT>
</body>
</html>
