<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/agent/addMobileAgent.js"></script>

<body class="baody">
<div class="bianji_tbale">
<input type="hidden" id="pageContext" value="${request.getContextPath()}">
<form id="agentEditform" method="post" enctype="multipart/form-data">
<input type="hidden" id="userName" name="userName" value=""/>

<table border="0" cellspacing="0" cellpadding="0">
 <tr>
    <th><span class="F00">*</span>代理商名称：</th>
    <td>
    <input type="text" name="name"  datatype="*"  class="input_text"/>
    </td>
  </tr>
  <tr>
    <th><span class="F00">*</span>所属市场人员：</th>
    <td>
    <select name="userId" id="userId" datatype="n" >
    	<option value="">-- --</option>
    	<#list userList as user>
    		<option value="${user.userId}">${user.name}</option>
   		</#list>
    </select>
  </td>
  </tr>
  <tr>
    <th><span class="F00">*</span>联系人：</th>
    <td>
    <input type="text" name="relationName" id="relationName" class="input_text" datatype="*"/>
    </td>
  </tr>
  <tr>
    <th>地址：</th>
    <td>
    <input type="text" name="address"   class="input_text"/>
    </td>
  </tr>
  <tr>
    <th>备案信息：</th>
    <td>
    <input type="text" name="record"   class="input_text"/>
    </td>
  </tr>
  <tr>
    <th><span class="F00">*</span>邮箱：</th>
    <td><input type="text" name="email"  errormsg="邮箱格式不正确！" datatype="e" class="input_text"/>
    </td>
  </tr>
  <tr>
    <th>客服qq1：</th>
    <td><input type="text" name="qq"   class="input_text"/></td>
  </tr>
   <tr>
    <th>客服qq2：</th>
    <td><input type="text" name="qq2"   class="input_text"/></td>
  </tr>
  <tr>
    <th>客服qq3：</th>
    <td><input type="text" name="qq3"   class="input_text"/></td>
  </tr>
   <tr>
    <th><span class="F00">*</span>联系电话：</th>
    <td>
    	<input type="text" name="phone"  datatype="/(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)/"  class="input_text"/>
    </td> 
  </tr>
  <!--<tr>
    <th><span class="F00">*</span>网址：</th>
    <td><input type="text" name="url"  errormsg="网址格式不正确！" datatype="url" class="input_text"/>
     </td>([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$
  </tr>-->
  <tr>
    <th>简介：</th>
    <td><input type="text" name="overview"  class="input_text"/></td>
  </tr>
  <tr>
    <th>代理商logo:(332*79)</th>
    <td><input type="file" name="bannerFile" value="上传图片" id="bannerFile" class="input_text"></td>
  </tr>
  <tr>
    <th>设备型号：</th>
    <td><input type="text" name="model"  class="input_text"/></td>
  </tr>
   <tr>
    <th></th>
    <td><input  class="tb baocunanniu color_bai" type="button" id="subBtn" value="保存" /></td>
  </tr>
  </table>
  </form>
  </div>
  </body>
