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
    <link type="text/css" href="/css/bi.css"
          rel="stylesheet"/>
</head>
<body>

<div id="header">
    <div id="headerc"><span id="biaoti">大数据环境下农业气象灾害商务智能系统</span></div>
</div>
<div id="nav">

    <div id="navc1">
        <center>欢迎${sessionScope.user},<a
                href="<s:url action="hrefAction" method="loginout"/>">注销</a></center>
    </div>

    <div id="navc">
        <ul>
            <li><a href="#">查询</a>
                <ul>
                    <li><a href="http://localhost:8080/BI/webjsp/concept.jsp">基本信息查询</a></li>
                    <li><a href="http://localhost:8080/BI/webjsp/dataSearch.jsp">气象数据查询</a></li>
                </ul>
            </li>
            <li><a href="#">统计</a>
                <ul>
                    <li><a href="<s:url action="hrefAction"/>">数据统计</a></li>
                    <li><a href="<s:url action="hrefAction"/>">灾害统计</a></li>
                </ul>
            </li>
            <li><a href="<s:url action="hrefAction" method="evaluate"/>">评估</a></li>
            <li><a href="<s:url action="hrefAction" method="warn"/>">预警</a></li>
            <li><a href="<s:url action="hrefAction" method="defense"/>">防控</a></li>
            <li><a href="<s:url action="hrefAction" method="userManager"/>">用户管理</a></li>
        </ul>
    </div>
</div>
<div id="content">
    <div id="contentc">
        <div id="content_left"></div>
        <div id="content_right">
            <iframe id="reportFrame" name="reportFrame"></iframe>
        </div>
    </div>
</div>
<div id="bottom">
    <div id="bottomc"><span>Copyright © 2014 合肥工业大学 管理学院
智能管理研究所</span></div>
</div>
</body>
</html>
