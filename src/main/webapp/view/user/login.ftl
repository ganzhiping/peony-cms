<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" CONTENT="no-cache">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Expires" CONTENT="0">
<title>牡丹舆情监测分析后台系统</title>
<link rel="stylesheet" href="${request.getContextPath()}/style/css/mddsj_houtai_login.css">
<link href="${request.getContextPath()}/css/jbox/jbox.css" rel="stylesheet" type="text/css" id="jbox"/>
<link href="${request.getContextPath()}/css/validform/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="${request.getContextPath()}/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/form/jquery.form.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox.src.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/jbox/jquery.jBox-zh-CN.js"></script>
<script type="text/javascript" src="${request.getContextPath()}/js/utils/validform/Validform_v5.3.2_min.js"></script>

<!--[if lte IE 6]>
	<script type="text/javascript" src="${request.getContextPath()}/style/js/belatedPNG.js"></script>
	<script type="text/javascript">
		// 解决IE6透明PNG图片BUG
        DD_belatedPNG.fix("img,.logo,.DD_png,.DD_png_w li,.DD_png_w dt,.DD_png_w span,.doanghuang li,.tb,.tb2,.title_h1,.title_h1 li,.more,.t_tit,.t_tit1,.t_tit2,.t_tit3,.t_tit4");
        </script>
<![endif]-->
</head>
<body class="denglu_body2">
<input type="hidden" id="pageContext" value="${request.getContextPath()}">
	<div class="denglu_w_br DD_png">
		<div class="bg">
			<div class="denglu_w_in">
				<div class="denglu_logo on_left DD_png"></div>
					<div class="denglu_k on_left">
						<div class="denglu_center DD_png color_bai">
						<form id="loginForm">
		  					<p><label>用户名:</label>
		   		 				<input class="denglu_input denglu_input1 tb" type="text" name="loginName" datatype="*" nullmsg="请填写用户名" id="loginName" />
		   		 			</p>
		  					<p><label>密　码:</label>
		  						<input class="denglu_input denglu_input2 tb" type="password" name="password" id="password" datatype="*" nullmsg="请填写密码"/>
		  					</p>
    						<!--<p class="font_13px"><label>&nbsp;</label>
      							<input type="checkbox" name="checkbox" id="checkbox" />记住用户名&nbsp;&nbsp;&nbsp;
      								<input type="checkbox" name="checkbox" id="checkbox" />自动登录
      						</p>-->
  							<div class="denglu_anniuw">
	  							<!--<input name="自动登录" type="submit" class="denglu_anniu1 color_bai tb" value="自动登录" />-->
	  							<input  type="button" id="subBtn" name="button"  class="denglu_anniu1 color_bai tb" value="登  录"/>
	  							<input  type="reset"  name="button"  class="denglu_anniu1 color_bai tb" value="重  置"/>
  							</div>
  						</form>
  					</div>
				</div>
			<div class="blank15px"></div>
		</div>
	</div>
<div class="HackBox"></div></div>
<script src="${request.getContextPath()}/js/user/login.js" type="text/javascript"></script>
</body>
</html>