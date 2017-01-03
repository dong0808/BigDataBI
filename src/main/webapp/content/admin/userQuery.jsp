<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/12/2
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <th align="center">用户信息列表</th>
        <tr>
            <td>编号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>性别</td>
            <td>用户类型</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <s:iterator value="#request.userList" var="user">
            <s:push value="#user">
            <tr>
                <td><s:property value="userID"/></td>
                <td><s:property value="userName"/></td>
                <td><s:property value="pwd"/></td>
                <td><s:property value="sex"/></td>
                <td><s:property value="userType"/></td>
                <td><s:property value="phone"/></td>
                <td><a href="<s:url action='userAction' method='userEdit'>
                <s:param name="userID" value="userID"/></s:url>">编辑</a>
                    <a href="<s:url action="userAction" method="userDelete">
                    <s:param name="userID" value="userID"/></s:url>">删除</a></td>

            </tr>
            </s:push>
        </s:iterator>
    </table>

</body>
</html>
