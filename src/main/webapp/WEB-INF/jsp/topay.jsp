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
    <title>支付</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>

    <!--//引入迷你购车jqery和css-->
    <script src="js/minicart_addItems.js"></script>
    <link rel="stylesheet" href="css/minicart.css">
    <script src="js/common.js"></script>
    <script src="js/topay.js"></script>
    <script src="js/jquery.uiAlertView-1.0.0.js"></script>

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
<div class="cart-items">
    <div class="container">
        <h2>确认收货信息</h2>
        <form class="form-horizontal" action="#" method="post" id="payform">
            <input type="hidden" name="order.id" value="3">
            <input type="hidden" name="order.paytype" id="paytype">
            <div class="row">
                <label class="control-label col-md-1">收货人</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.name" value="${sessionScope.order.name}" style="height:auto;padding:10px;" placeholder="输入收货人" required="required"><br>
                </div>
            </div>
            <div class="row">
                <label class="control-label col-md-1">收货电话</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.phone" value="${sessionScope.order.phone}" style="height:auto;padding:10px;" placeholder="输入收货电话" required="required"><br>
                </div>
            </div>
            <div class="row">
                <label class="control-label col-md-1">收货地址</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.address" value="${sessionScope.order.address}" style="height:auto;padding:10px;" placeholder="输入收货地址" required="required"><br>
                </div>
            </div>
        </form>

        <br><hr><br>

        <h2>选择支付方式</h2>
        <h3>订单编号: ${sessionScope.order.id}  支付金额￥: ${sessionScope.order.total}</h3><br><br>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="#" >
                    <img src="images/wechat.jpg" id="weChatPay" alt="微信支付">
                </a>
            </div>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="#">
                    <img src="images/alipay.jpg"  id="zfbPay" alt="支付宝支付">
                </a>
            </div>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="#" id="payWhenReceive">
                    <img src="images/offline.jpg" alt="货到付款">
                </a>
            </div>
        </div>
    </div>
</div>





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

<script type="text/javascript">
    function dopay(paytype){
        $("#paytype").val(paytype);
        $("#payform").submit();
    }
</script>

</body>
</html>