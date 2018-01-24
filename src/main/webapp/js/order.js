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
    $("#order" + orderId).remove();
}

// $().ready(function () {
//     $.ajax({
//         url: "orderAction",
//         type: "POST",
//         dataType: "Json",
//         success: function (respons) {
//             for(var i=0;i<respons.length;i++){
//               if(respons[i].status==1){
//                   alert("1");
//                   $(".btn-receive"+respons[i].id).attr({"disabled":"disabled"});
//               }
//               if(respons[i].status==2){
//                   alert("2");
//
//                   $(".btn-topay" + orderId).text("已付款");
//                   $(".btn-topay"+respons[i].id).attr({"disabled":"disabled"});
//               }
//                 if(respons[i].status==3){
//                     alert("3");
//
//                     $(".btn-topay" + orderId).text("已付款");
//                     $(".btn-receive" + orderId).text("已完成");
//                     $(".btn-topay"+respons[i].id).attr({"disabled":"disabled"});
//                     $(".btn-receive"+respons[i].id).attr({"disabled":"disabled"});
//                 }
//
//             }
//         },
//         error: function () {
//             alert("请求失败乐乐乐乐乐乐乐");
//         }
//     })
// });