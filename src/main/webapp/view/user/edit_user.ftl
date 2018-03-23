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
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/user/user_edit.js"></script>

<script>

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
			$("#citySel").attr("value","${dept.name}");
		});

</script>
</head>
<body class="baody">
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form  id="editForm">
<input type="hidden" name="deptId" id="deptId" value="${dept.deptId}" />
<input type="hidden" name="userId" value="${user.userId}" />
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>部门名称:</th>
    <td>
    <input  id="citySel" value="" onclick="showMenu()" value="${dept.name}"  class="cword gray" datatype="*" nullmsg="请填写部门名称"/><span id="fieldErr_depName"></span> 
      </td>
  </tr>
  <tr>
    <th>用户名:</th>
    <td>
    <input class="input_text" type="text" name="loginName" value="${user.loginName}" disabled="true" id="textfield" /> 
      </td>
  </tr>
  <tr>
    <th>姓　名:</th>
    <td><input class="input_text" type="text" name="name" value="${user.name}" id="textfield" />
    </td>
  </tr>
   <tr>
    <th>用户类型:</th>
    <td><input type="radio" name="userType" value="1"   <#if user.userType=='1'> checked</#if>  />普通用户 <input type="radio" name="userType" value="2"  <#if user.userType=='2'> checked</#if>/>政府用户</td>
  </tr>
  <tr>
    <th>邮　箱:</th>
    <td><input class="input_text" type="text" name="email" value="${user.email}" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>电　话:</th>
    <td><input class="input_text" type="text" name="mobile" value="${user.mobile}" id="textfield2" /></td>
  </tr>
  <tr>
    <th>性　别:</th>
    <td><input type="radio" <#if user.sex=='男'> checked</#if> name="sex" value="男" /> 男<input type="radio"  <#if user.sex=='女'> checked</#if> name="sex" value="女" />女</td>
  </tr>
  <tr>
    <th>单  位:</th>
    <td><input class="input_text" type="text" name="company" value="${user.company}" id="textfield5" /></td>
  </tr>
  <tr>
    <th>地  址:</th>
    <td><input class="input_text" type="text" name="address" value="${user.address}"  id="textfield6" /></td>
  </tr>
  <tr>
    <th>备  注:</th>
    <td>
      <textarea class="input_text2"name="note"   id="textarea" cols="45" rows="5">${user.note}</textarea></td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td>
    <input class="tb baocunanniu color_bai" type="button" name="button" id="subBtn"  " value="保 存" /></td>
  </tr>
</table>
</form>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
</div>
</body>
</html>