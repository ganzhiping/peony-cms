<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加套餐</title>

<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script src="${request.getContextPath()}/js/combo/edit_combo.js"></script>
<body style="background:#FFFFFF">
	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in">
        <div class="table_tanchu">
        <form id="comboForm">
        <input type="hidden" name="id" value="${combo.id}" />
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>套餐名称：</th>
              <td><input type="text" name="name" value="${combo.name}" class="input_text" datatype="*" nullmsg="请填写套餐名称"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>关键词数量：</th>
              <td><input type="text" name="keywordnumber" value="${combo.keywordnumber}" class="input_text" datatype="n1-11" nullmsg="请填写关键词数量" errormsg="关键词个数为数字"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>话题数量：</th>
              <td><input type="text" name="topicnumber" value="${combo.topicnumber}" class="input_text" datatype="n1-11" nullmsg="请填写话题数量" errormsg="话题个数为数字"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>说明：</th>
              <td><textarea name="introduce" rows="2" cols="34"  datatype="s1-400" nullmsg="请填写说明" errormsg="最多400个字符">${combo.introduce}</textarea></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>单价：</th>
              <td><input type="text" name="price" value="${price}" class="input_text" datatype="/([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$/" nullmsg="请填写单价" errormsg="单价应为数值"/></td>
            </tr>
            <tr>
              <th valign="top">&nbsp;</th>
              <td valign="top">
              <div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
                  <input class="tb fabiao1 color_bai" type="button" id="editBtn" value="修改" />
                </div></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
</body>
</html>