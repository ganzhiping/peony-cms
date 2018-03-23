<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>

<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/points/edit_points.js" type="text/javascript"></script>
</head>
 <input type="hidden" id="pageContext" value="${request.getContextPath()}"/>

	<div class="xtpz_yhgl_addyh ">
    <div class="tneirong_2">
      <div class="tneirong_2_in">
      <form  id="pointsForm">
       <input type="hidden" id="id" name="id" value="${points.id}"/>
        <div class="table_tanchu">
          <table border="0" cellspacing="0" cellpadding="0">
            <tr>
              <th>积分类型：</th>
              <td><#if points.type==1>登录 </#if><#if points.type==2>转发 </#if><#if points.type==3> 注册(首次)</#if><#if points.type==4> 购买</#if></td>
            </tr>
            <tr>
              <th><span class="F00">*</span>系统显示名称：</th>
              <td><input class="input_text input_text_small" type="text" name="points" value="${price}" id="points"   datatype="/([0-9]*\.?[0-9]+|[0-9]+\.?[0-9]*)([eE][+-]?[0-9]+)?$/" nullmsg="请填写积分单价" errormsg="积分应为数值" /></td>
            </tr>
          </table>
        </div>
        <div class="aniu_xinxi_fab">
            <input class="tb fabiao2 fabiao2a color_bai" type="button" onClick="parent.showPop();" value="返回" />
            <input class="tb fabiao1 color_bai" type="button" id="subBtn" value="保存" />
       </div>
      </form>
      </div>
    </div>
  </div>
