<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>

<script src="${request.getContextPath()}/js/baseclass/baseclass_add.js"></script>
<SCRIPT type="text/javascript">
$(function() {
		var pageContext=$("#pageContext").val();
		var setting = {
			view: {
				dblClickExpand: false
			},
			async: {
				enable: true,
				url:pageContext+"/baseclass/findChildren",
				autoParam:["id"]
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
		$.fn.zTree.init($("#treeDemo"), setting, ${nodeList});
})
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
	
	</SCRIPT>
</head>
<body style="background:#FFFFFF">
 <div class="tneirong_2_in">
        <div class="table_tanchu">
        <form id="baseclassform" >
			<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
			<input type="hidden" name="baseclassPid" id="pid" />
	          <table border="0" cellspacing="0" cellpadding="0">
	            <tr>
	               <th align="right">所属类别：</th>
	           	   <td> <input type="text" name="pname"  id="citySel" value="" onclick="showMenu()"  readonly/></td>
	            </tr>
	            <tr>
	              <th><span class="F00">*</span>类别名称：</th>
	              <td><input  type="text" name="name" value="" datatype="*" nullmsg="请填写类别名称" /></td>
	            </tr>
	            <tr>
	              <th><span class="F00">*</span>排序：</th>
	              <td><input  type="text" value="" name="order"  datatype="n" nullmsg="请填写排序号"/></td>
	            </tr>
	              <tr>
	              <th><span class="F00">*</span>是否为公共词库：</th>
	              <td><input  type="radio" value="1" name="isPublic"  checked/>是   &nbsp; &nbsp; <input  type="radio" value="0" name="isPublic"  />否</td>
	            </tr>
	            <tr>
	              <td colspan=2><div class="aniu_xinxi_fab">
		                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
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
