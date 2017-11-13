import java.util.ArrayList;
import java.util.List;

/**
 * Description PACKAGE_NAME in Venus
 * Created by SuzumiyaHaruhi on 2017/11/10.
 */
public class ByteCopy {
    public static void main(String[] args) {
        byte[] b1 = new byte[]{2, 3, 4, 5};
        byte[] b2 = new byte[]{6, 7, 8, 8};
        byte[] b3 = new byte[]{6, 99, 0, 8};
        byte[] re = new byte[b1.length + b2.length + b3.length];
        int length = 0;
        List<byte[]> list = new ArrayList<byte[]>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        for(byte[] item:list){
            System.arraycopy(item, 0, re, length, item.length);
            length += item.length;
        }
        System.out.println(re.toString());
        System.out.println(System.getProperty("user.dir"));
    }
}
