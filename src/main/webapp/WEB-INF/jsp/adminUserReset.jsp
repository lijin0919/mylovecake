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
    <title>重置密码</title>
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
        <input type="hidden" id="user-id" value="${requestScope.user.id}">
        <div class="form-group">
            <label for="user-username" class="col-sm-1 control-label">用户名</label>
            <div class="col-sm-5" id="user-username">${requestScope.user.username}</div>
        </div>


        <%--原密码--%>
        <div class="form-group">
            <label for="old-password" class="col-sm-1 control-label">原密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="old-password" name="userPassword" placeholder="请输入原密码"/>
            </div>
            <p id="check-old-password-false" style="color: red"></p>
            <p id="check-old-password-true" style="color: limegreen"></p>
        </div>

        <%--新密码--%>
        <div class="form-group">
            <label for="new-password" class="col-sm-1 control-label">新密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="new-password" name="userPasswordNew" placeholder="请输入新密码"/>
            </div>
            <p id="check-new-password-false" style="color: red"></p>
        </div>





        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button id="p-submit-button" type="button" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>

    <span style="color:red;"></span>

</div>
</body>
</html>