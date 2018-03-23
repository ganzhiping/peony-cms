<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/customer/select_region.js"></script>
<head>
<SCRIPT type="text/javascript">
$(function() {
	var pageContext = $("#pageContext").val();
	function configTree() {
		setting = {data: {
				simpleData: {
					enable: true
				}
			},
			async: {
				enable: true,
				url:pageContext+"/region/findChildren",
				autoParam:["id"]
			},
			view : {
				expandSpeed : ""
			},
			callback : {
				onClick : function(event, treeId, treeNode) {
					currentNode = treeNode;
					window.parent.setRegionId(currentNode.id,currentNode.name);
					parent.jBox.tip('地域设置成功', 'success');
					parent.showPop(); //关闭窗体
				}
			}
		};
		return setting;
	}
	$.fn.zTree.init($("#regionTree"), configTree(),${nodeList});
});




	</SCRIPT>
</head>
<body class="baody2">
 <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div style="float:left;">
		<ul class="tree_ul ztree" id="regionTree" style="width:175px;"></ul>
</div>
</body>