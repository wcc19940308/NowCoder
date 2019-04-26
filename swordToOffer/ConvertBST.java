package NowCoder.swordToOffer;

import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode res = null;
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if (pre != null) pre.right = pRootOfTree;
        res = res == null ? pRootOfTree : res;
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return res;
    }

    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode res = null, pre = null;
        TreeNode p = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res = res == null ? p : res;
            p.left = pre;
            if (pre != null) pre.right = p;
            pre = p;
            p = p.right;
        }
        return res;
    }
}
