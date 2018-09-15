package sos.nagato.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @ClassName CodeUtil
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/15 13:37
 * @Version 10032
 **/
public class CodeUtil {
    public static String encode(String to_encode_str){
        try {
            return new String(Base64.getUrlEncoder().encode(to_encode_str.getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(String to_decode_str){
        return new String(Base64.getUrlDecoder().decode(to_decode_str));
    }
}
