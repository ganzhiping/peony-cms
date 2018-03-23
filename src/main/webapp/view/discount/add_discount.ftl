<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加折扣</title>

<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script src="${request.getContextPath()}/js/discount/add_discount.js"></script>
<body style="background:#FFFFFF">
	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in">
        <div class="table_tanchu">
        <form id="addForm">
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>套餐名称：</th>
              <td><select name="comboid" id="comboid" >
						<#list comboList as combo>
    					<option value="${combo.id}">${combo.name}</option>
   						</#list>
					</select>
			  </td>
            </tr>
            <tr>
              <th><span class="F00">*</span>开始天数：</th>
              <td><input type="text" name="beginday" value="" class="input_text" datatype="n1-11" nullmsg="请填写开始天数" errormsg="开始天数为数字"/></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>结束天数：</th>
              <td><input type="text" name="endday" value="" class="input_text" datatype="n1-11" nullmsg="请填写结束天数" errormsg="结束天数为数字"/></td>
            </tr>
            
            <tr>
              <th><span class="F00">*</span>折扣：</th>
              <td><input type="text" name="discount"  class="input_text" datatype="/([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$/" nullmsg="请填写折扣价格" errormsg="折扣价应为数值"/></td>
            </tr>
            <tr>
              <th valign="top">&nbsp;</th>
              <td valign="top">
              <div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="showPop();" value="返回" />
                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
                </div></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
</body>
</html>