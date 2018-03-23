<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/datatable/datatable.css"  rel="stylesheet" media="all" type="text/css"/>
<link href="${request.getContextPath()}/style/css/mddsj_houtai_right.css" rel="stylesheet">
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 日志管理 &gt;&gt; 信息日志</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
</div>
<input type="hidden" id="infoLogId" value="${infoLogId}" >
<input type="hidden" id="operationType" value="${operationType}" >
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="10%">用户名</td>
	                <td width="10%">销售类型</td>
	                <td width="10%">代理商</td>
	                <td width="10%">客户类型</td>
	                <#if operationType==1>
			        <td width="10%">点击时间</td>
		            </#if>
					<#if operationType==2>
					<td width="10%">转发时间</td>
					</#if>
					<#if operationType==3>
					<td width="10%">收藏时间</td>
					</#if>
	            </tr>
            </thead>
        </table>
		
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/ebinfodetaillog/ebinfodetaillog.js"></script>		
</body>
</html>

