<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文章详情</title>
<body>
<div class="bg">
  <div class="zhanwei color_hongse_n">
    <strong>当前位置：</strong>&nbsp;&gt;&nbsp;文章详细 </div>
 </div>
<div class="bg">

<div class="wenzhangxiangxi_t">
	<h1>${subjectPage.title}</h1>
	<h2 class="color_huise">
		来源：<span>${subjectPage.website}</span> 
		发布时间：<span>${subjectPage.publishdate?string("yyyy-MM-dd HH:mm:ss")}</span> 
		<!--点击数:<span>${subjectPage.clickcount}</span> 
		回复数：<span>${subjectPage.replycount}</span> -->
		<span class="color_hongse_n"><a href="#">查看快照</a></span>
	</h2>
</div>
<div class="wenzhangxiangxi">
	<!--317-->
	<#if subjectPage.type!=3>
		<iframe marginWidth=0 marginHeight=0 src="${subjectPage.url}" frameBorder=0 width="956" height="700"></iframe>
	<#else>
		${subjectPage.summary}
	</#if>
	
</div>
<div class="xiangguan">
<div class="title_h1 color_bai">
       相关信息 
    </div>
	<div class="list">
		<#list list as subjectPage>
          <dl>
            <dd><em>${subjectPage.website}</em><span>${subjectPage.publishdate?string("yyyy-MM-dd HH:mm:ss")}</span></dd>
            <dt>
            	<a href="javascript:" onclick="loadSubjectPage('${subjectPage.id}','${subjectPage.groupseedid}')">${subjectPage.title}</a>
            </dt>
          </dl>
		</#list>
    </div>
</div>
<div class="HackBox"></div>
</div>
<div class="blank5px"></div>
</body>
</html>