package sos.haruhi.crypto;

import com.sun.deploy.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by SuzumiyaHaruhi on 2017/8/21.
 */
public class Base64Crypto {
    public static void main(String[] args) {
        String password = "66562000";
        password = encryptBASE64(password.getBytes());
        System.out.println(password);
        password = new String(decryptBASE64(password));
        System.out.println(password);
    }

    /**
     * BASE64 加密
     * @param key   明文
     * @return  byte[]
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) {
        byte[] haruhi = {};
        try {
            haruhi = (new BASE64Decoder()).decodeBuffer(key);
        } catch(Exception e){
            e.printStackTrace();
        }
        return haruhi;
    }

    /**
     * BASE64 解密
     * @param key   密文
     * @return  String
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}
