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
    <title>用户管理</title>
</head>
<body>
<table>
    <th>选择管理项目</th>
    <tr><td><a href="<s:url action="userAction" method="managerInfoEdit"/>">修改个人信息</a></td></tr>
    <tr><td><a href="<s:url action="userAction" method="updatePWD"/>">修改密码</a></td></tr>
</table>

</body>
</html>
