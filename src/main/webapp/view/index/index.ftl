<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title></title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai.css">
<script type="text/javascript" language="javascript" src="${request.getContextPath()}/style/js/jquery.js"></script>
<script src="${request.getContextPath()}/style/js/index_mddsj_houtai.js" type="text/javascript"></script>
</head>
<body onload="StartPoint();">
<input type="hidden" id="pageContext" value="${request.getContextPath()}"/>
<div class="page_container" onmousemove="GetXYPosition(event)"> 
<#include "/common/top.ftl">

<#include "/common/left.ftl">
  <!--页面头部-->
  <!--<div class="page_header">
    <div class="page_header_in">
      <div class="logo"></div>
      <div class="on_rightx color_bai">
        <div class="yonghu">
          <li>欢迎您登陆系统，<span class="color_cheng_l">Admin</span></li>
          <li class="tb"><a href="#">退出</a></li>
          </ul>
        </div>
        <div class="links">
          <ul>
          <#list menuSet as menu>
            <li id="${menu.menuId}">${menu.name}</li>
            </#list>
            <li>系统配置</li>
            <li>信息管理</li>
            <li>客户反馈管理</li>
            <li>日志管理</li>
            <li>关键词维护</li>
          </ul>
        </div>
      </div>
    </div>
  </div>-->
  <!--页面头部结束--> 
  
  <!--侧边菜单-->
 <!-- <div class="page_aside">
    <div class="sidebar">
      <div class="open"></div>
      <div class="page_fold_btn"></div>
      <div class="tb time color_bai">2014-05-01  14:30</div>
      <div class="left_dh">
        <div>
          <h1 class="td2 dh_1">个人中心</h1>
          <dl>
            <dt></dt>
            <dd><a href="${request.getContextPath()}/user/editUserInfo" target="right">个人信息</a></dd>
            <dd><a href="${request.getContextPath()}/user/editPwd" target="right">修改密码</a></dd>
            <dd><a href="${request.getContextPath()}/information/informationList" target="right">站内消息</a></dd>
          </dl>
        </div>
        <div id="moudle">
          <h1 class="td2 dh_2">系统配置</h1>
          <dl>
            <dt></dt>
            <dd><a href="${request.getContextPath()}/menu/menuList" target="right">菜单维护</a></dd>
            <dd><a href="${request.getContextPath()}/role/roleList" target="right">角色管理</a></dd>
            <dd><a href="${request.getContextPath()}/dept/deptList" target="right">组织管理</a></dd>
            <dd><a href="${request.getContextPath()}/user/userList" target="right">用户管理</a></dd>
            <dd><a href="${request.getContextPath()}/agent/agentList" target="right">代理商管理</a></dd>
          </dl>
        </div>
        <div>
          <h1 class="td2 dh_3">信息管理</h1>
          <dl>
            <dt></dt>
            <dd><a href="信息管理_用户信息管理.html" target="right">用户信息管理</a></dd>
            <dd><a href="信息管理_预警信息管理.html" target="right">预警信息管理</a></dd>
          </dl>
        </div>
        <div>
          <h1 class="td2 dh_4">客户反馈管理</h1>
          <dl>
            <dt></dt>
            <dd><a href="${request.getContextPath()}/message/messageList" target="right">留 言 板</a></dd>
            <dd><a href="${request.getContextPath()}/feedback/feedbackList" target="right">问题反馈</a></dd>
            <dd><a href="${request.getContextPath()}/apply/applyList" target="right">试用申请</a></dd>
          </dl>
        </div>
        <div>
          <h1 class="td2 dh_5">日志管理</h1>
          <dl>
            <dt></dt>
            <dd><a href="日志管理_系统日志.html" target="right">系统日志</a></dd>
            <dd><a href="${request.getContextPath()}/operationlog/operationLogList" target="right">操作日志</a></dd>
            <dd><a href="${request.getContextPath()}/operationlog/selectOperationLogsCounts" target="right">行为分析</a></dd>
          </dl>
        </div>
        <div>
          <h1 class="td2 dh_6">关键词维护</h1>
          <dl>
            <dt></dt>
            <dd><a href="${request.getContextPath()}/area/areaList" target="right">区域维护</a></dd>
            <dd><a href="${request.getContextPath()}/areakeyws/areaList" target="right">区域关键词维护</a></dd>
            <dd><a href="${request.getContextPath()}/baseclass/baseClassList" target="right">基础关键词<br />类别维护</a></dd>
            <dd><a href="${request.getContextPath()}/baseClasskeyws/baseClassList" target="right">基础关键词维护</a></dd>
          </dl>
        </div>
      </div>
      <div class="bottomx"></div>
    </div>
  </div>-->
  <!--侧边菜单结束--> 
  <!--主体内容-->
  <div class="main_content">
    <div class="wrapper">
      <iframe name="right" id="rightMain" src="" frameborder="false" scrolling="auto" allowtransparency="true"></iframe>
    </div>
  </div>
  <!--主体内容结束-->
  <div class="foot"></div>
</div>
</body>
<script src="${request.getContextPath()}/js/index/index.js" type="text/javascript"></script>
</html>
