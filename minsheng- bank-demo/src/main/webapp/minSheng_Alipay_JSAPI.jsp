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
    <title>支付宝支付</title>
</head>
<body>
    <h1 id="tradeNO"></h1>
</body>
<script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
<script src="https://a.alipayobjects.com/g/component/antbridge/1.1.4/antbridge.min.js"></script>
<script>
    var tradeNO = GetQueryString('state');
    $('#tradeNO').html(tradeNO);
    function ready(callback) {
        // 如果jsbridge已经注入则直接调用
        if (window.AlipayJSBridge) {
            callback && callback();
        } else {
            // 如果没有注入则监听注入的事件
            document.addEventListener('AlipayJSBridgeReady', callback, false);
        }
    }
    ready(function(){
        AlipayJSBridge.call("tradePay",{
            tradeNO: "'"+tradeNO+"'"
        }, function(result){
            alert(JSON.stringify(result));
        });
    });
    function GetQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
</script>
</html>
