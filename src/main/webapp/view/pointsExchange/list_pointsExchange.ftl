<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>积分兑换管理</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">

</head>
<body style="background:#FFFFFF">
<div class="tb mianbaoxue">首页 &gt;&gt; E人E本 &gt;&gt; 积分兑换管理</div>
<div class="tianjia">
<div class="tb baocunanniu color_bai" id="create">添 加</div>
</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_pointsexchange" >
			<thead>
	            <tr class="header_title">
	                <td >积分数量</td>
	                <td >积分单价</td>
	                 <td >操作</td>
	            </tr>
            </thead>
            
        </table>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/datatable/jquery.dataTables.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/pointsexchange/pointsexchange.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
</body>
</html>
        