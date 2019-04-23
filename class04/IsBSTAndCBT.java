package NowCoder.class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断是否为二叉搜索树和完全二叉树
 * 二叉搜索树：中序遍历升序(递归、非递归、Morris遍历)
 * 完全二叉树：层次遍历
 * 1.如果X有右节点没有左节点，false
 * 2.如果X有左没右，或者X左右都没有，那么X右边的必须都是叶节点，可以通过一个bool变量来开启此阶段，即如果bool为true，那么后面的节点都应该是叶节点
 */
public class IsBSTAndCBT {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = new TreeNode(Integer.MIN_VALUE);
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.value <= pre.value) {
                        return false;
                    }
                    pre = root;
                    root = root.right;
                }
            }
        }
        return true;
    }

    static TreeNode pre = null;
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (pre != null && root.value <= pre.value) {
            return false;
        }
        pre = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }

    public static boolean isValidCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 如果开启了leaf阶段，并且后续的节点不是叶子节点 或者 左孩子为空右孩子不为空，那么返回false
            if ((leaf && (node.left != null || node.right != null))
                    || (node.left == null && node.right != null)) {
                return false;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
