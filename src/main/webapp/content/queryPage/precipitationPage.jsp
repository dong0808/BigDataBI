<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>降水量查询</title>

    <link href="/assets1/css/bs3/dpl.css" rel="stylesheet">
    <link href="/assets1/css/bs3/bui.css" rel="stylesheet">

</head>
<body>



<div class="row" align="center">
    <div class="span24">
        <div class="panel-header"><h3 align="center"><font color="#6495ed">降水量查询</font></h3></div>
        <form id="searchForm"  action="QueryInfoAction!precipitationQuery"class="form-horizontal" tabindex="0" style="outline: none;">
            <%--<input type="hidden" name="precipitationQuery" value="pq"/>--%>
            <div class="row">
                <div class="control-group span8">
                    <label class="control-label"><s>*</s>站点名称：</label>
                    <div class="controls">
                        <select  data-rules="{required:true}"  name="type" class="input-normal">
                            <option>请选择</option>
                            <option>合肥</option>
                            <option>蚌埠</option>
                            <option>芜湖</option>
                            <option>六安</option>
                        </select>
                    </div>
                </div>

                <div class="control-group span10">
                    <label class="control-label"><s>*</s>起始日期：</label>
                    <div class="controls bui-form-group" data-rules="{dateRange : true}">
                        <input name="start" data-tip="{text : '起始日期'}" data-rules="{required:true}" data-messages="{required:'起始日期不能为空'}" class="input-small calendar" type="text"><label>&nbsp;-&nbsp;</label>
                        <input name="end" data-rules="{required:true}" data-messages="{required:'结束日期不能为空'}" class="input-small calendar" type="text">
                    </div>
                </div>
                <div class="form-actions span5">
                    <button id="btnSearch" type="submit" class="button button-primary">查询</button>
                </div>
            </div>

        </form>

    </div>
</div>
<div class="search-grid-container">
    <script src="/assets1/js/jquery-1.8.1.min.js"></script>
    <script src="/assets1/js/bui-min.js?t=201309041336"></script>
    <script type="text/javascript">
        //创建表单，表单中的日历，不需要单独初始化
        var form = new BUI.Form.HForm({
            srcNode : '#searchForm'
        }).render();

        form.on('beforesubmit',function(ev) {
            //序列化成对象
            var obj = form.serializeToObject();
            obj.start = 0; //返回第一页
            store.load(obj);
            return false;
        });
    </script>
    <!-- script end -->
</div>
</body>
</html>