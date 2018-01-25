<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/25
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>类目列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/adminType.js"></script>
</head>
<body>
<div class="container-fluid">





    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8"/>
    </head>
    <body>

    <!DOCTYPE html>
    <jsp:include page="adminHeader.jsp"/>

    </body>
    </html>

    <br>

    <div>
        <form class="form-inline" method="post" action="#">
            <input type="text" class="form-control" id="input_name" name="type.name" placeholder="输入类目名称" required="required" style="width: 500px">
            <input type="button" class="btn btn-warning" value="添加类目" onclick="typeSave()"/>
        </form>
    </div>

    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">名称</th>
            <th width="10%">操作</th>
        </tr>

        <c:forEach var="type" items="${sessionScope.typeList}">
        <tr>
            <td><p>${type.typeId}</p></td>
            <td><p>${type.typeName}</p></td>
            <td>
                <a class="btn btn-primary" href="toEditType?typeId=${type.typeId}" >修改</a>
                <a class="btn btn-danger" href="#"  onclick="typeDelete(${type.typeId})">删除</a>
            </td>
        </tr>
        </c:forEach>



    </table>

</div>
</body>
</html>