<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>操作日志</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 日志管理 &gt;&gt; 操作日志</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
  <dl>
  <dt>操 作 人：</dt>
  <dd>
<select class="input_text input_text3" name="userId" id="userId">
	<option value="">--</option>
	<#list userList as user>
  	<option value ="${user.userId}">${user.name}</option>
  	</#list>
</select></dd>
<dt>操作类型：</dt>
  <dd>
  <select class="input_text input_text3" name="type" id="type">
    <option value="">--</option>
	<option value="1">登录</option>
	<option value="2">操作</option>
</select>
</dd><dt>登录方式：</dt>
  <dd>
  <select class="input_text input_text3" name="loginType" id="loginType">
 	<option value="">--</option>
	<option value="1">PC</option>
	<option value="2">手机</option>
</select>
</dd>
<dd><div class="tb baocunanniu_sosuo color_bai"  id="searchDiv"> 搜 索</div></dd></dl>
<div class="HackBox"></div>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="15%">时间</td>
	                <td width="15%">操作人</td>
	                <td width="10%">操作类型</td>
	                <td width="10%">登录方式</td>
	                <td width="50%">内容</td>
	            </tr>
            </thead>
        </table>
        
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/operationlog/operationlog.js"></script>
</body>
</html>

