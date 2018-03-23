<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息管理</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>

<div class="tb mianbaoxue">首页 &gt;&gt; 信息管理 &gt;&gt; 用户信息管理</div>
<div class="sousuox">
<dl>
<dt>用 户 名：</dt><dd><!--<input class="input_text input_text3" type="text" name="userName" id="userName" />-->
<select name="userIds" id="userId">
	<#list userList as user>
    	<option value="${user.userId}">${user.name}</option>
   	</#list>
</select>

</dd><dt>标 题：</dt><dd><input class="input_text input_text5" type="text" name="title" id="title" /></dd><dd><div class="tb baocunanniu_sosuo color_bai" id="searchDiv">搜 索</div></dd><span class="tb aniniu_1"><a href="#" onClick="sendWarning();">发送</a></span></dl>

<div class="HackBox"></div>
</div>
<div class="top_ananiu top_ananiu_br">
<div class="on_left color_bai"><span class="tb aniniu_1"><a href="#" onClick="change(1);">正 面</a></span><span class="tb aniniu_2"><a href="#" onClick="change(-1);">负 面</a></span><span class="tb aniniu_3"><a href="#" onClick="change(0);">中 性</a></span></div>
<div class="on_right color_bai" ><span class="tb aniniu2_1" onClick="updateState(1);">正 面</span><span class="tb aniniu2_2" onClick="updateState(-1);">负 面</span><span class="tb aniniu2_3" onClick="updateState(0);">中 性</span><span class="tb aniniu2_4" id="delete">删 除</span></div>
</div>
<input type="hidden" name="polarity" id="polarity" value=""/>
 	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr>
	                <td width="5%"><input type="checkbox" id="chk_all" onclick="checkAll(this);"></td>
	                <td>标题</td>
	                <td width="15%">时间</td>
	            </tr>
            </thead>
     </table>
     
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/subjectpage/subjectpage.js"></script>

</body>
</html>
