<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/11/28
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>主页</title>
    <meta name="大数据环境下农业气象灾害商务智能系统" content="合肥工业大学智能管理研究所"/>
    <!-- Date: 2014-07-18 -->
    <link href="/assets1/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets1/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets1/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${sessionScope.user}</span><a href="<s:url action="hrefAction" method="loginout"/>" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">查询</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">统计</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">评估</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">预警</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">防控</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">用户管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/assets1/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/assets1/js/bui-min.js"></script>
<script type="text/javascript" src="/assets1/js/common/main-min.js"></script>
<script type="text/javascript" src="/assets1/js/config-min.js"></script>
<script type="text/javascript">
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{
            text:'灾害基本信息查询',
            items:[
                {id:'111',text:'洪涝',href:'content/queryPage/query_honglao.html'},
                {id:'112',text:'雾霾',href:'content/queryPage/query_wumai.html'},
                {id:'113',text:'干旱',href:'content/queryPage/query_ganhan.html'},
            ]},
            {text:'地区基本信息查询',
                items:[
                    {id:'121',text:'合肥',href:'content/queryPage/query_honglao.html'},
                    {id:'122',text:'蚌埠',href:'content/queryPage/query_wumai.html'},
                    {id:'123',text:'芜湖',href:'content/queryPage/query_ganhan.html'},
                ]},
           {text:'气象数据查询',
            items:[
                {id:'121',text:'降水量',href:'Node/index.html'},
                {id:'122',text:'温度',href:'Role/index.html'},
                {id:'123',text:'PM2.5',href:'User/index.html'}]}]},
            {id:'2',
                menu:[{
                    text:'数据统计',
                    items:[
                            {id:'9',text:'数据',href:'Node/index.html'}]},
                    {
                        text:'灾害统计',
                        items:[
                            {id:'9',text:'灾害',href:'Node/index.html'}]}
                ]},
            {id:'3',
                menu:[{
                    text:'数据统计',
                    items:[
                        {id:'9',text:'数据',href:'Node/index.html'}]},
                    {
                        text:'灾害统计',
                        items:[
                            {id:'9',text:'灾害',href:'Node/index.html'}]}
                ]},
            {id:'4',
                menu:[{
                    text:'数据统计',
                    items:[
                        {id:'9',text:'数据',href:'Node/index.html'}]},
                    {
                        text:'灾害统计',
                        items:[
                            {id:'9',text:'灾害',href:'Node/index.html'}]}
                ]},
            {id:'5',
                menu:[{
                    text:'数据统计',
                    items:[
                        {id:'9',text:'数据',href:'Node/index.html'}]},
                    {
                        text:'灾害统计',
                        items:[
                            {id:'9',text:'灾害',href:'Node/index.html'}]}
                ]},
            {id:'6',
                menu:[{
                    text:'选择管理项目',
                    items:[
                        {id:'61',text:'修改密码',href:'<s:url action="userAction" method="updatePWD"/>'},
                        {id:'62',text:'修改个人信息',href:'<s:url action="userAction" method="managerInfoEdit"/>'}]},

                ]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>
