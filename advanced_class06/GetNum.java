package NowCoder.advanced_class06;

/**
 * 给你标号为1、2、3、……、N的N个位置，机器人初始停在M位置上，走P步后停在K位置上的走法有多少种。
 * 注：机器人在1位置上时只能向右走，在N位置上时只能向左走，其它位置既可向右又可向左。
 * DP写法：会撞墙的杨辉三角形
 */
public class GetNum {
    public static int getNum(int N, int curPosition, int resStep, int K) {
        if (curPosition < 1 || curPosition > N || resStep < 0 || N < 2 || K < 1 || K > N) {
            return 0;
        }
        int res = 0;
        if (resStep == 0) {
            res = curPosition == K ? 1 : 0;
        } else {
            // 如果是最左边，只能往右走；如果是最右边，只能往左走；否则，可以向两边走
            if (curPosition == 1) {
                res += getNum(N, curPosition + 1, resStep - 1, K);
            } else if (curPosition == N) {
                res += getNum(N, curPosition - 1, resStep - 1, K);
            } else {
                res += getNum(N, curPosition + 1, resStep - 1, K)
                        + getNum(N, curPosition - 1, resStep - 1, K);
            }
        }
        return res;
    }

    // dp[i][j]表示剩余步数为i时，从j位置到达目标位置K一共有多少种可能
    // 状态转移根据递归来改即可
    public static int dpGetNum(int N, int curPosition, int restStep, int K) {
        int[][] dp = new int[restStep + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            if (i == K) dp[0][i] = 1;
        }
        for (int i = 1; i <= restStep; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[restStep][curPosition];
    }

    public static int[] generateRandomArray(int maxValue) {
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int res = getNum(5, 2, 3, 3);
        int res2 = dpGetNum(5, 2, 3, 3);
        System.out.println(res + " " + res2);
    }
}
