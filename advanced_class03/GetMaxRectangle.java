package NowCoder.advanced_class03;

import java.util.Stack;
/**
 * �����������Ӿ���Ĵ�С
 * �Ծ����ÿ����Ϊ���и����Ȼ��ÿһ�ֶ�����ֱ��ͼ�ĵ���ջ(��������ÿ������ߵ�һ�����ұߵ�һ�����Լ�С�ģ���������ߵı߽磬��ͷ��)��⼴��
 * ʱ�临�Ӷ�O(n * m)
 */
public class GetMaxRectangle {
    public int getMaxRectangle(int[][] matrix) {
        if (matrix.length == 0 || matrix == null) {
            return 0;
        }
        // �и����
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
        // ����ջ��ʣ�µ�Ԫ��
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, height[j] * (height.length - k - 1));
        }
        return maxArea;
    }
}
