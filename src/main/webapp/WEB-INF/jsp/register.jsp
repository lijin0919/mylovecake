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
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!--<script type="text/javascript" src="js/simpleCart.min.js"></script>-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/register.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <style>
        .error{
            color: red;
        }
    </style>
    <!--//引入迷你购车jqery和css-->
    <script src="js/minicart_addItems.js"></script>
    <link rel="stylesheet" href="css/minicart.css">
    <script src="js/common.js"></script>
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

            <form action="actionRegister" id="commentForm" method="post">
                <div class="register-top-grid">
                    <h3>注册新用户</h3>
                    <div class="input">
                        <span>用户名 <label style="color:red;">*</label></span>
                        <input type="text" id="username-test" name="username" placeholder="请输入用户名" required/>
                    </div>
                    <div class="input">
                        <span>密码 <label style="color:red;">*</label></span>
                        <input type="text" name="password" placeholder="请输入密码" required/>
                    </div>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input type="text" name="name" placeholder="请输入收货人姓名">
                    </div>
                    <div class="input">
                        <span>收货电话<label></label></span>
                        <input type="text" name="userPhone" placeholder="请输入收货电话" required>
                    </div>
                    <div class="input">
                        <span>收货地址<label></label></span>
                        <input type="text" name="userAddress" placeholder="请输入收货地址">
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-but text-center">
                    <input class="submit" type="submit" value="提交">
                    <div class="clearfix"> </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//account-->

<!--ihihui-->



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