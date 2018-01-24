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
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%--<script src="js/twitter-bootstrap-hover-dropdown.min.js"></script>--%>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <script src="js/cart_addItems.js"></script>
    <script src="js/jquery.uiAlertView-1.0.0.js"></script>

    <script>
        $(function() {
            $('.flexslider').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
            });
        });
    </script>
    <!--//引入迷你购车jqery和css-->
    <script src="js/minicart_addItems.js"></script>
    <link rel="stylesheet" href="css/minicart.css">
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
</div>
<!--//header-->

</body>
</html>

<!--//single-page-->
<div class="single">
    <div class="container">
        <div class="single-grids">
            <div class="col-md-4 single-grid">
                <div class="flexslider">

                    <ul class="slides">
                        <li data-thumb="${requestScope.good.goodCover}">
                            <div class="thumb-image"> <img src="${requestScope.good.goodCover}" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="${requestScope.good.goodImage1}">
                            <div class="thumb-image"> <img src="${requestScope.good.goodImage1}" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <li data-thumb="${requestScope.good.goodImage2}">
                            <div class="thumb-image"> <img src="${requestScope.good.goodImage2}" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 single-grid simpleCart_shelfItem">
                <h3>${requestScope.good.goodName}</h3>
                <div class="tag">
                    <p>分类 : <a href="goods.jsp">${requestScope.good.goodType.typeName}</a></p>
                </div>
                <p>${requestScope.good.goodIntro}</p>
                <div class="galry">
                    <div class="prices">
                        <h5 class="item_price">¥ ${requestScope.good.goodPrice}</h5>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="btn_form">
                    <!--<a href="" class="add-cart item_add" onclick="buy(1)">加入购物车</a>-->
                    <a href="#" class="add-cart item_add detail_item_add" id="detail-cart-btn" onclick="addGoodToCart(${requestScope.good.goodId})">加入购物车</a>
                </div>
            </div>
            <div class="col-md-4 single-grid1">
                <!-- <h2>商品分类</h2> -->
                <ul>
                    <c:forEach items="${requestScope.typeList}" var="type">
                        <li><a href="typeGoods?goodsTypeId=${type.typeId}">${type.typeName}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>

<!--related-products--><!--
	<div class="related-products">
		<div class="container">
			<h3>猜你喜欢</h3>
			<div class="product-model-sec single-product-grids">
				<div class="product-grid single-product">
					<a href="single.html">
					<div class="more-product"><span> </span></div>
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m1.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">
						<button>View</button>
						</h4>
						</div>
					</div>
					</a>
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>
							<span class="item_price">$2000</span>
							<div class="ofr">
							  <p class="pric1"><del>$2300</del></p>
							  <p class="disc">[15% Off]</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
 -->	<!--related-products-->







<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->


</body>
</html>