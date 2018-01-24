<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/minicart.css">
    <link rel="stylesheet" href="css/uiAlertView-1.0.0.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript"src="js/minicart_addItems.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <!--购物车Jquery效果-->
    <script type="text/javascript"src="js/common.js"></script>
    <script src="js/jquery.uiAlertView-1.0.0.js"></script>


<%--<script>--%>
        <%--//就绪函数--%>
        <%--$().ready(function () {--%>
            var req = new XMLHttpRequest();
            <%--$(".addItem").click(function () {--%>
                <%--//设置传送方式，对应的servlet或action路径，是否异步处理--%>
                <%--req.open("POST","/index",true);--%>
                <%--//如果设置数据传送方式为post，则必须设置请求头信息--%>
                <%--req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");--%>
                <%--//设置回调函数--%>
                <%--req.onreadystatechange=callback()--%>

                <%--//设置要发送的信息--%>
                <%--// 商品图片、商品类型、商品价格、图片href属性值--%>
                <%--var reqData = "goodDetailHref="+$("#top-Good-href").attr("href");--%>
                <%--reqData+="&goodType="+${topList1[0].types.typeName};--%>
                <%--reqData+="&goodCover="+$("#top-good-pic");--%>
                <%--alert(reqData);--%>
                <%--req.send(reqData);--%>


            <%--})--%>
        <%--})--%>
    <%--</script>--%>


</head>
<body>

<%--//header--%>
<jsp:include page="header.jsp"/>
<!--//header-->

<!--banner-->

<div class="banner">
    <div class="container">
        <h2 class="hdng"><a href="detail?goodId=${topList1[0].goods.goodId}">${topList1[0].goods.goodName}</a><span></span></h2>
        <p>今日精选推荐</p>
        <a class="banner_a"href="#" onclick="addGoodToCart(${topList1[0].goods.goodId})">加入购物车</a>
        <%--<button class="banner_a addItem" value="${topList1[0].goods.goodId}">加入购物车</button>--%>
        <div class="banner-text">
            <a id="top-Good-href" href="detail?goodId=${topList1[0].goods.goodId}">
                <img id="top-good-pic" src="${topList1[0].goods.goodCover}" alt="" width="350" height="350">
            </a>
        </div>
    </div>
</div>

<!--//banner-->

<div class="subscribe2"></div>

<!--gallery-->
<div class="gallery">
    <div class="container">
        <div class="alert alert-danger">热销推荐</div>
        <div class="gallery-grids">
            <!-------------------------------热销推荐------------------------------------->
            <!--商品1-->
            <c:forEach items="${sessionScope.topList2}" var="top">
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail?goodId=${top.goods.goodId}">
                    <img src="${top.goods.goodCover}" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop"href="#" onclick="addGoodToCart(${top.goods.goodId})">加入购物车</a>

                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>${top.types.typeName} > ${top.goods.goodName}</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ ${top.goods.goodPrice}</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            </c:forEach>
        <!---------------------------新品推荐------------------------------->


        <div class="clearfix"></div>
        <div class="alert alert-info">新品推荐</div>
        <div class="gallery-grids">



            <!--推荐1-->

            <c:forEach items="${sessionScope.topList3}" var="top">
                <div class="col-md-3 gallery-grid ">
                    <a href="detail?goodId=${top.goods.goodId}">
                        <img src="${top.goods.goodCover}" class="img-responsive" alt=""/>
                    </a>
                    <div class="gallery-info">
                        <p>
                            <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            <a href="#">查看详情</a>
                        </p>
                        <a class="shop"href="#" onclick="addGoodToCart(${top.goods.goodId})">加入购物车</a>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="galy-info">
                        <p>${top.types.typeName} > ${top.goods.goodName}</p>
                        <div class="galry">
                            <div class="prices">
                                <h5 class="item_price">¥ ${top.goods.goodPrice}</h5>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>



        </div>
    </div>
</div>
<!--//gallery-->

<!--subscribe-->
<div class="subscribe"></div>
<!--//subscribe-->


<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->

</body>
</html>