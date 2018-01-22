<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/18
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand"><a href="index.jsp">甜品店</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="index.jsp">首页</a></li>
                    <li class="dropdown navbar_type">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown">商品分类<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2 type_list">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                        <ul class="multi-column-dropdown">

                                            <c:forEach items="${sessionScope.typeList }" var="type">
                                                <li><a class="list"
                                                       href="typeGoods?goodsTypeId=${type.typeId}">${type.typeName}</a>
                                                </li>
                                            </c:forEach>


                                            <%--<li><a class="list" href="goods.jsp">法式系列</a></li>--%>

                                            <%--<li><a class="list" href="goods.jsp">儿童系列</a></li>--%>

                                            <%--<li><a class="list" href="goods.jsp">零食系列</a></li>--%>

                                            <%--<li><a class="list" href="goods.jsp">冰淇淋系列</a></li>--%>

                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li><a href="typeGoods2?goodsType=tops">热销</a></li>
                    <li><a href="typeGoods2?goodsType=news">新品</a></li>
                    <%--用户登陆显示--%>
                    <c:if test="${sessionScope.user==null}">
                        <li><a href="register">注册</a></li>
                        <li><a href="login">登录</a></li>
                    </c:if>
                    <%--用户未登录--%>
                    <c:if test="${sessionScope.user!=null}">
                        <li><a href="order">我的订单</a></li>
                        <li><a href="userCenter">个人中心</a></li>
                        <li><a href="logout">退出</a></li>
                    </c:if>


                    <li><a href="#" target="_blank">后台管理</a></li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <form class="navbar-form" action="#">
                        <input type="text" class="form-control" name="name">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button>
                    </form>
                </div>
            </div>

            <div id="cart-img" class="header-right cart">
                <a href="cart.jsp">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span
                            class="card_num">${cart.totalNum}</span></span>
                </a>
                <!--新增的点击购物车图标弹出迷你购物车窗口功能-->
                <div id="minicart-show"
                     style="width: 350px;height:auto; background-color:white;position: absolute;display: none;z-index: 99 ;">
                    <!--到顶了。。。。。-->
                    <div class="cart-order"
                         style="display: block;overflow: auto;overflow-x:hidden;width: 335px;height:520px">
                        <%--miniCart--%>
                        <ul class="list-minicart">

                        </ul>
                    </div>
                    <div class="mcart-pay clearfix">
                        <div class="pull-left" style="margin-left:10px; ">
                            共
                            <span class="glyphicon-shopping-cart" id="items_num">${cart.totalNum}</span>
                            件商品
                        </div>
                        <div class="pull-right">
                            商品小计:
                            <span class="fs-3 VI-color2" id="cart_items_totalPrice">￥${cart.totalPricr}</span>
                        </div>
                        <button id="btncart" type="button" class="btn btn-success btn-lg btn-block"
                                style="margin-right:10px; ">立即结算
                        </button>
                    </div>


                    <!--到底了。。。。。-->
                </div>
            </div>

            <%--如果用户没有登录则不显示--%>
            <c:if test="${sessionScope.user!=null}">
                <div class="header-right login">
                    <a href="userCenter"><span class="glyphicon" aria-hidden="true">${sessionScope.user.username}</span></a>
                </div>
            </c:if>

            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>
