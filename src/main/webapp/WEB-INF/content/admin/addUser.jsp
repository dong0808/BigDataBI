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
    <p align="center">添加用户</p>
    <s:form action="addUser" method="POST">
        <div>
            <s:textfield label="用户ID" name="user.userID"/>
        </div>

        <div>
            <s:textfield label="用户名" name="user.userName"/>
        </div>
        <div>
            <s:textfield label="密码" name="user.pwd"/>
        </div>
        <div>
            <s:select  label="性别" name="user.sex" list="{'男','女'}"/>
        </div>
        <div>
            <s:select label="用户类型" name="user.userType" list="{'manager','professor','common'}" />
        </div>
        <div>
            <s:textfield label="电话" name="user.phone"/>
        </div>
        <div>
            <s:submit value="提交" />
        </div>
    </s:form>
+
</body>
</html>
