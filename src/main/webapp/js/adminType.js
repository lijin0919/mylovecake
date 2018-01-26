function  typesSave() {
    var typeName=$("#input_name1").val();
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
                    "                <a class='btn btn-primary' href='toEditType?typeId="+respons.typeId+"'>修改</a>\n" +
                    "                <a class='btn btn-danger' href='#'  onclick='typeDelete("+respons.typeId+")'>删除</a>\n" +
                    "            </td>\n" +
                    "        </tr>"
                );
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
            $(this).parent().parent().remove();
            window.location.href="typeList";
        },
        error: function () {
            alert("请求失败");
        }
    });

}

$().ready(function () {
    $("#form-horizontal").validate({
        // 当标签获得焦点时暂时清除表单验证
        focusCleanup:true,
        //当标签失去焦点时进行表单验证
        onfocusout: function (element) {
            $(element).valid();
        },
        rules: {
            //name为login_username的验证规则
            typename: {
                //是否必须填写
                required: true

            },

            //不符合验证规则时的提示信息
            messages: {
                //name为login_username的标签中内容不符合验证规则时的提示信息
                typename: {
                    //未填写时的提示信息
                    required: "请输入新类型名！"
                }
            }
        }
    });
});