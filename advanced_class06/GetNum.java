package NowCoder.advanced_class06;

/**
 * ������Ϊ1��2��3��������N��N��λ�ã������˳�ʼͣ��Mλ���ϣ���P����ͣ��Kλ���ϵ��߷��ж����֡�
 * ע����������1λ����ʱֻ�������ߣ���Nλ����ʱֻ�������ߣ�����λ�üȿ������ֿ�����
 * DPд������ײǽ�����������
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
            // ���������ߣ�ֻ�������ߣ���������ұߣ�ֻ�������ߣ����򣬿�����������
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

    // dp[i][j]��ʾʣ�ಽ��Ϊiʱ����jλ�õ���Ŀ��λ��Kһ���ж����ֿ���
    // ״̬ת�Ƹ��ݵݹ����ļ���
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
