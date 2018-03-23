  <link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
  <script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
  <script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
  <script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
  <script>
  function loginOut(){

    var submit = function(v, h, f) {
		if (v == 'ok') {
  			window.location.href="${request.getContextPath()}/user/logout";
 		 }
		
  }
    $.jBox.setDefaults({
		defaults : {
			border : 0
		}
	})
  
  $.jBox.confirm("您确定要退出吗？", "提示", submit);
}
  
  </script>
  
  <!--页面头部-->
  <div class="page_header">
    <div class="page_header_in">
      <div class="logo"></div>
      <div class="on_rightx color_bai">
        <div class="yonghu">
          <li>欢迎您登陆系统，<span class="color_cheng_l">${user.name}</span></li>
          <li class="tb"><a href="#" onClick="loginOut();" >退出</a></li>
          </ul>
        </div>
        <div class="links">
          <ul>
          <#list backMenuSet as menu>
            <li id="${menu.identify}"><span>${menu.name}</span></li>
          </#list>
           <!-- <li>系统配置</li>
            <li>信息管理</li>
            <li>客户反馈管理</li>
            <li>日志管理</li>
            <li>关键词维护</li>-->
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!--页面头部结束--> 
