<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">蛋糕店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="orderList.action">订单管理</a></li>
                <li class="active"><a href="toAdminUserList">客户管理</a></li>
                <li ><a href="GoodsList">商品管理</a></li>
                <li ><a href="typeList">类目管理</a></li>
                <li ><a href="resetAdminPassword">修改密码</a></li>
                <li><a href="adminLogout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

</body>
</html>