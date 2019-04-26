package NowCoder.swordToOffer;

import java.util.TreeMap;

/**
 * 树的子结构(拓扑结构)
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 注意这里判断的是拓扑结构，即不一定要求整颗子树都一致，区别于leetcode572中对整颗子树的判断
 */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2) || recursive(root1, root2);
    }

    public boolean recursive(TreeNode root1, TreeNode root2) {
        // 已经找到一个子结构
        if (root2 == null){ return true;}
        // root2 != null但是root1 == null那么返回false
        if (root1 == null) return false;
        return root1.val == root2.val && recursive(root1.left, root2.left) && recursive(root1.right, root2.right);
    }

}
