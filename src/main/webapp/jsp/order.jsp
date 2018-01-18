<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<!DOCTYPE html>
<html>
<head>
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
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

<!--cart-items-->
<div class="cart-items">
    <div class="container">



        <h2>我的订单</h2>

        <table class="table table-bordered table-hover">

            <tr>
                <th width="10%">ID</th>
                <th width="10%">总价</th>
                <th width="20%">商品详情</th>
                <th width="20%">收货信息</th>
                <th width="10%">订单状态</th>
                <th width="10%">支付方式</th>
                <th width="10%">下单时间</th>
                <th width="10%">操作</th>
            </tr>

            <tr>
                <td><p>1</p></td>
                <td><p>598</p></td>
                <td>

                    <p>夜礼服(299) x 1</p>

                    <p>草莓冰淇淋(299) x 1</p>

                </td>
                <td>
                    <p>asdfasdf</p>
                    <p>1222222222222</p>
                    <p>sadfasdfasdfasdf</p>
                </td>
                <td>
                    <p>

                        <span style="color:red;">已付款</span>


                    </p>
                </td>
                <td>
                    <p>

                        支付宝

                    </p>
                </td>
                <td><p>2018-01-16 15:54:27</p></td>
                <td>

                </td>
            </tr>


        </table>




    </div>
</div>
<!--//cart-items-->





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