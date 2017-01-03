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
    <title></title>
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
<form action="addUser" method="POST" class="definewidth m20">
    <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft">用户ID</td>
            <td><input type="text" name="user.userID"/></td>
        </tr>
        <tr>
            <td class="tableleft">用户名</td>
            <td><input type="text" name="user.userName"/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="text" name="user.pwd"/></td>
        </tr>

        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <select name="user.sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">用户类型</td>
            <td>
                <select name="user.userType">
                    <option value="manager">manager</option>
                    <option value="professor">professor</option>
                    <option value="common">common</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">电话</td>
            <td><input type="text" name="user.phone"/></td>
        </tr>

        <
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">提交</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
