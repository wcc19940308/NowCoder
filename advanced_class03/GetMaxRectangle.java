package NowCoder.advanced_class03;

import java.util.Stack;
/**
 * 求矩阵中最大子矩阵的大小
 * 以矩阵的每行作为底切割矩阵，然后每一轮都进行直方图的单调栈(求数组中每个数左边第一个和右边第一个比自己小的，这就是两边的边界，两头夹)求解即可
 * 时间复杂度O(n * m)
 */
public class GetMaxRectangle {
    public int getMaxRectangle(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return 0;
        }
        // 切割矩阵
        int[] height = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, getMaxArea(height));
        }
        return maxArea;
    }

    public int getMaxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[j] * (i - k - 1));
            }
            stack.push(i);
        }
        // 结算栈中剩下的元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[j] * (height.length - k - 1));
        }
        return maxArea;
    }
}
