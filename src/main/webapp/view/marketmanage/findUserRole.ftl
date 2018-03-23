<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>市场用户关系管理</title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_right.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script src="${request.getContextPath()}/js/marketmanage/findUserRole.js"></script>
</head>
<body>
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
      <div class="tneirong_2_in" style="height:100%;">
        <div class="table_tanchu">
        <div class="yonhu_js_xz">
         <form>
         	<input type="hidden" id="managerUserId" name="managerUserId" value="${managerUserId}"/>
        	<#list listMarketUser as user>
        	<#if user.userId!=managerUserId> 
        		<span><input type="checkbox"  <#list sellerList as seller> <#if seller.userId==user.userId> checked</#if> </#list> name="chk_list" value="${user.userId}" />${user.name}</span>
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
