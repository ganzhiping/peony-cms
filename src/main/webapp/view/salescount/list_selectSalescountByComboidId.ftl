<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售明细(移动免费版)</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<script  type="text/javascript">
		//var userList =new Object();
		//<#list list as x>
		//	userList['${x.userId}'] = '${x.name}';
		//</#list>
	    var agentList =new Object();
		<#list listAgent as x>
			agentList['${x.agentId}'] = '${x.name}';
		</#list>
</script>

</head>
<body>
<div class="tb mianbaoxue">首页 &gt;&gt; 销售统计 &gt;&gt; 销售统计明细(移动免费版)</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<input type="hidden" id="comboid" value="${comboid}"/>
		<a href="${request.getContextPath()}/salescount/selectSalescount">&lt;&lt;返回</a>
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	           
	            <tr class="header_title">
	            	<td  >用户名</td>
	            	<td >销售类型</td>
	            	<td >代理商</td>
	            	<td >客户状态</td>
	            	<td >截止日</td>
	            	<td >购买日</td>
	            	<td >银行付款金额</td>
	            	<td >积分兑换</td>
	            	<td >购买天数</td>
	            </tr>
           </thead>
           
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/salesCount/salesCountByComboid.js"></script>
</body>
</html>

