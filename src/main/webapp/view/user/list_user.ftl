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
<div class="tb mianbaoxue">首页 &gt;&gt; 系统配置 &gt;&gt;用户管理</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<input type="hidden" id="dept_id"/>
<input type="hidden" id="deptId"/><!-- 查询用-->
<div class="sousuox">
<dl>
<dt>用 户 名：</dt><dd><input class="input_text input_text3" type="text" name="loginName" id="loginName" /></dd>
<dt>姓 名：</dt><dd><input class="input_text input_text3" type="text" name="name" id="name" /></dd>
<dt class="dt_a">部 门：</dt><dd><input class="input_text input_text3"  value="" onclick="showMenu()"type="text" name="citySel" id="citySel" /></dd></dl>
<dl><dt>注册时间：</dt>
<dd class="dd_sx"><input class="input_text input_text4" type="text" name="startTime" id="startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/>

<input class="input_text input_text4" type="text" name="endTime" id="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"/></dd>
<dt class="dt_a">状 态：</dt><dd>
    <select class="input_text input_text3" name="userStatus" id="userStatus">
		  <option value="1">正常</option>
		  <option value="2">试用</option>
		  <option value="3">停止</option>
	  </select>
</dd>
<dd><div class="tb baocunanniu_sosuo color_bai" id="searchDiv">搜 索</div></dd></dl>
<div class="HackBox"></div>
</div>
<div>
<table width="10%" border="0" cellspacing="0" cellpadding="0" class="treeTable" style="Float:left;">
			<tr>
	    		<!--左侧目录树-->
		    	<td class="treeTd"  valign="top">
			        <ul class="tree_ul ztree" style="width:175px;"id="departmentTree"></ul>
		    	</td>
			    <td class="org_Table" valign="top" id="viewDiv">
			    	
		        </td>
			</tr>
		</table>
		<div style="margin-left:30px;Float:left;">
		<div class="tianjia">
  		<div class="tb baocunanniu color_bai" id="create">添 加</div>
  
		<table width="800px;" border="0" cellspacing="0" cellpadding="0"  class="display lis_tablet4" id="list_user" >
			<thead>
	            <tr class="header_title">
	                <td width="15%">登录名</td>
	                <td width="15%">姓名</td>
	                <td width="10%">邮箱</td>
	                <td width="10%">电话</td>
	                <td width="5%">性别</td>
	                <td width="20%">时间</td>
	                <td width="25%">操作</td>
	            </tr>
            </thead>
        </table>
        
</div>
</div>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
</div>
</div>

<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>

<script type="text/javascript" src="${request.getContextPath()}/js/datatable/jquery.dataTables.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>

<script src="${request.getContextPath()}/js/user/user.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>


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
					$("#dept_id").val(treeNode.id)
					search();
				}
			}
		};
		return setting;
	}
	$.fn.zTree.init($("#departmentTree"), configTree(),${nodeList});
});
	</SCRIPT>
	<SCRIPT type="text/javascript">
		var setting2 = {
			view: {
				dblClickExpand: false
			},
		
			data: {
				simpleData: {
					enable: true
				}
			},
			callback : {
				onClick : function (e, treeId, treeNode) {
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
			}
		};

		

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
			$.fn.zTree.init($("#treeDemo"), setting2, ${nodeList});
			$("#citySel").attr("value",$.fn.zTree.getZTreeObj("treeDemo").getCheckedNodes(true)[0].name);
		});
	</SCRIPT>
</body>
</html>
