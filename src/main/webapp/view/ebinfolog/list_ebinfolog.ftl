<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息日志</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 日志管理 &gt;&gt; 信息日志</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
<dl>
  <dt>日期：</dt>
  <dd>
  <input class="input_text input_text3" type="text" id="beginTime" name="beginTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  />  
  </dd>
  <dt>至：</dt>
  <dd>
   <input class="input_text input_text3" type="text" id="endTime" name="endTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
  </dd>
<dt>网站来源：</dt>
  <dd>
  <select class="input_text input_text3" name="type" id="type">
 	<option value="">--</option>
	<option value="1">新闻</option>
	<option value="2">论坛</option>
	<option value="3">微博</option>
	<option value="4">博客</option>
	<option value="5">报刊</option>
	<option value="6">境外</option>
	<option value="7">微信</option>
  </select>
  </dd>
<dt>排序条件：</dt>
  <dd>
  <select class="input_text input_text3" name="sortCondition" id="sortCondition">
  	<option value="">--</option>
	<option value="1">点击人次</option>
	<option value="2">转发人次</option>
	<option value="3">收藏人次</option>
  </select>
  </dd>
</dl>
<dl>
<dt>模块：</dt>
  <dd>
  <select class="input_text input_text3" name="module" id="module">
 	<option value="">--</option>
  	<option value ="1">热点网评</option>
  	<option value ="2">热点新闻</option>
  	<option value ="3">政务动态</option>
  	<option value ="4">地域舆情</option>
  	<option value ="5">事件专题</option>
  	<option value ="6">定制舆情</option>
  	<option value ="7">舆情预警</option>
  </select>
  </dd>

<dd><div style="position: relative;	left:120px;" class="tb baocunanniu_sosuo color_bai"  id="searchDiv"> 搜 索</div></dd>
</dl>
<div class="HackBox"></div>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" style="word-wrap:break-word; word-break:break-all;" >
			<thead>
	            <tr class="header_title">
	                <td width="10%">点击人次</td>
	                <td width="10%">转发人数</td>
	                <td width="10%">收藏人数</td>
	                <td width="10%">模块</td>
	                <td width="10%">网站来源</td>
	                <td width="10%">网站名称</td>
	                <td width="8%">发布时间</td>
	                <td width="16%">标题</td>
	                <td width="16%">地址</td>
	            </tr>
            </thead>
        </table>
        
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/ebinfolog/ebinfolog.js"></script>	
</body>
</html>

