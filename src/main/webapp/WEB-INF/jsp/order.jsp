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
    <script src="js/order.js"></script>

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
                <th width="10%">订单编号</th>
                <th width="10%">总价</th>
                <th width="20%">商品详情</th>
                <th width="20%">收货信息</th>
                <th width="10%">订单状态</th>
                <th width="10%">支付方式</th>
                <th width="10%">下单时间</th>
                <th width="10%">操作</th>
            </tr>
            <c:forEach var="order" items="${sessionScope.orderList}">
                <tr id="order${order.id}">
                    <td><p>${order.id}</p></td>
                    <td><p>${order.total}</p></td>
                    <td>
                        <c:forEach var="good" items="${order.goodsList}">
                            <p>${good.goodName}(${good.goodPrice}) x ${good.goodsNum}</p>
                        </c:forEach>
                    </td>
                    <td>
                        <p>${order.name}</p>
                        <p>${order.phone}</p>
                        <p>${order.address}</p>
                    </td>
                    <td>
                        <p>
                            <c:if test="${order.status==1}" >
                            <span style="color:red;" class="paytype${order.id}">未付款</span>
                            </c:if>
                            <c:if test="${order.status==2}">
                                <span style="color:red;" class="paytype${order.id}">已付款</span>
                            </c:if>
                            <c:if test="${order.status==3}">
                                <span style="color:red;" class="paytype${order.id}">配送中</span>
                            </c:if>
                            <c:if test="${order.status==4}">
                                <span style="color:red;" class="paytype${order.id}">已完成</span>
                            </c:if>

                        </p>
                    </td>
                    <td>
                        <p>
                            <c:if test="${order.paytype==1}">
                                微信支付
                            </c:if>
                            <c:if test="${order.paytype==2}">
                                支付宝支付
                            </c:if>
                            <c:if test="${order.paytype==3}">
                                货到付款
                            </c:if>

                        </p>
                    </td>
                    <td><p>2018-01-24 11:54:27</p></td>
                    <td>
                        <c:if test="${order.status==1}">
                        <button style="display: inline" class="btn-topay${order.id}" onclick="orderTopay(${order.id}) ">立即支付</button>
                            <button style="display: inline"  class="btn-receive${order.id}" onclick="receiveGoods(${order.id})  "disabled="disabled">确认收货</button>
                        </c:if>
                        <c:if test="${order.status==2}">
                            <button style="display: inline" class="btn-topay${order.id}" onclick="orderTopay(${order.id}) " disabled="disabled">已支付</button>
                            <button style="display: inline"  class="btn-receive${order.id}" onclick="receiveGoods(${order.id}) ">确认收货</button>
                        </c:if>
                        <c:if test="${order.status==4}">
                            <button style="display: inline" class="btn-topay${order.id}" onclick="orderTopay(${order.id}) " disabled="disabled">已支付</button>
                            <button style="display: inline"  class="btn-receive${order.id}" onclick="receiveGoods(${order.id}) ">已完成</button>
                        </c:if>
                        <%--<button style="display: inline"  class="btn-delete${order.id}"onclick="deleteOrder(${order.id})">删除</button>--%>

                    </td>
                </tr>
            </c:forEach>

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