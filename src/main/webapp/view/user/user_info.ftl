<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body class="baody">
<div class="tb mianbaoxue">首页 >> 个人中心 >> 个人信息修改</div>
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form  id="userInfoForm"  method="post">
<input type="hidden" name="userId" value="${user.userId}" />
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>用户名:</th>
    <td>
    <input class="input_text" type="text" name="loginName" value="${user.loginName}" disabled="true" id="textfield" /> 
      </td>
  </tr>
  <tr>
    <th>姓　名:</th>
    <td><input class="input_text" type="text" name="name" value="${user.name}" id="textfield" datatype="*" nullmsg="姓名不能为空"/>
    </td>
  </tr>
  <tr>
    <th>邮　箱:</th>
    <td><input class="input_text" type="text" name="email" value="${user.email}" id="textfield" datatype="e"/>
     </td>
  </tr>
  <tr>
    <th>电　话:</th>
    <td><input class="input_text" type="text" name="mobile" value="${user.mobile}" id="textfield2" datatype="m"/></td>
  </tr>
  <tr>
    <th>性　别:</th>
    <td><input type="radio" <#if user.sex=='男'> checked</#if> name="sex" value="男" /> 男<input type="radio"  <#if user.sex=='女'> checked</#if> name="sex" value="女" />女</td>
  </tr>
  
  <tr>
    <th>备  注:</th>
    <td>
      <textarea class="input_text2"name="note"   id="textarea" cols="45" rows="5">${user.note}</textarea></td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td>
    <input class="tb baocunanniu color_bai" type="button" name="button" id="subBtn" value="保 存" /></td>
  </tr>
</table>
</form>
</div>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/user/userinfo.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
</body>
</html>
