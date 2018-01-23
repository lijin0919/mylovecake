<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript"  src="../../js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%--<script type="text/javascript" src="js/simpleCart.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="js/messages_zh.js"></script>
    <script  type="text/javascript" src="../../js/login.js"></script>
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

            <form action="#" method="post" id="login_form" class="login_form">
                <div class="register-top-grid">
                    <h3>用户登录</h3>
                    <p style="color: red" id="np-warning" align="center"></p>
                    <div class="input">
                        <span>用户名 <label style="color:red;">*</label></span>
                        <input type="text" name="login_username" placeholder="请输入用户名" id="login_username">
                    </div>
                    <div class="input">
                        <span>密码 <label style="color:red;">*</label></span>
                        <input type="text" name="login_password" placeholder="请输入密码"  id="login_password"  >
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-but text-center">
                    <input type="button" id="btn_login" value="提交">
                    <div class="clearfix"> </div>
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