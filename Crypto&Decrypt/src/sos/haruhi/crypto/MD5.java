package sos.haruhi.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by SuzumiyaHaruhi on 2017/8/21.
 */
public class MD5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String haruhi = "6656200";
        System.out.println(encryptMD5(haruhi));
    }


    public static String encryptMD5(String key){
        //<li>Algorithms (such as DSA, RSA, MD5 or SHA-1).
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(key.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = md5.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        //将加密后的byte数组转换为十六进制的字符串,否则的话生成的字符串会乱码
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1){
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            }else{
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString();
    }
}
