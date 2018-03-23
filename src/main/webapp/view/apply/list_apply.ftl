<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试用申请</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>

<div class="tb mianbaoxue">首页 &gt;&gt; 个人中心 &gt;&gt; 站内消息</div>

<input type="hidden" id="status" name="status" value=""/>
<div class="sousuox shenqingsouxs">
<div class="fudong on_left color_bai">
<span class="tb aniniu_1"><a href="#" onClick="change(2);">未查看</a></span><span class="tb aniniu_3"><a href="#" onClick="change(1);">已查看</a></span></div>
<div class="on_right color_bai" >
<span class="tb aniniu2_1" id="isread">已 阅</span>
<span class="tb aniniu2_4" id="delete">删 除</span>
</div><div class="on_right">
<dl>
<dd class="souuoxd"><input class="input_text input_text5" type="text" name="name" id="name" /></dd><dd><div class="tb baocunanniu_sosuo color_bai" id="search">搜 索</div></dd></dl>

<div class="HackBox"></div>
</div></div>




 	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="1%"><input type="checkbox" id="chk_all" onclick="checkAll(this);"></td>
	                <td width="10%">姓名</td>
	                <td width="15%">邮箱</td>
	                <td width="15%">qq</td>
	                <td width="20%">手机</td>
	                <td width="10%">单位</td>
	                <td width="10%">座机</td>
	                <td width="25%">申请时间</td>
	            </tr>
            </thead>
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/apply/apply.js"></script>
</body>
</html>