<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>销售明细(移动免费版)</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<script  type="text/javascript">
		//var userList =new Object();
		//<#list list as x>
		//	userList['${x.userId}'] = '${x.name}';
		//</#list>
	    //var comboList =new Object();
		//<#list comboList as x>
		//	comboList['${x.id}'] = '${x.name}';
		//</#list>
</script>

</head>
<body>
<div class="tb mianbaoxue">首页 &gt;&gt; 销售统计 &gt;&gt; 积分明细(移动免费版)</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
<dl>
	<dt>销售类型：</dt>
	<dd>
	<select name="userSource" id="userSource" >
		<option value="-1">--</option>
	    <option value="0">直销</option>
	    <option value="1">代理商</option>
    </select>
	</dd>
	
	<dt>所属代理商：</dt>
	<dd>
		<select name="agentId" id="agentId" style="width:100px">
    				<option value="-1">--</option>
    				<#list listAgent as agent>
    					<option value="${agent.agentId}">${agent.name}</option>
   					</#list>
    		   </select>
    </dd>
    <dt>客户类型：</dt>
   	 <dd>
	  <select  name="platformType" id="platformType">
		  <option value="-1">--</option>
		  <option value="1">正式</option>
		  <option value="2">试用</option>
		  <option value="3">未注册</option>
	  </select>
	  </dd>
	  <dt>积分来源：</dt>
	<dd>
		 <select  name="type" id="type">
		  <option value="-1">--</option>
		  <option value="0">增加</option>
		  <option value="1">消费</option>
	  </select>
    </dd>
 </dl>
 <dl>
  <dt>注册类型：</dt>
   	 <dd>
	  <select  name="typestatus" id="typestatus">
		  <option value="-1">--</option>
		  <option value="1">QQ</option>
		  <option value="2">微博</option>
		  <option value="3">微信</option>
		  <option value="4">qq空间</option>
		  <option value="5">手机</option>
	  </select>
	  </dd>
	  <dt>登录名称：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="loginName" name="loginName"  />
    </dd>
    
	 <dt>日期：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="beginCreateTime" name="beginCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	   <dt>至：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="endCreateTime" name="endCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			
	  </dd>
	  <input  class="tb baocunanniu color_bai" type="button" id="searchDiv" value="搜 索" />
   
    
	</dl>
	
		<div class="HackBox"></div>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	           		<td >日期</td>
	                <td >登录名称</td>
	                <td >注册类型</td>
	                <td >积分类型</td>
	                <td >获得积分</td>
	            </tr>
            </thead>
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/pointschange/pointschange.js"></script>
</body>
</html>

