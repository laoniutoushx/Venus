<%@ page import="sos.haruhi.config.MinShengConfig" %><%--
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
    <style>
        input{
            width: 40px;
            height:40px;
            border-left: 2px solid grey;
            border-bottom: 2px solid grey;
            border-top: 2px solid grey;
            border-right: none;
            text-align: center;
            vertical-align: middle;
            font-size: 24px;
            font-weight: bolder;
            background-color: white;
        }
        div{
            margin: 20px auto;
        }
    </style>
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
    <div id="haruhi_moneyInput" style="border: 1px solid; position: absolute;">
        <div id="haruhi_title" style="text-align: center; font-size: 18px; font-weight: bolder">请输入付款金额：</div>
        <div id="haruhi_money" style="text-align: center">
            <input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input type="number" disabled="disabled"/><input id="haruhi_last_input" type="number" style="border-right: 2px solid grey"/>
        </div>
        <div id="haruhi_submit" style="text-align: center; border: 1px solid black;"><h2>确认金额</h2></div>
    </div>
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

        $('#haruhi_last_input').focus();
        $('#haruhi_submit').on('click', function(){
            $.post({
                url: '<%=MinShengConfig.test_Alipay_Business_Url%>',
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
