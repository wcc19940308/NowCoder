package NowCoder.class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * �ж��Ƿ�Ϊ��������������ȫ������
 * �����������������������(�ݹ顢�ǵݹ顢Morris����)
 * ��ȫ����������α���
 * 1.���X���ҽڵ�û����ڵ㣬false
 * 2.���X����û�ң�����X���Ҷ�û�У���ôX�ұߵı��붼��Ҷ�ڵ㣬����ͨ��һ��bool�����������˽׶Σ������boolΪtrue����ô����Ľڵ㶼Ӧ����Ҷ�ڵ�
 */
public class IsBSTAndCBT {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = new TreeNode(Integer.MIN_VALUE);
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.value <= pre.value) {
                        return false;
                    }
                    pre = root;
                    root = root.right;
                }
            }
        }
        return true;
    }

    static TreeNode pre = null;
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (pre != null && root.value <= pre.value) {
            return false;
        }
        pre = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }

    public static boolean isValidCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // ���������leaf�׶Σ����Һ����Ľڵ㲻��Ҷ�ӽڵ� ���� ����Ϊ���Һ��Ӳ�Ϊ�գ���ô����false
            if ((leaf && (node.left != null || node.right != null))
                    || (node.left == null && node.right != null)) {
                return false;
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
