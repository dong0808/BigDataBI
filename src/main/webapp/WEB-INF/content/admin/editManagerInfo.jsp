<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/12/5
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改管理员信息</title>
</head>
<body>
    <p align="center">编辑管理员信息</p>
    <s:form action="updateUserAction!updateManager" method="post">
        <div>
            <s:textfield label="用户ID" name="user.userID" value="%{#request.userID}" readonly="true"/>
        </div>
        <div>
            <s:textfield label="用户名" name="user.userName" value="%{#request.userName}"/>
        </div>
        <div>
            <s:select label="性别" name="user.sex" value="%{#request.sex}" list="{'男','女'}"/>
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
