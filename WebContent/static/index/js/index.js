/**
 * Created by dxn on 2017/6/19.
 */
var menory_container = null;//内存折线对象
var cpu_av_container = null;//cpu折现对象
var window_height=0;
var ws = null;
$(function() {
	//获取页面高度
	window_height=$(document.body).height();
	memberChart();
	cpuAvChart();
	connect();
	 get_display_list();
});
/**
 * 布局
 * 
 * @param content
 */

function display_list(content) {
	var cpu_info_list = content.cpu_info_list;
	// var menory_info_list = content.menory_info_list;
	var menory_info_map = content.menory_info_map;
	var disk_info_list = content.disk_info_list;
	/*-----------cpu info------------*/
	// console.log("Highcharts:"+Highcharts.charts[0].renderTo.id);
	$
			.each(
					cpu_info_list,
					function(index, item) {
						if (index < item.size) {
							/* 判断是否存在 */
							var containerCpu = "container" + index + "";
							if ($('#' + containerCpu + '').length > 0) {
								var containerChart = null;
								// 遍历所有Highcharts 根据Highcharts.charts获取对象
								for (var i = 0; i < Highcharts.charts.length; i++) {
									// 获取对象id值
									var chartId = Highcharts.charts[i].renderTo.id;
									if (chartId == containerCpu)
										containerChart = Highcharts.charts[i];
								}
								containerChart.xAxis[0].categories
										.push(item.addTime);// x轴
								/**
								 * 新增点，获取原来点的总数判断是否需要删除第一个点
								 */
								var container_data_length = containerChart.series[0].data.length;
								if (container_data_length > 20) {
									// 第三个参数表示是否删除第一个点
									containerChart.series[0].addPoint(
											parseFloat(item.cpuUseRate), true,
											true);
								} else {
									containerChart.series[0].addPoint(
											parseFloat(item.cpuUseRate), true,
											false);
								}
							} else {
								var htmlCpu = '<div style="width:25%;float:left;"><div id ='
										+ containerCpu
										+ ' class="cpuCharts" style="width:85%;margin:0 auto;height:'+window_height*0.3+'px;"></div></div>';
								$('#title_cpu_info').append(htmlCpu);
								var containerChart = new Highcharts.Chart({
									title : {
										text : 'CPU ' + (index + 1) + '',
										x : -20
									},
									chart : {
										type : 'spline',
										renderTo : '' + containerCpu + '',
										backgroundColor:'#03091d'
									},
									xAxis : {
										visible:false,
										categories : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
									},
									yAxis : {
										title : {
											text : '使用率 (%)'
										},
										max : 100,
										min : 0,
										tickAmount : 5
									// 刻度数
									},
									tooltip : {
										valueSuffix : '%'
									},
									legend : {
										layout : 'vertical',
//										align : 'right',
//										verticalAlign : 'middle',
										borderWidth : 0
									},
									plotOptions : {
										series : {
											marker : {
												radius : 1,
											}
										},
									},
									series : [ {
										name : '使用率',
										data : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
									} ]
								});
								containerChart.xAxis[0].categories
										.push(item.addTime);// x轴
								/**
								 * 新增点，获取原来点的总数判断是否需要删除第一个点
								 */
								var container_data_length = containerChart.series[0].data.length;
								if (container_data_length > 20) {
									// 第三个参数表示是否删除第一个点
									containerChart.series[0].addPoint(
											parseFloat(item.cpuUseRate), true,
											true);
								} else {
									containerChart.series[0].addPoint(
											parseFloat(item.cpuUseRate), true,
											false);
								}
							}
						}
					});

	/*-----------cpu info------------*/
	/*-----------menory info------------*/
	var cpu_info_list_size=cpu_info_list.length;
	 menory_container.xAxis[0].categories.push(menory_info_map.add_time);
	 cpu_av_container.xAxis[0].categories.push(cpu_info_list[cpu_info_list_size-2].addTime);
	 if (menory_container.series[0].data.length>50){
	 // 第三个参数表示是否删除第一个点
	 menory_container.series[0].addPoint(parseFloat(menory_info_map.Using_Rate),
	 true, true);
	 cpu_av_container.series[0].addPoint(parseFloat(cpu_info_list[cpu_info_list_size-1].cpuUseRate),
			 true, true);
	 }else{
	 menory_container.series[0].addPoint(parseFloat(menory_info_map.Using_Rate),
	 true, false);
	 cpu_av_container.series[0].addPoint(parseFloat(cpu_info_list[cpu_info_list_size-1].cpuUseRate),
			 true, false);
	 }
	/*-----------menory info------------*/
	/*-----------disk info------------*/
	 var htmlDisk = '';
	 $.each(disk_info_list,function(index,item){
	 // alert("id len:"+$("#containerDisk"+index+"").length);
	 if($("#containerDisk"+index+"").length==0){
	 htmlDisk = '<div style="width:25%;float:left;"><div id ="containerDisk'+index+'"style="width:85%;margin:0 auto;height:'+window_height*0.3+'px;"></div></div>';
	 $('#title_disk_info').append(htmlDisk);
	 $('#containerDisk'+index+'').highcharts({
	 chart: {
	 plotBackgroundColor: null,
	 plotBorderWidth: null,
	 plotShadow: false,
	 backgroundColor:'#03091d'
	 },
	 title: {
	 text: item.diskName+'盘'
	 },
	 tooltip: {
	 headerFormat: '{series.name}<br>',
	 pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
	 },
	 plotOptions: {
	 pie: {
	 allowPointSelect: true,
	 cursor: 'pointer',
	 dataLabels: {
	 enabled: false
	 },
	 showInLegend: true
	 }
	 },
	 series: [{
	 type: 'pie',
	 // name: '盘符: C',
	 name: item.diskName+' 总内存：'+item.dbDiskTotalG+'G',
	 data: [
	 ['已使用', parseFloat(item.dbDiskUsed)],
	 ['空闲', parseFloat(item.dbDiskFree)]
	 ]
	 }]
	 });
	 }else{
	 containerDiskData = [];
	 containerDiskUsedData = [];
	 containerDiskFreeData = [];
	 containerDiskUsedData.push('已使用');
	 containerDiskUsedData.push(parseFloat(item.dbDiskUsed));
	 containerDiskFreeData.push('空闲');
	 containerDiskFreeData.push(parseFloat(item.dbDiskFree));
	 containerDiskData.push(containerDiskUsedData)
	 containerDiskData.push(containerDiskFreeData)
	 var containerDisk = "containerDisk"+index+"";
	 var containerDiskChart = null;
	 //遍历所有Highcharts 根据Highcharts.charts获取对象
	 for (var i = 0; i<Highcharts.charts.length;i++){
	 //获取对象id值
	 var chartId = Highcharts.charts[i].renderTo.id;
	 if(chartId == containerDisk)
	 containerDiskChart = Highcharts.charts[i];
	 }
	 containerDiskChart.series[0].setData(containerDiskData);
	 containerDiskChart.redraw(true);
	 }
	 });
	/*-----------disk info------------*/
}

/** 内存折线图加载 */
function memberChart() {
	$("#menory_container").css("height",window_height*0.3);
	menory_container = new Highcharts.Chart({
		// $('#menory_container').highcharts({
		// chart: {
		// type: 'area'
		// },
		chart : {
			type : 'spline',
			renderTo : 'menory_container',
			zoomType : 'x',
			backgroundColor:'#03091d'
		},
		title : {
			text : '内存使用情况'
		},
		// subtitle: {
		// text: '内存使用情况'
		// },
		subtitle : {
			text : document.ontouchstart === undefined ? '鼠标拖动可以进行缩放'
					: '手势操作进行缩放'
		},
		xAxis : {
			allowDecimals : false,
			categories : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
			visible:false,
			// 坐标轴标题
//			title : {
//				text : '时间'
//			},
			// ceiling:50//自动计算坐标轴极值的上限
			tickPixelInterval : 10
		// 设置刻度间隔为
		},
		yAxis : {
			title : {
				text : '内存占用率(%)'
			},
			max : 100,
			min : 0,
			tickAmount : 5
		// 刻度数
		},
		tooltip : {
			split : true,
			pointFormat : '{series.name} <b>{point.y:,.2f}%</b>'
		},
		plotOptions : {
			series : {
				marker : {
					radius : 1
				}
			}
		},
		series : [ {
			name : "使用内存",
			data : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
		} ]
	});
}

/** CPU均值折线图加载 */
function cpuAvChart() {
	$("#cpu_av_container").css("height",window_height*0.3);
	cpu_av_container = new Highcharts.Chart({
		// $('#menory_container').highcharts({
		// chart: {
		// type: 'area'
		// },
		chart : {
			type : 'spline',
			renderTo : 'cpu_av_container',
			zoomType : 'x',
			backgroundColor:'#03091d'
		},
		title : {
			text : 'CPU均值'
		},
		// subtitle: {
		// text: '内存使用情况'
		// },
		subtitle : {
			text : document.ontouchstart === undefined ? '鼠标拖动可以进行缩放'
					: '手势操作进行缩放'
		},
		xAxis : {
			allowDecimals : false,
			categories : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
			visible:false,
			// 坐标轴标题
//			title : {
//				text : '时间'
//			},
			// ceiling:50//自动计算坐标轴极值的上限
			tickPixelInterval : 10
		// 设置刻度间隔为
		},
		yAxis : {
			title : {
				text : '使用率(%)'
			},
			max : 100,
			min : 0,
			tickAmount : 5
		// 刻度数
		},
		tooltip : {
			split : true,
			pointFormat : '{series.name} <b>{point.y:,.2f}%</b>'
		},
		plotOptions : {
			series : {
				marker : {
					radius : 1
				}
			}
		},
		series : [ {
			name : "使用率",
			data : [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
		} ]
	});
}

function connect() {
	url = $("#url").val();
	console.log(url);
	if ('WebSocket' in window) {

		ipAddress = document.location.hostname;
		ws = new WebSocket("ws://" + url + "/handle");

	} else {

		ws = new SockJS("http://" + url + "/sockjs");

	}

	ws.onopen = function() {
	};
	ws.onmessage = function(event) {
		// alert(event.data);
		var res = eval('(' + event.data + ')');
		// display_baoxiu_count(res.list_day_report_by_hour);
		console.log(res);
		display_list(res);

	};
	ws.onclose = function(event) {
		// TODO:关闭连接
	};
}

// 断开websocket连接
function disconnect() {
	if (ws != null) {
		ws.close();
		ws = null;
	}
}
/**
 * 进入当前界面时获取
 */
 function get_display_list(){
 $.ajax({
 type:"POST",
 dataType:'json',
 url:ctx+'/monitor/sigar/list',
 // data:{
 // 'selectDate':date
 // },
 async:false,
 success:function(data){
 console.log(data);
 display_list(data);
 }
 });
 }
formatterDateHMS = function(date) {
	return date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
};
