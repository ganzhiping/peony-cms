<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单编辑</title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script src="${request.getContextPath()}/js/menu/menu_edit.js"></script>
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
<body style="background:#FFFFFF">
<div class="tneirong_2_in">
        <div class="table_tanchu">
        <form id="editForm" >
        	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
			<input type="hidden" name="menuId" value="${menu.menuId}"/>
			<input type="hidden" name="menuPid" id="pid" value="${menu.menuPid}"/>
	          <table border="0" cellspacing="0" cellpadding="0">
	            <tr>
	               <th align="right">所属菜单：</th>
	           	   <td> <input type="text" name="pname"  id="citySel" value="" onclick="showMenu()"  readonly/></td>
	            </tr>
	            <tr>
	              <th><span class="F00">*</span>菜单名称：</th>
	              <td><input class="input_text" type="text" name="name" value="${menu.name}" datatype="*" nullmsg="请填写菜单名称" /></td>
	            </tr>
	            <tr>
	              <th><span class="F00">*</span>排序：</th>
	              <td><input class="input_text" type="text" value="${menu.order}" name="order"  datatype="n" nullmsg="请填写排序号"/></td>
	            </tr>
	              <tr>
	              <th><span class="F00">*</span>菜单地址：</th>
	              <td><input class="input_text" type="text" value="${menu.url}" name="url"  datatype="*" nullmsg="请填写菜单url"/></td>
	            </tr>
	              <tr>
	              <th><span class="F00">*</span>菜单标识：</th>
	              <td><input class="input_text" type="text" value="${menu.identify}" name="identify"  datatype="*" nullmsg="请填写标识"/></td>
	            </tr>
	             <tr>
	              <th><span class="F00">*</span>是否可见：</th>
	              <td><input type="radio" <#if menu.visible=='1'> checked</#if> name="visible" value="1" /> 是
            		  <input type="radio" <#if menu.visible=='0'> checked</#if> name="visible" value="0" /> 否
            	  </td>
	            </tr>
	            <tr>
	              <th>&nbsp;</th>
	              <td><div class="aniu_xinxi_fab">
		                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
	        		  </div>
	       		 </td>
	            </tr>
	          </table>
	          </form>
	          <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
					<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
			  </div>
        </div>
      </div>
</body>
</html>
