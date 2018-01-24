<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!--<script type="text/javascript" src="js/simpleCart.min.js"></script>-->
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <!--点击购买，购物车添加-->
    <script type="text/javascript" src="js/cart_addItems.js"></script>
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
<div class="alert alert-dismissable alert-success" id="addSuccess" style="display: none; width: 200px; height: 50px; position: fixed;top: 30%; left: 45%; z-index: 5000;">

    <h4>
        加入购物车成功！
    </h4>
</div>
<!--products-->
<div class="products">
    <div class="container">
        <c:if test="${isSearch}">
            <h2>${goodsList[0].goodType.typeName}</h2>
        </c:if>
        <c:if test="${isSearch==null}">
            <h2>${goodsList[0].goodType.typeName}</h2>
        </c:if>


        <div class="col-md-12 product-model-sec">
            <c:forEach items="${goodsList}" var="good">
            <div class="product-grid">
                <a  href="detail?goodId=${good.goodId}">
                    <div class="more-product"><span> </span></div>
                    <div class="product-img b-link-stripe b-animate-go  thickbox">
                        <img src="${good.goodCover}" class="img-responsive" alt="夜礼服" width="240" height="240">
                        <div class="b-wrapper">
                            <h4 class="b-animate b-from-left  b-delay03">
                                <button>查看详情</button>
                            </h4>
                        </div>
                    </div>
                </a>
                <div class="product-info simpleCart_shelfItem">
                    <div class="product-info-cust prt_name">
                        <h4>${good.goodName}</h4>
                        <span class="item_price">¥ ${good.goodPrice}</span>
                        <input type="button" class="item_add items" onclick="addGoodToCart(${good.goodId});return false;" id="item_add_id>${good.goodId}" value="加入购物车">
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            </c:forEach>


            <div class="clearfix"> </div>
        </div>
        <div><div style='text-align:center;'>
            <a class='' disabled >首页</a>
            <a class='' disabled >上一页</a>
            <h2 style='display:inline;'>[1/1]</h2>
            <h2 style='display:inline;'>[6]</h2>
            <a class='' disabled >下一页</a>
            <a class='' disabled >尾页〉</a>
            <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='' onclick=''>GO</a>
        </div>
        </div>
    </div>
</div>
<!--//products-->





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