<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/25
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/adminOrderList.js"></script>
</head>
<body>
<div class="container-fluid">






    <!DOCTYPE html>
<jsp:include page="adminHeader.jsp"/>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li class="active" role="presentation"><a href="#" onclick="getOrderList(0)">全部订单</a></li>
        <li  role="presentation"><a href="#"  onclick="getOrderList(1)">未付款</a></li>
        <li  role="presentation"><a href="#"  onclick="getOrderList(2)">已付款</a></li>
        <li  role="presentation"><a href="#"  onclick="getOrderList(3)">配送中</a></li>
        <li  role="presentation"><a href="#"  onclick="getOrderList(4)">已完成</a></li>
    </ul>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="5%">总价</th>
            <th width="15%">商品详情</th>
            <th width="20%">收货信息</th>
            <th width="10%">订单状态</th>
            <th width="10%">支付方式</th>
            <th width="10%">下单用户</th>
            <th width="10%">下单时间</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach var="order" items="${sessionScope.orderList}">
        <tr id="adminOrder${order.id}">
            <td><p>${order.id}</p></td>
            <td><p>${order.total}</p></td>
            <td>
                <c:forEach items="${order.goodsList}" var="good" >
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
            <td><p>${order.userName}</p></td>
            <td><p>${order.systime}</p></td>
            <td>


                <a class="btn btn-danger" href="#" onclick="deleteOrder(${order.id})">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>

    <br><div style='text-align:center;'>
    <a class='btn btn-info' disabled >首页</a>
    <a class='btn btn-info' disabled >上一页</a>
    <h2 style='display:inline;'>[1/1]</h2>
    <h2 style='display:inline;'>[3]</h2>
    <a class='btn btn-info' disabled >下一页</a>
    <a class='btn btn-info' disabled >尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/ssh_cake/admin/orderList.action?page="+(this.previousSibling.value)+""'>GO</a>
</div>
    <br>
</div>
</body>
</html>