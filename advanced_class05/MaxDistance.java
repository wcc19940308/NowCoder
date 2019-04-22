package NowCoder.advanced_class05;

/**
 * 1.������������������
 * 2.������������������
 * 3.������������
 */
public class MaxDistance {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public int getMaxDistance(Node head) {
        int[] res = new int[1];
        process(head, res);
        return res[0];
    }

    public int process(Node head, int[] res) {
        if (head == null) {
            res[0] = 0;
            return 0;
        }
        int left = process(head.left, res);
        int maxLeft = res[0];
        int right = process(head.right, res);
        int maxRight = res[0];
        int curLength = maxLeft + maxRight;
        res[0] = Math.max(left, right) + 1;
        return Math.max(curLength, Math.max(left, right));
    }
}
