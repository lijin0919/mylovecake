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
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
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
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
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
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
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
                        $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + ")'>移出条幅</a>")
                    }
                    if (!value.topScroll) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + ")'>加入条幅</a>")
                    }
                    if (value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + ")'>移出热销</a>")
                    }
                    if (!value.topLarge) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + ")'>加入热销</a>")
                    }
                    if (value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + ")'>移出新品</a>")
                    }
                    if (!value.topSmall) {
                        $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + ")'>加入新品</a>")
                    }
                    $("table tr td ").last().append(
                        "                       <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
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
 * 加入条幅，加入热销，加入新品
 * @param goodId
 * @param typeId
 */
function topSave(goodId, typeId) {
    $.ajax({
        url: "topSave",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            window.location.reload();

        },
        error: function () {
            alert("异常！");
        }
    });
}


/**
 * 移出条幅，移出热销，移出新品
 * @param goodId
 * @param typeId
 */
function topDelete(goodId, typeId) {
    $.ajax({
        url: "topDelete",//url
        type: "POST",//方法类型
        data: {"goodId": goodId, "typeId": typeId},
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            window.location.reload();

        },
        error: function () {
            alert("异常！");
        }
    });
}
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
                    $("table tr td p").last().append("<a class='btn btn-info' href='#'  onclick='topDelete(" + value.goodId + "," + 1 + ")'>移出条幅</a>")
                }
                if (!value.topScroll) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#'  onclick='topSave(" + value.goodId + "," + 1 + ")'>加入条幅</a>")
                }
                if (value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 2 + ")'>移出热销</a>")
                }
                if (!value.topLarge) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 2 + ")'>加入热销</a>")
                }
                if (value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-info' href='#' onclick='topDelete(" + value.goodId + "," + 3 + ")'>移出新品</a>")
                }
                if (!value.topSmall) {
                    $("table tr td p").last().append("<a class='btn btn-primary' href='#' onclick='topSave(" + value.goodId + "," + 3 + ")'>加入新品</a>")
                }
                $("table tr td ").last().append(
                    "                       <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
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