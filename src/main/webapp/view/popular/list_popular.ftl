
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
</head>
<body style="background:#FFFFFF">
<div class="sousuox">
<dl>
<dt>标题：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="title" name="title"  />
    </dd>
	<dd><div class="tb baocunanniu_sosuo color_bai" id="searchDiv">搜 索</div></dd>
	
	<dt></dt>
	<dd>
    	<div class="tb baocunanniu color_bai" id="add">添 加</div>
	</dd>
</dl>
</div>
  
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<input type="hidden" id="channelId" value="${channelId}"/>
 	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="45%">标题</td>
	                <td width="10%">作者</td>
	                <td width="15%">上传时间</td>
	                <td width="10%">期数</td>
					<td width="10%">用户</td>
	                <td width="20%">操作</td>
	            </tr>
            </thead>
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/pubinfo/channel.js"></script>		
		<script src="${request.getContextPath()}/js/popular/popular.js"></script>
		

</body>
</html>
