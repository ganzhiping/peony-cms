<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>部门编辑</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/area/area_edit.js"></script>
<SCRIPT type="text/javascript">
		var setting = {
			view: {
				dblClickExpand: false
			},
		
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick
			}
		};

		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			cid="";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
				cid+=nodes[i].id + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			if (cid.length > 0 ) cid = cid.substring(0, cid.length-1);
			var cityObj = $("#citySel");
			cityObj.attr("value", v);
			$("#pid").attr("value",cid);
			hideMenu();
		}

	function showMenu() {
			var cityObj = $("#citySel");
			var cityOffset = $("#citySel").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, ${nodeList});
			$("#citySel").attr("value",$.fn.zTree.getZTreeObj("treeDemo").getCheckedNodes(true)[0].name);
		});
	</SCRIPT>
</head>
<body>
<div class="form" >
<form id="editForm">
	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
	<input type="hidden" name="areaId" value="${area.areaId}"/>
	<input type="hidden" name="areaPid" id="pid" value="${area.areaPid}"/>
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="boxTable boxmar">
    
        <tr class="bg nobr">
            <td align="right">所属区域：</td>
            <td> <input type="text" name="pname"  id="citySel" value="" onclick="showMenu()" readonly class="cword gray" datatype="*" nullmsg="请填写所属区域名称"/><span id="fieldErr_fatherAreaName"></span></td>
	          
            </td>
        </tr>
        <tr class="nobg">
            <td align="right"><span class="F00">*</span>区域名称：</td>
            <td><input type="text" name="name" value="${area.name}" class="cword gray" datatype="*" nullmsg="请填写区域名称"/><span id="fieldErr_areaName"></span></td>
        </tr>
        <tr class="nobg">
            <td align="right"><span class="F00">*</span>排序：</td>
            <td><input type="text" name="order" value="${area.order}" class="cword gray" datatype="n" nullmsg="请填写排序号"/><span id="fieldErr_seq"></span></td>
        </tr>
        <tr class="nobg">
            <td align="right"><span class="F00"></span>级别：</td>
            <td><input type="text" name="level" value="${area.level}" class="cword gray"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
            	<input class="btn" type="button" id="subBtn" value="保存">
            </td>
        </tr>
    </table>
</form>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
</div>
</body>
</html>
