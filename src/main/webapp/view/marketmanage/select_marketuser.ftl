<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>市场用户查询</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 用户管理 &gt;&gt; 市场用户查询</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
<dl>
	<dt>用 户 名：</dt><dd><input class="input_text input_text3" type="text" id="name" name="name"  /></dd>
	<dt>姓 名：</dt><dd><input class="input_text input_text3" type="text"  id="loginName" name="loginName"  /></dd>
	<dd><div class="tb baocunanniu_sosuo color_bai" id="searchDiv">搜 索</div></dd></dl>
	<div class="HackBox"></div>
</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="20%">用户名</td>
	                <td width="20%">姓名</td>
	                <td width="10%">电话</td>
	                <td width="20%">邮箱</td>
	                <td width="10%">录入人</td>
	                <td width="20%">录入日期</td>
	            </tr>
            </thead>
        </table>
        
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/marketmanage/select_market.js"></script>
</body>
</html>

