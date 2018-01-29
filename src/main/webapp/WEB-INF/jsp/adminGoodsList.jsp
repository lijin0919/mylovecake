<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/26
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/adminGoodsList.js"></script>
</head>
<body>
<div class="container-fluid">


    <jsp:include page="adminHeader.jsp"/>



    <div class="text-right"><a class="btn btn-warning" href="goodAdd">添加商品</a></div>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li class="active" role="presentation"><a href="GoodsList">全部商品</a></li>
        <li  role="presentation"><a href="#" onclick="toTopList(1)">条幅推荐</a></li>
        <li  role="presentation"><a href="#" onclick="toTopList(2)">热销推荐</a></li>
        <li  role="presentation"><a href="#" onclick="toTopList(3)">新品推荐</a></li>
    </ul>





    <br>

    <table class="table table-bordered table-hover" id="goodsTable">

        <tr>
            <th width="5%">商品Id</th>
            <th width="10%">图片</th>
            <th width="10%">名称</th>
            <th width="20%">介绍</th>
            <th width="10%">价格</th>
            <th width="10%">类目</th>
            <th width="25%">操作</th>
        </tr>
        <c:forEach var="good" items="${sessionScope.goodsPage.goodsList}">
        <tr id="good${good.goodId}">
            <td><p>${good.goodId}</p></td>
            <td><p><a href="../index/detail.action?goodid=14" target="_blank"><img src="..//${good.goodCover}" width="100px" height="100px"></a></p></td>
            <td><p><a href="../index/detail.action?goodid=14" target="_blank">${good.goodName}</a></p></td>
            <td><p>${good.goodIntro}</p></td>
            <td><p>${good.goodPrice}</p></td>
            <td><p>${good.goodType.typeName}</p></td>
            <td>
                <p>
                    <c:if test="${good.topScroll}"><a class="btn btn-info" href="#" onclick="topDeleteA(${good.goodId},1,${sessionScope.goodsPage.currentPage}">移出条幅</a></c:if>
                    <c:if test="${!good.topScroll}"><a class="btn btn-primary" href="#" onclick="topSaveA(${good.goodId},1,${sessionScope.goodsPage.currentPage})">加入条幅</a></c:if>
                    <c:if test="${good.topLarge}"><a class="btn btn-info" href="#" onclick="topDeleteA(${good.goodId},2,${sessionScope.goodsPage.currentPage})">移出热销</a></c:if>
                    <c:if test="${!good.topLarge}"><a class="btn btn-primary" href="#" onclick="topSaveA(${good.goodId},2,${sessionScope.goodsPage.currentPage})">加入热销</a></c:if>
                    <c:if test="${good.topSmall}"><a class="btn btn-info" href="#" onclick="topDeleteA(${good.goodId},2,${sessionScope.goodsPage.currentPage})">移出新品</a></c:if>
                    <c:if test="${!good.topSmall}"><a class="btn btn-primary" href="#" onclick="topSaveA(${good.goodId},2,${sessionScope.goodsPage.currentPage})">加入新品</a></c:if>
                </p>
                <a class="btn btn-success" href="goodEdit?goodId=${good.goodId}">修改</a>
                <a class="btn btn-danger" href="#" onclick="adminGoodDelete(${good.goodId})">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>

    <br><div style='text-align:center;'>
    <input type="hidden" id="totalNum" value="${sessionScope.goodsPage.totalPage}"/>
    <a class='btn btn-info'  id="first"  href="#" onclick="firstAndLastPage(${1})">首页</a>
    <a class='btn btn-info'  id="before" href="#"  onclick="beforePage(${sessionScope.goodsPage.currentPage})">上一页</a>
    <h2 style='display:inline;' id="nums">[${sessionScope.goodsPage.currentPage}/${sessionScope.goodsPage.totalPage}]</h2>
    <a class='btn btn-info' href='#' id="next" onclick="nextPage(${sessionScope.goodsPage.currentPage})">下一页</a>
    <a class='btn btn-info' href='#' id="last" onclick="firstAndLastPage(${sessionScope.goodsPage.totalPage})">尾页</a>
    <input type='text' id="pageNum" class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='#' onclick='gotoPage()'>GO</a>
</div>
    <br>
</div>
</body>
</html>
