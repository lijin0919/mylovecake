<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/24
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/minicart.css">
    <link rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <!--购物车Jquery效果-->

    <script type="text/javascript"src="js/common.js"></script>
    <script type="text/javascript" src="js/adminLogin.js"></script>

</head>

<!-- 设置背景图片 -->
<body style="background-image:url(/admin/img/bg.jpg);background-size:100%;">

<div class="container">



    <form class="form-horizontal" style="margin-top:15%;" action="#">
        <h2 class="text-center">登录后台</h2>
        <p style="color: red" id="np-warning" align="center"></p>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="text" class="form-control" style="height:auto;padding:10px;" placeholder="输入用户名" name="admin.username" value="" id="username">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="password" class="form-control" style="height:auto;padding:10px;" placeholder="输入密码" name="admin.password" value=""id="password">
            </div>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <input class="btn btn-lg btn-primary btn-block" type="button" id="adminLogin">登录</input>
        </div>
    </form>

</div>

</body>
</html>
