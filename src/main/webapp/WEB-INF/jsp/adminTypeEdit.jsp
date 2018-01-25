<%--
  Created by IntelliJ IDEA.
  User: madi
  Date: 2018/1/25
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>类目编辑</title>
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

    <jsp:include page="adminHeader.jsp"/>

    </body>
    </html>

    <br><br>

    <form class="form-horizontal" action="#" method="post">
        <input type="hidden" name="type.id" value="6">
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">类目名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="type.name" value="${sessionScope.types.typeName}" required="required">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="button" class="btn btn-success" onclick="editType(${sessionScope.types.typeId})">提交修改</button>
            </div>
        </div>
    </form>

    <span style="color:red;"></span>

</div>
</body>
</html>
