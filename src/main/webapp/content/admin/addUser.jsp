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
    <meta charset="UTF-8"/>
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
<script src="/assets1/js/jquery-1.8.1.min.js"></script>

<script type="text/javascript">
    function validate(){
        var inputList = document.getElementsByTagName("input");

        for(i=0;i<inputList.length;i++) {
            console.log(inputList[i].value);
        }
        userid = inputList[0].value;
        if(userid =="")
        {
            alert("请输入用户编号！");
            return false;
        }
        if(uesrid.length<3)
        {
            alert("用户编号格式错误！");
            return false;
        }
        username = inputList[1].value;
        if(username =="")
        {
            alert("请输入用户名！");
            return false;
        }
        password = inputList[2].value;
        if(password =="")
        {
            alert("请输入密码！");
            return false;
        }
        if(password.length<5)
        {
            alert("密码强度不足！");
            return false;
        }
        tel = inputList[3].value;
        if(tel == "")
        {
            alert("请输入电话号码！");
            return false;
        }
        if(tel.length<11)
        {
            alert("请输入正确的电话格式！");
            return false;
        }
        else {
            return true;
        }
    }
</script>
<form id="adduser" name="addUser" action="addUser" method="POST" class="definewidth m20" onSubmit="return validate()">
    <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft">用户ID</td>
            <td><input type="text" name="user.userID" onblur="checkUserId(this)"/><span id="userIdMsg" class="error"></span><br/></td>
        </tr>
        <tr>
            <td class="tableleft">用户名</td>
            <td><input type="text" name="user.userName" value="" onblur="checkUsername(this)"/><span id="usernameMsg" class="error"></span><br/></td>
        </tr>
        <tr>
            <td class="tableleft">密码</td>
            <td><input type="password" name="user.pwd" value="" onblur="checkPassword(this)"/><span id="passwordMsg" class="error"></span><br/></td>
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
            <td><input type="text" name="user.phone"onblur="checkPhone(this)"/><span id="phoneMsg" class="error"></span><br/></td>
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
