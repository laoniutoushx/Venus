import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description PACKAGE_NAME in Venus
 * Created by SuzumiyaHaruhi on 2017/11/17.
 */
public class UnionPayParseFile {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("S://INN17011988ZM_898111472980125");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(is, "utf-8"));

            String line = null;
            int[] seperator = {3, 11, 11, 6, 10, 19, 12, 4, 2, 21, 2, 32, 2,
                    6, 10, 13, 13, 4, 15, 2, 2, 6, 2, 4, 32, 1, 21, 15,
                    1, 15, 32, 13, 13, 8, 32, 13, 13, 12, 2, 1, 32, 98
            };
            List<String[]> list = new ArrayList<String[]>();

            while ((line = reader.readLine()) != null) {
                String[] str = new String[42];
                System.out.println(line);
                for(int i = 0, cursor = 0; i < 42; i++){
                    char[] chars = new char[seperator[i]];
                    for(int k = 0; k < seperator[i]; k++){
                        chars[k] = line.charAt(cursor++);
                    }
                    //cursor++;
                    cursor++;
                    str[i] = String.valueOf(chars);
                    System.out.println("th-" + (i+1) + "：" + str[i] + "|");
                }
                list.add(str);
            }
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
