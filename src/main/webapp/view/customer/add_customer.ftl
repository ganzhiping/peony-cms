<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>

<script>
$(function(){
var pageContext = $("#pageContext").val();
		var parentCode = 243;
						
							$.ajax({
										type : "GET",
										async : false,
										url : pageContext
												+ "/customer/baseclassList/"
												+ parentCode,
										success : function(data) {
											var text = '行业：<select name="baseclassId" id="dept"></select>';
											$("#dept_span").append(text);
											var select = $("#dept");

											for ( var i = 0; i < data.length; i++) {
												var baseclass = data[i];
											
	                			                select.append("<option  value="+baseclass.baseclassId+">"+baseclass.name+"</option>");
	                	
											}
										}
									});

	})
</script>
	
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/customer/customer_add.js"></script>
</head>
 <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
	<div class="xtpz_yhgl_addyh ">
    <div class="tneirong_2">
      <div class="tneirong_2_in">
      <form  id="userForm">
        <div class="table_tanchu">
          <input type="hidden" name="regionId" id="regionId" value="" /><!-- 选择的地域id-->
          <input type="hidden" name="personType" value="2" /><!-- 标识客户-->
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>登录名称：</th>
              <td><input class="input_text input_text_small" type="text"  name="loginName" value=""  id="loginName" datatype="*" nullmsg="请填写登录名称"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>系统显示名称：</th>
              <td><input class="input_text input_text_small" type="text" name="name" value="" id="name"   datatype="*" nullmsg="请填写系统显示名称" /></td>
            </tr>
              <tr>
              <th>客户姓名：</th>
              <td><input class="input_text input_text_small" type="text" name="realName" value="" id="realName"   /></td>
            </tr>
              <tr>
              <th>联系人姓名：</th>
              <td><input class="input_text input_text_small" type="text" name="contactName" value="" id="contactName"   /></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>密码：</th>
              <td><input class="input_text input_text_small"  type="password" name="password" value="mdyq" id="password"   datatype="*" nullmsg="请填写密码" />(默认mdyq)</td>
            </tr>
            <tr>
              <th><span class="F00">*</span>确认密码：</th>
              <td><input class="input_text input_text_small" type="password" name="confirmpassword" value="mdyq" id="confirmpassword"   datatype="*" nullmsg="请重复填写密码" recheck="password" errormsg="您两次输入的密码不一致！" /></td>
            </tr>
            <tr>
              <th>单位名称：</th>
              <td><input class="input_text" type="text" name="company" value="" id="company" /></td>
            </tr>
             <tr>
              <th><span class="F00">*</span>邮箱：</th>
              <td><input class="input_text input_text_small" type="text" name="email" value="" id="email"  datatype="e" /></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>手 机 号：</th>
              <td><input class="input_text input_text_small" type="text" name="mobile" value="" datatype="m" nullmsg="手机号格式不正确"/></td>
            </tr>
            <tr>
              <th valign="top"> qq号：</th>
              <td><input class="input_text input_text_small" type="text"   name="qq" value=""/></td>
            </tr>
            <tr>
              <th>所属市场人员：</th>
              <td><select name="belongId" id="belongId" datatype="n" >
    			<option value="">-- --</option>
    				<#list userList as user>
    					<option value="${user.userId}">${user.name}</option>
   					</#list>
    		   </select>
			 </td>
            </tr>
            <tr>
              <th>客户范围：</th>
              <td ><select name="userType" id="userType">
              		<option value="1">企业</option>
    				<option value="2">政府</option>
    				<option value="3">国资</option>
    				<option value="4">文化</option>
    			</select>
    			<span id="dept_span">
    			<!--部门 -->
              </span>
              <span id="area"><!--所在区域 --></span>
              <span id="areaName"><!--所在区域名称 --></span>
            </tr>
            <tr>
              <th>客户类型：</th>
              <td>
	              <div class="yonhu_js_xz">
		              <span><input type="radio"  checked name="userSource" id="commonUser" value="0" /> 直销用户</span>
		              <span><input type="radio"  name="userSource" id="agentUser" value="1" />代理商用户</span>   <span id="agent_span"></span>
	             </div>
	         </td>
            </tr>
             <tr>
              <th>客户样式：</th>
              <td ><select name="userStyle" id="userStyle">
              		<option value="1">红色</option>
    				<option value="2">蓝色</option>
    				<option value="3">绿色</option>
    			</select>
	         </td>
            </tr>
            <tr>
              <th valign="top"> 备注：</th>
              <td colspan="3"><textarea class="input_text2 input_text_r" name="note" id="textarea" cols="45" rows="5"></textarea></td>
            </tr>
          </table>
        </div>
        <div class="aniu_xinxi_fab">
            <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
            <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
       </div>
       </div>
        </div>
      </form>
      
   
  </div>
