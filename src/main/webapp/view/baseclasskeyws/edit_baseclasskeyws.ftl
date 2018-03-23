<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/baseclasskeyws/baseclasskeyws_edit.js"></script>

<body style="background:#FFFFFF">
	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in">
        <div class="table_tanchu">
        <form  id="baseclassEditform" >
        <input type="hidden" name="baseclassKeywsId" value="${baseClassKeyws.baseclassKeywsId}"/>
          <table border="0" cellspacing="0" cellpadding="0">
           <tr>
            <td><span class="F00">*</span>名称：</th>
            <td><input  type="text" name="name" value="${baseClassKeyws.name}" datatype="*" nullmsg="请填写名称" /></td>
	       </tr>
            <tr>
              <th><span class="F00">*</span>关键字：</th>
              <td>
              <textarea name="content" rows="6" cols="50" datatype="*" nullmsg="请填写关键字">${baseClassKeyws.content}</textarea><span id="fieldErr_keywordsName"></span>
              
              </td>
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
</body>
