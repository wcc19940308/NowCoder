package NowCoder.swordToOffer;

import java.util.TreeMap;

/**
 * �����ӽṹ(���˽ṹ)
 * ��Ŀ����
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * ע�������жϵ������˽ṹ������һ��Ҫ������������һ�£�������leetcode572�ж������������ж�
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
        // �Ѿ��ҵ�һ���ӽṹ
        if (root2 == null){ return true;}
        // root2 != null����root1 == null��ô����false
        if (root1 == null) return false;
        return root1.val == root2.val && recursive(root1.left, root2.left) && recursive(root1.right, root2.right);
    }

}
