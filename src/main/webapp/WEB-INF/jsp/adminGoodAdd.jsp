<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/27
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
    <title>商品添加</title>
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

    <jsp:include page="adminHeader.jsp"/>

    </body>
    </html>

    <br><br>
    <form class="form-horizontal" action="goodAddAction" method="post" enctype="multipart/form-data" id="addGoodId">
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="goodname" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">价格</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_price" name="goodprice" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">介绍</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_info" name="goodintro" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">库存</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_stock" name="goodstock" required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">封面图片</label>
            <div class="col-sm-6">
                <input type="file" name="cover"  id="input_file" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片1</label>
            <div class="col-sm-6">
                <input type="file" name="image1"  id="input_file1" required="required">推荐尺寸: 500 * 500
            </div>
        </div>
        <div class="form-group">
            <label for="input_file" class="col-sm-1 control-label">详情图片2</label>
            <div class="col-sm-6">
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
                <button type="submit" class="btn btn-success" >提交保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
