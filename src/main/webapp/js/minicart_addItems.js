// 点击首页商品的加入购物车链接，将商品加入迷你购物车事件
function addGoodToCart(goodId) {
    $.ajax({
        url: "getCartGood",
        type: "POST",
        data: {id:goodId},
        dataType: "Json",
        success: function (respons) {
            location.reload();
        },

        error: function () {
            alert("请求失败");
        }
    });
}

    function addGoods(goodId) {
        $.ajax({
            url: "addGood",
            type: "POST",
            data: {id:goodId},
            dataType: "Json",
            success: function (respons) {
                $("#cart_item_num"+goodId).val(respons[0]);
                $(".card_num").text(respons[1]);
                $("#items_num").text(respons[1]);
                $("#cart_items_totalPrice").text("￥" + respons[2]);

            },
            error: function () {
                alert("请求失败");
            }
        });
    }
function decGoods(goodId) {
    $.ajax({
        url: "decGood",
        type: "POST",
        data: {id:goodId},
        dataType: "Json",
        success: function (respons) {
            $("#cart_item_num"+goodId).val(respons[0]);
            $(".card_num").text(respons[1]);
            $("#items_num").text(respons[1]);
            $("#cart_items_totalPrice").text("￥" + respons[2]);

        },
        error: function () {
            alert("请求失败");
        }
    });
}
function deleteGoods(goodId) {
    $.ajax({
        url: "deleteGood",
        type: "POST",
        data: {id:goodId},
        dataType: "Json",
        success: function (respons) {
            $("#item6-in-minicart-a"+goodId).remove();
            $(".card_num").text(respons[1]);
            $("#items_num").text(respons[1]);
            $("#cart_items_totalPrice").text("￥" + respons[2]);

        },
        error: function () {
            alert("请求失败");
        }
    });
}
    $().ready(function () {

    /*mini迷你购物车窗口事件-----------------------------------------*/
    //迷你迷你购物车页面鼠标悬停和失去触发事件
    //悬停时让迷你迷你购物车不显示
    $("#cart-img").mouseover(function () {
        // alert(123);
        $("#minicart-show").css("display", "block");
    });
    //失去时时让迷你迷你购物车不显示
    $("#cart-img").mouseout(function () {
        $("#minicart-show").css("display", "none");
    });

});


function goToCart() {
    window.location.href="cart";
}
