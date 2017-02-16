<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/11/29
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>气象数据查询</title>
</head>

<body>
<table>
    <th>选择查询指标</th>
    <tr><td><a href="<s:url action="hrefAction" method="precipitationQuery"></s:url>">降水量</a></td></tr>
    <tr><td><a href="<s:url action="hrefAction" method="tempQuery"></s:url>">温度</a></td></tr>
    <tr><td><a href="<s:url action="hrefAction" method="pmQuery"></s:url>">PM2.5</a></td></tr>
    <tr><td><a href="<s:url action="hrefAction" method="coQuery"></s:url> ">CO</a> </td></tr>
    <tr><td><a href="<s:url action="hrefAction" method="noQuery"></s:url> ">NO</a> </td></tr>
</table>

</body>
</html>
