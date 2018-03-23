<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/areakeyws/areakeyws_edit.js"></script>

<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<input type="hidden" id="pageContext" value="${request.getContextPath()}">
<form id="areakeywsEditform">
<input type="hidden" name="areaKeywsId" value="${areaKeyws.areaKeywsId}"/>
<table>
<tr><td>
关键字：<input type="text" name="name" value="${areaKeyws.name}"  />
</td>
</tr>
<tr>
<td>
<input type="button" id="subBtn" value="保存" />
</td>
</tr>
</form>
