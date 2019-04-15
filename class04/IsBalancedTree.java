package NowCoder.class04;

/**
 *
 * �ж��Ƿ�Ϊƽ�������:�ж���ÿ���ڵ�Ϊͷ�����Ƿ�ƽ��
 *
 * ����DP
 * �г������ԣ����������ֵ�����ͣ���Ƶݹ麯����ȷ���ݹ��
 * ���оٿ���������Ҫ��
 * ��ƽ�⣿��ƽ�⣿��߶ȣ��Ҹ߶�
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

    // res�����ô���,ͨ�����ص�res���ж��Ƿ�Ϊƽ�������
    public static int getHeight(TreeNode root, int level, boolean[] res) {
        // ����Ϊƽ�����������ô���ı�res��ֱֵ�ӷ���
        if (root == null) {
            return level;
        }
        int left = getHeight(root.left, level + 1, res);
        // ����һ������resΪfalse���������ֱ�ӷ��أ����ټ������¼���
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
