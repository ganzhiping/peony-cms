<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>折扣管理</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">

</head>
<body style="background:#FFFFFF">
<div class="tb mianbaoxue">首页 &gt;&gt; E人E本 &gt;&gt; 折扣管理</div>
<div class="sousuox">
<dl>
<dd><div id="create" class="tb baocunanniu color_bai">添加</div></dd>
<dt>套餐名：</dt>
<dd>
<select name="comboid" id="comboid" >
	<option value="0" selected='selected'>全部</option>
	<#list comboList as combo>
    	<option value="${combo.id}">${combo.name}</option>
   	</#list>
</select>
</dd>

</dl>

</div>

<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_discount" >
			<thead>
	            <tr class="header_title">
	                <td >套餐名称</td>
	                <td >开始天数</td>
	                <td >结束天数</td>
	                <td >折扣</td>
	                <td >录入时间</td>
	                 <td >操作</td>
	            </tr>
            </thead>
            
        </table>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/datatable/jquery.dataTables.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/discount/discount.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
</body>
</html>
        