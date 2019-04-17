package NowCoder.class08;

/**
 * ����һ������arr����һ������aim�������������ѡ��arr�е�
 * ���֣��ܲ����ۼӵõ�aim������true����false
 */
public class MoneyProbloem {
    public static boolean money1(int[] arr, int sum, int i, int aim) {
        if (i == arr.length) {
            return aim == sum;
        }
        return money1(arr, sum, i + 1, aim) || money1(arr, sum + arr[i], i + 1, aim);
    }

    public static boolean money2(int[] arr, int aim) {
        int n = arr.length;
        // ����֮������n+1���ɵݹ�ĵݹ��������
        boolean[][] dp = new boolean[n + 1][aim + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][aim] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                // ���µ��жϾ��ǶԵݹ�ĸ�д
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    // ����dp[i][j]Ҫô���������dp[i+1][j]��Ҫô����dp[i+1][j+arr[i]]
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 12;
        System.out.println(money1(arr, 0, 0, aim));
        System.out.println(money2(arr, aim));
    }
}
