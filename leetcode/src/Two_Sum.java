import java.util.HashMap;
import java.util.Map;

/**
 * Description PACKAGE_NAME in Venus
 * Created by SuzumiyaHaruhi on 2017/11/21.
 */
public class Two_Sum {
    public static int[] twosum(Integer[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){   /* only one-pass */
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        throw new RuntimeException("no find");
    }
    public static void main(String[] args) {
        int[] result = twosum(new Integer[]{2, 7, 11, 16}, 23);
        System.out.println(result[0] + " - " + result[1]);
    }
}
