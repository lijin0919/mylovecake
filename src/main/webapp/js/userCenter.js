$().ready(function () {

//  《----------------修改用户姓名、电话、地址表单-------------》
   $("#npa-submit-button").click(function () {
       //先获取表单提交数据
       var newName = $("#new-user-name").val();
       var newUserPhone = $("#new-user-phoneNum").val();
       var newUserAddress = $("#new-user-address").val();
       alert(newName);
       $.ajax(
           alert(newUserAddress),
           {
           url:"actionUserCenter",
           type:"POST",
           data:{
               "newName":newName,
               "newUserPhone":newUserPhone,
               "newUserAddress":newUserAddress
           },
           dataType:"Json",
           success:function (flag) {
               alert(flag);
               // 从服务器返回结果
               if (flag){//如果为真
                   //提示用户修改成功
                   $.alertView("修改成功！")

               }
           }
       })
   });//修改用户姓名、电话、地址表单

//  《-----------------------修改用户密码----------------------》
        //修改密码之前，首先应该验证原密码是否正确
   $("#old-password").blur(function () {
       var oldPassword = $("#old-password").val();
       // alert(oldPassword);
       if (oldPassword!=""){
           $.ajax(
               // alert("进来了！"),
               {
               url:"checkPassword",
               type:"POST",
               data:{"oldPassword":oldPassword},
               dataType:"Json",

               success:function (data) {
                  if (data){
                      //提示用户名匹配
                      $("#check-old-password-true").html("用户原密码输入正确！")
                  } else {
                      $("#check-old-password-true").html("");
                      $("#check-old-password-false").html("用户原密码输入不正确！")

                  }
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
       if (newPassword.eq("")||oldPassword.eq("")&&!(newPassword.eq(oldPassword))){
           $.alertView("密码修改失败！")
       }else {
           //发送ajax修改密码
           $.ajax(
               {
                   url:"changePassword",
                   type:"POST",
                   data:{"newPassword":newPassword},
                   dataType:"Json",

                   success:function (flag) {
                       if (flag){
                           $.alertView("密码修改成功！")
                       }else {
                           $.alertView("密码修改失败！")
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