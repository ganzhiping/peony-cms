<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预警信息管理</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>

<div class="tb mianbaoxue">首页 &gt;&gt; 信息管理 &gt;&gt; 预警信息管理</div>
<div class="aniu_xinxi_fab">
<span class="tb fabiao1 color_bai">发 送</span><span class="tb fabiao2 color_bai">删 除</span>
</div>
 	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr>
	                <td width="5%"><input type="checkbox" id="chk_all" onclick="checkAll(this);"></td>
	                <td>标题</td>
	                <td width="15%">时间</td>
	                <td width="15%">用户名</td>
	            </tr>
            </thead>
     </table>
     
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/warning/warning.js"></script>

</body>
</html>
