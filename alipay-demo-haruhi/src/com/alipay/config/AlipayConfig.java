package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016082000297197";
	// 应用私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANxlc9UqaKkXPjde5lpUpVQB+/1Wrbq5p8rAs0wA7HdLTxmCcLE2j5/+tYXbqVUXq4CDbjsp/zF3obJ/hcb5sXIcIkfx1MRHOm/MVDu3jnvC3yZ5sGkkD0deCaXRNo3R5rbSi/OhU5exEIIfu+w1tH3TXpcpKH5J7kIX1NK/qho7AgMBAAECgYEA1xDpB4pqtxZHUCD7CAqxililXYHH5f5lDiUc0X3VQlPqzCnNbiCf5rDW0diYVMDUSoP2fSVuMQdccqKeGJxv2en7jsYUrdGiPFJdcY/PZRQIfVEZjYDJ7aHd+5omFSZc2++NbkWlMwONtUd/OO5S1FWVCK65+UMpKiI0M+3uUYECQQD6lTzDo8GmDtOdQEyWK+jHnrwzlq4xizOZnVxudzmp67noAXEAl6EPRQkgy/Xo9+4sZzePtlFR2k94X/TihPaFAkEA4SkoYTlSJucF2EDxtA0dT72fpskZcNpbMpppUCqtEa8EjWCyEzz8TBh8sJatbEPiTfdQ+zyZeleHfTKNaTWJvwJAMt9DY9CGCultqroYElC9xHEEclC/8oz5H9Gjp0WLLmUN6/0G7QDbkNcKIF9oADD9aIRX8lQoND7m7WBFvgsSZQJADmKNxOBfokKiOfW0O3eXBtArkgFJEc+xgeMhlVCUrAuNc+bYmagMymPKG5IU1FTl8Ws6jkKJ36oV6ua+6BjWiwJAGc3w/T1H3i5WXFgoWfvAsck+BRgkDRQrE6rxyLeVjXZaR2dmu5DSSteAaSZWQVaaKV1mVKux4P3kTyey2PkF/g==";
    // 应用公钥 pkcs8格式的
    public static String RAS_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0xl8nBXkkG3/pqQ7qfTJ0aqCjWmsSyTTO4TCoetiqQpzegg/nEDZx0Y403BKSAEm8ceLGgwEguu6VWd/THL01lmAQWzWimiffM6Q6ucXImAtKcGqah7lYfz7fMAdxOydOkX75+q+bRS8Nx2T3EyRyNa3rovdCshr3LiwMNkeA0XyHetGRcxMXkyHICf+jgktkWVFBR6AppUWFIdEZnRwMXL/B0DVXj1SBsYPqwraenMXJJWWzgom6zHvwENGzoLC2cciJ2Azye6tpBzd4pONAxhj3BE30NxUfD5xy56xZD4975py3DjpsW6/IIrxTE2wyeMG1H9MG7XJUvVJbY4piQIDAQAB";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.1.253:8080/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://192.168.1.253:8080/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0xl8nBXkkG3/pqQ7qfTJ0aqCjWmsSyTTO4TCoetiqQpzegg/nEDZx0Y403BKSAEm8ceLGgwEguu6VWd/THL01lmAQWzWimiffM6Q6ucXImAtKcGqah7lYfz7fMAdxOydOkX75+q+bRS8Nx2T3EyRyNa3rovdCshr3LiwMNkeA0XyHetGRcxMXkyHICf+jgktkWVFBR6AppUWFIdEZnRwMXL/B0DVXj1SBsYPqwraenMXJJWWzgom6zHvwENGzoLC2cciJ2Azye6tpBzd4pONAxhj3BE30NxUfD5xy56xZD4975py3DjpsW6/IIrxTE2wyeMG1H9MG7XJUvVJbY4piQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
