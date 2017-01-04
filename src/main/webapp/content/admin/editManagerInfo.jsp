<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 东东
  Date: 2016/11/13
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sex = (String)request.getAttribute("sex");
    String type = (String)request.getAttribute("userType");

%>
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
<form action="updateUserAction!updateManager" method="POST" class="definewidth m20">
    <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft">用户ID</td>
            <td><input type="text" name="user.userID" value="<%=request.getAttribute("userID")%>" readonly="true"/></td>
        </tr>
        <tr>
            <td class="tableleft">用户名</td>
            <td><input type="text" name="user.userName" value="<%=request.getAttribute("userName")%>"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">性别</td>
            <td>
                <select id="user.sex" name="user.sex">
                    <option  value="男" <%if(sex.equals("男")){%>selected<%}%>>男</option>
                    <option  value="女" <%if(sex.equals("女")){%>selected<%}%>>女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">用户类型</td>
            <td>
                <select name="user.userType" value="<%=request.getAttribute("userType")%>">
                    <option value="manager" <%if(type.equals("manager")){%>selected<%}%>>manager</option>
                    <option value="professor" <%if(type.equals("professor")){%>selected<%}%>>professor</option>
                    <option value="common" <%if(type.equals("common")){%>selected<%}%>>common</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="tableleft">电话</td>
            <td><input type="text" name="user.phone" value="<%=request.getAttribute("phone")%>"/></td>
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
<script type="text/javascript">
    $(document).ready(function(){
        $("#user.sex").attr("value",'${requestScope.user.sex}');
    })
</script>