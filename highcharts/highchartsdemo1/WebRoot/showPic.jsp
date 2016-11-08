<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>Highcharts-曲线图示例</title>
<!-- 以下是绘制曲线图需要引入的js文件 -->
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.min.js"></script>
<script src="<%=path%>/js/highcharts.js"></script>
<script src="<%=path%>/js/modules/exporting.js"></script>
<!-- 绘制曲线图的代码 -->
<script type="text/javascript">

var ydt;
/* 1.从后台获取数据的方法 */
function getData(){
	$.ajax({
		type:"GET",
		dataType:"json",
		/* async: false,  */
		url:"createdata",
		success:function(data){
			chart.series[0].addPoint([data.x,data.y], true, true);
			ydt = data.y;
		}
	});
	/* alert("ydt---"+ydt); */
	return ydt;
}
/* 2.绘制图像的方法 */
function drawPic(){
	  Highcharts.setOptions({
	      global: {
	        useUTC: false
	      }
	    });
	    //创建曲线图对象
	    chart = new Highcharts.Chart({
	      chart: {
	        renderTo: 'container',
	        defaultSeriesType: 'spline',
	        marginRight: 10
	      },
	      title: {
	        text: '动态曲线图'
	      },
	      xAxis: {
	        title: {
	          text: '时间'
	        },
	        type: 'datetime',
	        tickPixelInterval: 150
	      },
	      yAxis: {
	        title: {
	          text: '数值'
	        },
	        plotLines: [
	          {
	            value: 0,
	            width: 1,
	            color: '#808080'
	          }
	        ]
	      },
	      //dateFormat,numberFormat是highCharts的工具类
	      tooltip: {
	        formatter: function() {
	          return '<b>' + this.series.name + '</b><br/>' +
	                  Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
	                  Highcharts.numberFormat(this.y, 4);
	        }
	      },
	      credits:{
	          enabled:false
	      },
	      legend: {
	        enabled: false
	      },
	      exporting: {
	        enabled: false
	      },
	      //放入数据
	      series: [
	        {
	          name: 'xxx',
	          data: (function() {
	            // 初始化数据
	            var data = [],
	                    time = (new Date()).getTime(),
	                    i;
	           /*  alert(ydt+"++++"); */
	            for (i = -9; i <= 0; i++) {
	              data.push({
	                x: time + i * 1000,
	                y: ydt
	              });
	            }
	            return data;
	          })()
	        }
	      ]
	    });
	  getData();  
}
</script>
<script type="text/javascript">
 $(document).ready(function(){
	/* alert(getData()+"----get"); */
	getData();
	drawPic();
	setInterval("getData()", 1000);
 });
</script>
</head>
<body>
	<div id="container" style="width: 610px; height: 400px; margin: 0 auto"></div>
</body>
</html>
