
<script language="javascript" type="text/javascript">
	var t;
	function show() {
	var date = new Date(); //日期对象
	var now = "";
	now = date.getFullYear() + "-"; //读英文就行了
	now = now + (date.getMonth() + 1) + "-"; //取月的时候取的是当前月-1如果想取当前月+1就可以了
	now = now + date.getDate()  + "   ";
	now = now + date.getHours() + ":";
	now = now + date.getMinutes() + ":";
	now = now + date.getSeconds() ;
	document.getElementById("nowDiv").innerHTML = now; //div的html是now这个字符串
	t= setTimeout("show()", 1000); //设置过1000毫秒就是1秒，调用show方法
	}
</script>
</head>
<body onload="show();">
  <!--侧边菜单-->
  <div class="page_aside">
    <div class="sidebar">
      <div class="open"></div>
      <div class="page_fold_btn"></div>
      <div class="tb time color_bai" id="nowDiv">2014-05-01  14:31</div>
      <div class="left_dh">
        <div id="moudle">
          <dl>
            <dt></dt>
            <#list leftMenuList as menu>
            <dd><a href="${request.getContextPath()}/${menu.url}" target="right">${menu.name}</a></dd>
            </#list>
          </dl>
        </div>
       
      </div>
      <div class="bottomx"></div>
    </div>
  </div>
</body>
</html>
  <!--侧边菜单结束--> 