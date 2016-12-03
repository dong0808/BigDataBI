<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/11/13
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="addUser" method="POST">
        <s:textfield name="user.userName" key="user" value=""/>
        <s:textfield name="user.pwd" key="pwd" value=""/>
        <s:select name="user.userType" key="userType" list="{'manager','professor','user'}" multiple="false"/>
        <s:submit name="addUser" key="addUser"/>
    </s:form>
+
</body>
</html>
