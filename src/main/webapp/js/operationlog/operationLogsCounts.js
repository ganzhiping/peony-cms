var pageContext;
$(function () {
pageContext = $("#pageContext").val();
var options = {
     chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '登录排行'
        },
        xAxis: {
            categories: [],
             labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
        },
        yAxis: {
        	min:0,
            title: {
                text: '登录次数'
            }
        },
        legend: {
                enabled: false
            },
        tooltip: {
                pointFormat: '登录 <b>{point.y} 次</b>'
            },
        series: [{
            name: 'Jane',
            data: [],
            dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
        }]
};


$.ajax({
  type: 'POST',
  url: pageContext+"/operationlog/selectOperationLoginLogsByajax",
  dataType:'json',
  success: function(data){
 		options.xAxis.categories = [];
		for(var i=0;i<data.loginCountList.length;i++){
							options.xAxis.categories.push(data.loginCountList[i].name);
							options.series[0].data.push(data.loginCountList[i].counts);
						}
	
	$('#container').highcharts(options);
	}

});



var module_options = {
     chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '模块排行'
        },
        xAxis: {
            categories: [],
             labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
        },
        yAxis: {
        	min:0,
            title: {
                text: '点击次数'
            }
        },
        legend: {
                enabled: false
            },
        tooltip: {
                pointFormat: '点击 <b>{point.y} 次</b>'
            },
        series: [{
            name: 'Jane',
            data: [],
            dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: 4,
                    y: 10,
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif',
                        textShadow: '0 0 3px black'
                    }
                }
        }]
};


$.ajax({
  type: 'POST',
  url: pageContext+"/operationlog/selectOperationModuleLogsByajax",
  dataType:'json',
  success: function(data){
 		module_options.xAxis.categories = [];
		for(var i=0;i<data.moduleCountList.length;i++){
							module_options.xAxis.categories.push(data.moduleCountList[i].operateModule);
							module_options.series[0].data.push(data.moduleCountList[i].counts);
						}
	
	$('#module_container').highcharts(module_options);
	}

});


var ereblogin_options = {
	     chart: {
	            type: 'column',
	            margin: [ 50, 50, 100, 80]
	        },
	        title: {
	            text: 'E人E本登录排行'
	        },
	        xAxis: {
	            categories: [],
	             labels: {
	                    rotation: -45,
	                    align: 'right',
	                    style: {
	                        fontSize: '13px',
	                        fontFamily: 'Verdana, sans-serif'
	                    }
	                }
	        },
	        yAxis: {
	        	min:0,
	            title: {
	                text: '登录次数'
	            }
	        },
	        legend: {
	                enabled: false
	            },
	        tooltip: {
	                pointFormat: '点击 <b>{point.y} 次</b>'
	            },
	        series: [{
	            name: 'Jane',
	            data: [],
	            dataLabels: {
	                    enabled: true,
	                    rotation: -90,
	                    color: '#FFFFFF',
	                    align: 'right',
	                    x: 4,
	                    y: 10,
	                    style: {
	                        fontSize: '13px',
	                        fontFamily: 'Verdana, sans-serif',
	                        textShadow: '0 0 3px black'
	                    }
	                }
	        }]
	};

$.ajax({
	  type: 'POST',
	  url: pageContext+"/operationlog/selectEbookOperationLoginLogsByajax",
	  dataType:'json',
	  success: function(data){
		  ereblogin_options.xAxis.categories = [];
			for(var i=0;i<data.moduleCountList.length;i++){
				ereblogin_options.xAxis.categories.push(data.moduleCountList[i].name);
				ereblogin_options.series[0].data.push(data.moduleCountList[i].counts);
							}
		
		$('#ebook_login').highcharts(ereblogin_options);
		}

	});
var hotnews_options = {
	     chart: {
	            type: 'column',
	            margin: [ 50, 50, 100, 80]
	        },
	        title: {
	            text: '热点新闻点击排行'
	        },
	        xAxis: {
	            categories: [],
	             labels: {
	                    rotation: -45,
	                    align: 'right',
	                    style: {
	                        fontSize: '13px',
	                        fontFamily: 'Verdana, sans-serif'
	                    }
	                }
	        },
	        yAxis: {
	        	min:0,
	            title: {
	                text: '点击次数'
	            }
	        },
	        legend: {
	                enabled: false
	            },
	        tooltip: {
	                pointFormat: '点击 <b>{point.y} 次</b>'
	            },
	        series: [{
	            name: 'Jane',
	            data: [],
	            dataLabels: {
	                    enabled: true,
	                    rotation: -90,
	                    color: '#FFFFFF',
	                    align: 'right',
	                    x: 4,
	                    y: 10,
	                    style: {
	                        fontSize: '13px',
	                        fontFamily: 'Verdana, sans-serif',
	                        textShadow: '0 0 3px black'
	                    }
	                }
	        }]
	};

$.ajax({
	  type: 'POST',
	  url: pageContext+"/operationlog/selectEbookOperationHotNewsLogsByajax",
	  dataType:'json',
	  success: function(data){
		  hotnews_options.xAxis.categories = [];
			for(var i=0;i<data.moduleCountList.length;i++){
				hotnews_options.xAxis.categories.push(data.moduleCountList[i].content);
				hotnews_options.series[0].data.push(data.moduleCountList[i].counts);
							}
		
		$('#ebook_hotnews').highcharts(hotnews_options);
		}

	});
});
