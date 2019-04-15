package NowCoder.class04;

import java.util.Stack;

/**
 * 二叉树的非递归先中后序遍历
 * <p>
 * 前序：1个栈，先打印，左不为空压左，右不为空压右
 * 中序：当前节点为空，从栈拿，打印，往右跑；当前节点不为空，当前节点压栈，往左跑；
 * 后序：利用2个栈，用先序可以知道，打印顺序为中左右，即先打印，再压右，再压左；那么同样地，我们可以实现顺序为中右左的遍历：
 * 即先打印，再压左，再压右，但是如果我们以压入另一个栈的方式来代替这3步，即按照中右左的顺序压入另一个栈，再弹出的时候就有左右中的顺序，即后序遍历的过程
 */
public class PreInPostTraversal {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }
    public static void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.value + " ");
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value + " ");
                    root = root.right;
                }
            }
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                // 这句是关键，即将打印改为向栈2中压入
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);


        System.out.println("pre-order: ");
        preOrderTraversal(head);
        System.out.println("in-order: ");
        inOrderTraversal(head);
        System.out.println("pos-order: ");
        postOrderTraversal(head);

    }
}
