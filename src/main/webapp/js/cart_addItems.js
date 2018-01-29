$().ready(function () {
    //《-----------------购物车-----------------》

    $(".detail_item_add").click(function () {
        var json = {
            // title:"标题",
            msg: "添加购物车成功！",
            buttons: [
                {
                    title: "继续购物", color: "blue", click: function () {
                        //跳回当前页
                        $(location).attr('href', '#');
                    }
                },
                {
                    title: "立即结算", color: "red", click: function () {
                        $(location).attr('href', 'cart');
                    }
                }
            ]
        };
        $.alertView(json);

    });


    // $().ready(function () {
    //     $("#testBtn").click(function () {
    //         $.alertView("你好")
    //     })
    // });


});
/*购物车页面内每次点击某个商品的增加按钮，商品数量数量增加1个,并且重新计算总价*/
function addGoodNum(id) {
    $.ajax({
        url: "addGood2",//url
        type: "POST",//方法类型
        // data: $("#login_form").serialize(),
        data: {"id": id},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            for (var i = 0; i < response.goodsList.length; i++) {
                if (id == response.goodsList[i].goodId) {
                    // $("#"+"cart_item_num"+id).text("数量:"+response.goodsList[i].goodsNum);
                    $(this).prev().text("数量:"+response.goodsList[i].goodsNum);
                }

            }
            $("#cart_items_totalPrices").text("订单总金额: ¥"+response.totalPricr);
        },
        error: function () {
            alert("异常！");
        }
    });
}


/*购物车页面内每次点击某个商品的减少按钮，商品数量数量减少1个,并且重新计算总价*/
function decGoodNum(id) {
    $.ajax({
        url: "decGood2",//url
        type: "POST",//方法类型
        // data: $("#login_form").serialize(),
        data: {"id": id},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            for (var i = 0; i < response.goodsList.length; i++) {
                if (id == response.goodsList[i].goodId) {
                    $(this).prev().prev().children("span").text("数量:"+response.goodsList[i].goodsNum);

                }
            }
            $("#cart_items_totalPrices").text("订单总金额: ¥"+response.totalPricr);
        },
        error: function () {
            alert("异常！");
        }
    });
}

/*购物车页面内每次点击某个商品的删除按钮，则将此商品移除,并且重新计算总价*/

function deleteGood(id) {
    $.ajax({
        url: "deleteGood2",//url
        type: "POST",//方法类型
        // data: $("#login_form").serialize(),
        data: {"id": id},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            for (var i = 0; i < response.goodsList.length; i++) {
                if (id == response.goodsList[i].goodId) {
                    $("#item"+id).remove();
                    break;
                }
            }
            $("#cart_items_totalPrices").text("订单总金额: ¥"+(response.totalPricr));
        },
        error: function () {
            alert("异常！");
        }
    });
}


