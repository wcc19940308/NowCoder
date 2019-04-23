package NowCoder.advanced_class06;

/**
 * ��Ǯ�ķ�����
 * ����һ�����飬��һ��target��ͨ�������е�ֵ�ܹ�����target�Ĵ���
 */
public class Coin {

    public static int coin1(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0) {
            return 0;
        }
        int res = process1(arr, 0, target);
        return res;
    }

    // ��indexλ�ÿ�ʼ���ԣ�һ���ж����ֿ����ܹ�����target
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
     * �Զ����µ�DP������index��target�ľ��󣬸��ݵݹ�ʽ���иı�
     * dp[i][j]��ʾ�������iλ�ÿ�ʼ���ܹ����Ŀ��ֵj������Ϊ����
     * ��ˣ�Ŀ�����dp[0][target]
     * ���ݵݹ����dp[N][0] = 1, dp[i][0] = 1����ʾ���۴��ĸ��±꿪ʼ��һ����1�ַ�ʽ�ܹ��õ�Ŀ��ֵΪ0��
     * ����dp[N-1][j]��һ����˵��������������һ��ֵ��ʼ���ܹ��õ�Ŀ��ֵΪj������������jΪ0, 1*arr[n-1], 2*arr[n-2]...ʱ��
     * do[N-1][j] = 1
     * ��˵�ĿǰΪֹ��dp�ĳ���λ�õ�״̬�Ѿ�ȷ��
     * �ָ���һ������ĵݹ鷽�̣�����dp[i][j] = dp[i+1][j - arr[i]]��Ϊ״̬ת�Ʒ���
     */
    public static int coin3(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[n][0] = 1;
        // ��һ�ж���1
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        // ��N-1���У����targetΪarr[n-1]�ı�������ô��Щλ��Ҳ��1,����ʾֻ����arr[N-1]��һ�ֻ��ҵ�ʱ������Щλ��������target
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
     * ͬ������ʹ���Ե����ϵ�DP�����Ƶ���dp[i][j]��ʾ�����0��iλ�ã��ܹ����Ŀ��ֵj������Ϊ����
     * ��ˣ����dp[N-1][target],���Ǻ�����ֻ��Ҫdp[N][target+1]��С��DP���鼴��
     * ��ʱ���൱�ڶԵݹ���̵�����
     * ͬ���ģ�����֪��dp[i][0] = 1
     * ����dp[0][j]��һ����˵��������������һ��ֵ��ʼ���ܹ��õ�Ŀ��ֵΪj������������jΪ0, 1*arr[n-1], 2*arr[n-2]...ʱ��
     * dp[0][j] = 1
     * ��˵�ĿǰΪֹ��dp�ĳ���λ�õ�״̬�Ѿ�ȷ��
     * ��Ϊ���Ե����ϵĵ��ƣ�����dp[i][j] = dp[i-1][j - arr[i]]��Ϊ״̬ת�Ʒ���
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
                // j-arr[i]�ж�λ����û�г�����ı߽�
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[n - 1][target];
    }

    // ʹ��һά���飬��ʡ�ռ�
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
