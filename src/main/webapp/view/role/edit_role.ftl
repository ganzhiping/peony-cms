<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/role/role_edit.js"></script>

<input type="hidden" id="pageContext" value="${request.getContextPath()}">
<form id="roleform">
	<input type="hidden" name="roleId" value="${role.roleId}" />
	   <div class="tneirong_2_in">
        <div class="table_tanchu">
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th><span class="F00">*</span>角色名称：</th>
              <td><input type="text" name="name" value="${role.name}" class="input_text" datatype="*" nullmsg="请填写角色名称"/><span id="fieldErr_roleName"></span></td>
            </tr>
            <tr>
              <th valign="top">&nbsp;</th>
              <td valign="top">
              <div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
                </div></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
</form>
