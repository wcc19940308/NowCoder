package NowCoder.class04;

import sun.reflect.generics.tree.Tree;

/**
 *
 * 计算完全二叉树节点的个数，时间复杂度要求低于O（N）
 * 判断根节点的右树的左边界有没有到最后一层：
 * 到了，左树就是满二叉树，递归求右树；没到，右树就是满二叉树，递归求左树。然后根据2^n-1来求解对应树的节点数量
 *
 */
public class CompleteTreeNodeNumber {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count(root, 1, getDepth(root, 1));
    }

    public static int count(TreeNode root, int level, int depth) {
        if (level == depth) {
            return 1;
        }
        // 如果右子树的最大高度为depth，那么代表左子树为满二叉树
        if (getDepth(root.left, level + 1) == depth) {
            return (1 << (depth - level)) + count(root.right, level + 1, depth);
        } else {
            return (1 << (depth - level - 1)) + count(root.left, level + 1, depth);
        }
    }

    public static int getDepth(TreeNode root, int level) {
        while (root != null) {
            level++;
            root = root.left;
        }
        return level - 1;
    }
}
