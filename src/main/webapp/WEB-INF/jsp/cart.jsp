<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>

    <script type="text/javascript" src="js/cart_addItems.js"></script>
    <script src="js/common.js"></script>


</head>
<body>
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



        <h2>我的购物车</h2>



<c:forEach var="item" items="${cart.goodsList}">
        <div class="cart-header col-md-6  item  " id="good${item.goodId}">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="#">
                        <img src="${item.goodCover}" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail">${item.goodName}</a></h3>
                    <h3><span>单价: ¥ ${item.goodPrice}</span></h3>
                    <h3><span class="cart_item_num" id="${item.goodId}" >数量: ${item.goodsNum}</span></h3>
                    <a class="btn btn-info" href="#" id="btn-info${item.goodId}" onclick="addGoodNum(${item.goodId})">增加</a>
                    <a class="btn btn-warning" id="btn-warning${item.goodId}"  href="#" onclick="decGoodNum(${item.goodId})">减少</a>
                    <a class="btn btn-danger"  id="btn-danger${item.goodId}" href="#" onclick="deleteGood(${item.goodId})">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
</c:forEach>


        <div class="cart-header col-md-12">
            <hr>
            <h3 id="cart_items_totalPrices"> 订单总金额: ¥${cart.totalPricr}</h3>
            <a class="btn btn-success btn-lg" style="margin-left:74%" href="topay">提交订单</a>
        </div>


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