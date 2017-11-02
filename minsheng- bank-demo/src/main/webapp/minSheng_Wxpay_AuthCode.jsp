<%--
  Created by IntelliJ IDEA.
  User: SuzumiyaHaruhi
  Date: 2017/10/26
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户授权</title>
</head>
<body>
    <form>

    </form>
    <table style="width: 100%;">
        <tr><td>tradeNO:</td><td id="tradeNO"></td></tr>
        <tr><td>app_id:</td><td id="app_id"></td></tr>
        <tr><td>auth_code:</td><td id="auth_code"></td></tr>
        <tr><td>scope:</td><td id="scope"></td></tr>
        <tr><td>state:</td><td id="state"></td></tr>
        <tr><td>result:</td><td id="result"></td></tr>
    </table>
</body>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script src="https://a.alipayobjects.com/g/component/antbridge/1.1.4/antbridge.min.js"></script>
<script>
    window.onload = function(){

        var app_id = GetQueryString('app_id');
        var auth_code = GetQueryString('auth_code');
        var scope = GetQueryString('scope');
        var state = GetQueryString('state');
        $('#app_id').html(app_id);
        $('#auth_code').html(auth_code);
        $('#scope').html(scope);
        $('#state').html(state);

        $.post({
            url: 'http://192.168.2.100:8080/QRCode_Wxpay_MinSheng',
            data: {auth_code: auth_code, state: state},
            success: function(data){
                $('#tradeNO').html(data);
                ready(function(){
                    AlipayJSBridge.call("tradePay",{
                        tradeNO: data,
                    }, function(result){
                        $('#result').html(JSON.stringify(result));
                    });
                });
            }
        });
    };

    function GetQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    function ready(callback) {
        // 如果jsbridge已经注入则直接调用
        if (window.AlipayJSBridge) {
            callback && callback();
        } else {
            // 如果没有注入则监听注入的事件
            document.addEventListener('AlipayJSBridgeReady', callback, false);
        }
    }

</script>
</html>
