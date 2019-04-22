package NowCoder.advanced_class04;

import java.util.HashMap;
import java.util.Map;

/**
 * ��һ��������л��֣����ܹ��õ������������������Ļ��ַ�ʽ-DP
 * dp[i]������i��β����������������黮�ֵ�����
 * dp[i] = dp[i - 1], i�������Ż��ֵ�һ����
 *         dp[k - 1] + 1, i�����Ż��ֵ�һ���֣���k��i֮�������Ż��ֵĲ���
 */
public class MaxXorLength {
    public static int maxXorLength(int[] arr) {
        // map���ڸ������͵�����һ��λ��
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
                // �����i��Ϊ��β���ܹ����ֵ������������������
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            // һֱ���������λ�ã�ʹ���ҵ�������Ϊ0�����鳤������С��
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
