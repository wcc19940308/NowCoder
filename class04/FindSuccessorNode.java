package NowCoder.class04;

/**
 *
 * 找到二叉树中某个节点X的后继节点;找前驱节点同理
 * 1.如果X有右子树，那么要找的节点就是X右子树中最左边的节点
 * 2.如果X没有右子树，那么就寻找X是哪个节点作为左子树的最后一个节点：
 * 一. 如果X是左孩子，那么父节点就是要找的节点
 * 二. 如果X是右孩子，往上找，找到当前节点是它父节点的左孩子的时候停，这个父节点就是要找的节点
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
