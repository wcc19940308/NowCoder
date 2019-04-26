package NowCoder.swordToOffer;

import java.util.Stack;

/**
 * ������������˫������
 * ��Ŀ����
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
