<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/28
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>商品编辑</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="css/bootstrap.css" />
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/adminGoodsList.js"></script>
</head>
<body>
<div class="container-fluid">




    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8"/>
    </head>
    <body>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="">蛋糕店后台</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li ><a href="orderList.action">订单管理</a></li>
                    <li ><a href="userList.action">客户管理</a></li>
                    <li class="active"><a href="goodList.action">商品管理</a></li>
                    <li ><a href="typeList.action">类目管理</a></li>
                    <li ><a href="adminRe.action">修改密码</a></li>
                    <li><a href="logout.action">退出</a></li>
                </ul>
            </div>
        </div>
    </nav>

    </body>
    </html>

    <br><br>
    <form class="form-horizontal" action="goodEditAction" method="post" enctype="multipart/form-data">
        <input type="hidden" name="goodid" value="${sessionScope.goodForEdit.goodId}"/>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="goodname" value="${sessionScope.goodForEdit.goodName}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_price" name="goodprice" value="${sessionScope.goodForEdit.goodPrice}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_info" name="goodintro" value="${sessionScope.goodForEdit.goodPrice}" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_stock" name="goodstock" value="${sessionScope.goodForEdit.goodStock}" required="required">

            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">封面图片</label>
            <div class="col-sm-6"><img src="${sessionScope.goodForEdit.goodCover}" width="100" height="100"/>
                <input type="file" name="cover"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片1</label>
            <div class="col-sm-6"><img src="${sessionScope.goodForEdit.goodImage1}" width="100" height="100"/>
                <input type="file" name="image1"  id="input_file1" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片2</label>
            <div class="col-sm-6"><img src="${sessionScope.goodForEdit.goodImage2}" width="100" height="100"/>
                <input type="file" name="image2"  id="input_file2" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="select_topic" class="col-sm-1 control-label">类目</label>
            <div class="col-sm-6">
                <select class="form-control" id="select_topic" name="goodtypeid">
                    <c:forEach var="type" items="${sessionScope.typesList}">
                        <option value="${type.typeId}">${type.typeName}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>