package NowCoder.advanced_class05;

/**
 * �������������ͣ�
 * 1.����O��n^3��
 * 2.����0~start-1 ��� start~i = 0 ��� i�����Կ���ͨ�����������ͬ��ֵ�����л��� O��n^2��
 * 3.ǰ׺���������Ľ����֯��ǰ׺�����������λΪ�����Ҹ�λ��ֵ�����������·����Ϊ���������������ÿ�μ�¼��0~i������
 * ǰ׺����¼0~start-1�ļ�¼����ˣ�Ϊ���ܹ��ó�����start~i��������ͣ�Ѱ��ǰ׺�����ܹ���������������·
 */
public class Max_EOR {

    // O��n^2��
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int xor = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i]; // 0��i�������
            max = Math.max(xor, max);
            for (int start = 1; start <= i; start++) {
                // ���start��i�������
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
                // ����Ƿ���λ��ϣ��ѡ�������λ��ͬ�ģ�0^0 = 0, 1^1 = 0�������ܵõ�����
                // ������Ƿ���λ����ôϣ��ѡ���뵱ǰ���෴�ģ�����õ�����������best
                int best = move == 31 ? path : (path ^ 1);
                // ��ô����ʵ�����ѡ��ʵ�ʵ�best
                best = cur.next[best] != null ? best : (best ^ 1);
                // �õ�����ʵ���
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


    // ������ȷ�Ķ����� O(n^3)
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
