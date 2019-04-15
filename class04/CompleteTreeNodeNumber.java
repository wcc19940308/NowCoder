package NowCoder.class04;

import sun.reflect.generics.tree.Tree;

/**
 *
 * ������ȫ�������ڵ�ĸ�����ʱ�临�Ӷ�Ҫ�����O��N��
 * �жϸ��ڵ����������߽���û�е����һ�㣺
 * ���ˣ��������������������ݹ���������û�����������������������ݹ���������Ȼ�����2^n-1������Ӧ���Ľڵ�����
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
        // ��������������߶�Ϊdepth����ô����������Ϊ��������
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
