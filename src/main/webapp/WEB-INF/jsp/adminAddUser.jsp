<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
    <title>客户添加</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/admin_register.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/jquery.uiAlertView-1.0.0.js"></script>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<div class="container-fluid">

    <!DOCTYPE html>
    <jsp:include page="adminHeader.jsp"/>

    <br><br>

    <form id="commentForm" class="form-horizontal" action="" method="post">
        <p id="warning-msg" style="color: red"></p>
        <div class="form-group">
            <label for="username-test" class="col-sm-1 control-label">用户名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="username-test" name="username" placeholder="请输入用户名" required>
            </div>
        </div>
        <div class="form-group">
            <label for="user-password" class="col-sm-1 control-label">密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="user-password" name="password" placeholder="请输入密码" required>
            </div>
        </div>
        <div class="form-group">
            <label for="user-name" class="col-sm-1 control-label">收货人</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="user-name" name="name" placeholder="请输入收货人" >
            </div>
        </div>
        <div class="form-group">
            <label for="user-phone" class="col-sm-1 control-label">电话</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="user-phone" name="userPhone" placeholder="请输入收货人电话" required>
            </div>
        </div>
        <div class="form-group">
            <label for="user-address" class="col-sm-1 control-label">地址</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="user-address" name="userAddress" placeholder="请输入收货地址" >
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button id="submit-btn" type="button" class="btn btn-success">提交保存</button>
            </div>
        </div>
    </form>

    <span style="color:red;"></span>
</div>
</body>
</html>