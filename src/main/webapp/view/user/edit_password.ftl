<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">


<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/user/edit_password.js"></script>
</head>
<body class="baody">
<div class="tb mianbaoxue">首页 >> 个人中心 >> 修改密码</div>
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form id="editForm">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>用户名:</th>
    <td>
    <input class="input_text" type="text" name="loginName" value="${user.loginName}" disabled="true" id="textfield" /><span id="fieldErr_seq"></span></td>
  </tr>
  <tr>
    <th><span class="F00">*</span>原密码:</th>
    <td><input class="input_text" type="password" name="oldPassword" id="oldPassword" class="input_text cword gray" datatype="*" nullmsg="请填写原密码"/></td>
  </tr>
  <tr>
    <th><span class="F00">*</span>新密码:</th>
    <td><input class="input_text" type="password" name="newPassword" id="newPassword" class="input_text cword gray" datatype="*" nullmsg="请填写新密码"  />
      </td>
  </tr>
  <tr>
    <th><span class="F00">*</span>重复输入新密码:</th>
    <td><input  type="password" name="newPasswordconfirm" id="newPasswordconfirm"  class="input_text cword gray" datatype="*" nullmsg="请重复填写新密码"  recheck="newPassword" errormsg="您两次输入的密码不一致！"/>
    </td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td>
    <input class="tb baocunanniu color_bai" type="button" name="button" id="subBtn"  value="保 存" /></td>
  </tr>
</table></div>
</body>
</html>
