<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>代理商查询</title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="tb mianbaoxue">首页 &gt;&gt; 系统配置 &gt;&gt; 代理商查询</div>
<div class="sousuox">
<dl>
	<dt>单位名称：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="name" name="name"  />
    </dd>
	<dt>所属市场人员：</dt>
	<dd>
		<select name="userId" id="userId" >
    			<option value="-1">--</option>
    				<#list list as user>
    					<option value="${user.userId}">${user.name}</option>
   					</#list>
    		   </select>
    </dd>
	<dt>联系人：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="relationName" name="relationName"  />
    </dd>
    <dt>电话：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="phone" name="phone"  />
    </dd>
</dl>
<dl>
    <dt>地域：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="region" name="region"  />
    </dd>
     <dt>录入时间：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="beginCreateTime" name="beginCreateTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"  />
	  </dd>
	   <dt>至：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="endCreateTime" name="endCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
	  		<input  class="tb baocunanniu color_bai" type="button" id="searchDiv" value="搜 索" />
	  </dd>
	</dl>
		<div class="HackBox"></div>
		</div>

        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	                <td width="10%">单位名称</td>
	                <td width="10%">市场人员</td>
	                <td width="10%">联系人</td>
	                <td width="10%">电话</td>
	                <td width="10%">邮箱</td>
	                <td width="10%">传真</td>
	                <td width="10%">区域</td>
	                <td width="10%">地址</td>
	             	<td width="10%">录入人</td>
	             	<td width="10%">录入日期</td>	
	            </tr>
            </thead>
        </table>    
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/agent/select_agent.js"></script>
</body>
</html>
