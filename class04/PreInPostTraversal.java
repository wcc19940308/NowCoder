package NowCoder.class04;

import java.util.Stack;

/**
 * �������ķǵݹ����к������
 * <p>
 * ǰ��1��ջ���ȴ�ӡ����Ϊ��ѹ���Ҳ�Ϊ��ѹ��
 * ���򣺵�ǰ�ڵ�Ϊ�գ���ջ�ã���ӡ�������ܣ���ǰ�ڵ㲻Ϊ�գ���ǰ�ڵ�ѹջ�������ܣ�
 * ��������2��ջ�����������֪������ӡ˳��Ϊ�����ң����ȴ�ӡ����ѹ�ң���ѹ����ôͬ���أ����ǿ���ʵ��˳��Ϊ������ı�����
 * ���ȴ�ӡ����ѹ����ѹ�ң��������������ѹ����һ��ջ�ķ�ʽ��������3�����������������˳��ѹ����һ��ջ���ٵ�����ʱ����������е�˳�򣬼���������Ĺ���
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
                // ����ǹؼ���������ӡ��Ϊ��ջ2��ѹ��
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
