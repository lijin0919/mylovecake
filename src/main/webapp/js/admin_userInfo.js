//点击注册提交后的触发事件

// 就绪函数
    $().ready(function() {
        //让当前表单调用validate方法，实现表单验证功能
        $("#commentForm").validate({
            // debug:true,
            focusCleanup: true,
            onfocusout: function (element) {
                $(element).valid();
            },
            rules: {     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
                username: {
                    checkName: true,
                    checkName1:true,
                    required: true,  //必填。如果验证方法不需要参数，则配置为true
                    rangelength: [6, 12]
                },
                password: {
                    checkPwd: true,
                    required: true,
                    rangelength: [6, 12]
                },
                userPhone: {
                    required: true,
                    minlength: 11,
                    maxlength: 11,
                    isphoneNum: true
                }
            },
            messages: {
                username: {
                    required: "*请输入用户名（必填）",
                    rangelength: $.validator.format("*用户名长度在必须为：{0}-{1}之间"),
                    checkName: "*只允许6-16位英文字母、数字或者下画线！",
                    checkName1:"*用户名已存在存在，请重新输入"
                },
                password: {
                    required: "*请输入密码（必填）",
                    rangelength: $.validator.format("*字段长度必须为：{0}-{1}之间"),
                    checkPwd: "*只允许2-10位英文字母、数字或者下画线！"
                },
                userPhone: {
                    required: "*请输入用户电话号码（必填）",
                    minlength: "请您输入11位手机号码",
                    maxlength: "请您输入11位手机号码",
                    isphoneNum: "*您输入的手机号码格式不正确"
                }
            }
        });


        //自定义正则表达式验证方法
        // 《------------------自定义验证用户名-----------------》
        $.validator.addMethod("checkName", function (value, element, params) {
            var checkName = /^\w{2,10}$/g;
            return this.optional(element) || (checkName.test(value));
        });
        //《------------------自定义密码验证-------------------》
        $.validator.addMethod("checkPwd", function (value, element, params) {
            var checkPwd = /^\w{6,16}$/g;
            return this.optional(element) || (checkPwd.test(value));
        });
        // 《-----------------自定义电话验证-------------------》
        $.validator.addMethod("isphoneNum", function (value, element, params) {
            // debugger;
            // var length = value.length;
            var mobile = /^1(3|4|5|7|8|9)\d{9}$/;
            return this.optional(element) || (mobile.test(value));
        });






        $("#submit-btn").click(function () {
            var username = $("#username-test").val();
            // alert(username);
            $.ajax({

                url: "checkUsername",
                type: "POST",
                data: {"username": username},
                dataType: "Json",
                success: function (response) {
                    // 如果返回为真,表示用户存在
                    alert(response);

                    if(response){
                        // alert("123");
                        // $(location).attr("href","#");
                        $("#warning-msg").html("*用户名已存在，请您重新输入");


                    } else {


                            var password = $("#user-password").val();
                            var name = $("#user-name").val();
                            var userPhone = $("#user-phone").val();
                            var userAddress =$("#user-address").val();
                            if (username==""||password==""){//如果用户输入的为空
                                $("#warning-msg").html("*用户名与密码不能为空！");
                            } else {
                                $.ajax({
                                    url:"actionRegister",
                                    type:"POST",
                                    data:{"username":username,
                                        "password":password,
                                        "name":name,
                                        "userPhone":userPhone,
                                        "userAddress":userAddress
                                    },
                                    dataType:"Json",
                                    success:function (data) {
                                        alert(data);

                                        if(data){
                                            var json={
                                                msg:"添加用户成功！",
                                                buttons:[
                                                    {
                                                        title:"返回用户列表",font_family:"楷体",color:"blue",click:function () {
                                                            $(location).attr('href','toAdminUserList')
                                                        }
                                                    }
                                                ]
                                            };
                                            $.alertView(json);
                                            // $(location).attr("href","index");
                                        }
                                    }

                                });
                            }
                    }
                },
                error:function () {
                    alert("错误");
                }

            })
        });//ajax


        //光标移入错误提示移除
        $("#username-test").focus(function () {
            $("#warning-msg").html("");
        });


//  《----------------修改用户姓名、电话、地址表单-------------》
            $("#npa-submit-button").click(function () {
                //先获取表单提交数据
                var newName = $("#new-user-name").val();
                var newUserPhone = $("#new-user-phoneNum").val();
                var newUserAddress = $("#new-user-address").val();
                var userId = $("#user-id").val();
                alert(userId);
                alert(newName);
                $.ajax(
                    alert(newUserAddress),
                    {
                        url:"adminChangeUserInfo",
                        type:"POST",
                        data:{
                            "newName":newName,
                            "newUserPhone":newUserPhone,
                            "newUserAddress":newUserAddress,
                            "userId":userId
                        },
                        dataType:"Json",
                        success:function (flag) {
                            alert(flag);
                            // 从服务器返回结果
                            if (flag){//如果为真
                                //提示用户修改成功
                                var json1={
                                    msg:"信息修改成功！",
                                    buttons:[
                                        {
                                            title:"返回用户列表",font_family:"楷体",color:"blue",click:function () {
                                                $(location).attr('href','toAdminUserList')
                                            }
                                        }
                                    ]
                                };
                                $.alertView(json1);

                            }else {
                                var json={
                                    msg:"信息修改失败！",
                                    buttons:[
                                        {
                                            title:"返回用户列表",font_family:"楷体",color:"red",click:function () {
                                                $(location).attr('href','toAdminUserList')
                                            }
                                        }
                                    ]
                                };
                                $.alertView(json);
                            }
                        }
                    })
            });//修改用户姓名、电话、地址表单






//  《-----------------------修改用户密码----------------------》
            //修改密码之前，首先应该验证原密码是否正确
            $("#old-password").blur(function () {
                var oldPassword = $("#old-password").val();
                var userId = $("#user-id").val();
                // alert(oldPassword);
                alert(userId);
                if (oldPassword!=""){
                    $.ajax(
                        alert("进来了！"),
                        {
                            url:"adminCheckPassword",
                            type:"POST",
                            data:{"oldPassword":oldPassword,"userId":userId},
                            dataType:"Json",

                            success:function (data) {
                                if (data){
                                    //提示用户名匹配
                                    $("#check-old-password-true").html("用户原密码输入正确！")
                                } else {
                                    $("#check-old-password-true").html("");
                                    $("#check-old-password-false").html("用户原密码输入不正确！")

                                }
                            },
                            error:function () {
                                alert("修改失败！")
                            }
                        })
                }else {
                    //提示用户原密码不能为空
                    $("#check-old-password-false").html("用户原密码不能为空！")
                }
            });
            //然后要验证新密码不能为空并且不能与原密码相同
            $("#new-password,#old-password").blur(function () {
                //获取新密码和旧密码
                var oldPassword = $("#old-password").val();
                var newPassword = $("#new-password").val();
                if (newPassword==""&&oldPassword!=""){
                    //提示新密码不能为空
                    $("#check-new-password-false").html("用户新密码不能为空！")
                }else if(oldPassword==newPassword&&oldPassword!=""&&newPassword!=""){
                    //提示用户新旧密码不能一致
                    $("#check-new-password-false").html("用户新密码不能与原密码一致！")
                }else if (newPassword==""&&oldPassword==""){
                    $("#check-new-password-false").html("用户新密码不能为空！");
                    $("#check-old-password-false").html("用户原密码不能为空！")
                }else if (newPassword!=""&&oldPassword==""){
                    $("#check-old-password-false").html("用户原密码不能为空！")
                }
            });





            $("#p-submit-button").click(function () {
                //获取旧密码和新密码（非空操作）
                var newPassword = $("#new-password").val();
                var oldPassword = $("#old-password").val();
                var userId = $("#user-id").val();
                if (newPassword!=""&&oldPassword!=""){
                    //发送ajax修改密码
                    $.ajax(
                        {
                            url:"adminChangePassword",
                            type:"POST",
                            data:{"newPassword":newPassword,"userId":userId},
                            dataType:"Json",

                            success:function (flag) {
                                if (flag){
                                    var json={
                                        msg:"密码修改成功！",
                                        buttons:[
                                            {
                                                title:"返回用户列表",font_family:"楷体",color:"blue",click:function () {
                                                    $(location).attr('href','toAdminUserList')
                                                }
                                            }
                                        ]
                                    };
                                    $.alertView(json);
                                }else {
                                    var json={
                                        msg:"修改密码失败！",
                                        buttons:[
                                            {
                                                title:"返回用户列表",font_family:"楷体",color:"red",click:function () {
                                                    $(location).attr('href','#')
                                                }
                                            }
                                        ]
                                    };
                                    $.alertView(json);
                                }
                            }
                        })
                }

            });


            //光标移入警告消失
            $("#old-password,#new-password").focus(function () {
                $("#check-old-password-false").html("");
                $("#check-new-password-false").html("");

            })


});//ready
