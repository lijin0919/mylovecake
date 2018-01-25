$().ready(function () {
    //《-----------------购物车-----------------》

    // $("#weChatPay").click(function () {
    //     //     $("#weChatPay").attr("src","picture/weChat.jpg");
    //     //
    //     // });
    //     //
    //     // $("#zfbPay").click(function () {
    //     //     $("#zfbPay").attr("src","picture/zfb.jpg");
    //     //
    //     // });

    $("#we-Chat-pic").click(function() {
        $("#qrcode1").fadeIn("slow");
        return false;
    });
    $("#maYun-pic").click(function() {
        $("#qrcode2").fadeIn("slow");
        return false;
    });

    $(".qrcode").click(function() {
        $("#qrcode1").fadeOut("slow");
        $("#qrcode2").fadeOut("slow");
    })
});
