<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>

<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/website/website_add.js"></script>

</head>
<body class="baody">
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form  id="websiteAddform">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>网站名:</th>
    <td>
    	<input class="input_text" type="text" name="name" value=""  id="textfield" datatype="*" nullmsg="请填写网站名称" /> 
    </td>
  </tr>
  <!--
  <tr>
    <th>采集状态:</th>
    <td>
    	<select name="collectStatus">
	    	<option value="0">未采集</option>
	    	<option value="1">已采集</option>
	    </select>
    </td>
  </tr>
  -->
  <tr>
    <th>媒体类型:</th>
    <td>
	    <select name="mediaType">
	    	<option value="1">新闻</option>
	    	<option value="2">论坛</option>
	    	<option value="3">微博</option>
	    	<option value="4">博客</option>
	    	<option value="5">报纸</option>
	    	<option value="6">twitter</option>
	    </select>
    </td>
  </tr>
    <tr>
    <th>省份:</th>
    <td><input class="input_text" type="text" name="province" value="" id="province" datatype="*" nullmsg="请填写网站名称"/>
    </td>
  </tr>
    <tr>
    <th>所在市:</th>
    <td><input class="input_text" type="text" name="town" value="" id="town" />
    </td>
  </tr>
  <tr>
    <th>网址:</th>
    <td><input class="input_text" type="text" name="url" value="" id="textfield" datatype="url" nullmsg="请填写网站名称"/>
    </td>
  </tr>
  <tr>
    <th>ip:</th>
    <td><input class="input_text" type="text" name="ip" value="" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>公司名称:</th>
    <td><input class="input_text" type="text" name="company" value="" id="textfield" />
     </td>
  </tr>
   <tr>
    <th>公司性质:</th>
    <td>
     <select name="nature">
	    	<option value="1">企业</option>
	    	<option value="2">政府机关</option>
	    	<option value="3">事业单位</option>
	    	<option value="4">社会团体</option>
	    	<option value="5">个人</option>
	    </select>
     </td>
  </tr>
   <tr>
    <th>备案信息:</th>
    <td><input class="input_text" type="text" name="record" value="" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>联系人姓名:</th>
    <td><input class="input_text" type="text" name="contacts" value="" id="contacts" />
     </td>
  </tr>
  <tr>
    <th>phone:</th>
    <td><input class="input_text" type="text" name="phone" value="" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>fax:</th>
    <td><input class="input_text" type="text" name="fax" value="" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>法人:</th>
    <td><input class="input_text" type="text" name="legalPerson" value="" id="textfield" />
     </td>
  </tr>
   <tr>
    <th>事件处置流程描述:</th>
    <td><textarea name="processDescription" rows="6" cols="50" ></textarea>
     </td>
  </tr>
   
   <tr>
    <th>所需材料:</th>
    <td>
    <textarea name="material" rows="6" cols="50" ></textarea>
     </td>
  </tr>
  <tr>
    <th>&nbsp;</th>
    <td>
    <input class="tb baocunanniu color_bai" type="button" name="button" id="subBtn"   value="保 存" /></td>
  </tr>
</table>
</form>
</div>
</body>
</html>
