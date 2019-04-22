package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.Map;

/**
 * 一道原型题：子数组的问题，思考 以数组中的每个元素结尾的情况
 * 未排序数组中累加和为给定值的最长子数组
 * 求出以数组中每个位置结尾的累加和为给定值的最长子数组
 * 思路：
 * 对于i位置，从0到i位置的累加和为sum，想要求i位置结尾的累加和为target的最长子数组，只要求出从0到k位置第一次累加和为sum - target的位置k即可，那么k+1 ~ i位置就是
 * i位置结尾的累加和为target的最长子数组（也可能不是从0位置开始的）
 */
public class MaxLength {
    public int maxLength(int[] arr, int target) {
        // map记录累加和第一次出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 表示从sum - target + 1 到 i的累加和为target
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }
            // 第一次出现这个累加和的位置
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
