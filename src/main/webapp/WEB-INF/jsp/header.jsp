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
    <script type="text/javascript" src="../../js/jquery-3.2.1.min.js"></script>
</head>
<script>
    // function addGoodToCart(goodsId) {
    //     if (window.XMLHttpRequest) {
    //         //高版本浏览器
    //         xmlRequest = new XMLHttpRequest();
    //     } else {
    //         xmlRequest = new ActiveXObject();
    //     }
    //     xmlRequest.onreadystatechange = function () {
    //         if (xmlRequest.readyState == 4 && xmlRequest.status == 200) {
    //             alert("请求成功header！")
    //             document.getElementsByClassName("card_num").innerText  = xmlRequest.responseText;
    //         }else {
    //             alert("请求失败header！")
    //         }
    //     };
    //     xmlRequest.open("POST", "http://127.0.0.1:8080/getCartGood", true);
    //     xmlRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xmlRequest.send("goodId=1");
    // }
        // ---------------------------
        // $().ready(
            // function() {
            //     $(".banner_a").click(
                    function addGoodToCart(goodId) {
                        // var goodId = $(".banner_a").val();

                            $.ajax({
                                url : "getCartGood",
                                type:"POST",
                                data:{id:goodId},
                                dataType:"Json",


                                success : function(respons) {

                                    //请求成功，显示购物车商品数量
                                    $(".card_num").text(respons.totalNum);
                                    $("#items_num").text(respons.totalNum);
                                    $("#cart_items_totalPrice").text("￥"+respons.totalPricr);
                                        $(".list-minicart").append(
                                            " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
                                            "\n" +
                                            "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
                                            "                                    <!--左，商品图片-->\n" +
                                            "                                    <div><img  class=\"minicart_div_left\"  src=\""+respons.goodsList[respons.goodsList.length-1].goodCover+"\" alt=\"\" ></div>\n" +
                                            "                                </a>\n" +
                                            "                                <!--中，商品信息-->\n" +
                                            "                                <div class=\"minicart_div_center\">\n" +
                                            "                                    <div class=\"minicart_div_center_div\">\n" +
                                            "                                        <h5>"+respons.goodsList[respons.goodsList.length-1].goodName+"</h5>\n" +
                                            "                                    </div>\n" +
                                            "                                    <div class=\"minicart_div_center_div\">\n" +
                                            "                                        <h5>\n" +
                                            "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
                                            "                                            ￥"+respons.goodsList[respons.goodsList.length-1].goodPrice+"/礼盒\n" +
                                            "                                        </h5>\n" +
                                            "                                    </div>\n" +
                                            "                                    <div class=\"minicart_div_center_div\">\n" +
                                            "                                        <input class=\"min\" name=\"\" type=\"button\" value=\"-\" id=\"btn-warning\"/>\n" +
                                            "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\""+respons.goodsList[respons.goodsList.length-1].goodsNum+"\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
                                            "                                        <input class=\"add\" name=\"\"  type=\"button\" value=\"+\" id=\"btn-info\" onclick='fun()' />\n" +
                                            "                                    </div>\n" +
                                            "                                </div>\n" +
                                            "                                <!--右，删除按钮-->\n" +
                                            "                                <div class=\"minicart_div_right\">\n" +
                                            "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                                            "                                    <div class=\"minicart_div_center_div\"><button id=\"btn-danger6\">删除</button></div>\n" +
                                            "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                                            "                                </div>\n" +
                                            "\n" +
                                            "                            </div>"
                                        );


                                    alert("加入购物车成功！");

                                },
                                error : function() {
                                    alert("请求失败");
                                }
                            });
                    // });

            }



        // ---------------------------------
    // }
</script>
<body>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
                    <li><a href="index.jsp" >首页</a></li>
                    <li class="dropdown navbar_type">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown">商品分类<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2 type_list">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                        <ul class="multi-column-dropdown">
                                           <c:forEach items="${sessionScope.typeList }" var="type">
                                               <li><a class="list" href="typeGoods?goodsTypeId=${type.typeId}">${type.typeName}</a></li>
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
                    <li><a href="typeGoods2?goodsType=tops" >热销</a></li>
                    <li><a href="typeGoods2?goodsType=news" >新品</a></li>


                    <li><a href="order.jsp" >我的订单</a></li>
                    <li><a href="userCenter.jsp" class="active">个人中心</a></li>
                    <li><a href="index.jsp">退出</a></li>

                    <li><a href="admin/adminLogin.jsp" target="_blank">后台管理</a></li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <form class="navbar-form" action="search.action">
                        <input type="text" class="form-control" name="name">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button>
                    </form>
                </div>
            </div>

            <div id="cart-img" class="header-right cart">
                <a href="cart.jsp">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num" >${cart.totalNum}</span></span>
                </a>
                <!--新增的点击购物车图标弹出迷你购物车窗口功能-->
                <div id="minicart-show" style="width: 350px;height:auto; background-color:white;position: absolute;display: none;z-index: 99 ;">
                    <!--到顶了。。。。。-->
                    <div class="cart-order" style="display: block;overflow: auto;overflow-x:hidden;width: 335px;height:520px">
                        <%--miniCart--%>
                        <ul class="list-minicart">
                            <c:if test="${sessionScope.cart!=null}">
                                <c:forEach var="g" items="${sessionScope.cart.goodsList}">
                                <div  type="normal" class="item-in-minicart-a">

                                    <a href="detail.jsp" target="_blank">
                                        <!--左，商品图片-->
                                        <div><img  class="minicart_div_left"  src="${g.goodCover}" alt="" ></div>
                                    </a>
                                    <!--中，商品信息-->
                                    <div class="minicart_div_center">
                                        <div class="minicart_div_center_div">
                                            <h5>${g.goodName}</h5>
                                        </div>
                                        <div class="minicart_div_center_div">
                                            <h5>
                                                <!--<span class="pull-right">满额折9折</span>-->
                                                ￥${g.goodPrice}/礼盒
                                            </h5>
                                        </div>
                                        <div class="minicart_div_center_div">
                                            <input class="min" name="" type="button" value="-" id="btn-warning6"/>
                                            <input class="text_box" name="goodnum" type="text" value="1" style="width:25px;" id="cart_item_num6"/>
                                            <input class="add" name="" type="button" value="+" id="btn-info6" />
                                        </div>
                                    </div>
                                    <!--右，删除按钮-->
                                    <div class="minicart_div_right">
                                        <div class="minicart_div_center_div"></div>
                                        <div class="minicart_div_center_div"><button id="btn-danger6">删除</button></div>
                                        <div class="minicart_div_center_div"></div>
                                    </div>

                                </div>
                                </c:forEach>
                            </c:if>

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
                        <button id="btncart" type="button" class="btn btn-success btn-lg btn-block" style="margin-right:10px; ">立即结算</button>
                    </div>


                    <!--到底了。。。。。-->
                </div>
            </div>
            <div class="header-right login">
                <a href="userCenter.jsp"><span class="glyphicon" aria-hidden="true">madi</span></a>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
</body>
</html>
