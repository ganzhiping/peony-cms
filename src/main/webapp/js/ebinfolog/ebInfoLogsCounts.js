var pageContext;
$(function () {    
	pageContext = $("#pageContext").val();
	
	/*热点信息分析*/
	var options = {                                           
	        chart: {                                                           
	            type: 'bar'                                                    
	        },                                                                 
	        title: {                                                           
	            text: '热点信息分析'                    
	        },                                                                 
	        subtitle: {                                                        
	            text: ''                                  
	        },                                                                 
	        xAxis: {                                                           
	            categories: [],
	            title: {                                                       
	                text: ''                                                 
	            }                                                              
	        },                                                                 
	        yAxis: {                                                           
	            min: 0,                                                        
	            title: {                                                       
	                text: '点击/转发/收藏 (次数)',                             
	                align: 'high'                                              
	            },                                                             
	            labels: {                                                      
	                overflow: 'justify'                                        
	            }                                                              
	        },                                                                 
	        tooltip: {                                                         
	            valueSuffix: ' 次'                                       
	        },                                                                 
	        plotOptions: {                                                     
	            bar: {                                                         
	                dataLabels: {                                              
	                    enabled: true                                          
	                }                                                          
	            }                                                              
	        },                                                                 
	        legend: {                                                          
	            layout: 'vertical',                                            
	            align: 'right',                                                
	            verticalAlign: 'top',                                          
	            x: -40,                                                        
	            y: 100,                                                        
	            floating: true,                                                
	            borderWidth: 1,                                                
	            backgroundColor: '#FFFFFF',                                    
	            shadow: true                                                   
	        },                                                                 
	        credits: {                                                         
	            enabled: false                                                 
	        },                                                                 
	        series: [{                                                         
	            name: '点击',                                             
	            data: []                                   
	        },{                                                         
	            name: '转发',                                             
	            data: []                                   
	        },{                                                         
	            name: '收藏',                                             
	            data: []                                   
	        }]                                                                 
	    }
    
    $.ajax({
  	  type: 'POST',
  	  url: pageContext+"/ebinfolog/selectEbInfoLogsByAjax",
  	  dataType:'json',
  	  success: function(data){
  		options.xAxis.categories = [];
  			for(var i=0;i<data.ebInfoLogCountList.length;i++){
  				options.xAxis.categories.push(data.ebInfoLogCountList[i].title);
  				options.series[0].data.push(data.ebInfoLogCountList[i].clicks);
  				options.series[1].data.push(data.ebInfoLogCountList[i].forwards);
  				options.series[2].data.push(data.ebInfoLogCountList[i].collects);
  							}	
  			 $('#container').highcharts(options); 
  		}

  	});

	/*TOP100来源分布*/
	var type_options = {  
			
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    
		    title: {
		        text: 'TOP100来源分布',
		        x: -80
		    },
		    
		    pane: {
		    	size: '80%'
		    },
		    
		    xAxis: {
		        categories: [],
		        tickmarkPlacement: 'on',
		        lineWidth: 0
		    },
		        
		    yAxis: {
		        gridLineInterpolation: 'polygon',
		        lineWidth: 0,
		        min: 0
		    },
		    
		    tooltip: {
		    	shared: true,
		        pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}条</b><br/>'
		    },
		    
		    legend: {
		        align: 'right',
		        verticalAlign: 'top',
		        y: 70,
		        layout: 'vertical'
		    },
		    
		    series: [{
		        name: '信息来源',
		        data: [],
		        pointPlacement: 'on'
		    }]	
	}
							
	 $.ajax({
	  	  type: 'POST',
	  	  url: pageContext+"/ebinfolog/selectEbInfoLogsByAjaxAndType",
	  	  dataType:'json',
	  	  success: function(data){
	  		type_options.xAxis.categories = [];
	  			for(var i=0;i<data.ebInfoLogTypeCountList.length;i++){
	  				if (data.ebInfoLogTypeCountList[i].type == "1") {
	  					type_options.xAxis.categories.push("新闻");
					}else if (data.ebInfoLogTypeCountList[i].type == "2") {
						type_options.xAxis.categories.push("论坛");
					}else if (data.ebInfoLogTypeCountList[i].type == "3") {
						type_options.xAxis.categories.push("微博");
					}else if (data.ebInfoLogTypeCountList[i].type == "4") {
						type_options.xAxis.categories.push("博客");
					}else if (data.ebInfoLogTypeCountList[i].type == "5") {
						type_options.xAxis.categories.push("报刊");
					}else if (data.ebInfoLogTypeCountList[i].type == "6") {
						type_options.xAxis.categories.push("境外");
					}else if (data.ebInfoLogTypeCountList[i].type == "7") {
						type_options.xAxis.categories.push("微信");
					}
	  				type_options.series[0].data.push(data.ebInfoLogTypeCountList[i].counts);
	  							}	
	  		  $('#type_container').highcharts(type_options);
	  		}
	  	});			
	
	/*模块点击量排行*/
	var module_options = {
			
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '模块点击量排行'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	               
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ''
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:1f} 次</b></td>' +
	           '</tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '点击量',
	            data: []

	        }, {
	            name: '新闻数量',
	            data: []

	        }]   
	}
	
	 $.ajax({
	  	  type: 'POST',
	  	  url: pageContext+"/ebinfolog/selectEbInfoLogsByAjaxAndModule",
	  	  dataType:'json',
	  	  success: function(data){
	  		type_options.xAxis.categories = [];
	  			for(var i=0;i<data.ebInfoLogModuleCountList.length;i++){
	  				if (data.ebInfoLogModuleCountList[i].module == "1") {
	  					module_options.xAxis.categories.push("热点时评");
					}else if (data.ebInfoLogModuleCountList[i].module == "2") {
						module_options.xAxis.categories.push("热点新闻");
					}else if (data.ebInfoLogModuleCountList[i].module == "3") {
						module_options.xAxis.categories.push("政务动态");
					}else if (data.ebInfoLogModuleCountList[i].module == "4") {
						module_options.xAxis.categories.push("地域舆情");
					}else if (data.ebInfoLogModuleCountList[i].module == "5") {
						module_options.xAxis.categories.push("事件专题");
					}else if (data.ebInfoLogModuleCountList[i].module == "6") {
						module_options.xAxis.categories.push("定制舆情");
					}else if (data.ebInfoLogModuleCountList[i].module == "7") {
						module_options.xAxis.categories.push("舆情预警");
					}
	  				module_options.series[0].data.push(data.ebInfoLogModuleCountList[i].clicksCounts);
	  				module_options.series[1].data.push(data.ebInfoLogModuleCountList[i].counts);
	  							}	
	  			$('#module_container').highcharts(module_options);
	  		}
	  	});	
	
	/*模块转发收藏量排行*/
     var module_forwards_collects_options = {
			
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '模块转发收藏量排行'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	               
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: ''
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:1f} 次</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '收藏',
	            data: []

	        }, {
	            name: '转发',
	            data: []

	        }]   
	}
	
	 $.ajax({
	  	  type: 'POST',
	  	  url: pageContext+"/ebinfolog/selectEbInfoLogsByAjaxAndModuleAndForwardsCollects",
	  	  dataType:'json',
	  	  success: function(data){
	  		type_options.xAxis.categories = [];
	  			for(var i=0;i<data.enInfoLogMoudleForColCountList.length;i++){
	  				if (data.enInfoLogMoudleForColCountList[i].module == "1") {
	  				    module_forwards_collects_options.xAxis.categories.push("热点时评");
					}else if (data.enInfoLogMoudleForColCountList[i].module == "2") {
						module_forwards_collects_options.xAxis.categories.push("热点新闻");
					}
					else if (data.enInfoLogMoudleForColCountList[i].module == "3") {
						module_forwards_collects_options.xAxis.categories.push("政务动态");
					}
					else if (data.enInfoLogMoudleForColCountList[i].module == "4") {
						module_forwards_collects_options.xAxis.categories.push("地域舆情");
					}
					else if (data.enInfoLogMoudleForColCountList[i].module == "5") {
						module_forwards_collects_options.xAxis.categories.push("事件专题");
					}
					else if (data.enInfoLogMoudleForColCountList[i].module == "6") {
						module_forwards_collects_options.xAxis.categories.push("定制舆情");
					}
					else if (data.enInfoLogMoudleForColCountList[i].module == "7") {
						module_forwards_collects_options.xAxis.categories.push("舆情预警");
					}
	  				module_forwards_collects_options.series[0].data.push(data.enInfoLogMoudleForColCountList[i].collectsCounts);
	  				module_forwards_collects_options.series[1].data.push(data.enInfoLogMoudleForColCountList[i].forwardCounts);
	  							}	
	  			$('#module_forwards_collects_container').highcharts(module_forwards_collects_options);
	  		}
	  	});			

});                             
