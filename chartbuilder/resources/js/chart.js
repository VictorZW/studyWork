/*根据图表类型绘制图表*/
function drawChart(){
    //获取时间范围
    var tRange = $("#timeRange").val();
    //获取图表类型
    var chType = $("#chartType").val();
    //y轴范围
    var yMin = $("#yMin").val();
    var yMax = $("#yMax").val();
    //选择的指标
    var selectCategory = $("#selectCategory").val();
    var selectDevices =  $("#selectDevices").val();
    var selectMetrics =  $("#selectMetrics").val();

    $(".tsqueryInput").val("SELECT " + selectMetrics +" WHERE CATEGORY= "+ selectCategory +" AND IP= "+selectDevices)
    console.log("图表类型:"+chType );
    console.log("时间范围:"+tRange );
    console.log("y轴范围:"+yMin+"-"+ yMax);
    console.log("设备类型:"+selectCategory );
    console.log("选择的设备:"+selectDevices );
    console.log("选择的指标:"+selectMetrics );


    if (chType=="lineChart"){
        drawLineChart();
    }else if (chType=="columnChart"){
        drawColumnChart();
    }
}
/*绘制折线图*/
function drawLineChart() {

    /*$.ajax({
        url:"querySrvTotalTopDuration.action",
        async:true,
        dataType:"json",
        data:{"startTime":startTime,"endTime":endTime,"CHANNEL_CODE":CHANNEL_CODE,"OP_CODE":OP_CODE},
        type:"GET",
        success:function(srvTotalTop){

        }
    });*/
    $('#container').highcharts({
        credits: {
            enabled: false
        },
        title: {
            text: 'CPU 利用率折线图',
            x: -20 //center
        },
        subtitle: {
            text: '172.21.152.115',
            x: -20
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                minute: '%H:%M'
            },
            tickInterval: 1800 * 1000
        },
        yAxis: {
            title: {
                text: '利用率 (%)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '%'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name:'cpu',
            data: [29.9, 71.5, 16.4, 19.2, 14.0, 16.0, 35.6, 48.5, 26.4, 94.1, 95.6, 54.4],
            pointStart: new Date().getTime()-1800000,
            pointInterval: 600 * 1000 // one day
        }]
    });
}

/*绘制柱状图*/
function drawColumnChart() {
    $('#container').highcharts({
        credits: {
            enabled: false
        },
        chart: {
            type: 'column'
        },
        title: {
            text: 'CPU利用率柱状图'
        },
        subtitle: {
            text: '172.21.152.115'
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                minute: '%H:%M'
            },
            tickInterval: 1800 * 1000
        },
        yAxis: {
            min: 0,
            title: {
                text: '利用率 (%)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} %</b></td></tr>',
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
            name:'cpu',
            data: [29.9, 71.5, 16.4, 19.2, 14.0, 16.0, 35.6, 48.5, 26.4, 94.1, 95.6, 54.4],
            pointStart: new Date().getTime()-1800000,
            pointInterval: 600 * 1000 // one day
        }]
    });
}

/*更改时间范围*/
function changeTimeRange(data) {
    $("#timeRange").val(data);
    $("#cmsTimeRangeSelection ."+data+"min").siblings().removeClass("active");
    $("#cmsTimeRangeSelection ."+data+"min").addClass("active");
    drawChart();
}

/*更改图表类型*/
function changeChartType(data){
    $("#chartType").val(data);
    $(".chart-type-pills ."+data).siblings().removeClass("active");
    $(".chart-type-pills ."+data).addClass("active");
    drawChart();
}

/*关闭选择设备和指标的对话框*/
function closeDialog() {
    $("#metricsModal").modal('hide');
}
