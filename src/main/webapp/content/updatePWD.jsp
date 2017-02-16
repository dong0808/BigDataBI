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
    <title>修改密码</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <script type="text/javascript" src="/Js/jquery.js"></script>
    <script type="text/javascript" src="/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/Js/bootstrap.js"></script>
    <script type="text/javascript" src="/Js/ckform.js"></script>
    <script type="text/javascript" src="/Js/common.js"></script>
    <!--ajaxUtils是使用ajax来异步发送请求的文件-->
    <script type="text/javascript" src="/assets1/js/ajaxUtils.js"></script>
    <!--checkMessage是用来验证输入的js文件-->
    <script src="/assets1/js/checkMessage.js"></script>
    <!--utils是将验证的抽象方法将它抽取出来另外置于一个文件-->
    <script type="text/javascript" src="/assets1/js/utils.js"></script>
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
<form action="updatePWDAction" method="POST" class="definewidth m20">
    <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft">旧密码</td>
            <td><input type="password" name="oldPWD" onblur="checkPassword(this)"/><span id="passwordMsg" class="error"></span><br />
            </td>
        </tr>
        <tr>
            <td class="tableleft">新密码</td>
            <td><input type="password" name="newPWD1"/></td>
        </tr>
        <tr>
            <td class="tableleft">确认新密码</td>
            <td><input type="password" name="newPWD2"/></td>
        </tr>

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
