$().ready(function () {
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
               "name":newName,
               "newUserPhone":newUserPhone,
               "newUserAddress":newUserAddress
           },
           dataType:"Json"
       })
   })
});