<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>人员角色</title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script src="${request.getContextPath()}/js/user/findUserRole.js"></script>
<script>
</script>
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in" style="height:100%;">
        <div class="table_tanchu">
        <div class="yonhu_js_xz">
         <form>
         	<input type="hidden" id="userId" value="${userId}"/>
        	<#list allRoleList as allRole>
        	 <#if 1!=allRole.roleId && 133!=allRole.roleId>
        			<span><input type="checkbox"  <#list roleList as role> <#if role.roleId==allRole.roleId> checked</#if> </#list> name="chk_list" value="${allRole.roleId}" />${allRole.name}</span>
             </#if>
        	<#if 133==allRole.roleId && userModel.userId==2> 
        			<span><input type="checkbox"  <#list roleList as role> <#if role.roleId==allRole.roleId> checked</#if> </#list> name="chk_list" value="${allRole.roleId}" />${allRole.name}</span>
        	</#if>
        	</#list>
         </div>
         <div class="aniu_xinxi_fab">
            <input type="button"  class="tb fabiao1 color_bai"  onClick="modify();"  value="保存" />
         </div>
         </form>
        </div>
</body>
</html>
