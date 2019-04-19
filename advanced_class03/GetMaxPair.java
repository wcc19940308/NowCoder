package NowCoder.advanced_class03;

import java.util.Stack;

/**
 * 问题：
 * 烽火台，形成环形数组，规定如果2个烽火台之间的值不大于2个烽火台的最小值，那么这2个烽火台是可以相互看见的，问最多有多少对可以相互看见的烽火台
 * 单调栈的应用，考虑从栈底到栈顶递减的单调栈，两头夹的就是比中间高的烽火台，那么从中间这个烽火台出发，一定存在2对，即到达两边的烽火台
 * 但是考虑到可能存在相同高度的烽火台，因此，我们将相同高度的烽火台累加次数，当出栈时，这些相同高度的烽火台能够构成的对数为C(2, k) + 2 * k,
 * 即中间这些烽火台是可以相互看见的，而从每个出发，有2对烽火台（从当前到最左，从当前到最右）
 *
 *
 * 当遍历完一轮的时候，栈中倒数第一和倒数第二的元素要分别讨论：
 * 1.如果栈底出现的次数为1，那么栈底倒数第二的元素能够构成的对数为C（2, k） + k
 * 2.如果栈底出现的次数大于1， 那么栈底倒数第二的元素能够构成的对数为C（2, k） + 2 * k
 *
 * 1.栈底的元素如果出现次数为1， 那么栈底元素能够成的对数为0
 * 2.栈底元素如果出现的次数大于1， 那么栈底元素能够成对数为C（2， k）
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
        // 注意这里至少会留下2个，1个最大的，1个次大的，因为最大的不可能遇到比他大的，所以不会弹出，而次大的不会在顶上遇到比他更大的了，因此不会弹出
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

    // 计算循环数组下一个下标
    public int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    // 计算C（n, 2）
    public long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }
}
