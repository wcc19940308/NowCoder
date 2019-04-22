package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.Map;

/**
 * 对一个数组进行划分，求能够得到的子数组中异或和最多的划分方式-DP
 * dp[i]代表以i结尾的数组的最优子数组划分的数量
 * dp[i] = dp[i - 1], i不是最优划分的一部分
 *         dp[k - 1] + 1, i是最优划分的一部分，且k到i之间是最优划分的部分
 */
public class MaxXorLength {
    public static int maxXorLength(int[] arr) {
        // map用于更新异或和的最右一个位置
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        map.put(0, -1);
        int xor = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                // 获得以i作为结尾的能够划分的最多异或和子数组数量
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            // 一直更新最晚的位置，使得找到的异或和为0的数组长度是最小的
            map.put(xor, i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 0, 1, 2, 3, 0};
        System.out.println(maxXorLength(arr));
    }
}
