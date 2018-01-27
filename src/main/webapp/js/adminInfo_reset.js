//修改管理员密码
$().ready(function () {
    //《--------------验证后台输入信息是否为空----------》
    $("#admin-reset-form").validate({
        //鼠标移入提示信息展示清除
        focusCleanup:true,
        //鼠标移除验证信息是否为空
        onfocusout:function (element) {
            $(element).valid();
        },
        rules:{
            oldAdminPassword:{
                required:true
            },
            newAdminPassword:{
                required:true
            }
        },
        massages:{
            oldAdminPassword:{
                required:"请输入原密码（必填）"
            },
            newAdminPassword:{
                required:"请输入新密码（必填）"
            }
        }
    });

});


//《-------------先判断是否与原密码相符-------------》
function resetAdminPassword(adminId) {
    //先获取用户输入的新密码
    var newAdminPassword = $("#new-password").val();
    alert(newAdminPassword+"和"+adminId)
    if (newAdminPassword==""){

    }else {
        alert("进来了1！");
        $.ajax(
            alert("进来了2！"),
            {
            url:"resetAdminPasswordAction",
            type:"POST",
            data:{"newAdminPassword":newAdminPassword,"adminId":adminId},
            dataType:"Json",

            success:function (response) {
                if (response){
                    var json={

                        title:"修改密码成功！",
                        msg:"立即重新登录",
                        buttons:[{
                            title:"是",font_family:"楷体",color:"green",click:function () {
                                $(location).attr("href","adminLogin")
                            }
                        },
                            {
                                title:"否",font_family:"楷体",color:"red",click:function () {
                                    $(location).attr("href",window.history.go(-1))
                                }
                            }]
                    };
                    $.alertView(json);
                } else {
                    alert("失败了！")
                }
            }
        })
    }
}
