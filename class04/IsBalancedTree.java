package NowCoder.class04;

/**
 *
 * 判断是否为平衡二叉树:判断以每个节点为头的树是否平衡
 *
 * 树形DP
 * 列出可能性，整理出返回值的类型，设计递归函数，确定递归基
 * （列举可能性最重要）
 * 左平衡？右平衡？左高度？右高度
 *
 */
public class IsBalancedTree {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    // res的引用传递,通过返回的res来判断是否为平衡二叉树
    public static int getHeight(TreeNode root, int level, boolean[] res) {
        // 空树为平衡二叉树，那么不改变res的值直接返回
        if (root == null) {
            return level;
        }
        int left = getHeight(root.left, level + 1, res);
        // 这里一旦遇到res为false的情况，就直接返回，不再继续向下计算
        if (!res[0]) {
            return level;
        }
        int right = getHeight(root.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(left - right) > 1) {
            res[0] = false;
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
//        head.right.right = new TreeNode(7);

        System.out.println(isBalance(head));

    }
}
