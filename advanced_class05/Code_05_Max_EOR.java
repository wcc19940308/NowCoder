package NowCoder.advanced_class05;

public class Code_05_Max_EOR {
    public static int comparator1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                int xor = 0;
                for (int k = j; k <= i; k++) {
                    xor ^= nums[k];
                }
                max = Math.max(max, xor);
            }
        }
        return max;
    }

    public static int comparator2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            max = Math.max(xor, max);
            for (int j = 1; j <= i; j++) {
                int curXor = xor ^ dp[j - 1];
                max = Math.max(curXor, max);
            }
            dp[i] = xor;
        }
        return max;
    }

    public static class Node {
        Node[] nexts = new Node[2];
    }

    public static class NumTire {
        Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int i = 31; i >= 0; i--) {
                int path = (num >> i) & 1; // 得出每一位
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int i = 31; i >= 0; i--) {
                int path = (num >> i) & 1;
                int best = i == 31 ? path : path ^ 1; // 符号位和其他位区别对待
                best = cur.nexts[best] != null ? best : best ^ 1; // best根据实际情况判断
                res |= (path ^ best) << i; // 能够得到的最好结果
                cur = cur.nexts[best];
            }
            return res;
        }
    }


    public static int maxSubXorArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int xor = 0;
        NumTire numTire = new NumTire();
        numTire.add(0);
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            max = Math.max(max, numTire.maxXor(xor));
            numTire.add(xor);
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 50;
        int maxValue = 30;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int comp1 = comparator1(arr);
            int comp2 = comparator2(arr);
            int res = maxSubXorArray(arr);
            if (!(comp1 == comp2 && comp2 == res)) {
                success = false;
                printArray(arr);
                System.out.println(comp1);
                System.out.println(comp2);
                System.out.println(res);
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fuck");
    }
}
