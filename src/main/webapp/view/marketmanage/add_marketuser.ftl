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
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/marketmanage/marketuser_add.js"></script>


</head>
<div class="xtpz_yhgl_addyh ">
 <div class="tneirong_2">
      <div class="tneirong_2_in">
        <div class="table_tanchu">
	      <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
		  <form  id="userForm">
		  <input type="hidden" name="personType" value="1" />
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>用户名 ：</th>
              <td colspan="3"><input class="input_text" style="position: relative;bottom:20px;" type="text" name="loginName" value=""  id="loginName" class="cword gray" datatype="*" nullmsg="请填写用户名"/><span id="fieldErr_loginName"></span> </td>
            </tr>
            <tr>
              <th><span class="F00">*</span>姓名：</th>
              <td><input class="input_text input_text_small" style="position: relative;top:-20px;" type="text" name="name" value="" id="name"  class="cword gray" datatype="*" nullmsg="请填写姓名"/><span id="fieldErr_userName"></span></td>
              <th>性别：</th>
              <td><input type="radio"  checked name="sex" value="男" /> 男<input type="radio"  name="sex" value="女" />女</td>
            </tr>
            <tr>
              <th><span class="F00">*</span>密码：(默认mdyq)</th>
              <td><input type="password" name="password" value="mdyq" id="password"  class="cword gray" datatype="*" nullmsg="请填写密码"/><span id="fieldErr_password"></span></td>
              <th><span class="F00">*</span>确认密码：</th>
              <td><input type="password" style="position: relative;top:-20px;" name="confirmpassword" value="mdyq" id="confirmpassword"  class="input_text input_text_small" datatype="*" nullmsg="请重复填写密码" recheck="password" errormsg="您两次输入的密码不一致！"/><span id="fieldErr_confirmpwd"></span></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>邮箱：</th>
              <td colspan="3"><input class="input_text input_mail" type="text" name="email" value="" id="email"  datatype="e"/></td>
            </tr>
              <tr>
              <th>qq：</th>
              <td colspan="3"><input class="input_text input_mail" type="text"   name="qq" value="" /></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>手机：</th>
              <td><input class="input_text input_text_small" type="text" name="mobile" value="" datatype="m"/></td>
            </tr>
            <tr>
              <th valign="top"> 备注：</th>
              <td colspan="3"><textarea class="input_text2 input_text_r" name="note" id="textarea" cols="45" rows="5"></textarea></td>
            </tr>
           
            <tr>
              <th >&nbsp;</th>
              <td colspan="3" ><div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
                </div></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
    </div>
