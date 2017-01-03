<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/12/5
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
    <p>密码修改</p>
    <s:form action="updatePWDAction" method="post">
        <div>
            <s:textfield label="旧密码" name="oldPWD"/>
        </div>

        <div>
            <s:textfield label="新密码" name="newPWD1"/>
        </div>

        <div>
            <s:textfield label="确认新密码" name="newPWD2"/>
        </div>

        <div>
            <s:submit value="提交" />
        </div>

    </s:form>
</body>
</html>
