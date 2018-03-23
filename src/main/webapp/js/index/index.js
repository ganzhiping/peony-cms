var pageContext=$("#pageContext").val();
var currentMousePosition1;//记录鼠标坐标  
var currentMousePosition2;  
var eventID;  
  
function mousePos(e){  
var x,y;  
var e = e||window.event;  
return {  
x:e.clientX+document.body.scrollLeft+document.documentElement.scrollLeft,  
y:e.clientY+document.body.scrollTop+document.documentElement.scrollTop  
};  
};  
  

  
var timeout = 30*60*1000;  //设定超时时间  30分钟
var currentSecond = 0;  
function GetXYPosition(e){  
	currentMousePosition2 = mousePos(e).x+','+mousePos(e).y; 
	};  
function CheckTime()  
{  
    if(currentMousePosition1 == currentMousePosition2)  
    {  
        currentSecond = currentSecond+1000;  
        if(currentSecond>timeout)  
        {  
            clearInterval(eventID);  
            window.location.href = pageContext+"/user/login";  
        }  
    }  
    else  
    {  
        currentSecond = 0;  
        currentMousePosition1 = currentMousePosition2;  
    }  
}  
  
function StartPoint()  
{  
   currentMousePosition1 = "";  
   currentMousePosition2 = "";  
   eventID = setInterval(CheckTime,1000);  
}  
  




$(function() {
 $("#rightMain").attr("src",$("dd").eq(0).find("a").attr("href"));
 
 
  $('ul li').bind('click',function(){
  		var identify=this.id;
  		$.ajax({
			    type: "POST",
			    async:false,
			    url: pageContext+"/user/module",
			    data: {
			    	identify:identify
			    },
			    success: function(data){
			    var text="<dt></dt>";
			    	for (var i = 0; i < data.length; i++) {
                		var menu = data[i];
			    		text+=' <dd><a href='+pageContext+menu.url+' target="right">'+menu.name+'</a></dd>';
			    		
			    	}
			    	
			    	$('dl').html(text);
			    	
			    	var url=$("dd").eq(0).find("a").attr("href");
					$("#rightMain").attr("src",url);
			    	
			    }
			});
  
  
	  })
 
 
 
  })
  