package NowCoder;

import java.util.Stack;
import java.util.concurrent.ConcurrentSkipListSet;

public class Exec {
    public static class Pair {
        public int val;
        public int times;

        public Pair(int val) {
            this.val = val;
            times = 1;
        }
    }

    public int communication(int[] arr) {
        int n = arr.length;
        int maxIndex = 0;
        Stack<Pair> stack = new Stack<>();
        int res = 0;
        for (int i = 1; i < n; i++) {
            maxIndex = arr[i] > arr[maxIndex] ? i : maxIndex;
        }
        int nextIndex = getNextIndex(n, maxIndex);
        stack.push(new Pair(arr[maxIndex]));
        while (nextIndex != maxIndex) {
            int value = arr[nextIndex];
            while (!stack.isEmpty() && stack.peek().val < value) {
                int times = stack.pop().times;
                res += getInternalSum(times) + times * 2;
            }
            if (!stack.isEmpty() && stack.peek().val == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            nextIndex = getNextIndex(n, nextIndex);
        }

        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times);
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {
                    res += times;
                } else {
                    res += stack.peek().times == 1 ? 0 : times;
                }
            }
        }
        return res;
    }

    public int getNextIndex(int len, int curIndex) {
        return curIndex < (len - 1) ? curIndex + 1 : 0;
    }

    public int getInternalSum(int n) {
        return n == 1 ? 0 : n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        ConcurrentSkipListSet skipListSet = new ConcurrentSkipListSet();

    }
}
