<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/user/user_add.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
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
			$("#deptId").attr("value",cid);
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
		
		
		function showRegion(){
		var pageContext=$("#pageContext").val();
		jBox("iframe:" + pageContext + "/region/selectRegion", {
		title : "选择地域",
		width : 300,
		height : 415,
		top : '8%',
		buttons : {}
	});
}

function showPop() {
	$.jBox.close(true);
}
	</SCRIPT>
	
	
</head>
<body class="baody">
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form  id="userForm">
<input type="hidden" id="deptId" name="deptId" value=""/>
<table border="0" cellspacing="0" cellpadding="0">
 <tr>
    <th><span class="F00">*</span>部门名称:</th>
    <td>
    <input  type="text" name="pname"  id="citySel" value="" onclick="showMenu()" class="cword gray" datatype="*" nullmsg="请填写部门名称"/><span id="fieldErr_depName"></span> 
      </td>
  </tr>
  <tr>
    <th>用户类型:</th>
    <td><input type="radio" name="userType" value="1"  checked  />普通用户 <input type="radio" name="userType" value="2"/>政府用户     &nbsp;选择地域<input  type="text" name="regionName"  id="region" value="" onClick="showRegion();" class="cword gray" datatype="*" nullmsg="请选择地域名称"/><span id="fieldErr_regionName"></span></td>
  </tr>
  <tr>
    <th><span class="F00">*</span>用户名:</th>
    <td>
    <input class="input_text" type="text" name="loginName" value=""  id="loginName" class="cword gray" datatype="*" nullmsg="请填写用户名"/><span id="fieldErr_loginName"></span> 
      </td>
  </tr>
  <tr>
    <th><span class="F00">*</span>姓　名:</th>
    <td><input class="input_text" type="text" name="name" value="" id="name"  class="cword gray" datatype="*" nullmsg="请填写姓名"/><span id="fieldErr_userName"></span>
    </td>
  </tr>
  <tr>
    <th>邮　箱:</th>
    <td><input class="input_text" type="text" name="email" value="" id="email" />
     </td>
  </tr>
  <tr>
    <th>电　话:</th>
    <td><input class="input_text" type="text" name="mobile" value="" id="mobile" /></td>
  </tr>
  <tr>
    <th>性　别:</th>
    <td><input type="radio"  checked name="sex" value="男" /> 男<input type="radio"  name="sex" value="女" />女</td>
  </tr>
  <tr>
    <th>单  位:</th>
    <td><input class="input_text" type="text" name="company" value="" id="company" /></td>
  </tr>
  <tr>
    <th>地  址:</th>
    <td><input class="input_text" type="text" name="address" value=""  id="address" /></td>
  </tr>
  <tr>
    <th>备  注:</th>
    <td>
      <textarea class="input_text2"name="note"   id="textarea" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td>
    <input class="tb baocunanniu color_bai" type="button" name="button" id="subBtn"   value="保 存" /></td>
  </tr>
</table>
</form>
<div id="regionMenu" class="menuContent" style="display:none; position: absolute;">
	<ul id="regionTree" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>

<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
</div>

</body>
</html>
