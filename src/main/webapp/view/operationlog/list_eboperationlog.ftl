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
<div class="tb mianbaoxue">首页 &gt;&gt; 日志管理 &gt;&gt; e本操作日志</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
  <dl>
  <dt>销售类型：</dt>
  <dd>
	<select class="input_text input_text3" name="userSource" id="userSource">
		<option value="">--</option>
	  	<option value ="1">代理商客户</option>
	  	<option value ="0">直销客户</option>
	</select></dd>
<dt>代理商：</dt>
  <dd>
  <select class="input_text input_text3" name="agentId" id="agentId">
    <option value="">--</option>
	<#list agentList as agent>
  		<option value ="${agent.agentId}">${agent.name}</option>
 </#list>
</select>
</dd>
<dt>用户类型：</dt>
  <dd>
  <select class="input_text input_text3" name="platformType" id="platformType">
 	<option value="">--</option>
	<option value="1">正式用户</option>
	<option value="2">注册用户</option>
	<option value="3">未注册用户</option>
</select>
</dd>
<dt>客户状态：</dt>
  <dd>
  <select class="input_text input_text3" name="userStatus" id="userStatus">
 	<option value="">--</option>
	<option value="1">有效</option>
	<option value="2">无效</option>
</select>
</dd>
</dl>
<dl>
<dt>注册类型：</dt>
  <dd>
  <select class="input_text input_text3" name="loginType" id="loginType">
 	<option value="">--</option>
	<option value="1">QQ</option>
	<option value="2">微博</option>
	<option value="3">微信</option>
	<option value="4">qq空间</option>
	<option value="5">手机</option>
</select>
</dd>
<dt>用 户 名：</dt><dd><input class="input_text input_text3" type="text" name="name" id="name" /></dd>
<dl>
<dt>日期时间：</dt>
<dd class="dd_sx"><input class="input_text input_text4" type="text" name="startTime" id="startTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>

<input class="input_text input_text4" type="text" name="endTime" id="endTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></dd>
</dl>
<dl>
<dt>日志类型：</dt>
  <dd>
  <select class="input_text input_text3" name="type" id="type">
 	<option value="">--</option>
	<option value="1">登录</option>
	<option value="2">操作</option>
</select>
</dd>

<dt>模块：</dt>
  <dd>
  <select class="input_text input_text3" name="operateModule" id="operateModule">
 	<option value="">--</option>
 	<option value="1">首页</option>
	<option value="2">热点时评</option>
	<option value="3">热点新闻</option>
	<option value="4">政务动态</option>
	<option value="5">地域舆情</option>
	<option value="6">定制舆情</option>
	<option value="7">事件专题</option>
	<option value="8">舆情预警</option>
	<option value="9">个人中心</option>
</select>
</dd>
</dl>
<dl>
	<dd><div class="tb baocunanniu_sosuo color_bai"  id="searchDiv"> 搜 索</div></dd>
	<dd><div class="tb baocunanniu_sosuo color_bai"  id="export"> 导出</div></dd>
</dl>
<div class="HackBox"></div>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="5%"><input type="checkbox" id="chk_all" onclick="checkAll(this);"></td>
	                <td width="15%">日期</td>
	                <td width="10%">用户名</td>
	                <td width="10%">注册类型</td>
	                <td width="10%">日志类型</td>
	                <td width="10%">模块</td>
	                <td width="40%">操作</td>
	            </tr>
            </thead>
        </table>
        
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/operationlog/eb_operationlog.js"></script>
</body>
</html>

