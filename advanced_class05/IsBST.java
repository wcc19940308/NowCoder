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
        // 树上的最小值和最大值
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
        // 返回高度,向上层返回的时候+1
        return Math.max(left, right) + 1;
    }
}
