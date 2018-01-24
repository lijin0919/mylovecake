function receiveGoods(orderId) {
    $.ajax({
        url: "receiveGoods",
        type: "POST",
        data: {id: orderId},
        dataType: "Json",
        success: function (respons) {
            if (respons > 0) {
                $(".paytype" + orderId).text("已完成");
                $(".btn-receive" + orderId).text("已完成");
                $(".btn-receive" + orderId).attr("disabled","disabled");
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}

function orderTopay(orderId) {
    $.ajax({
        url: "toPayNow",
        type: "POST",
        data: {id: orderId},
        dataType: "Json",
        success: function (respons) {
            if (respons > 0) {
                $(".paytype" + orderId).text("已付款");
                $(".btn-topay" + orderId).text("已支付");
                $(".btn-topay" + orderId).attr("disabled","disabled");
                $(".btn-receive" + orderId).removeAttr("disabled");
            }
        },
        error: function () {
            alert("请求失败");
        }
    });
}

function deleteOrder(orderId) {
    $.ajax({
        url: "deleteOrder",
        type: "POST",
        data: {id: orderId},
        dataType: "Json",
        success: function (respons) {
            if (respons > 0) {
                $("#order" + orderId).remove();
            }else {
                alert("删除失败！")
            }
        },
        error: function () {
            alert("请求失败");
        }
    });

}
