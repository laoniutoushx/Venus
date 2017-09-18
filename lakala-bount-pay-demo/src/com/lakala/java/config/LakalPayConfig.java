package com.lakala.java.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * desc:拉卡拉跨境支付配置类
 *
 * @author jiangzhifei jiangzhifei@lakala.com
 *         Created by jiang on 16/8/11.
 */
public class LakalPayConfig {

    private static final Map<String, String> ENV_CONFIG = new ConcurrentHashMap<String, String>();

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 商户号
     */
    private static final String MERCHANT_NO = "DOPCHN000611";

    /**
     * 商户私钥
     */
    private static final String PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAIf/nLPtJTMvYkP7JhnodtKSsqyMpp8NC6Hi48DqKQpT+xwLd3So6Bukl5468gKUhm15ESVmNrQV3ipdosNiJ7tGNftRT2yTQ1TXfOlwR/O6k7sgJ8JxZKe95mO1rnfIRXuysAEBXeGTJaWbHLl8kL6pvWeiXFLCnU/kk5v53hlrAgMBAAECgYAz4W49MWV0jkn1VxTk40qY7/+bVZimqkpaunxZ9rorR3hO7Yzngxvwl6yDX0c9dr2Fe57v3ntV3dW/4bKayJIRDP4Oj8hxY5a7acFR4Tz4bllvyYvRubJaNjTQPIDErZnwAeN52VM15cs3wZMTVPb4GHGHsMk8/H5shwysgErgQQJBAOOMNKY1W1hzdaXBHjFrg/upywHGYLX1ZcGcECijIjONpCcYUGK9HOw1aJLui3e/8pWz219yqN4yV/YYNty6GKECQQCZAOtmQDKhhirRo0N7vKqcIZv1q/wRd4MFi/KHEHZlIOI6GdZ6OcQO47rwqWoIWv11p7esi4stHV9l1SZLVnqLAkEA2wts41MZy9vZtOZimlBVjT22Hs9I6eCBRA9nvrbLhbUkAD53o5VI8lm3gToBKBWvAE1TMF7AEKWF53EH3xOGAQJBAINpJsVLnjDc6yni77L2+BHhS/JVJMpbu0yoRkV6/jUdaTA9wNh5hMrFDWpmF4vVmpvS0Q6BS6gT8jukNp++RsECQQC6WoH7RlQ6rQr6HpajMPDNdJkah99/rs501VzObzTJBMRXQUvZ3PfEvolHQOAaF8jSBxoOYnPb692RUdeTy++e";

    /**
     * 商户公钥
     */
    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDPg0O4rPQJL1O+jqJ4rBjFVNRAuDmBSoii9pYfPQBaescCVY0irkWWoLyfTT65TjvnPpOx+IfNzBTlB13qCEFm7algREoeUHjFgFNHiXJ2LK/R0+VWgXe5+EDFfbrFCPnmLKG3OcKDGQszP0VOf6VVTM1t56CpgaRMm1/+Tzd2TQIDAQAB";

    /**
     * 拉卡拉服务器
     * 联调：http://testintl.lakala.com
     * 生产：https://intl.lakala.com
     */
    public static String LKL_HOST = "http://testintl.lakala.com";

    /**
     * 端口
     * 联调:8080
     * 生产:7777
     */
    public static String PORT = "8080";

    static {
        ENV_CONFIG.put("merchantNo", MERCHANT_NO);
        ENV_CONFIG.put("privateKey", PRIVATE_KEY);
        ENV_CONFIG.put("pubKey", PUB_KEY);
    }

    public static void setMerchantNo(String merchantNo) {

        ENV_CONFIG.put("merchantNo", merchantNo);

    }

    /**
     * 获取商户号，若无则取默认
     *
     * @return
     */
    public static String getMerchantNo() {
        String merchantNo = ENV_CONFIG.get("merchantNo");
        if (null == merchantNo || "".equals(merchantNo)) {
            merchantNo = MERCHANT_NO;
        }
        return merchantNo;
    }

    public static void setPrivateKey(String privateKey) {
        ENV_CONFIG.put("privateKey", privateKey);

    }

    public static String getPrivateKey() {
        try {
            lock.writeLock().lock();
            String privateKey = ENV_CONFIG.get("privateKey");
            if (null == privateKey || "".equals(privateKey)) {
                privateKey = PRIVATE_KEY;
            }
            return privateKey;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void setPubKey(String pubKey) {
        ENV_CONFIG.put("pubKey", pubKey);

    }

    public static String getPubKey() {
        try {
            lock.writeLock().lock();
            String pubKey = ENV_CONFIG.get("pubKey");
            if (null == pubKey || "".equals(pubKey)) {
                pubKey = PUB_KEY;
            }
            return pubKey;
        } finally {
            lock.writeLock().unlock();
        }

    }

    /**
     * 切换到生产环境，默认是sandbox
     */
    public static void getLiveEnv() {
        try {
            lock.writeLock().lock();
            LKL_HOST = "https://intl.lakala.com";
            PORT = "7777";
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 切换到sandbox，默认是生产环境
     */
    public static void getSandBoxEnv() {
        try {
            lock.writeLock().lock();
            LKL_HOST = "http://testintl.lakala.com";
            PORT = "8080";
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 恢复默认环境设置，即读入LakalPayConfig类中的初始值
     */
    public static void setDefaultEnv() {
        try {
            lock.writeLock().lock();
            LKL_HOST = "http://testintl.lakala.com";
            PORT = "8080";
            ENV_CONFIG.put("merchantNo", MERCHANT_NO);
            ENV_CONFIG.put("privateKey", PRIVATE_KEY);
            ENV_CONFIG.put("pubKey", PUB_KEY);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
