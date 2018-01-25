<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>客户列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">


<jsp:include page="adminHeader.jsp"/>


    <div class="text-right"><a class="btn btn-warning" href="toAdminAddUser">添加客户</a></div>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">用户名</th>
            <th width="10%">电话</th>
            <th width="10%">地址</th>
            <th width="10%">操作</th>
        </tr>


        <tr>
            <td><p>5</p></td>
            <td><p>maojie111</p></td>
            <td><p>13444444444</p></td>
            <td><p>点点滴滴</p></td>
            <td>
                <a class="btn btn-info" href="toAdminUserReset">重置密码</a>
                <a class="btn btn-primary" href="toAdminUserEdit">修改</a>
                <a class="btn btn-danger" href="">删除</a>
            </td>
        </tr><%--这里是要查询后循环打印的--%>




    </table>

    <br><div style='text-align:center;'>
    <a class='btn btn-info' disabled >首页</a>
    <a class='btn btn-info' disabled >上一页</a>
    <h2 style='display:inline;'>[1/1]</h2>
    <h2 style='display:inline;'>[5]</h2>
    <a class='btn btn-info' disabled >下一页</a>
    <a class='btn btn-info' disabled >尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/ssh_cake/admin/userList.action?page="+(this.previousSibling.value)+""'>GO</a>
</div>
    <br>
</div>
</body>
</html>