/**
 * 下一页按钮
 * @param Page
 */
function nextPage(Page) {
    var currentPage = Page + 1;
    $.ajax({
        url: "PageGoodsList",//url
        type: "POST",//方法类型
        data: {"Page": currentPage},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            $("#goodsTable").empty();
            var msg = "<tr>" +
                "            <th width='5%'>商品Id</th>" +
                "            <th width='10%'>图片</th>" +
                "            <th width='10%'>名称</th>" +
                "            <th width='20%'>介绍</th>" +
                "            <th width='10%'>价格</th>" +
                "            <th width='10%'>类目</th>" +
                "            <th width='25%'>操作</th>" +
                "        </tr";
            $("#goodsTable").append(msg);
            response.goodsList.forEach(function (value) {
                $("table").last().append(
                    "<tr id='good" + value.goodId + "'>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p></p></td></tr>");
                if (value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + "," + currentPage+ ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSaveA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success' href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                    "                        <a class='btn btn-danger'href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

            });
            $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
            $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
            $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
            $("#first").attr("onclick", "firstAndLastPage(" + 1 + ")");
            $("#last").attr("onclick", "firstAndLastPage(" + response.totalPage + ")")

        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * 上一页按钮

 * @param Page
 */
function beforePage(Page) {
    var currentPage = Page - 1;
    $.ajax({
        url: "PageGoodsList",//url
        type: "POST",//方法类型
        data: {"Page": currentPage},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            $("#goodsTable").empty();
            var msg = "<tr>" +
                "            <th width='5%'>商品Id</th>" +
                "            <th width='10%'>图片</th>" +
                "            <th width='10%'>名称</th>" +
                "            <th width='20%'>介绍</th>" +
                "            <th width='10%'>价格</th>" +
                "            <th width='10%'>类目</th>" +
                "            <th width='25%'>操作</th>" +
                "        </tr";
            $("#goodsTable").append(msg);
            response.goodsList.forEach(function (value) {
                $("table").last().append(
                    "<tr  id='good" + value.goodId + "'>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p></p></td></tr>");
                if (value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDeleteA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSaveA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success'href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                    "                        <a class='btn btn-danger' href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

            });
            $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
            $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
            $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
            $("#first").attr("onclick", "firstAndLastPage(" + 1 + ")");
            $("#last").attr("onclick", "firstAndLastPage(" + response.totalPage + ")")

        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * 首页和尾页按钮
 * @param Page
 */
function firstAndLastPage(Page) {
    $.ajax({
        url: "PageGoodsList",//url
        type: "POST",//方法类型
        data: {"Page": Page},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            $("#goodsTable").empty();
            var msg = "<tr>" +
                "            <th width='5%'>商品Id</th>" +
                "            <th width='10%'>图片</th>" +
                "            <th width='10%'>名称</th>" +
                "            <th width='20%'>介绍</th>" +
                "            <th width='10%'>价格</th>" +
                "            <th width='10%'>类目</th>" +
                "            <th width='25%'>操作</th>" +
                "        </tr";
            $("#goodsTable").append(msg);
            response.goodsList.forEach(function (value) {
                $("table").last().append(
                    "<tr  id='good" + value.goodId + "'>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p></p></td></tr>");
                if (value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDeleteA(" + value.goodId + "," + 1 + "," + Page+ ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSaveA(" + value.goodId + "," + 1 + "," + Page+ ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 2 + "," + Page+ ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(A" + value.goodId + "," + 2 + "," + Page+ ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 3 + "," + Page+ ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 3 + "," + Page+ ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success'href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                    "                        <a class='btn btn-danger' href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

            });
            $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
            $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
            $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
            $("#first").attr("onclick", "firstAndLastPage(" + 1 + ")");
            $("#last").attr("onclick", "firstAndLastPage(" + response.totalPage + ")")

        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * go页面跳转按钮
 */
function gotoPage() {
    var currentPage = $("#pageNum").val();
    var total = $("#totalNum").val();
    if (currentPage <= total || currentPage > 0) {
        $.ajax({
            url: "PageGoodsList",//url
            type: "POST",//方法类型
            data: {"Page": currentPage},
            dataType: "Json",//预期服务器返回的数据类型
            success: function (response) {
                $("#goodsTable").empty();
                var msg = "<tr>" +
                    "            <th width='5%'>商品Id</th>" +
                    "            <th width='10%'>图片</th>" +
                    "            <th width='10%'>名称</th>" +
                    "            <th width='20%'>介绍</th>" +
                    "            <th width='10%'>价格</th>" +
                    "            <th width='10%'>类目</th>" +
                    "            <th width='25%'>操作</th>" +
                    "        </tr";
                $("#goodsTable").append(msg);
                response.goodsList.forEach(function (value) {
                    $("table").last().append(
                        "<tr  id='good" + value.goodId + "'>" +
                        "            <td><p>" + value.goodId + "</p></td>" +
                        "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                        "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                        "            <td><p>" + value.goodIntro + "</p></td>" +
                        "            <td><p>" + value.goodPrice + "</p></td>" +
                        "            <td><p>" + value.goodType.typeName + "</p></td>" +
                        "            <td>" +
                        "                <p></p></td></tr>");
                    if (value.topScroll) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDeleteA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>移出条幅</a>")
                    }
                    if (!value.topScroll) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSaveA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>加入条幅</a>")
                    }
                    if (value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>移出热销</a>")
                    }
                    if (!value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>加入热销</a>")
                    }
                    if (value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>移出新品</a>")
                    }
                    if (!value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 3 + "," + currentPage+")'>加入新品</a>")
                    }
                    $("table tr td ").last().append(
                        "                       <a class='btn btn-success'href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                        "                        <a class='btn btn-danger' href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

                });
                $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
                $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
                $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
                $("#first").attr("onclick", "firstAndLastPage(" + 1 + ")");
                $("#last").attr("onclick", "firstAndLastPage(" + response.totalPage + ")")

            },
            error: function () {
                alert("异常！");
            }
        });
    }
}
/**
 * go页面跳转按钮
 */
function gotoPageA(currentPage) {
    var total = $("#totalNum").val();
    if (currentPage <= total || currentPage > 0) {
        $.ajax({
            url: "PageGoodsList",//url
            type: "POST",//方法类型
            data: {"Page": currentPage},
            dataType: "Json",//预期服务器返回的数据类型
            success: function (response) {
                $("#goodsTable").empty();
                var msg = "<tr>" +
                    "            <th width='5%'>商品Id</th>" +
                    "            <th width='10%'>图片</th>" +
                    "            <th width='10%'>名称</th>" +
                    "            <th width='20%'>介绍</th>" +
                    "            <th width='10%'>价格</th>" +
                    "            <th width='10%'>类目</th>" +
                    "            <th width='25%'>操作</th>" +
                    "        </tr";
                $("#goodsTable").append(msg);
                response.goodsList.forEach(function (value) {
                    $("table").last().append(
                        "<tr  id='good" + value.goodId + "'>" +
                        "            <td><p>" + value.goodId + "</p></td>" +
                        "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                        "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                        "            <td><p>" + value.goodIntro + "</p></td>" +
                        "            <td><p>" + value.goodPrice + "</p></td>" +
                        "            <td><p>" + value.goodType.typeName + "</p></td>" +
                        "            <td>" +
                        "                <p></p></td></tr>");
                    if (value.topScroll) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDeleteA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>移出条幅</a>")
                    }
                    if (!value.topScroll) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSaveA(" + value.goodId + "," + 1 + "," + currentPage+ ")'>加入条幅</a>")
                    }
                    if (value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>移出热销</a>")
                    }
                    if (!value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 2 + "," + currentPage+ ")'>加入热销</a>")
                    }
                    if (value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDeleteA(" + value.goodId + "," + 3 + "," + currentPage+ ")'>移出新品</a>")
                    }
                    if (!value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSaveA(" + value.goodId + "," + 3 + "," + currentPage+")'>加入新品</a>")
                    }
                    $("table tr td ").last().append(
                        "                       <a class='btn btn-success'href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                        "                        <a class='btn btn-danger' href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

                });
                $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
                $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
                $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
                $("#first").attr("onclick", "firstAndLastPage(" + 1 + ")");
                $("#last").attr("onclick", "firstAndLastPage(" + response.totalPage + ")")

            },
            error: function () {
                alert("异常！");
            }
        });
    }
}
/**
 * 加入条幅，加入热销，加入新品（条幅热销新品商品）
 * @param goodId
 * @param typeId
 */
function topSave(goodId, typeId,page) {
    $.ajax({
        url: "topSave",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            if(page==0){
            window.location.reload();
            }
            if (page==1){
                toTopList(page);
            }
            if (page==2){
                toTopList(page);
            }
            if (page==3){
                toTopList(page);
            }
        },
        error: function () {
            alert("异常！");
        }
    });
}


/**
 * 移出条幅，移出热销，移出新品（条幅热销新品商品）
 * @param goodId
 * @param typeId
 */
function topDelete(goodId, typeId,page) {
    $.ajax({
        url: "topDelete",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {

            if(page==0){
                window.location.reload();
            }
            if (page==1){
                toTopList(page);
            }
            if (page==2){
                toTopList(page);
            }
            if (page==3){
                toTopList(page);
            }

        },
        error: function () {
            alert("异常！");
        }
    });
}
/**
 * 所有商品展示页面加入条幅，加入热销，加入新品功能
 * @param goodId
 * @param typeId
 */
function topSaveA(goodId, typeId,page) {
    $.ajax({
        url: "topSave",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
           gotoPageA(page);
        },
        error: function () {
            alert("异常！");
        }
    });
}


/**
 * 所有商品展示页面移出条幅，移出热销，移出新品功能
 * @param goodId
 * @param typeId
 */
function topDeleteA(goodId, typeId,page) {
    $.ajax({
        url: "topDelete",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            gotoPageA(page);


        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * 热销新品条幅商品展示
 * @param status
 */
function toTopList(status) {
    $.ajax({
        url: "toTopLists",//url
        type: "POST",//方法类型
        data: {"status": status},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            $("#goodsTable").empty();
            $("li").attr("class", "");
            $(this).attr("class", "active");

            var msg = "<tr>" +
                "            <th width='5%'>商品Id</th>" +
                "            <th width='10%'>图片</th>" +
                "            <th width='10%'>名称</th>" +
                "            <th width='20%'>介绍</th>" +
                "            <th width='10%'>价格</th>" +
                "            <th width='10%'>类目</th>" +
                "            <th width='25%'>操作</th>" +
                "        </tr";
            $("#goodsTable").append(msg);
            response.forEach(function (value) {
                $("table").last().append(
                    "<tr  id='good" + value.goodId + "'>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p></p></td></tr>");
                if (value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 +"," + status+ ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + "," + status+ ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + "," + status+ ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + "," + status+ ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + "," + status+ ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + "," + status+ ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success'href='goodEdit?goodId="+value.goodId+"'>修改</a>" +
                    "                        <a class='btn btn-danger' href='#' onclick='adminGoodDelete("+value.goodId+")'>删除</a>")

            });

        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * 删除商品
 * @param goodId
 */
function adminGoodDelete(goodId) {
    $.ajax({
        url: "adminGoodDelete",//url
        type: "POST",//方法类型
        data: {"goodId": goodId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            if (response > 0) {
                $("#good" + goodId).remove();
            }

        },
        error: function () {
            alert("异常！");
        }
    });
}

/**
 * 推荐热销新品商品删除
 * @param goodId
 */
function topGoodDelete(goodId, status) {
    $.ajax({
        url: "topGoodDelete",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": status},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            alert("ok");
            if (response > 0) {
                $("#good" + goodId).remove();
            }

        },
        error: function () {
            alert("异常！");
        }
    });
}

