<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>客户修改</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/admin_userInfo.js"></script>
    <script type="text/javascript" src="js/jquery.uiAlertView-1.0.0.js"></script>
</head>
<body>
<div class="container-fluid">





    <!DOCTYPE html>
    <jsp:include page="adminHeader.jsp"/>

    <br><br>

    <form class="form-horizontal" action="" method="post">
        <input id="user-id" type="hidden" name="userId" value="${requestScope.user.id}">
        <input type="hidden" name="user.username" value="${requestScope.user.username}">
        <div class="form-group">
            <label for="user-name" class="col-sm-1 control-label">用户名</label>
            <div class="col-sm-5" id="user-name">${requestScope.user.username}</div>
        </div>
        <div class="form-group">
            <label for="new-user-name" class="col-sm-1 control-label">收货人</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="new-user-name" name="name" value="${requestScope.user.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="new-user-phoneNum" class="col-sm-1 control-label">收货电话</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="new-user-phoneNum" name="userPhone" value="${requestScope.user.userPhone}">
            </div>
        </div>
        <div class="form-group">
            <label for="new-user-address" class="col-sm-1 control-label">收货地址</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="new-user-address" name="userAddress" value="${requestScope.user.userAddress}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button id="npa-submit-button" type="button" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>

    <span style="color:red;"></span>

</div>
</body>
</html>