<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>降水量查询</title>

    <link href="/assets1/css/bs3/dpl.css" rel="stylesheet">
    <link href="/assets1/css/bs3/bui.css" rel="stylesheet">

</head>
<body>
<


<div class="row" align="center">
    <div class="span24">
        <div class="panel-header"><h3 align="center"><font color="#6495ed">降水量查询</font></h3></div>
        <form id="searchForm"   class="form-horizontal" tabindex="0" style="outline: none;">
            <%--<input type="hidden" name="precipitationQuery" value="pq"/>--%>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>站点名称：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="station_name" class="input-normal">
                            <option>请选择</option>
                            <option value="合肥">合肥</option>
                            <option value="蚌埠">蚌埠</option>
                            <option value="芜湖">芜湖</option>
                            <option value="六安">六安</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span10">
                    <label class="control-label"><s>*</s>起始日期：</label>
                    <div class="controls bui-form-group" data-rules="{dateRange : true}">
                        <input name="startDate" data-tip="{text : '起始日期'}" data-rules="{required:true}" data-messages="{required:'起始日期不能为空'}" class="input-small calendar" type="text"><label>&nbsp;-&nbsp;</label>
                        <input name="endDate" data-rules="{required:true}" data-messages="{required:'结束日期不能为空'}" class="input-small calendar" type="text">
                    </div>
                </div>
                <div class="form-actions span5">
                    <button  id="btnSearch1" type="button" class="button button-primary" >查询</button>
                </div>
            </div>

        </form>

    </div>
</div>
<div id="MyChart" align="center" style="width: 1000px;height:700px;margin-top: 20px;margin-left: 40px">

</div>
    <script src="/assets1/js/jquery-1.8.1.min.js"></script>
    <script src="/assets1/js/bui-min.js"></script>
     <script src="/assets/echart/echarts.js"></script>
    <script type="text/javascript">
        //创建表单，表单中的日历，不需要单独初始化
        var form = new BUI.Form.HForm({
            srcNode : '#searchForm'
        }).render();

    </script>
 <script type="text/javascript">
        $(document).ready(function () {
            $("#btnSearch1").click(function () {
                var formData = $("#searchForm").serialize();
                console.log(formData);
                $.ajax({
                    url:'queryDataAction!precipitationQuery',
                    type:'POST',
                    data:formData,
                    dataType:'json',
                    success:function (data) {
                        var d = eval(data);
                        console.log(d);
                       mychart(d[0].dateResult,d[0].preResult,d[0].stationName);
                    },
                    error:function () {
                        alert("出错了的！！");
                    }

                });
            });});

            function mychart(dData,pData,sName) {
                var myChart = echarts.init(document.getElementById('MyChart'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: sName,

                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    tooltip: {},
                    legend: {
                        data:['降水量']
                    },
                    xAxis: {
                        data: dData
                    },
                    yAxis: {},
                    series: [{
                        name: '降水量',
                        type: 'bar',
                        data: pData
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);


            }

    </script>


</body>
</html>