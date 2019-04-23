package NowCoder.advanced_class05;

/**
 * 求数组的最大异或和：
 * 1.暴力O（n^3）
 * 2.由于0~start-1 异或 start~i = 0 异或 i，所以可以通过两边异或相同的值来进行化简 O（n^2）
 * 3.前缀树，将异或的结果组织成前缀树，优先最高位为正数且高位的值尽量大的那条路，即为最大的异或结果，并且每次记录从0~i的异或和
 * 前缀树记录0~start-1的记录，因此，为了能够得出最大的start~i的异或结果和，寻找前缀树中能够满足条件的那条路
 */
public class Max_EOR {

    // O（n^2）
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int xor = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i]; // 0到i的异或结果
            max = Math.max(xor, max);
            for (int start = 1; start <= i; start++) {
                // 获得start到i的异或结果
                max = Math.max(max, xor ^ dp[start - 1]);
            }
            dp[i] = xor;
        }
        return max;
    }

    public static class Node {
        Node[] next = new Node[2];
    }

    public static class NumTire {
        public Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                cur.next[path] = cur.next[path] == null ? new Node() : cur.next[path];
                cur = cur.next[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                // 如果是符号位，希望选择与符号位相同的，0^0 = 0, 1^1 = 0这样都能得到正数
                // 如果不是符号位，那么希望选择与当前数相反的，这里得到的是期望的best
                int best = move == 31 ? path : (path ^ 1);
                // 那么根据实际情况选出实际的best
                best = cur.next[best] != null ? best : (best ^ 1);
                // 得到的真实结果
                res |= (path ^ best) << move;
                cur = cur.next[best];
            }
            return res;
        }
    }

    public static int maxXorSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int xor = 0;
        int max = Integer.MIN_VALUE;
        NumTire numTire = new NumTire();
        numTire.add(0);
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            max = Math.max(max, numTire.maxXor(xor));
            numTire.add(xor);
        }
        return max;
    }


    // 绝对正确的对数器 O(n^3)
    public static int comparator(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int start = 0; start <= i; start++) {
                int curXor = 0;
                for (int j = 0; j <= start; j++) {
                    curXor ^= nums[j];
                }
                max = Math.max(max, curXor);
            }
        }
        return max;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - maxValue * Math.random());
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
        int[] arr = new int[]{1, 2};
        int res = getMax(arr);
        System.out.println(res);

    }


}
