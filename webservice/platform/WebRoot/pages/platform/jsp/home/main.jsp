<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../common/common.jsp"%>
<script type="text/javascript"
	src="<%=basePath%>pages/platform/echarts/echarts.js"></script>
<script type="text/javascript"
	src="<%=basePath%>pages/platform/echarts/china.js"></script>
<title>首页</title>
<meta name=”viewport” content=”width=device-width, initial-scale=1″ />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript">
	$(function() {
		var chart = echarts.init(document.getElementById('main'));
		option = {
			title : {
				text : '南丁格尔玫瑰图',
				subtext : '',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				x : 'center',
				y : 'bottom',
				data : [ 'rose1', 'rose2', 'rose3', 'rose4', 'rose5', 'rose6',
						'rose7', 'rose8' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'pie', 'funnel' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			series : [ {
				name : '半径模式',
				type : 'pie',
				radius : [ 20, 110 ],
				center : [ '25%', '50%' ],
				roseType : 'radius',
				label : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				lableLine : {
					normal : {
						show : false
					},
					emphasis : {
						show : true
					}
				},
				data : [ {
					value : 10,
					name : 'rose1'
				}, {
					value : 5,
					name : 'rose2'
				}, {
					value : 15,
					name : 'rose3'
				}, {
					value : 25,
					name : 'rose4'
				}, {
					value : 20,
					name : 'rose5'
				}, {
					value : 35,
					name : 'rose6'
				}, {
					value : 30,
					name : 'rose7'
				}, {
					value : 40,
					name : 'rose8'
				} ]
			}, {
				name : '面积模式',
				type : 'pie',
				radius : [ 30, 110 ],
				center : [ '75%', '50%' ],
				roseType : 'area',
				data : [ {
					value : 10,
					name : 'rose1'
				}, {
					value : 5,
					name : 'rose2'
				}, {
					value : 15,
					name : 'rose3'
				}, {
					value : 25,
					name : 'rose4'
				}, {
					value : 20,
					name : 'rose5'
				}, {
					value : 35,
					name : 'rose6'
				}, {
					value : 30,
					name : 'rose7'
				}, {
					value : 40,
					name : 'rose8'
				} ]
			} ]
		};
		chart.setOption(option);
		var chart1 = echarts.init(document.getElementById('map'));
		chart1.setOption({
			series : [ {
				type : 'map',
				map : 'china'
			} ]
		});
		option = {
			title : {
				text : '某站点用户访问来源',
				subtext : '纯属虚构',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : [ {
					value : 335,
					name : '直接访问'
				}, {
					value : 310,
					name : '邮件营销'
				}, {
					value : 234,
					name : '联盟广告'
				}, {
					value : 135,
					name : '视频广告'
				}, {
					value : 1548,
					name : '搜索引擎'
				} ],
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		var chart2 = echarts.init(document.getElementById('bing'));
		chart2.setOption(option);
		option = {
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend : {
				data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'value'
			},
			yAxis : {
				type : 'category',
				data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
			},
			series : [ {
				name : '直接访问',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : [ 320, 302, 301, 334, 390, 330, 320 ]
			}, {
				name : '邮件营销',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : [ 120, 132, 101, 134, 90, 230, 210 ]
			}, {
				name : '联盟广告',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : [ 220, 182, 191, 234, 290, 330, 310 ]
			}, {
				name : '视频广告',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : [ 150, 212, 201, 154, 190, 330, 410 ]
			}, {
				name : '搜索引擎',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : [ 820, 832, 901, 934, 1290, 1330, 1320 ]
			} ]
		};
		var chart3 = echarts.init(document.getElementById('jindu'));
		chart3.setOption(option);
		option = {
			tooltip : {
				formatter : "{a} <br/>{b} : {c}%"
			},
			toolbox : {
				feature : {
					restore : {},
					saveAsImage : {}
				}
			},
			series : [ {
				name : '业务指标',
				type : 'gauge',
				detail : {
					formatter : '{value}%'
				},
				data : [ {
					value : 50,
					name : '完成率'
				} ]
			} ]
		};
		var chart4 = echarts.init(document.getElementById('yibiao'));
		chart4.setOption(option);

		option = {
			title : {
				text : '基础雷达图'
			},
			tooltip : {},
			legend : {
				data : [ '预算分配（Allocated Budget）', '实际开销（Actual Spending）' ]
			},
			radar : {
				// shape: 'circle',
				indicator : [ {
					name : '销售（sales）',
					max : 6500
				}, {
					name : '管理（Administration）',
					max : 16000
				}, {
					name : '信息技术（Information Techology）',
					max : 30000
				}, {
					name : '客服（Customer Support）',
					max : 38000
				}, {
					name : '研发（Development）',
					max : 52000
				}, {
					name : '市场（Marketing）',
					max : 25000
				} ]
			},
			series : [ {
				name : '预算 vs 开销（Budget vs spending）',
				type : 'radar',
				// areaStyle: {normal: {}},
				data : [ {
					value : [ 4300, 10000, 28000, 35000, 50000, 19000 ],
					name : '预算分配（Allocated Budget）'
				}, {
					value : [ 5000, 14000, 28000, 31000, 42000, 21000 ],
					name : '实际开销（Actual Spending）'
				} ]
			} ]
		};
		var chart5 = echarts.init(document.getElementById('leida'));
		chart5.setOption(option);
	});
</script>

</head>
<body>
	<div style="text-align:center"> <a href="http://echarts.baidu.com/examples.html">echarts官方网站(案例)</a> </div>
		<div id="main"
			style="float: left; height: 300px; width: 700px; border: 1px solid gray;">
		</div>
		<div id="map"
			style="float: left; height: 300px; width: 400px; border: 1px solid gray;">
		</div>
		<div id="bing"
			style="float: left; height: 300px; width: 500px; border: 1px solid gray;">
		</div>
		<div id="jindu"
			style="float: left; height: 350px; width: 700px; border: 1px solid gray;">
		</div>
		<div id="yibiao"
			style="float: left; height: 350px; width: 400px; border: 1px solid gray;">
		</div>
		<div id="leida"
			style="float: left; height: 350px; width: 500px; border: 1px solid gray;">
		</div>
	
</body>
</html>