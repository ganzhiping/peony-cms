<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看用户</title>
<link rel="stylesheet" media="all" type="text/css" href="${request.getContextPath()}/css/datatable/datatable.css" />

<link href="${request.getContextPath()}/css/ztree/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/datatable/jquery.dataTables.js"></script>
<script src="${request.getContextPath()}/js/utils/strUtils/dateUtil.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js" type="text/javascript"></script>
<script src="${request.getContextPath()}/js/utils/ztree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
</head>

<div class="container-fluid breadcrumb">
		<div class="row-fluid span12">
			<span class="span4">角色名称: <b>${role.name}</b></span>
		</div>
	</div>
<div class="breadcrumb">
<form id="assignRoleForm" action="" method="post" class="hide"></form>
<!--<a id="assignButton" href="javascript:" class="btn btn-primary">分配角色</a>-->
		<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
		<input type="hidden" id="roleId" value="${role.roleId}"/>
		<input type="hidden" id="roleName" value="${role.name}"/>
	
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="data_Table"  id="list_info" >
				<thead>
		            <tr class="header_title">
		                <td>登录名</td>
		                <td>姓名</td>
		                <td>操作</td>
		            </tr>
	            </thead>
	        </table>
	
	<!--<script src="${request.getContextPath()}/js/role/assign.js"></script>-->

	<script src="${request.getContextPath()}/js/role/userRole.js"></script>
		
</html>