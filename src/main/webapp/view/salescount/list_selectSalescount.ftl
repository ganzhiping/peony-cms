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
<div class="tb mianbaoxue">首页 &gt;&gt; 销售统计 &gt;&gt; 销售统计(移动免费版)</div>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="sousuox">
<dl>
  
	  <dt>日期：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="beginTime" name="beginCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	   <dt>至：</dt>
	  <dd>
			<input class="input_text input_text3" type="text" id="endTime" name="endCreateTime"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
	  </dd>
	<!--<dt>付款类型：</dt>
	
	<dd>
	<select name="userSource" id="userSource" >
		<option value="-1">--</option>
	    <option value="0">银行付款</option>
	    <option value="1">积分付款</option>
    </select>
	</dd>
	-->
 </dl>
 <dl>
  <dt>销售类型：</dt>
   	 <dd>
	  <select  name="userSource" id="userSource">
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
    <dd><input  class="tb baocunanniu color_bai" type="button" id="searchDiv" value="搜 索" /></dd>
	</dl>
		<div class="HackBox"></div>
		</div>
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="display lis_tablet4"  >
		 <tr class="header_title">
	           		<td  width="16%"></td>
	                <td width="28%" colspan="2" >银行付款</td>
	                <td width="28%" colspan="2" >积分兑换</td>
	                
	            </tr>
		</table>
		<table width="100%" border="1" cellspacing="0" cellpadding="0" class="display lis_tablet4"  id="list_info" >
			<thead>
	           
	            <tr class="header_title">
	            	<td  width="16%">套餐名称</td>
	            	<td width="14%">购买比数</td>
	            	<td width="14%">金额</td>
	            	<td width="14%">购买比数</td>
	            	<td width="14%">积分</td>
	            	
	            </tr>
           </thead>
           
        </table>
		<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
		<script src="${request.getContextPath()}/js/datatable/jquery.dataTables.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
		<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
		<script src="${request.getContextPath()}/js/salesCount/salesCount.js"></script>
</body>
</html>

