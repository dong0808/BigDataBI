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
<script type="text/javascript">
    function validate(){
        oldpassword = document.uptPWD.oldPWD.value;
        if(oldpassword=="")
        {
            alert("请输入原密码！");
            return false;
        }
        newpassword1 = document.uptPWD.newPWD1.value;
        if(newpassword1=="")
        {
            alert("请输入新密码！");
            return false;
        }
        if(newpassword1.length<5)
        {
            alert("密码强度不足！");
            return false;
        }
        newpassword2 = document.uptPWD.newPWD2.value;
        if(newpassword2=="")
        {
            alert("请再次输入原密码！");
            return false;
        }
        if(newpassword2.length<5)
        {
            alert("密码强度不足！");
            return false;
        }
        if(newpassword2!=newpassword1)
        {
            alert("两次输入密码不一致！");
            return false;
        }
        else{
            return true;
    }}
</script>
<form name="uptPWD" action="updatePWDAction" method="POST" class="definewidth m20" onSubmit="return validate()">
    <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft" width="200">旧密码</td>
            <td><input type="password" name="oldPWD" onblur="checkPassword(this)"/><span id="passwordMsg" class="error"></span><br /></td>
        </tr>
        <tr>
            <td class="tableleft">新密码</td>
            <td><input type="password" name="newPWD1" onblur="checkPassword1(this)"/><span id="passwordMsg1" class="error"></span><br /></td>
        </tr>
        <tr>
            <td class="tableleft">确认新密码</td>
            <td><input type="password" name="newPWD2" onblur="checkPassword2(this)"/><span id="passwordMsg2" class="error"></span><br /></td>
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
