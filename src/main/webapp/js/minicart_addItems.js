// 点击首页商品的加入购物车链接，将商品加入迷你购物车事件
function addGoodToCart(goodId) {
    $.ajax({
        url: "getCartGood",
        type: "POST",
        data: {id:goodId},
        dataType: "Json",
        success: function (response) {
            $("#list-minicart").empty();
            response.goodsList.forEach(function (value){

            $("#list-minicart").append("<div  type='normal' class='item6-in-minicart-a' id='item6-in-minicart-a"+value.goodId+"'>\n" +
                "\n" +
                "                                        <a href='detail.jsp' target='_blank'>\n" +
                "                                            <!--左，商品图片-->\n" +
                "                                            <div><img  class='minicart_div_left'  src='"+value.goodCover+"' alt='' ></div>\n" +
                "                                        </a>\n" +
                "                                        <!--中，商品信息-->\n" +
                "                                        <div class='minicart_div_center'>\n" +
                "                                            <div class='minicart_div_center_div'>\n" +
                "                                                <h5>"+value.goodName+"</h5>\n" +
                "                                            </div>\n" +
                "                                            <div class='minicart_div_center_div'>\n" +
                "                                                <h5>\n" +
                "                                                    <!--<span class='pull-right'>满额折9折</span>-->\n" +
                "                                                    ￥"+value.goodPrice+"/礼盒\n" +
                "                                                </h5>\n" +
                "                                            </div>\n" +
                "                                            <div class='minicart_div_center_div'>\n" +
                "                                                <input class='min' name='' type='button' value='-' id='btn-warning6'onclick='decGoods("+value.goodId+")'/>\n" +
                "                                                <input class='text_box' name='goodnum' type='text' value='"+value.goodsNum+"' style='width:25px;' id='cart_item_num"+value.goodId+"'/>\n" +
                "                                                <input class='add' name='' type='button' value='+' id='btn-info6' onclick='addGoods("+value.goodId+")'/>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <!--右，删除按钮-->\n" +
                "                                        <div class='minicart_div_right'>\n" +
                "                                            <div class='minicart_div_center_div'></div>\n" +
                "                                            <div class='minicart_div_center_div'><button id='btn-danger6' onclick='deleteGoods("+value.goodId+")'>删除</button></div>\n" +
                "                                            <div class='minicart_div_center_div'></div>\n" +
                "                                        </div>\n" +
                "\n" +
                "                                    </div>");});
                $("#items_num").text(response.totalNum);
                $("#cart_items_totalPrice").text(response.totalPricr);
                $("#card_num").text(response.totalNum);


        },

        error: function () {
            alert("请求失败");
        }
    });
}
    //迷你购物车中点击商品的“+”
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
//迷你购物车中点击商品的“-”
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
//迷你购物车中点击商品的“删除”
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
