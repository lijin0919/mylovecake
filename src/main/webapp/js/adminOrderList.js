function deleteOrder(orderId) {
    $.ajax({
        url: "deleteOrder",
        type: "POST",
        data: {id: orderId},
        dataType: "Json",
        success: function (respons) {
            if (respons > 0) {
                $("#adminOrder" + orderId).remove();
            } else {
                alert("删除失败！")
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}

function getOrderList(status) {
    alert("进入getOrderList");
    $.ajax({
        url: "orderList1",
        type: "POST",
        data: {"status": status},
        dataType: "Json",
        success: function (respons) {
            $("li").attr("class", "");
            $(this).attr("class", "active");
            var msg="<tr>\n" +
                "            <th width=\"5%\">订单编号</th>\n" +
                "            <th width=\"5%\">总价</th>\n" +
                "            <th width=\"15%\">商品详情</th>\n" +
                "            <th width=\"20%\">收货信息</th>\n" +
                "            <th width=\"10%\">订单状态</th>\n" +
                "            <th width=\"10%\">支付方式</th>\n" +
                "            <th width=\"10%\">下单用户</th>\n" +
                "            <th width=\"10%\">下单时间</th>\n" +
                "            <th width=\"10%\">操作</th>\n" +
                "        </tr>";
            for (var i=0;i<respons.length;i++) {
                msg += ""
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}