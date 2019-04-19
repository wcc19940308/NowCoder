package NowCoder.advanced_class03;

import java.util.Stack;

/**
 * ���⣺
 * ���̨���γɻ������飬�涨���2�����̨֮���ֵ������2�����̨����Сֵ����ô��2�����̨�ǿ����໥�����ģ�������ж��ٶԿ����໥�����ķ��̨
 * ����ջ��Ӧ�ã����Ǵ�ջ�׵�ջ���ݼ��ĵ���ջ����ͷ�еľ��Ǳ��м�ߵķ��̨����ô���м�������̨������һ������2�ԣ����������ߵķ��̨
 * ���ǿ��ǵ����ܴ�����ͬ�߶ȵķ��̨����ˣ����ǽ���ͬ�߶ȵķ��̨�ۼӴ���������ջʱ����Щ��ͬ�߶ȵķ��̨�ܹ����ɵĶ���ΪC(2, k) + 2 * k,
 * ���м���Щ���̨�ǿ����໥�����ģ�����ÿ����������2�Է��̨���ӵ�ǰ�����󣬴ӵ�ǰ�����ң�
 *
 *
 * ��������һ�ֵ�ʱ��ջ�е�����һ�͵����ڶ���Ԫ��Ҫ�ֱ����ۣ�
 * 1.���ջ�׳��ֵĴ���Ϊ1����ôջ�׵����ڶ���Ԫ���ܹ����ɵĶ���ΪC��2, k�� + k
 * 2.���ջ�׳��ֵĴ�������1�� ��ôջ�׵����ڶ���Ԫ���ܹ����ɵĶ���ΪC��2, k�� + 2 * k
 *
 * 1.ջ�׵�Ԫ��������ִ���Ϊ1�� ��ôջ��Ԫ���ܹ��ɵĶ���Ϊ0
 * 2.ջ��Ԫ��������ֵĴ�������1�� ��ôջ��Ԫ���ܹ��ɶ���ΪC��2�� k��
 */
public class GetMaxPair {
    public static class Pair {
        public int val;
        public int times;

        public Pair(int val) {
            this.val = val;
            times = 1;
        }
    }

    public long communication(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];
        int index = nextIndex(size, maxIndex);
        long res = 0L;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));
        // ע���������ٻ�����2����1�����ģ�1���δ�ģ���Ϊ���Ĳ���������������ģ����Բ��ᵯ�������δ�Ĳ����ڶ�����������������ˣ���˲��ᵯ��
        while (index != maxIndex) {
            value = arr[index];
            while (!stack.isEmpty() && stack.peek().val < value) {
                int times = stack.pop().times;
//                res += getInternalSum(times) + times;
//                res += stack.isEmpty() ? 0 : times;
                res += getInternalSum(times) + 2 * times;
            }
            if (!stack.isEmpty() && stack.peek().val == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times);
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {
                    res += times;
                } else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }
        }
        return res;
    }

    // ����ѭ��������һ���±�
    public int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    // ����C��n, 2��
    public long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }
}
