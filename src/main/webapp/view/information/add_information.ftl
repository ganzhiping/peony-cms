<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站内消息添加</title>
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/information/information_add.js"></script>

</head>
	<body>
      <div class="tneirong_2_in">
        <div class="table_tanchu">
        <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
        <form  id="inforAddForm">
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th>显示方式：</th>
              <td> <input type="radio" checked name="messageType" value="对外" /> 对外&nbsp;&nbsp;&nbsp;&nbsp;
                   <input type="radio"  name="messageType" value="对内" />对内
              </td>
            </tr>
            <tr>
              <th>接收人：</th>
              <td><select class="input_text"  name="receiveUser" id="select">
					<#list userList as user>
	 	 				<option value ="${user.userId}">${user.loginName}</option>
	  				</#list>
				</select>
             </td>
            </tr>
            <tr>
              <th>消息标题：</th>
              <td><input type="text" class="input_text" datatype="*" nullmsg="请填写标题" name="title" value="" />
              </td>
            </tr>
            <tr>
              <th valign="top">内容：</th>
              <td><textarea class="input_text2 input_text_r"  name="content" id="textarea" cols="45" rows="5" datatype="*" nullmsg="请填写内容"></textarea></td>
            </tr>
            <tr>
              <th valign="top">&nbsp;</th>
              <td valign="top"><div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" value="返回" onClick="parent.showPop();";/>
                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
                </div></td>
            </tr>
          </table>
        </div>
      </div>
</body>
</html>