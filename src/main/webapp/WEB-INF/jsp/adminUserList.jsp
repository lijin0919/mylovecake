<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>客户列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/additional-methods.js"></script>
    <script type="text/javascript" src="js/admin_userInfo.js"></script>
    <script src="js/jquery.uiAlertView-1.0.0.js"></script>
</head>
<body>
<div class="container-fluid">


<jsp:include page="adminHeader.jsp"/>


    <div class="text-right"><a class="btn btn-warning" href="toAdminAddUser">＋ 添加客户</a></div>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">用户名</th>
            <th width="10%">电话</th>
            <th width="10%">地址</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach items="${requestScope.userList}" var="user">
            <tr id="dlt-user-id${user.id}">
                <td><p>${user.id}</p></td>
                <td><p>${user.username}</p></td>
                <td><p>${user.userPhone}</p></td>
                <td><p>${user.userAddress}</p></td>
                <td>
                    <a class="btn btn-info" href="toAdminUserReset?userId=${user.id}">重置密码</a>
                    <a class="btn btn-primary" href="toAdminUserEdit?userId=${user.id}">修改</a>
                    <a id="delete-user-button" class="btn btn-danger" href="javascript:deleteUser(${user.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
        <%--这里是要查询后循环打印的--%>

    </table>

    <br><div style='text-align:center;'>
    <a class='btn btn-info' disabled >首页</a>
    <a class='btn btn-info' disabled >上一页</a>
    <h2 style='display:inline;'>[1/1]</h2>
    <h2 style='display:inline;'>[5]</h2>
    <a class='btn btn-info' disabled >下一页</a>
    <a class='btn btn-info' disabled >尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/ssh_cake/admin/userList.action?page="+(this.previousSibling.value)+""'/>GO</a>
</div>
    <br>
</div>
</body>
</html>