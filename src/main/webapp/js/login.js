$().ready(function () {
    $("#btn_login").click(function () {
        alert("进入了");
        //获取用户输入的用户名
        var username=$("#login_username").val();
        //获取用户输入的密码
        var password=$("#login_password").val();
        $.ajax({
            url: "actionLogin" ,//url
            type: "POST",//方法类型
            // data: $("#login_form").serialize(),
            data: {"loginUserName":username,"loginPassword":password},
            dataType: "Json",//预期服务器返回的数据类型
            success: function (response) {
                //response为布尔值，true时表示用户名密码输入正确，我们返回首页，false表示输入错误
                if(response){
                    window.location.href="index";
                }else{
                    alert("用户名或者密码错误！")
                }

            },
            error : function() {
                alert("异常！");
            }
        });
    });
    $("#login_form").validate({
        // 当标签获得焦点时暂时清除表单验证
        focusCleanup:true,
        //当标签失去焦点时进行表单验证
        onfocusout: function (element) {
            $(element).valid();
        },
        rules: {
            //name为login_username的验证规则
            login_username: {
                //是否必须填写
                required: true,
                //长度
                minlength: 2
            },
            //name为login_password的验证规则
            login_password: {
                //是否必须填写
                required: true,
                //长度
                minlength: 5
            },

            //不符合验证规则时的提示信息
            messages: {
                //name为login_username的标签中内容不符合验证规则时的提示信息
                login_username: {
                    //未填写时的提示信息
                    required: "请输入用户名",
                    //填写长度不够时的验证信息
                    minlength: "用户名必需由两个字母组成"
                },
                //name为login_password的标签中内容不符合验证规则时的提示信息
                login_password: {
                    //未填写时的提示信息
                    required: "请输入密码",
                    //填写长度不够时的验证信息
                    minlength: "密码长度不能小于 5 个字母"
                }
            }
        }
    })
});