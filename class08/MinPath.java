package NowCoder.class08;

/**
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 */
public class MinPath {
    // 自顶向下的递归过程
    public static int minPath1(int[][] matrix) {
        return process1(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    public static int process1(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[i][j];
        }
        if (i == 0 && j != 0) {
            return matrix[i][j] + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return matrix[i][j] + process1(matrix, i - 1, j);
        }
        return matrix[i][j] + Math.min(process1(matrix, i - 1, j), process1(matrix, i, j - 1));
    }

    // 自底向上的DP过程
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int rows = m.length;
        int cols = m[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = m[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = m[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = m[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));

        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
    }
}
