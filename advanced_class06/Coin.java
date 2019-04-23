package NowCoder.advanced_class06;

/**
 * 换钱的方法数
 * 给定一组数组，和一个target，通过数组中的值能够构成target的次数
 */
public class Coin {

    public static int coin1(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int res = process1(arr, 0, target);
        return res;
    }

    // 从index位置开始尝试，一共有多少种可能能够构成target
    public static int process1(int[] arr, int index, int target) {
        int res = 0;
        if (index == arr.length) {
            res = target == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= target; i++) {
                res += process1(arr, index + 1, target - arr[index] * i);
            }
        }
        return res;
    }

    public static int coin2(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][target + 1];
        int res = process2(arr, 0, target, map);
        return res;
    }

    public static int process2(int[] arr, int index, int target, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = target == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= target; i++) {
                int mapValue = map[index + 1][target - i * arr[index]];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, target - arr[index] * i, map);
                }
            }
        }
        map[index][target] = res == 0 ? -1 : res;
        return res;
    }

    /**
     * 自顶向下的DP，画出index和target的矩阵，根据递归式进行改编
     * dp[i][j]表示从数组从i位置开始，能够组成目标值j的总数为多少
     * 因此，目标求解dp[0][target]
     * 根据递归基，dp[N][0] = 1, dp[i][0] = 1（表示无论从哪个下标开始，一定有1种方式能够得到目标值为0）
     * 对于dp[N-1][j]这一行来说，即从数组的最后一个值开始，能够得到目标值为j的总数，即当j为0, 1*arr[n-1], 2*arr[n-2]...时，
     * do[N-1][j] = 1
     * 因此到目前为止，dp的初试位置的状态已经确定
     * 又根据一般情况的递归方程，所以dp[i][j] = dp[i+1][j - arr[i]]即为状态转移方程
     */
    public static int coin3(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[n][0] = 1;
        // 第一列都是1
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        // 第N-1行中，如果target为arr[n-1]的倍数，那么那些位置也是1,即表示只是用arr[N-1]这一种货币的时候，有哪些位置能满足target
        for (int i = 1; i * arr[n - 1] <= target; i++) {
            dp[n - 1][i * arr[n - 1]] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[0][target];
    }

    /**
     * 同理，可以使用自底向上的DP进行推导，dp[i][j]表示数组从0到i位置，能够组成目标值j的总数为多少
     * 因此，求解dp[N-1][target],于是乎我们只需要dp[N][target+1]大小的DP数组即可
     * 此时，相当于对递归过程的逆序
     * 同样的，可以知道dp[i][0] = 1
     * 对于dp[0][j]这一行来说，即从数组的最后一个值开始，能够得到目标值为j的总数，即当j为0, 1*arr[n-1], 2*arr[n-2]...时，
     * dp[0][j] = 1
     * 因此到目前为止，dp的初试位置的状态已经确定
     * 因为是自底向上的递推，所以dp[i][j] = dp[i-1][j - arr[i]]即为状态转移方程
     */
    public static int coin4(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= target; i++) {
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                // j-arr[i]判断位置有没有超出表的边界
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[n - 1][target];
    }

    // 使用一维数组，节省空间
    public static int coin5(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target + 1];
        for (int i = 0; arr[0] * i <= target; i++) {
            dp[arr[0] * i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5};
        System.out.println(coin1(arr, 8));
        System.out.println(coin2(arr, 8));
        System.out.println(coin3(arr, 8));
        System.out.println(coin4(arr, 8));
        System.out.println(coin5(arr, 8));
    }
}
