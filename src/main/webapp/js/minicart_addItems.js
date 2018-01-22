$().ready(function () {

    function addItem(id) {
        alert(id);
    }

// 点击今日精选推荐商品的加入购物车，将商品加入迷你购物车事件
    $(".banner_a").click(function () {
        alert($(".banner_a").val());
        $.ajax({
            url: "getCartGood",
            type: "POST",
            data: {id: $(this).val()},
            dataType: "Json",
            success: function (respons) {
                //请求成功，显示购物车商品数量
                $(".card_num").text(respons.totalNum);
                $("#items_num").text(respons.totalNum);
                $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
                var htmldiv = "";
                for (var i = 0; i < respons.goodsList.length; i++) {
                    htmldiv +=
                        " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
                        "\n" +
                        "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
                        "                                    <!--左，商品图片-->\n" +
                        "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
                        "                                </a>\n" +
                        "                                <!--中，商品信息-->\n" +
                        "                                <div class=\"minicart_div_center\">\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <h5>\n" +
                        "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
                        "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
                        "                                        </h5>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <input class=\"min\" name=\"" + respons.goodsList[i].goodId + "\" type=\"button\" value=\"-\"  />\n" +
                        "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
                        "                                        <input class=\"add\" name=\"" + respons.goodsList[i].goodId + "\"  type=\"button\" value=\"+\" onclick='addItem(respons.goodsList[i].goodId)' />\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <!--右，删除按钮-->\n" +
                        "                                <div class=\"minicart_div_right\">\n" +
                        "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                        "                                    <div class=\"minicart_div_center_div\"><button value='" + respons.goodsList[i].goodId + "'  >删除</button></div>\n" +
                        "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                        "                                </div>\n" +
                        "\n" +
                        "                            </div>"
                    $(".list-minicart").empty();
                    $(".list-minicart").append(
                        htmldiv
                    );
                }
                alert("加入购物车成功！");
            },
            error: function () {
                alert("请求失败");
            }
        });
    });
    // 点击热销推荐和新品推荐商品的加入购物车事件，将商品加入迷你购物车事件
    $(".shop").click(function () {
        $.ajax({
            url: "getCartGood",
            type: "POST",
            data: {id: $(this).val()},
            dataType: "Json",
            success: function (respons) {
                //请求成功，显示购物车商品数量
                $(".card_num").text(respons.totalNum);
                $("#items_num").text(respons.totalNum);
                $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
                var htmldiv = "";
                for (var i = 0; i < respons.goodsList.length; i++) {
                    htmldiv +=
                        " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
                        "\n" +
                        "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
                        "                                    <!--左，商品图片-->\n" +
                        "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
                        "                                </a>\n" +
                        "                                <!--中，商品信息-->\n" +
                        "                                <div class=\"minicart_div_center\">\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <h5>\n" +
                        "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
                        "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
                        "                                        </h5>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"minicart_div_center_div\">\n" +
                        "                                        <input class=\"min\" name=\"" + respons.goodsList[i].goodId + "\" type=\"button\" value=\"-\"  />\n" +
                        "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
                        "                                        <input class=\"add\" name=\"" + respons.goodsList[i].goodId + "\"  type=\"button\" value=\"+\"  onclick='addItem(respons.goodsList[i].goodId)' />\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <!--右，删除按钮-->\n" +
                        "                                <div class=\"minicart_div_right\">\n" +
                        "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                        "                                    <div class=\"minicart_div_center_div\"><button  value='" + respons.goodsList[i].goodId + "'  >删除</button></div>\n" +
                        "                                    <div class=\"minicart_div_center_div\"></div>\n" +
                        "                                </div>\n" +
                        "\n" +
                        "                            </div>"

                    $(".list-minicart").empty();
                    $(".list-minicart").append(
                        htmldiv
                    );
                }

                alert("加入购物车成功！");


            },
            error: function () {
                alert("请求失败");
            }
        });

    });
    // $(".min").click(function () {
    //     $.ajax({
    //         url: "decCartGood",
    //         type: "POST",
    //         data: {id: $(this).attr("name")},
    //         dataType: "Json",
    //         success: function (respons) {
    //             //请求成功，显示购物车商品数量
    //             $(".card_num").text(respons.totalNum);
    //             $("#items_num").text(respons.totalNum);
    //             $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
    //             var htmldiv = "";
    //             for (var i = 0; i < respons.goodsList.length; i++) {
    //                 htmldiv +=
    //                     " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
    //                     "\n" +
    //                     "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
    //                     "                                    <!--左，商品图片-->\n" +
    //                     "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
    //                     "                                </a>\n" +
    //                     "                                <!--中，商品信息-->\n" +
    //                     "                                <div class=\"minicart_div_center\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
    //                     "                                    </div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>\n" +
    //                     "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
    //                     "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
    //                     "                                        </h5>\n" +
    //                     "                                    </div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <input class=\"min\" name=\""+respons.goodsList[i].goodId+"\" type=\"button\" value=\"-\"  />\n" +
    //                     "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
    //                     "                                        <input class=\"add\" name=\""+respons.goodsList[i].goodId +"\"  type=\"button\" value=\"+\" onclick='addItem(respons.goodsList[i].goodId)' />\n" +
    //                     "                                    </div>\n" +
    //                     "                                </div>\n" +
    //                     "                                <!--右，删除按钮-->\n" +
    //                     "                                <div class=\"minicart_div_right\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"><button value='"+respons.goodsList[i].goodId+"'  >删除</button></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                </div>\n" +
    //                     "\n" +
    //                     "                            </div>"
    //
    //                 $(".list-minicart").empty();
    //                 $(".list-minicart").append(
    //                     htmldiv
    //                 );
    //             }
    //
    //             alert("加入购物车成功！");
    //             alert(33333);
    //         },
    //         error: function () {
    //             alert("请求失败");
    //         }
    //     });
    //
    // });
    // $(".add").click(function () {
    //     alert(add);
    //     $.ajax({
    //         url: "addCartGood",
    //         type: "POST",
    //         data: {id: $(this).attr("name")},
    //         dataType: "Json",
    //         success: function (respons) {
    //             //请求成功，显示购物车商品数量
    //             alert(id);
    //             $(".card_num").text(respons.totalNum);
    //             $("#items_num").text(respons.totalNum);
    //             $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
    //             var htmldiv = "";
    //             for (var i = 0; i < respons.goodsList.length; i++) {
    //                 htmldiv +=
    //                     " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
    //                     "\n" +
    //                     "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
    //                     "                                    <!--左，商品图片-->\n" +
    //                     "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
    //                     "                                </a>\n" +
    //                     "                                <!--中，商品信息-->\n" +
    //                     "                                <div class=\"minicart_div_center\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
    //                     "                                    </div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>\n" +
    //                     "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
    //                     "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
    //                     "                                        </h5>\n" +
    //                     "                                    </div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <input class=\"min\" name=\""+respons.goodsList[i].goodId+"\" type=\"button\" value=\"-\"  />\n" +
    //                     "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
    //                     "                                        <input class=\"add\" name=\""+respons.goodsList[i].goodId +"\"  type=\"button\" value=\"+\" onclick='addItem(respons.goodsList[i].goodId)'  />\n" +
    //                     "                                    </div>\n" +
    //                     "                                </div>\n" +
    //                     "                                <!--右，删除按钮-->\n" +
    //                     "                                <div class=\"minicart_div_right\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"><button value='"+respons.goodsList[i].goodId+"' class=\"delete\" >删除</button></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                </div>\n" +
    //                     "\n" +
    //                     "                            </div>"
    //
    //                 $(".list-minicart").empty();
    //                 $(".list-minicart").append(
    //                     htmldiv
    //                 );
    //             }
    //
    //             alert("加入购物车成功！");
    //             alert(44444);
    //         },
    //         error: function () {
    //             alert("请求失败");
    //         }
    //     });
    //
    // });
    // $(".delete").click(function () {
    //     $.ajax({
    //         url: "deleteCartGood",
    //         type: "POST",
    //         data: {id: $(this).val()},
    //         dataType: "Json",
    //         success: function (respons) {
    //             //请求成功，显示购物车商品数量
    //             $(".card_num").text(respons.totalNum);
    //             $("#items_num").text(respons.totalNum);
    //             $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
    //             var htmldiv = "";
    //             for (var i = 0; i < respons.goodsList.length; i++) {
    //                 htmldiv +=
    //                     " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
    //                     "\n" +
    //                     "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
    //                     "                                    <!--左，商品图片-->\n" +
    //                     "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
    //                     "                                </a>\n" +
    //                     "                                <!--中，商品信息-->\n" +
    //                     "                                <div class=\"minicart_div_center\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
    //                     "                                    </div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\">\n" +
    //                     "                                        <h5>\n" +
    //                     "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
    //                     "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
    //                     "                                        </h5>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                        <input class=\"min\" name=\""+respons.goodsList[i].goodId+"\" type=\"button\" value=\"-\"  />\n" +
    //                     "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
    //                     "                                        <input class=\"add\" name=\""+respons.goodsList[i].goodId +"\"  type=\"button\" value=\"+\"  onclick='addItem(respons.goodsList[i].goodId)' />\n" +
    //                     "                                    </div>\n" +
    //                     "                                </div>\n" +
    //                     "                                <!--右，删除按钮-->\n" +
    //                     "                                <div class=\"minicart_div_right\">\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"><button value='"+respons.goodsList[i].goodId+"'  >删除</button></div>\n" +
    //                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
    //                     "                                </div>\n" +
    //                     "\n" +
    //                     "                            </div>";
    //
    //                 $(".list-minicart").empty();
    //                 $(".list-minicart").append(
    //                     htmldiv
    //                 );
    //             }
    //
    //             alert("加入购物车成功！");
    //         },
    //         error: function () {
    //             alert("请求失败");
    //         }
    //     });
    //
    // });


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

// $(window).on('beforeunload', function() {
//     $.ajax({
//         url: "reload",
//         type: "POST",
//         dataType: "Json",
//         success: function (respons) {
//             //请求成功，显示购物车商品数量
//             $(".card_num").text(respons.totalNum);
//             $("#items_num").text(respons.totalNum);
//             $("#cart_items_totalPrice").text("￥" + respons.totalPricr);
//             var htmldiv = "";
//             for (var i = 0; i < respons.goodsList.length; i++) {
//                 htmldiv +=
//                     " <div  type=\"normal\" class=\"item6-in-minicart-a\">\n" +
//                     "\n" +
//                     "                                <a href=\"detail.jsp\" target=\"_blank\">\n" +
//                     "                                    <!--左，商品图片-->\n" +
//                     "                                    <div><img  class=\"minicart_div_left\"  src=\"" + respons.goodsList[i].goodCover + "\" alt=\"\" ></div>\n" +
//                     "                                </a>\n" +
//                     "                                <!--中，商品信息-->\n" +
//                     "                                <div class=\"minicart_div_center\">\n" +
//                     "                                    <div class=\"minicart_div_center_div\">\n" +
//                     "                                        <h5>" + respons.goodsList[i].goodName + "</h5>\n" +
//                     "                                    </div>\n" +
//                     "                                    <div class=\"minicart_div_center_div\">\n" +
//                     "                                        <h5>\n" +
//                     "                                            <!--<span class=\"pull-right\">满额折9折</span>-->\n" +
//                     "                                            ￥" + respons.goodsList[i].goodPrice + "/礼盒\n" +
//                     "                                        </h5>\n" +
//                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
//                     "                                        <input class=\"min\" name=\""+respons.goodsList[i].goodId+"\" type=\"button\" value=\"-\"  />\n" +
//                     "                                        <input class=\"text_box\" name=\"goodnum\" type=\"text\" value=\"" + respons.goodsList[i].goodsNum + "\" style=\"width:25px;\" id=\"cart_item_num6\"/>\n" +
//                     "                                        <input class=\"add\" id=\""+respons.goodsList[i].goodId +"\"  type=\"button\" value=\"+\" onclick='addItem(respons.goodsList[i].goodId)'  />\n" +
//                     "                                    </div>\n" +
//                     "                                </div>\n" +
//                     "                                <!--右，删除按钮-->\n" +
//                     "                                <div class=\"minicart_div_right\">\n" +
//                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
//                     "                                    <div class=\"minicart_div_center_div\"><button value='"+respons.goodsList[i].goodId+"'  >删除</button></div>\n" +
//                     "                                    <div class=\"minicart_div_center_div\"></div>\n" +
//                     "                                </div>\n" +
//                     "\n" +
//                     "                            </div>";
//
//                 $(".list-minicart").empty();
//                 $(".list-minicart").append(
//                     htmldiv
//                 );
//             }
//
//             alert("刷新成功！");
//         },
//         error: function () {
//             alert("请求失败");
//         }
//     });
//
//
//
// });

