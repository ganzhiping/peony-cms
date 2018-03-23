<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/customer/customer_edit.js"></script>
<script>


$(function(){
var pageContext = $("#pageContext").val();
		var parentCode = "";
	var userType=$("#userType").val();
	if(userType==2){
		// 后台数据库写死
							parentCode = 41
		var area_text='所在区域 ： <a href="#" onClick="selectRegion();" >修改</a>';
			    $("#area").append(area_text);
		 		$.ajax({
				    type: "GET",
				    async:false,
				    url: pageContext+"/customer/baseclassList/"+parentCode,
			    	success: function(data){
				    	var text='部门：<select name="baseclassId" id="dept"></select>';
				    	$("#dept_span").append(text);
				    	var select=$("#dept");
			    	
			    		var basid=$("#baseclassid").val();
			    		for (var i = 0; i < data.length; i++) {
	                		var baseclass = data[i];
	                		if(basid==baseclass.baseclassId){
	                			select.append("<option selected value="+baseclass.baseclassId+">"+baseclass.name+"</option>");
	                		}else{
	                			select.append("<option  value="+baseclass.baseclassId+">"+baseclass.name+"</option>");
	                		}
                		}
			    	 }
					});
	
	
	}else{
	
							// 后台数据库写死
							if (userType == 1) {
								parentCode = 243;
							} else if (userType == 3) {
								parentCode = 150;
							} else if (userType == 4) {
								parentCode = 152;
							}
							$
									.ajax({
										type : "GET",
										async : false,
										url : pageContext
												+ "/customer/baseclassList/"
												+ parentCode,
										success : function(data) {
											var text = '行业：<select name="baseclassId" id="dept"></select>';
											$("#dept_span").append(text);
											var select = $("#dept");

			    		                    var basid=$("#baseclassid").val();
											for ( var i = 0; i < data.length; i++) {
												var baseclass = data[i];
											
												if(basid==baseclass.baseclassId){
	                			                select.append("<option selected value="+baseclass.baseclassId+">"+baseclass.name+"</option>");
	                		
	                		}else{
	                			select.append("<option  value="+baseclass.baseclassId+">"+baseclass.name+"</option>");
	                		
	                		}
											}
										}
									});

						
	}
	
	//获取选择的代理商
	var userSource='${user.userSource}';
	
	if(userSource==1){
	
				var userId=$("#belongId").val();
		 		$.ajax({
			    type: "GET",
			    async:false,
			    url: pageContext+"/customer/agentList",
			    data: {
			    	userId:userId
			    },
			    success: function(data){
			    	
			    	var text='选择代理商<select name="agentId" id="agentId" style="width:100px"></select>'
			    	$("#agent_span").append(text);
			    	var select=$("#agentId");
			    	for (var i = 0; i < data.length; i++) {
	                		var agent = data[i];
	                		if(agent.agentId=='${user.agentId}'){
	                			select.append("<option selected value="+agent.agentId+">"+agent.name+"</option>");
	                		}else{
	                			select.append("<option  value="+agent.agentId+">"+agent.name+"</option>");
	                		}
                		}
                		
                var use_agent_logo='${user.useAgentLogo}';
                var agentLog;
                if(use_agent_logo==1){
                	agentLog='&nbsp;&nbsp;使用代理商logo:<input type="radio" name="useAgentLogo" value="1"  checked />是  <input type="radio" name="useAgentLogo" value="0" />否 ';
                }else{
                	agentLog='&nbsp;&nbsp;使用代理商logo:<input type="radio" name="useAgentLogo" value="1" />是  <input type="radio" name="useAgentLogo" value="0"  checked />否 ';
                }
                $("#agent_span").append(agentLog);
                
			    }
			});
	}
})
</script>


</head>
 <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
	<div class="xtpz_yhgl_addyh ">
    <div class="tneirong_2">
      <div class="tneirong_2_in">
      <input type="hidden" id="baseclassid" value="${baseClass.baseclassId}" /><!--此项只作为判断字段 -->
      <input type="hidden" id="currentLoginName" value="${user.loginName}" /><!--此项只作为修改用户名时判断字段 -->
      <form  id="userForm">
        <div class="table_tanchu">
          <input type="hidden" name="userId" value="${user.userId}" />
          <input type="hidden" name="regionId" id="regionId" value="${region.regionid}" /><!-- 选择的地域id-->
          <input type="hidden" name="personType" value="2" /><!-- 标识客户-->
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>登录名称：</th>
              <td><input class="input_text input_text_small" type="text"  name="loginName" value="${user.loginName}"  id="loginName" readOnly/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>系统显示名称：</th>
              <td><input class="input_text input_text_small" type="text" name="name" value="${user.name}" id="name"   datatype="*" nullmsg="请填写姓名" /></td>
            </tr>
            <tr>
              <th>客户姓名：</th>
              <td><input class="input_text input_text_small" type="text" name="realName" value="${user.realName}" id="realName"    /></td>
            </tr>
              <tr>
              <th>联系人姓名：</th>
              <td><input class="input_text input_text_small" type="text" name="contactName" value="${user.contactName}" id="contactName"    /></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>密码：</th>
              <td><input class="input_text input_text_small"  type="password" name="password" value="${user.password}" id="password"   datatype="*" nullmsg="请填写密码" />(默认mdyq)</td>
            </tr>
            <tr>
              <th><span class="F00">*</span>确认密码：</th>
              <td><input class="input_text input_text_small" type="password" name="confirmpassword" value="${user.password}" id="confirmpassword"   datatype="*" nullmsg="请重复填写密码" recheck="password" errormsg="您两次输入的密码不一致！" /></td>
            </tr>
            <tr>
              <th>单位名称：</th>
              <td><input class="input_text" type="text" name="company" value="${user.company}" id="company" /></td>
            </tr>
             <tr>
              <th><span class="F00">*</span>邮箱：</th>
              <td><input class="input_text input_text_small" type="text" name="email" value="${user.email}" id="email" datatype="e"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>手 机 号：</th>
              <td><input class="input_text input_text_small" type="text" name="mobile" value="${user.mobile}" datatype="m"/></td>
            </tr>
            <tr>
              <th valign="top"> qq号：</th>
              <td><input class="input_text input_text_small" type="text"   name="qq" value="${user.qq}"/></td>
            </tr>
            <tr>
              <th>所属市场人员：</th>
              <td><select name="belongId" id="belongId" datatype="n" >
    			<option value="">-- --</option>
    				<#list userList as market>
    					<option value="${market.userId}"   <#if market.userId==user.belongId>selected</#if> >${market.name}</option>
   					</#list>
    		   </select>
			 </td>
            </tr>
            <tr>
              <th>客户范围：</th>
              <td ><select name="userType" id="userType">
              		<option value="1"   <#if user.userType==1>selected</#if>>企业</option>
    				<option value="2" <#if user.userType==2>selected</#if>>政府</option>
    				<option value="3" <#if user.userType==3>selected</#if>>国资</option>
    				<option value="4" <#if user.userType==4>selected</#if>>文化</option>
    			</select>
    			<span id="dept_span">
    			<!--部门 -->
              </span>
              <span id="area"><!--所在区域 --></span>
              <span id="areaName">${region.regionname}<!--所在区域名称 --></span>
            </tr>
            <tr>
              <th>客户类型：</th>
              <td>
	              <div class="yonhu_js_xz">
		              <span><input type="radio"  checked name="userSource" id="commonUser" value="0" <#if user.userSource==0>checked</#if>/> 直销用户</span>
		              <span><input type="radio"  name="userSource" id="agentUser" value="1" <#if user.userSource==1>checked</#if>/>代理商用户</span>   <span id="agent_span"></span>
	             </div>
	         </td>
            </tr>
             <tr>
              <th>客户样式：</th>
              <td ><select name="userStyle" id="userStyle">
              		<option value="1" <#if user.userStyle==1>selected</#if>>红色</option>
    				<option value="2" <#if user.userStyle==2>selected</#if>>蓝色</option>
    				<option value="3" <#if user.userStyle==3>selected</#if>>绿色</option>
    			</select>
	         </td>
            </tr>
            <tr>
              <th valign="top"> 备注：</th>
              <td colspan="3"><textarea class="input_text2 input_text_r" name="note" id="textarea" cols="45" rows="5">${user.note}</textarea></td>
            </tr>
            <tr>
              <th >&nbsp;</th>
              <td ></td>
            </tr>
          </table>
        </div>
        <div class="aniu_xinxi_fab">
            <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
            <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
       </div>
      </form>
      </div>
    </div>
  </div>
