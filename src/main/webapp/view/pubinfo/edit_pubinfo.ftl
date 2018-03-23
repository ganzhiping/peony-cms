<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/kind/themes/default/default.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>

<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script charset="utf-8" src="${request.getContextPath()}/js/utils/kind/kindeditor.js" type="text/javascript"></script>
<script charset="utf-8" type="text/javascript" language="javascript" src="${request.getContextPath()}/js/utils/kind/lang/zh_CN.js"></script>
<script src="${request.getContextPath()}/js/pubinfo/pubinfo_edit.js"></script>

<!-- 添加kindeditor的引用 -->    
    <script>
			KindEditor.ready(function(K) {
			K.create('textarea[name="content"]', {
			uploadJson : '${request.getContextPath()}/channel/uploadPic',
            fileManagerJson : 'tools/kindeditor-4.1.10/jsp/file_manager_json.jsp',
            allowFileManager : true,
            allowImageUpload : true, 
		    autoHeightMode : true,
			afterCreate : function() {this.loadPlugin('autoheight');},
			afterBlur : function(){ this.sync(); }  //Kindeditor下获取文本框信息

			});

			});
			
			function closeWin(){
				window.opener.location.href=window.opener.location.href;
				window.close();
	
}

</script>
<body style="background:#FFFFFF">
	<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in">
        <div class="table_tanchu">
        <form  id="editform" enctype="multipart/form-data">
        <input type="hidden" name="pubinfoId" value="${pubInfo.pubinfoId}"/>
          <table border="0" cellspacing="0" cellpadding="0" id="table">
          <tr>
              <th><span class="F00">*</span>类别：</th>
              <td>
              	 <#if pubInfo.isSubject=="1">专题</#if>
              	 <#if pubInfo.isSubject=="0">案例</#if>
              	
              </td>
            </tr>
            <tr>
              <th><span class="F00">*</span>标题：</th>
              <td>
              	<input type="text" name="title" value="${pubInfo.title}" class="cword gray" datatype="*" nullmsg="请填写关键字"/>
              </td>
            </tr>
            <tr>
              <th>撰写人员：</th>
              <td>
              	<input type="text" name="author" value="${pubInfo.author}" class="cword gray" />
              </td>
            </tr>
              <tr>
              <th><span class="F00">*</span>上传pc图片：1000*150</th>
              <td>
              	<input type="file" name="bannerFile" value="上传图片" id="bannerFile" class="input_text"><#if pubInfo.image?has_content> <span style="color:red;"> 已上传</span></#if>
              </td>
            </tr>
            <tr>
              <th><span class="F00">*</span>上传pad大图：768*314</th>
              <td>
              	<input type="file" name="bigFile" value="上传图片" id="bigFile" class="input_text"><#if pubInfo.bigImage?has_content> <span style="color:red;"> 已上传</span></#if>
              </td>
            </tr>
            <tr>
              <th><span class="F00">*</span>上传pad长图：736*106</th>
              <td>
              	<input type="file" name="longFile" value="上传图片" id="longFile" class="input_text" ><#if pubInfo.longImage?has_content> <span style="color:red;"> 已上传</span></#if>
              </td>
            </tr>
			<tr>
              <th><span class="F00">*</span>上传pad小图：140*106</th>
              <td>
              	<input type="file" name="smallFile" value="上传图片" id="smallFile" class="input_text" ><#if pubInfo.smallImage?has_content> <span style="color:red;"> 已上传</span></#if>
              </td>
            </tr>
           <tr>
              <th><span class="F00">*</span>摘要：</th>
              <td>
              	<textarea  name="summary" style="width:700px;height:100px;" datatype="*1-500" nullmsg="摘要不能为空" errormsg="摘要不能超过500字">${pubInfo.summary}</textarea> 
              </td>
            </tr>
             <tr>
              <th><span class="F00">*</span>内容：</th>
              <td>
              	<textarea id="editor_id" name="content" style="width:700px;height:300px;">${content}</textarea>
              </td>
            </tr>
            <tr>
              <th valign="top">&nbsp;</th>
              <td valign="top">
              <div class="aniu_xinxi_fab">
                  <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="closeWin();" value="返回" />
                  <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
                </div></td>
            </tr>
          </table>
          </form>
        </div>
      </div>
</body>
