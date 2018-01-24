<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/simpleCart.min.js"></script>

    <!--//引入迷你购车jqery和css-->
    <script src="js/minicart_addItems.js"></script>
    <link rel="stylesheet" href="css/minicart.css">
    <script src="js/common.js"></script>
    <script type="text/javascript" src="js/userCenter.js"></script>
    <script type="text/javascript" src="js/jquery.uiAlertView-1.0.0.js"></script>
</head>
<body>





<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>

<!--header-->
<jsp:include page="header.jsp"/>
<!--//header-->

</body>
</html>

<!--account-->
<div class="account">
    <div class="container">
        <div class="register">

            <form action="#" method="post">
                <input type="hidden" name="user.id" value="2">
                <div class="register-top-grid">
                    <h3>个人中心</h3>

                    <h4>收货信息</h4>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input id="new-user-name" type="text" name="name" value="${sessionScope.user.name}" placeholder="请输入收货人姓名">
                    </div>
                    <div class="input">
                        <span>收货电话</span>
                        <input id="new-user-phoneNum" type="text" name="usePhone" value="${sessionScope.user.userPhone}" placeholder="请输入收货电话">
                    </div>
                    <div class="input">
                        <span>收货地址</span>
                        <input id="new-user-address" type="text" name="userAddress" value="${sessionScope.user.userAddress}" placeholder="请输入收货地址">
                    </div>
                    <div class="register-but text-center">
                        <input id="npa-submit-button" type="button" value="提交">
                    </div>
                    <hr>

                    <h4>安全信息</h4>
                    <div class="input">
                        <span>原密码</span>
                        <input id="old-password" type="text" name="userPassword" placeholder="请输入原密码">
                    </div>
                    <p id="check-old-password-false" style="color: red"></p>
                    <p id="check-old-password-true" style="color: limegreen"></p>
                    <div class="input">
                        <span>新密码</span>
                        <input id="new-password" type="text" name="userPasswordNew" placeholder="请输入新密码">
                    </div>
                    <p id="check-new-password-false" style="color: red"></p>
                    <div class="clearfix"> </div>
                    <div class="register-but text-center">
                        <input id="p-submit-button" type="button" value="提交">
                    </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//account-->





<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>

<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->
</body>
</html>

</body>
</html>