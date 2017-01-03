<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/12/3
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p align="center">编辑用户信息</p>
    <s:form action="updateUserAction" method="post">
        <div>
            <s:textfield label="用户ID" name="user.userID" value="%{#request.userID}" readonly="true"/>
        </div>

        <div>
            <s:textfield label="用户名" name="user.userName" value="%{#request.userName}"/>
        </div>
        <div>
            <s:textfield label="密码" name="user.pwd" value="%{#request.pwd}"/>
        </div>
        <div>
            <s:select  label="性别" name="user.sex" value="%{#request.sex}" list="{'男','女'}"/>
        </div>
        <div>
            <s:select label="用户类型" name="user.userType" value="%{#request.userType}" list="{'manager','professor','common'}" />
        </div>
        <div>
            <s:textfield label="电话" name="user.phone" value="%{#request.phone}"/>
        </div>
        <div>
            <s:submit value="保存" />
        </div>

    </s:form>
</body>
</html>
