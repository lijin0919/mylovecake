function toOrderList() {

    $.ajax({
        url: "orderList" ,//url
        type: "POST",//方法类型
        dataType: "Json",//预期服务器返回的数据类型
        success: function (response) {
            //response为布尔值，true时表示用户名密码输入正确，我们返回首页，false表示输入错误
            if(response){
                $("#np-warning").html("");
                window.location.href="adminIndex";
            }else{
                $("#np-warning").html("*用户名或者密码错误！请重新输入");
                // alert("用户名或者密码错误！")
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}