package sos.haruhi.shiro.kit;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassName ShiroKit
 * @Description TODO
 * @Author Suzumiya Haruhi
 * @Date 2018/9/18 21:39
 * @Version 10032
 **/
public class ShiroKit {
    public static String md5(String password, String salt){
        return new Md5Hash(password, salt).toHex();
    }
}
