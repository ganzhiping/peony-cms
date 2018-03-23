<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/my97date/WdatePicker.js"></script>
<script src="${request.getContextPath()}/js/userservice/userservice.js"></script>

</head>
<body class="baody">
<div class="bianji_tbale">
<form id="usereditform">
<input type="hidden" id="pageContext" value="${request.getContextPath()}">
<input type="hidden" name="userserviceId" value="${userService.userserviceId}"/>
<input type="hidden" name="userId" value="${userId}"/>
<table border="0" cellspacing="0" cellpadding="0">
	<#if user.userType==1>
	  <tr>
	    <th>关键词个数：</th>
	    <td>
	    <input type="text"  name="keywsNumber" value="${userService.keywsNumber?default('30')}"  datatype="n" /><span>企业用户默认最大值为：30</span>
	    </td>
	  </tr>
	<#else>
	  <tr>
	    <th>关键词个数：</th>
	    <td>
	    <input type="text"  name="keywsNumber" value="${userService.keywsNumber?default('100')}"  datatype="n" /> <span>政府用户默认值最大值为：100</span>
	    </td>
	  </tr>
  </#if>
   <tr>
	    <th>预警关键词个数：</th>
	    <td><input type="text"  name="warnKeywsNumber" value="${userService.warnKeywsNumber?default('50')}"  datatype="n" /><span>默认值最大值为：50</span>
	    </td>
	  </tr>
  <tr>
    <th>邮箱个数：</th>
    <td><input type="text"  name="emailNumber" value="${userService.emailNumber?default('10')}"   datatype="n" />
     </td>
  </tr>
  <!--<tr>
    <th>接收短信手机个数：</th>
    <td><input type="text" class="input_text" name="phoneNumber" value="${userService.phoneNumber}"  datatype="n" /></td>
  </tr>-->
  <tr>
    <th>允许登录手机个数：</th>
    <td><input type="text" name="mobileNumber" value="${userService.mobileNumber?default('2')}"  datatype="n" /><span>默认值最大为：2</span>
    </td>
  </tr>
 <!-- <tr>
    <th>日报生成时间：</th>
    <td><input type="text" name="reportTime" value="${userService.reportTime}"  /></td>
  </tr>-->
  <tr>
    <th>预警重复时间<br>（单位/小时）：</th>
    <td><input type="text" name="warnReTime" value="${userService.warnReTime?default('3')}"/></td>
  </tr>
  <tr>
    <th>截止日期：</th>
    <td>
      <input type="text" name="deadline" id="deadline" value="${userService.deadline}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  /> </td>
  </tr>
   <tr>
    <th>用户类型：</th>
    <td>
	    <#if userService.platformType?if_exists>
	        <input type="radio" name="platformType" value="1"  checked  />正式  <input type="radio" name="platformType" value="2" <#if  userService.platformType=='2'> checked</#if> />试用  <input type="radio" name="platformType" value="3" <#if  userService.platformType=='3'> checked</#if> />演示
	    <#else>
	        <input type="radio" name="platformType" value="1" />正式  <input type="radio" name="platformType" value="2"  checked/>试用  <input type="radio" name="platformType" value="3"  />演示
	    </#if>
    </td>
  </tr>
  <tr>
    <th>用户服务：</th>
    <td>
	    <#if userService.status?if_exists>
	        <input type="radio" name="status" value="1"  checked  />有效  <input type="radio" name="status" value="3" <#if  userService.status=='3'> checked</#if> />无效
	    <#else>
	        <input type="radio" name="status" value="1"/>有效<input type="radio" name="status" value="3"/>无效
	    </#if>
    </td>
  </tr>
  <tr>
  <th>生成日报：</th>
  <td>
    <#if userService.reportCreate?if_exists>
        <input type="radio" name="reportCreate" value="1"  checked  />是 <input type="radio" name="reportCreate" value="0" <#if  userService.reportCreate=='0'> checked</#if> />否
    </#if>
 </td>
  </tr>
  <tr>
  <th>发送日报邮件：</th>
  <td>
    <#if userService.reportSend?if_exists>
        <input type="radio" name="reportSend" value="1"  checked  />是 <input type="radio" name="reportSend" value="0" <#if  userService.reportSend=='0'> checked</#if> />否
    </#if>
 </td>
  </tr>
 <tr>
  <th>发送预警：</th>
  <td>
    <#if userService.warningSend?if_exists>
        <input type="radio" name="warningSend" value="1"  checked  />是 <input type="radio" name="warningSend" value="0" <#if  userService.warningSend=='0'> checked</#if> />否
    </#if>
 </td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td><input  class="tb baocunanniu color_bai" type="button" id="subBtn" value="保存" /></td>
  </tr>
</table>
</form>
</div>
</body>
</html>