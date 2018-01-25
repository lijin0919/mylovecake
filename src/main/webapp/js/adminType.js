
function typeDelete(typeId) {

}
function  typeSave() {
    var typeName=$("#input_name").val();
    $.ajax({

        url: "insertNewType",
        type: "POST",
        data: {"name": typeName},
        dataType: "Json",
        success: function (respons) {

                $("table").last().append("<tr>\n" +
                    "            <td><p>"+respons.typeId+"</p></td>\n" +
                    "            <td><p>"+respons.typeName+"</p></td>\n" +
                    "            <td>\n" +
                    "                <a class=\"btn btn-primary\" href=\"#\" onclick=\""+typeEdit(respons.typeId)+"\">修改</a>\n" +
                    "                <a class=\"btn btn-danger\" href=\"#\"  onclick=\""+typeDelete(respons.typeId)+"\">删除</a>\n" +
                    "            </td>\n" +
                    "        </tr>");

        },
        error: function () {
            alert("请求失败");
        }
    });
}
function editType(typeId) {
    var typeName=$("#input_name").val();
    $.ajax({
        url: "changeTypeName",
        type: "POST",
        data: {"typeId":typeId,"typeName": typeName},
        dataType: "Json",
        success: function (respons) {
            alert("更新成功！");
            window.location.href="typeList";
        },
        error: function () {
            alert("请求失败");
        }
    });
}

function typeDelete(typeId) {
    $.ajax({
        url: "deleteTypeById",
        type: "POST",
        data: {"typeId":typeId},
        dataType: "Json",
        success: function (respons) {
            alert("删除成功！");
            $(this).parent().parent().remove();
        },
        error: function () {
            alert("请求失败");
        }
    });

}