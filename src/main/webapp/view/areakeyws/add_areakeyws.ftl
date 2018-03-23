<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/areakeyws/areakeyws_add.js"></script>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<input type="hidden" id="pageContext" value="${request.getContextPath()}">
<form id="areakeywsAddform">
<input type="hidden" name="areaId" value="${areaId}"/>
 <table border="0" cellspacing="0" cellpadding="0" width="100%" class="boxTable boxmar">
        <tr class="nobg">
            <td align="right"><span class="F00">*</span>关键字：</td>
            <td><input type="text" name="name" value="" class="cword gray" datatype="*" nullmsg="请填写关键字"/><span id="fieldErr_departmentName"></span></td>
        </tr>
        <tr >
            <td colspan="2" align="center">
            	    <input type="button"  id="subBtn" value="保存"/>
            </td>
        </tr>
    </table>
</form>
