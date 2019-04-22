package NowCoder.advanced_class05;

public class IsBST {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isBST(Node root) {
        // ���ϵ���Сֵ�����ֵ
        boolean[] res = new boolean[1];
        res[0] = true;
        recursive(root, res);
        return res[0];
    }

    public int recursive(Node root, boolean[] res) {
        if (root == null) {
            res[0] = true;
            return 0;
        }
        int left = recursive(root.left, res);
        if (!res[0]) return 0;
        int right = recursive(root.right, res);
        if (!res[0]) return 0;
        if (Math.abs(left - right) > 1) {
            res[0] = false;
            return 0;
        }
        // ���ظ߶�,���ϲ㷵�ص�ʱ��+1
        return Math.max(left, right) + 1;
    }
}
