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

<script type="text/javascript" language="javascript" src="${request.getContextPath()}/js/website/website_edit.js"></script>

</head>
<body class="baody">
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<form  id="websiteEditform">
<input type="hidden" name="websiteId" value="${webSite.websiteId}"/>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th>网站名:</th>
    <td>
    	<input class="input_text" type="text" name="name" value="${webSite.name}"  id="textfield" /> 
    </td>
  </tr>
  <!--
  <tr>
    <th>采集状态:</th>
    <td>
    	<select name="collectStatus">
	    	<option value="0"  <#if webSite.collectStatus=='0'> selected</#if> >未采集</option>
	    	<option value="1"  <#if webSite.collectStatus=='1'> selected</#if>> 已采集  </option>
	    </select>
    </td>
  </tr>
  -->
 <tr>
    <th>媒体类型:</th>
    <td>
	    <select name="mediaType">
	    	<option value="1" <#if webSite.mediaType=='1'> selected</#if>>新闻</option>
	    	<option value="2" <#if webSite.mediaType=='2'> selected</#if>>论坛</option>
	    	<option value="3" <#if webSite.mediaType=='3'> selected</#if>>微博</option>
	    	<option value="4" <#if webSite.mediaType=='4'> selected</#if>>博客</option>
	    	<option value="5" <#if webSite.mediaType=='5'> selected</#if>>报纸</option>
	    	<option value="6" <#if webSite.mediaType=='6'> selected</#if>>twitter</option>
	    </select>
    </td>
  </tr>
    <tr>
    <th>省份:</th>
    <td><input class="input_text" type="text" name="province" value="${webSite.province}" id="province" datatype="*" nullmsg="请填写网站名称"/>
    </td>
  </tr>
    <tr>
    <th>所在市:</th>
    <td><input class="input_text" type="text" name="town" value="${webSite.town}" id="town" />
    </td>
  </tr>
  <tr>
    <th>网址:</th>
    <td><input class="input_text" type="text" name="url" value="${webSite.url}" id="textfield" />
    </td>
  </tr>
  <tr>
    <th>ip:</th>
    <td><input class="input_text" type="text" name="ip" value="${webSite.ip}" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>公司名称:</th>
    <td><input class="input_text" type="text" name="company" value="${webSite.company}" id="textfield" />
     </td>
  </tr>
   <tr>
    <th>公司性质:</th>
    <td>
     <select name="nature">
	    	<option value="1" <#if webSite.nature=='1'> selected</#if>>企业</option>
	    	<option value="2" <#if webSite.nature=='2'> selected</#if>>政府机关</option>
	    	<option value="3" <#if webSite.nature=='3'> selected</#if>>事业单位</option>
	    	<option value="4" <#if webSite.nature=='4'> selected</#if>>社会团体</option>
	    	<option value="5" <#if webSite.nature=='5'> selected</#if>>个人</option>
	    </select>
     </td>
  </tr>
  <tr>
    <th>备案信息:</th>
    <td><input class="input_text" type="text" name="record" value="${webSite.record}" id="record" />
     </td>
  </tr>
   <tr>
    <th>联系人姓名:</th>
    <td><input class="input_text" type="text" name="contacts" value="${webSite.contacts}" id="contacts" />
     </td>
  </tr>
  <tr>
    <th>phone:</th>
    <td><input class="input_text" type="text" name="phone" value="${webSite.phone}" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>fax:</th>
    <td><input class="input_text" type="text" name="fax" value="${webSite.fax}" id="textfield" />
     </td>
  </tr>
  <tr>
    <th>法人:</th>
    <td><input class="input_text" type="text" name="legalPerson" value="${webSite.legalPerson}" id="textfield" />
     </td>
  </tr>
   
   <tr>
    <th>事件处置流程描述:</th>
    <td>
     <textarea name="processDescription" rows="6" cols="50" >${webSite.processDescription}</textarea>
     </td>
  </tr>
   <tr>
    <th>所需材料:</th>
    <td>
    <textarea name="material" rows="6" cols="50" >${webSite.material}</textarea>
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
