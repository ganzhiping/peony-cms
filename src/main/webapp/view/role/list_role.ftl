<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色管理</title>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">

</head>
<body style="background:#FFFFFF">
<div class="tb mianbaoxue">首页 &gt;&gt; 系统配置 &gt;&gt; 角色管理</div>
<div class="tianjia">
<div class="tb baocunanniu color_bai" id="create">添 加</div>
</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
		 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_role" >
			<thead>
	            <tr class="header_title">
	                <td width="25%">名称</td>
	                <td width="10%">时间</td>
	                <td width="10%">操作</td>
	            </tr>
            </thead>
        </table>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>

<script type="text/javascript" src="${request.getContextPath()}/js/datatable/jquery.dataTables.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>

<script src="${request.getContextPath()}/js/role/role.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
</body>
</html>
