<%@ page import="com.hfut.zngl.entity.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/12/2
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<User> userList = (List<User>) request.getAttribute("userList");
    System.out.println("用户解："+userList.size());

%>
<!DOCTYPE html>
<html>
<head>
    <title>显示用户</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <script type="text/javascript" src="/Js/jquery.js"></script>
    <script type="text/javascript" src="/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/Js/bootstrap.js"></script>
    <script type="text/javascript" src="/Js/ckform.js"></script>
    <script type="text/javascript" src="/Js/common.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="userAction!userQuery"" method="get">
     <input type="hidden" name="queryParam" class="abc input-default" placeholder="" value="query" />&nbsp;&nbsp;
    用户名称：
    <input type="text" name="QUserName" id="rolename"class="abc input-default" placeholder=""/>&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>性别</td>
        <td>用户类型</td>
        <td>电话</td>
        <td>管理操作</td>
    </tr>
    </thead>
    <%
        if(userList.size()>0){
    %>
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
    <%}else { %>
    <tr>
        <td colspan="7" align="center" ><font color="red">无符合条件的用户！</font></td>
    </tr>
    <%}%>
</table>
</body>
</html>
