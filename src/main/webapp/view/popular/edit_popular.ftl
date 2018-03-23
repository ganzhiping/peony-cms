<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/kind/themes/default/default.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/popular.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script charset="utf-8" src="${request.getContextPath()}/js/utils/kind/kindeditor.js" type="text/javascript"></script>
<script charset="utf-8" type="text/javascript" language="javascript" src="${request.getContextPath()}/js/utils/kind/lang/zh_CN.js"></script>
<script src="${request.getContextPath()}/js/popular/popular_edit.js"></script>

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
                <input type="hidden" name="popularId" value="${popular.popularId}">
                <table border="0" cellspacing="0" cellpadding="0" id="table">

                    <tr>
                        <th><span class="F00">*</span>标题：</th>
                        <td>
                            <input type="text" name="title" value="${popular.title}" class="cword gray" datatype="*" nullmsg="请填写关键字"/>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="F00">*</span>作者：</th>
                        <td>
                            <input type="text" name="writer" value="${popular.writer}" class="cword gray" datatype="*" nullmsg="请填写关键字" />
                        </td>
                    </tr>
                    <tr>
                        <th>期数：</th>
                        <td>
                            <input type="text" name="periods" value="${popular.periods}" class="cword gray"/>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="F00">*</span>用户：</th>
                        <td>
                            <input type="hidden" id="userId" name="userid" value="${popular.userid}" />
                            <input type="text" name="userName" value="${popular.userName}" id="s_f_btn_1" class="cword gray" datatype="*" nullmsg="请填写关键字"/>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="F00">*</span>出处：</th>
                        <td>
                            <textarea  name="descript" style="width:850px;height:100px;"datatype="*1-500" nullmsg="摘要不能为空" errormsg="摘要不能超过500字">
                            ${popular.descript}
                            </textarea>
                        </td>
                    </tr>
                    <tr>
                        <th><span class="F00">*</span>内容：</th>
                        <td>
                            <textarea id="editor_id" name="content" style="width:850px;height:400px;">
                                ${popular.content}
                            </textarea>
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

    <!--弹出层-->
    <div class="s_f_mask1">
        <!--在弹出层里面放一个DIV-->
        <div class="s_f_div1">
            <!--关闭按钮-->
            <a href="javascript:void(0);" class="s_f_btn_close">X</a>
            <div class="contentDiv" id="contentDiv">
            </div>
            <div class="sureBtn">
                <input type="button" value="确认" onClick="getValue()" >
            </div>

        </div>
    </div>
</body>
