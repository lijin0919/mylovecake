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
                    "<tr>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=1&tops.good.id=14'>加入条幅</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=2&tops.good.id=14'>加入热销</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=3&tops.good.id=14'>加入新品</a>" +
                    "                </p>" +
                    "                <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
                    "                <a class='btn btn-danger' href='goodDelete.action?good.id=14'>删除</a>" +
                    "            </td>" +
                    "        </tr>"
                );
            });
            $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
            $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
            $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
            $("#first").attr("onclick", "firstAndLastPage(" + 1+ ")");
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
                    "<tr>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=1&tops.good.id=14'>加入条幅</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=2&tops.good.id=14'>加入热销</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=3&tops.good.id=14'>加入新品</a>" +
                    "                </p>" +
                    "                <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
                    "                <a class='btn btn-danger' href='goodDelete.action?good.id=14'>删除</a>" +
                    "            </td>" +
                    "        </tr>"
                );
            });
            $("#nums").text("[" + response.currentPage + "/" + response.totalPage + "]");
            $("#next").attr("onclick", "nextPage(" + response.currentPage + ")");
            $("#before").attr("onclick", "beforePage(" + response.currentPage + ")");
            $("#first").attr("onclick", "firstAndLastPage(" + 1+ ")");
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
                    "<tr>" +
                    "            <td><p>" + value.goodId + "</p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                    "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                    "            <td><p>" + value.goodIntro + "</p></td>" +
                    "            <td><p>" + value.goodPrice + "</p></td>" +
                    "            <td><p>" + value.goodType.typeName + "</p></td>" +
                    "            <td>" +
                    "                <p>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=1&tops.good.id=14'>加入条幅</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=2&tops.good.id=14'>加入热销</a>" +
                    "" +
                    "                    <a class='btn btn-primary' href='topSave.action?tops.type=3&tops.good.id=14'>加入新品</a>" +
                    "                </p>" +
                    "                <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
                    "                <a class='btn btn-danger' href='goodDelete.action?good.id=14'>删除</a>" +
                    "            </td>" +
                    "        </tr>"
                );
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
        var currentPage=$("#pageNum").val();
        var total=$("#totalNum").val();
        if(currentPage<=total||currentPage>0) {
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
                            "<tr>" +
                            "            <td><p>" + value.goodId + "</p></td>" +
                            "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'><img src='..//" + value.goodCover + "' width='100px' height='100px'></a></p></td>" +
                            "            <td><p><a href='../index/detail.action?goodid=14' target='_blank'>" + value.goodName + "</a></p></td>" +
                            "            <td><p>" + value.goodIntro + "</p></td>" +
                            "            <td><p>" + value.goodPrice + "</p></td>" +
                            "            <td><p>" + value.goodType.typeName + "</p></td>" +
                            "            <td>" +
                            "                <p>" +
                            "" +
                            "                    <a class='btn btn-primary' href='topSave.action?tops.type=1&tops.good.id=14'>加入条幅</a>" +
                            "" +
                            "                    <a class='btn btn-primary' href='topSave.action?tops.type=2&tops.good.id=14'>加入热销</a>" +
                            "" +
                            "                    <a class='btn btn-primary' href='topSave.action?tops.type=3&tops.good.id=14'>加入新品</a>" +
                            "                </p>" +
                            "                <a class='btn btn-success' href='goodEdit.action?id=14'>修改</a>" +
                            "                <a class='btn btn-danger' href='goodDelete.action?good.id=14'>删除</a>" +
                            "            </td>" +
                            "        </tr>"
                        );
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