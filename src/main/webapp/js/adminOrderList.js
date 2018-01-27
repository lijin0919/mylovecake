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
    $.ajax({
        url: "orderList1",
        type: "POST",
        data: {"status": status},
        dataType: "Json",
        success: function (respons) {
            $("#ordrTable").empty();
            $("li").attr("class", "");
            $(this).attr("class", "active");
            var msg = "<tr id='xiaoma'>" +
                "            <th width='5%'>订单编号</th>" +
                "            <th width='5%'>总价</th>" +
                "            <th width='15%'>商品详情</th>" +
                "            <th width='20%'>收货信息</th>" +
                "            <th width='10%'>订单状态</th>" +
                "            <th width='10%'>支付方式</th>" +
                "            <th width='10%'>下单用户</th>" +
                "            <th width='10%'>下单时间</th>" +
                "            <th width='10%'>操作</th>" +
                "        </tr>";
            $("#ordrTable").html(msg);
            respons.forEach(function (value) {
                $("#ordrTable").last().append("<tr><td><p>" + value.id + "</p></td>" +
                    "            <td><p>" + value.total + "</p></td><td></td></tr>");
                value.goodsList.forEach(function (value) {
                    $("table tr td").last().append(" <p>" + value.goodName + "(" + value.goodsNum + ")" + "x " + value.goodPrice + "</p>")
                });
                // $("#ordrTable").last().append("</tr>");
                $("table tr").last().append(
                    "            <td>" +
                    "                <p>"+value.name+"</p>" +
                    "                <p>"+value.phone+"</p>" +
                    "                <p>"+value.address+"</p>" +
                    "            </td>"
                );
                if (value.status==1){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p><span style='color:red;' class='paytype'>未付款</span></p>"+
                        "            </td>"
                    )
                }
                if (value.status==2){
                    $("table tr").last().append(
                            "            <td>" +
                            "<p><span style='color:red;' class='paytype'>已付款</span></p>"+
                            "            </td>"
                    )
                }
                if (value.status==3){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p><span style='color:red;' class='paytype'>配送中</span></p>"+
                        "            </td>"
                    )
                }
                if (value.status==4){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p><span style='color:red;' class='paytype'>已完成</span></p>"+
                        "            </td>"
                    )
                }
                if(value.paytype==1){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p>微信支付</p>"+
                        "            </td>"
                    )
                }
                if(value.paytype==2){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p>支付宝支付</p>"+
                        "            </td>"
                    )
                }
                if(value.paytype==3){
                    $("table tr").last().append(
                        "            <td>" +
                        "<p>货到付款</p>"+
                        "            </td>"
                    )
                }
                $("table tr").last().append(
                    "            <td>" +
                    "<p>"+value.userName+"</p>"+
                    "            </td>"

                );
                $("table tr").last().append(
                    "            <td>" +
                    "<p>"+value.systime+"</p>"+
                    "            </td>"
                );
                $("table tr").last().append(
                    "            <td>" +
                    " <a class='btn btn-danger' href='#' onclick=deleteOrder("+value.id+")>删除</a>"+
                    "            </td>"

                )
            })


        },
        error: function () {
            alert("请求失败");
        }
    });
}

