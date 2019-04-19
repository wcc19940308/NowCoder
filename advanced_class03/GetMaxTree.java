package NowCoder.advanced_class03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ���������MaxTree������ջ��Ӧ��,Ҳ����ʹ�ý�����ʵ�֣�
 * ���������е�ÿ�������ҵ���ߵ�һ���������x1���ұߵ�һ���������x2
 * ���x1 == null & x2 == null ����ôxΪ���ڵ�
 * ���x1 != null && x2 != null ����ôxѡ��x1,x2��С����Ϊ��
 * ���x1��x2��һ��Ϊnull����ôѡ��Ϊnull����Ϊ���ڵ�
 * ������������Ķ���������MaxTree
 */
public class GetMaxTree {
    static class Node {
        int val;
        Node left;
        Node rigit;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node getMaxTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Map<Node, Node> leftBigMap = new HashMap<>();
        Map<Node, Node> rightBigMap = new HashMap<>();
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        for (int i = 0; i < nodes.length; i++) {
            Node curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popNode(stack,leftBigMap);
            }
            stack.push(curNode);
        }
        // ��ջ��ʣ�µ�Ԫ�ش����꣬��ͬ
        while (!stack.isEmpty()) {
            popNode(stack,leftBigMap);
        }

        for (int i = nodes.length - 1; i >= 0; i--) {
            Node curNode = nodes[i];
            while (!stack.isEmpty() && stack.peek().val < curNode.val) {
                popNode(stack,rightBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popNode(stack, rightBigMap);
        }

        Node head = null;
        for (int i = 0; i < nodes.length; i++) {
            Node left = leftBigMap.get(nodes[i]);
            Node right = rightBigMap.get(nodes[i]);
            if (left == null && right == null) {
                head = nodes[i];
            } else if (left == null) {
                if (right.left == null) {
                    right.left = nodes[i];
                } else {
                    right.rigit = nodes[i];
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = nodes[i];
                } else {
                    left.rigit = nodes[i];
                }
            } else {
                Node parent = left.val < right.val ? left : right;
                if (parent.left == null) {
                    parent.left = nodes[i];
                } else {
                    parent.rigit = nodes[i];
                }
            }
        }
        return head;
    }

    public static void popNode(Stack<Node> stack, Map<Node, Node> map) {
        Node pop = stack.pop();
        if (!stack.isEmpty()) {
            map.put(pop, stack.peek());
        } else {
            map.put(pop, null);
        }
    }
}
