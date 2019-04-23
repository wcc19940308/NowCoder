package NowCoder.advanced_class06;

/**
 * 排成一条线的纸牌博弈问题
 */
public class CardGame {
    public static int win(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 0) {
            return 0;
        }
        return Math.max(before(arr, 0, n - 1), after(arr, 0, n - 1));
    }

    public static int before(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + after(arr, i + 1, j), arr[j] + after(arr, i, j - 1));
    }

    public static int after(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(before(arr, i + 1, j), before(arr, i, j - 1));
    }

    public static int dpWin(int[] arr) {
        int n = arr.length;
        int[][] before = new int[n][n];
        int[][] after = new int[n][n];
        for (int j = 0; j < n; j++) {
            before[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                before[i][j] = Math.max(arr[i] + after[i + 1][j], arr[j] + after[i][j - 1]);
                after[i][j] = Math.min(before[i + 1][j], before[i][j - 1]);
            }
        }
        return Math.max(before[0][n - 1], after[0][n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 4};
        System.out.println(win(arr));
        System.out.println(dpWin(arr));

    }
}
