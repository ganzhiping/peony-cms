<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站信息</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">

</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 信息管理 &gt;&gt; 网站信息管理</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>

<div class="sousuox">
  <dl>
  <dt>网站名称：</dt><dd><input class="input_text input_text3" type="text" id="name" name="name"  /></dd>
  <dt>媒体类型：</dt>
  <dd>
  <select class="input_text input_text3" name="mediaType" id="mediaType">
 	<option value="-1">--</option>
	<option value="1">新闻</option>
	<option value="2">论坛</option>
	<option value="3">微博</option>
	<option value="4">博客</option>
	<option value="5">报纸</option>
	<option value="6">twtter</option>
</select>
</dd>
<dd><div class="tb baocunanniu_sosuo color_bai"  id="searchDiv"> 搜 索</div></dd></dl>
<div class="HackBox"></div>
</div>

<input type="button" id="create" class="tb baocunanniu color_bai" onClick="toAdd();" value="添加"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="10%">网站名称</td>
	                <td width="10%">媒体类型</td>
	                <td width="15%">网址</td>
	                <td width="15%">ip</td>
	                <td width="15%">公司名称</td>
	                <td width="10%">公司性质</td>
	                <td width="15%">备案信息</td>
	                <td width="10%">操作</td>
	            </tr>
            </thead>
        </table>
        
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/website/website.js"></script>
</body>
</html>

