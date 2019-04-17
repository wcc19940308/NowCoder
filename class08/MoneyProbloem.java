package NowCoder.class08;

/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
 * 数字，能不能累加得到aim，返回true或者false
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
        // 这里之所以是n+1是由递归的递归基决定的
        boolean[][] dp = new boolean[n + 1][aim + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][aim] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                // 如下的判断就是对递归的改写
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    // 这里dp[i][j]要么就是上面的dp[i+1][j]，要么就是dp[i+1][j+arr[i]]
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
