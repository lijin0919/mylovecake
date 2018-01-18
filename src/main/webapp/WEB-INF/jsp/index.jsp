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
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <!--购物车Jquery效果-->
    <script src="js/minicart_addItems.js"></script>
    <link rel="stylesheet" href="css/minicart.css">
    <script src="js/common.js"></script>


</head>
<body>

<%--//header--%>
<jsp:include page="header.jsp"/>
<!--//header-->

<!--banner-->

<div class="banner">
    <div class="container">
        <h2 class="hdng"><a href="../jsp/detail.jsp">${topList[0].goods.goodName}</a><span></span></h2>
        <p>今日精选推荐</p>
        <a class="banner_a" href="detail.jsp" onclick="">立刻购买</a>
        <div class="banner-text">
            <a href="detail.jsp">
                <img src="picture/7-1.jpg" alt="" width="350" height="350">
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
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/6-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>经典系列 > 夜礼服</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--商品2-->
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/1-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>冰淇淋系列 > 草莓冰淇淋</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--商品3-->
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/2-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>经典系列 > 留恋之恋</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--商品4-->
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/3-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>经典系列 > 芒果列车</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--商品5-->
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/4-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>经典系列 > 浪漫甜心</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--商品6-->
            <div class="col-md-4 gallery-grid glry-two">
                <a href="detail.jsp">
                    <img src="picture/5-1.jpg" class="img-responsive" alt="" width="350" height="350"/>
                </a>
                <div class="gallery-info galrr-info-two">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>经典系列 > 玫瑰花园</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">￥ 299</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </div>

        <!---------------------------新品推荐------------------------------->


        <div class="clearfix"></div>
        <div class="alert alert-info">新品推荐</div>
        <div class="gallery-grids">
            <!--推荐1-->
            <div class="col-md-3 gallery-grid ">
                <a href="detail.jsp">
                    <img src="picture/12-1.jpg" class="img-responsive" alt=""/>
                </a>
                <div class="gallery-info">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>零食系列 > 蜜蜂蛋糕</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">¥ 36</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--推荐2-->
            <div class="col-md-3 gallery-grid ">
                <a href="detail.jsp">
                    <img src="picture/11-1.jpg" class="img-responsive" alt=""/>
                </a>
                <div class="gallery-info">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>零食系列 > 青森芝士条</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">¥ 36</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--推荐3-->
            <div class="col-md-3 gallery-grid ">
                <a href="detail.jsp">
                    <img src="picture/10-1.jpg" class="img-responsive" alt=""/>
                </a>
                <div class="gallery-info">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>零食系列 > 半熟芝士</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">¥ 36</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--推荐4-->
            <div class="col-md-3 gallery-grid ">
                <a href="detail.jsp">
                    <img src="picture/13-1.jpg" class="img-responsive" alt=""/>
                </a>
                <div class="gallery-info">
                    <p>
                        <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                        <a href="detail.jsp">查看详情</a>
                    </p>
                    <a class="shop" href="detail.jsp" onclick="">立刻购买</a>
                    <div class="clearfix"> </div>
                </div>
                <div class="galy-info">
                    <p>零食系列 > 玫瑰舒芙蕾</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">¥ 36</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>

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