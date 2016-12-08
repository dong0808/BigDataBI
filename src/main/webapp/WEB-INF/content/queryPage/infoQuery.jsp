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
    <title>基本信息查询</title>
</head>
<body>
<table>
    <th>灾害种类查询</th>
    <tr><td><a href="<s:url action="queryInfoAction"><s:param name="damageType">honglao</s:param></s:url>">洪涝</a></td></tr>
    <tr><td><a href="<s:url action="queryInfoAction"><s:param name="damageType">ganghan</s:param></s:url>">干旱</a></td></tr>
    <tr><td><a href="<s:url action="queryInfoAction"><s:param name="damageType">wumai</s:param></s:url>">雾霾</a></td></tr>
</table>

<table>
    <th>地区信息查询</th>
    <tr><td> <div>
        <s:select name="cityInfo" list="{'请选择','六安','蚌埠','合肥','芜湖'}" />
    </div></td></tr>
</table>

</body>
</html>
