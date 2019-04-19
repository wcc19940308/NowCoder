package NowCoder.advanced_class03;

/**
 * Morris遍历，O（n）时间复杂度，O（1）空间复杂度实现二叉树的遍历
 * 通过叶子节点中指向null的引用，来记录上层节点的信息，从何实现遍历
 */
public class MorrisTraversal {
    public static class Node {
        public int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void morrisPre(Node head) {

    }

    public void morrisIn(Node head) {

    }

    public void morrisPost(Node head) {

    }
}
