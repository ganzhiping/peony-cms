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
	    var comboList =new Object();
		<#list comboList as x>
			comboList['${x.id}'] = '${x.name}';
		</#list>
</script>

</head>
<body>
<div class="tb mianbaoxue">首页 &gt;&gt; 销售统计 &gt;&gt; 销售明细(移动免费版)</div>
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
	  <dt>套餐名称：</dt>
	<dd>
		<select name="comboId" id="comboId" style="width:100px">
    				<option value="-1">--</option>
    				<#list comboList as comboList>
    					<option value="${comboList.id}" <#if user?exists><#if user.comboId==comboList.id> selected = "selected"</#if></#if>>${comboList.name}</option>
   					</#list>
    		   </select>
    </dd>
 </dl>
 <dl>
  <dt>注册类型：</dt>
   	 <dd>
	  <select  name="type" id="type">
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
		<input class="input_text input_text3" type="text" id="loginName" name="loginName" <#if user?exists><#if user.loginName!=null> value="${user.loginName}"</#if></#if> />
    </dd>
    <dt>业务类型：</dt>
   	 <dd>
	  <select  name="category" id="category">
		  <option value="-1">--</option>
		  <option value="1">银行付款</option>
		  <option value="2">积分兑换</option>
		  <option value="3">退款</option>
		  <option value="4">退积分</option>
		  <!--<option value="3">扣手续费</option>-->
	  </select>
	  </dd>
	<dt>区域：</dt>
	<dd><select name="region_id" id="region_id" >
	    				<option value="-1">--</option>
	    </select></dd>
	
    <!--<dt>联系人：</dt>
	<dd>
		<input class="input_text input_text3" type="text" id="loginName" name="loginName"  />
    </dd>-->
    
	</dl>
	  
	<dl>
	  
	  <dt>购买日期：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="beginCreateTime" name="beginCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	   <dt>至：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="endCreateTime" name="endCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	
	  <dt>截止日期：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="beginExpiryTime" name="beginExpiryTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	   <dt>至：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="endExpiryTime" name="endExpiryTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			<input  class="tb baocunanniu color_bai" type="button" id="searchDiv" value="搜 索" />
	  </dd>
	</dl>
		<div class="HackBox"></div>
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	            <tr class="header_title">
	           		<td width="5%">购买日期</td>
	                <td width="10%">登录名称</td>
	                <td width="10%">注册类型</td>
	                <td width="5%">业务类型</td>
	                <td width="5%">套餐名称</td>
	                <td width="10%">购买天数</td>
	                <td width="5%">服务截止日</td>
	                <td width="5%">金额/积分（元）</td>
	            </tr>
            </thead>
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/salesSubsidiary/salesSubsidiary.js"></script>
</body>
</html>

