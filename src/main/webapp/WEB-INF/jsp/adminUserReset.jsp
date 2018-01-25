<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-25
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <title>重置密码</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

    <!DOCTYPE html>
    <jsp:include page="adminHeader.jsp"/>

    <br><br>

    <form class="form-horizontal" action="userReset.action" method="post">
        <input type="hidden" name="user.id" value="5">
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">用户名</label>
            <div class="col-sm-5">maojie111</div>
        </div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="user.password" value="" required="required">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>

    <span style="color:red;"></span>

</div>
</body>
</html>