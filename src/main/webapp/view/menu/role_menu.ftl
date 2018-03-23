<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色分配权限</title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<SCRIPT type="text/javascript">

$(function() {
var pageContext = $("#pageContext").val();
	function configTree() {
		setting = {
		   check: {
              enable: true
		  },
		    data: {
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
	$.fn.zTree.init($("#roleMenuTree"), configTree(),${nodeList});
	
	var tree = $.fn.zTree.getZTreeObj("roleMenuTree");
	var ids=[${idslist}];
			for(var i=0; i<ids.length; i++) {
				var node = tree.getNodeByParam("id", ids[i]);
				try{tree.checkNode(node, true, false);}catch(e){}
			}
			
  


});
function selectCheckedNodes() { 
    var tree = $.fn.zTree.getZTreeObj("roleMenuTree"); 
    var nodes = new Array();  
    //取得选中的结点  
    nodes = tree.getCheckedNodes(true);  
    var str = "";  
    for (i = 0; i < nodes.length; i++) {  
        if (str != "") {  
            str += ",";  
        }  
        str += nodes[i].id;  
    }  
    return str;
}  

function submit() {
var pageContext = $("#pageContext").val();
var roleId=$("#roleId").val();
var menuIds=selectCheckedNodes();
	var submit = function(v, h, f) {
		if (v == 'ok') {
			$.ajax({
				type : "post",
				url : pageContext + "/menu/saveRoleMenu",
				dataType : "json",
				data : {
					menuIds : menuIds,
					roleId : roleId
				},
				success : function(data) {
					jBox.tip("修改成功", "success");
				},
				error : function() {
					jBox.info("修改失败", "提示");
				}
			});
		}
		return true;
	};

	$.jBox.confirm("您确定要修改吗？", "提示", submit);
}

</script>  
</head>
<body style="background:#FFFFFF">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<input type="hidden" id="roleId" name="roleId" value="${roleId}"/>

<div class="container">
	
    <div id="main">
    	<div class="position"></div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="treeTable">
        <tr>
	        <td>
	         <div class="aniu_xinxi_fab">
		        <input class="tb fabiao1 color_bai" type="button" onClick="submit();" value="保存" />
	        </div>
	        </td>
        </tr>
			<tr>
	    		<!--左侧目录树-->
		    	<td class="treeTd" width="160" valign="top">
			        <ul class="tree_ul ztree" id="roleMenuTree"></ul>
			        
		    	</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>
