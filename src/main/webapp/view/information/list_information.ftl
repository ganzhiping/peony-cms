<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站内消息</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">

 
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 个人中心 &gt;&gt; 站内消息</div>
<div class="tianjia">
<input type="button" id="create" class="tb baocunanniu color_bai" value="添加"/>

</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="15%">消息标题</td>
	                <td width="40%">消息内容</td>
	                <td width="15%">发送时间</td>
	                <td width="15%">发送人</td>
	                <td width="15%">操作</td>
	            </tr>
            </thead>
        </table>
        <script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
        <script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/information/information.js"></script>
</body>
</html>

