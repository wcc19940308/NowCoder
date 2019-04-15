package NowCoder.class04;

/**
 *
 * �ҵ���������ĳ���ڵ�X�ĺ�̽ڵ�;��ǰ���ڵ�ͬ��
 * 1.���X������������ôҪ�ҵĽڵ����X������������ߵĽڵ�
 * 2.���Xû������������ô��Ѱ��X���ĸ��ڵ���Ϊ�����������һ���ڵ㣺
 * һ. ���X�����ӣ���ô���ڵ����Ҫ�ҵĽڵ�
 * ��. ���X���Һ��ӣ������ң��ҵ���ǰ�ڵ��������ڵ�����ӵ�ʱ��ͣ��������ڵ����Ҫ�ҵĽڵ�
 *
 */
public class FindSuccessorNode {
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode findSuccessorNode(TreeNode root) {
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode parent = root.parent;
//            if (parent == null) {
//                return null;
//            } else {
//                if (parent.left == root) {
//                    return parent;
//                } else if (parent.right == root) {
//                    while (!(parent != null && root == parent.left)) {
//                        root = parent;
//                        parent = parent.parent;
//                    }
//                    return parent;
//                }
//            }
            while (parent != null && parent.left != root) {
                root = parent;
                parent = root.parent;
            }
            return parent;
        }
    }
}
