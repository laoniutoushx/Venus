package sos.haruhi.config;

/**
 * Description sos.haruhi.config in Venus
 * Created by SuzumiyaHaruhi on 2017/10/30.
 */
public class Alipay {
    // 商户appid
    public static String APPID = "2016082000297197";
    // 应用私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMEYQ+fSRVkQfa6RpS9acY94LUrHKr+PJ+Tw2tY0vIfpvGzT3JWLEaTjg+LMxk1XdnmoX77ok6r4KWov0/X2/BOsR0L9mXsjBP59KlyIy88hnqxZZkYRcHuNlcPExv43VGVYbPgGCwEbjDxYCo+WX47mO3LylqATTF3uDP4rCAW7f21YJdaPGN70ZkjB5c+LPX+tnyMMi9oidl2DHOo+6LOXjHNnMVLbj4VbQ9CSFynTzgiZ7nXCBi5TwH5I9pHlToBP4YD8z2jv2aqex2NrmrHSXFhWXuZcCm2XfmdPI/D44pji0kFozlBf7as7vcfsuxEVCrGabs4HOFy+joym4lAgMBAAECggEBAIL6jlNw6l0pddL7T6ZsGIl8Sldduw2digUbH4sX43HlEv5gRnrV+SbEJkvd0HQqObIkCU6AzMqX/OGoIHD2aaajsbmEVVFJS2wtOAnW8+Rr8Fhd1DihocuSy484w7GNXckbiSjYv5FlwQUw1xMrxHN3WL+f1nZOEm9F76v2K16bA6QmNt70i410moSKIWCYNOZUk+iiwQLhKotGeQD2isddISSF3AZ5s0+48mnbrtil5E/rDm3/V/bRTMB02aVUODbuRQWmY1T+RxaVU/ZuT8xWAbhyFtJURkrLCM7NPGAULv+ZRmU3wYSRY27eEXcIOT+PL5JW1dtukqXlNR6I+IECgYEAw3jHdDBMExsSedpURvaJVOvb7Qw2E5E3gIiMr/OflbjTNJnBgJXOyIf3mO89EYz2BKkfQP2qPKYf3RqFuUC4jT8jUDf2NQHXti4PwqoIZ5eTfRZER4jLExX2mhq7o91uPBQGG6V97LYDy+9Fe8xCLyD4YY11g1F/nK6JV7+aTq0CgYEAt3DdGhF2L23mNNELlnUMg3ijWi/9TrTe5Bn2H2QmgF1E5WnUuLMLfI4xN5Sm0IjqJvcSSI3jQbvUekXOE7Azh3vOh+EWmTp4PDm87Jwh/yedUSKqNI0ojWNddnFAlh/tfAqi0/YS7MKSNu3Df6dUfNmVCT4QPwAZUMxu4je/5FkCgYBFKrm4/VYN9KhnAcCMk7QonoTlrkp8RghTrP3LTPONMSdbF4UHEPtoreQI866yRSTQpV9vydKxPz9LJ5Vl5ebn5A2E1yiBvTMtPcNJ6Iysy0/fFT/36AmjqUPnZ8o5w6K8E4HNypNybT2Org3yLmbE8m+xZTLN0srLEF9880mQyQKBgQCPbEbyosRswNhEY01UDaADCsdtNCgw6Wl7nnC4im0v37yGQgB3iEVq1SHV+vuR//pTDMnWwFj2hAzUrM86xYEEZOBNjMdGdlibfekgddJ+1FJDpX6+J7+VDCN+/30n4z6ixQ4Z+0NAqb/4Al3f6Mw98UB9QXEiUMl6StxHMp9twQKBgGKzfwOyE7CFxjejUuXuflGJ01VokGczo1TcuRlKIH0Houep5sg4aQS7k0xBbcOylAwDXO1S0B1gyqt3wTwFKWqA9NHxgxwmqGk0f3PD9naDsF6Wdo7umfc/qtDpCbiS6jNA1MOeZTbY40hq6EDgLrbcHsB+S0KjlYTuB0y11ad/";
    // 应用 pkcs8公钥
    public static String RAS_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0xl8nBXkkG3/pqQ7qfTJ0aqCjWmsSyTTO4TCoetiqQpzegg/nEDZx0Y403BKSAEm8ceLGgwEguu6VWd/THL01lmAQWzWimiffM6Q6ucXImAtKcGqah7lYfz7fMAdxOydOkX75+q+bRS8Nx2T3EyRyNa3rovdCshr3LiwMNkeA0XyHetGRcxMXkyHICf+jgktkWVFBR6AppUWFIdEZnRwMXL/B0DVXj1SBsYPqwraenMXJJWWzgom6zHvwENGzoLC2cciJ2Azye6tpBzd4pONAxhj3BE30NxUfD5xy56xZD4975py3DjpsW6/IIrxTE2wyeMG1H9MG7XJUvVJbY4piQIDAQAB";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "https://www.baidu.com";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "https://m.alipay.com/Gk8NF23";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "utf-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjBGEPn0kVZEH2ukaUvWnGPeC1Kxyq/jyfk8NrWNLyH6bxs09yVixGk44PizMZNV3Z5qF++6JOq+ClqL9P19vwTrEdC/Zl7IwT+fSpciMvPIZ6sWWZGEXB7jZXDxMb+N1RlWGz4BgsBG4w8WAqPll+O5jty8pagE0xd7gz+KwgFu39tWCXWjxje9GZIweXPiz1/rZ8jDIvaInZdgxzqPuizl4xzZzFS24+FW0PQkhcp084Ime51wgYuU8B+SPaR5U6AT+GA/M9o79mqnsdja5qx0lxYVl7mXAptl35nTyPw+OKY4tJBaM5QX+2rO73H7LsRFQqxmm7OBzhcvo6MpuJQIDAQAB";

    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
