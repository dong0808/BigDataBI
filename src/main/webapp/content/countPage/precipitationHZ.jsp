<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>降水量汇总</title>

    <link href="/assets1/css/bs3/dpl.css" rel="stylesheet">
    <link href="/assets1/css/bs3/bui.css" rel="stylesheet">

</head>
<body>
<


<div class="row" align="center">
    <div class="span24">
        <div class="panel-header"><h3 align="center"><font color="#6495ed">降水量汇总信息查询</font></h3></div>
        <form id="searchForm"   class="form-horizontal" tabindex="0" style="outline: none;">
            <%--<input type="hidden" name="precipitationQuery" value="pq"/>--%>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>地市名称：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="cityName" class="input-normal" id="citySelect">
                            <option>请选择</option>
                            <option value="合肥">合肥</option>
                            <option value="蚌埠">蚌埠</option>
                            <option value="芜湖">芜湖</option>
                            <option value="六安">六安</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span8">
                    <label class="control-label"><s>*</s>起始年份：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="startYear" class="input-normal">
                            <option>请选择</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span8">
                    <label class="control-label"><s>*</s>开始月份：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="startMonth" class="input-normal">
                            <option>请选择</option>
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span8">
                    <label class="control-label"><s>*</s>结束年份：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="endYear" class="input-normal">
                            <option>请选择</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span8">
                    <label class="control-label"><s>*</s>结束月份：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="endMonth" class="input-normal">
                            <option>请选择</option>
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                    </div>
                </div>


                <div class="form-actions span5">
                    &nbsp;&nbsp;<button  id="btnSearch1" type="button" class="button button-primary" >查询</button>
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
        $(document).ready(function () {
            $("#btnSearch1").click(function () {
                var formData = $("#searchForm").serialize();
                console.log(formData);
                $.ajax({
                    url:'countAction!precipitationHZ',
                    type:'POST',
                    data:formData,
                    dataType:'json',
                    success:function (data) {
                        var d = eval(data);
                        console.log(d);
                       mychart(d[0].HZ,d[0].sName,d[0].total);
                    },
                    error:function () {
                        alert("出错了的！！");
                    }

                });
            });});

            function mychart(HZ,sName,total) {
                var myChart = echarts.init(document.getElementById('MyChart'));
                var arrayData = new Array(HZ.length);
                for(var i in HZ){
                    people ={
                        value:HZ[i],
                        name:sName[i]
                    };
                    arrayData[i] = people;
                }


                // 指定图表的配置项和数据
                option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data:sName
                    },
                    series: [
                        {
                            name:'站点名称',
                            type:'pie',
                            selectedMode: 'single',
                            radius: [0, '30%'],

                            label: {
                                normal: {
                                    position: 'inner'
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data:[
                                {value:total, name:'地市总的降水量之和', selected:true},

                            ]
                        },
                        {
                            name:'站点名称',
                            type:'pie',
                            radius: ['40%', '55%'],

                            data:arrayData
                        }
                    ]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);


            }

    </script>

</body>
</html>