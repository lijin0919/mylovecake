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




        <div class="cart-header col-md-6" id="item_6">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="detail">
                        <img src="picture/6-1.jpg" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail">夜礼服</a></h3>
                    <h3><span>单价: ¥ 299</span></h3>
                    <h3><span class="cart_item_num6">数量: 1</span></h3>
                    <a class="btn btn-info" id="btn_info6" href="#">增加</a>
                    <a class="btn btn-warning" id="btn_warning6" href="#">减少</a>
                    <a class="btn btn-danger" id="btn_danger6"  href="#">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="cart-header col-md-6"  id="item_5">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="detail">
                        <img src="picture/5-1.jpg" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail">芒果列车</a></h3>
                    <h3><span>单价: ¥ 269</span></h3>
                    <h3><span class="cart_item_num5">数量: 1</span></h3>
                    <a class="btn btn-info" id="btn_info5" href="#">增加</a>
                    <a class="btn btn-warning" id="btn_warning5" href="#">减少</a>
                    <a class="btn btn-danger" id="btn_danger5" href="#">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="cart-header col-md-6"  id="item_4">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="detail">
                        <img src="picture/4-1.jpg" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail">玫瑰物语</a></h3>
                    <h3><span>单价: ¥ 299</span></h3>
                    <h3><span class="cart_item_num4">数量: 1</span></h3>
                    <a class="btn btn-info" id="btn_info4" href="#">增加</a>
                    <a class="btn btn-warning" id="btn_warning4" href="#">减少</a>
                    <a class="btn btn-danger" id="btn_danger4" href="#">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="cart-header col-md-6"  id="item_3">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="detail">
                        <img src="picture/3-1.jpg" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail">留恋之恋</a></h3>
                    <h3><span>单价: ¥ 229</span></h3>
                    <h3><span class="cart_item_num3">数量: 1</span></h3>
                    <a class="btn btn-info" id="btn_info3" href="#">增加</a>
                    <a class="btn btn-warning" id="btn_warning3" href="#">减少</a>
                    <a class="btn btn-danger" id="btn_danger3" href="#">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>


        <div class="cart-header col-md-12">
            <hr>
            <h3 id="cart_items_totalPrices"> 订单总金额: ¥1096</h3>
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